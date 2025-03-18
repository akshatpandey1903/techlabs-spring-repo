package com.aurionpro.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.app.dto.CustomerRequestDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionRequestDto;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserResponseDto;
import com.aurionpro.app.entity.Account;
import com.aurionpro.app.entity.Transaction;
import com.aurionpro.app.entity.TransactionType;
import com.aurionpro.app.entity.User;
import com.aurionpro.app.exceptions.AccountApiException;
import com.aurionpro.app.exceptions.InsufficientBalanceException;
import com.aurionpro.app.exceptions.TransactionApiException;
import com.aurionpro.app.exceptions.UserApiException;
import com.aurionpro.app.repository.AccountRepository;
import com.aurionpro.app.repository.TransactionRepository;
import com.aurionpro.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	private ModelMapper modelMapper;
	@Autowired
	private EmailService emailService;
	
	public CustomerServiceImpl() {
		this.modelMapper = new ModelMapper();
	}
	
//	private User requestToUser(UserRequestDto userRequestDto) {
//		User user = new User();
//		user.setName(userRequestDto.getName());
//		user.setEmail(userRequestDto.getEmail());
//		user.setPassword(userRequestDto.getPassword());
//		user.setAge(userRequestDto.getAge());
//		user.setUsername(userRequestDto.getUsername());
//		return user;
//	}
//	
	private UserResponseDto userToResponse(User user) {
		UserResponseDto responseDto = new UserResponseDto();
		responseDto.setAge(user.getAge());
		responseDto.setId(user.getId());
		responseDto.setEmail(user.getEmail());
		responseDto.setName(user.getName());
		responseDto.setUsername(user.getUsername());
		return responseDto;
	}
	
	public TransactionResponseDto convertToResponseDto(Transaction transaction) {
	    TransactionResponseDto responseDto = new TransactionResponseDto();
	    
	    responseDto.setSenderAccno(transaction.getSenderAccno());
	    responseDto.setReceiverAccno(transaction.getReceiverAccno());
	    responseDto.setAmount(transaction.getAmount());
	    responseDto.setTransactionType(transaction.getTransactionType().toString());
	    responseDto.setDescription(transaction.getDescription());
	    responseDto.setTransactionDate(transaction.getTransactionDate());
	    
	    return responseDto;
	}

	@Override
	public UserResponseDto updateCustomerProfile(int customerId, CustomerRequestDto customerRequestDto) {
		User user = userRepository.findById(customerId)
				.orElseThrow(() -> new UserApiException("User with Id:" + customerId + " does not exist"));
		if(customerRequestDto.getEmail() != null) {
			user.setEmail(customerRequestDto.getEmail());
		}
		if(customerRequestDto.getUsername() != null) {
			user.setUsername(customerRequestDto.getUsername());
		}
		if(customerRequestDto.getPassword() != null) {
			user.setPassword(customerRequestDto.getPassword());
		}
		User updatedUser = userRepository.save(user);
		UserResponseDto responseDto = userToResponse(updatedUser);
		responseDto.setRoleName(updatedUser.getRole().getRoleName());
		return responseDto;
	}

	@Override
	public PageResponse<TransactionResponseDto> getTransactions(int id, int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		List<String> accountNumbers = accountRepository.findAccountNumbersByUserId(id);
		if(accountNumbers.isEmpty()) {
			throw new AccountApiException("No account found for this customer");
		}
		Page<Transaction> transactionsPage = transactionRepository.findTransactionsByAccountNumbers(accountNumbers, pageable);
		List<TransactionResponseDto> transactionsDto = transactionsPage.getContent()
				.stream()
				.map(transaction -> convertToResponseDto(transaction))
				.toList();
		PageResponse<TransactionResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(transactionsDto);
		pageResponse.setLast(transactionsPage.isLast());
		pageResponse.setPageSize(transactionsPage.getSize());
		pageResponse.setTotalPages(transactionsPage.getTotalPages());
		pageResponse.setTotalElements(transactionsPage.getTotalElements());
		return pageResponse;
	}

	@Override
	@Transactional
	public TransactionResponseDto createTransaction(TransactionRequestDto requestDto) {
	    Transaction transaction;
	    switch(requestDto.getTransactionType()) {
	    	case DEPOSIT:
	    		transaction = deposit(requestDto);
	    		break;
	    	case WITHDRAW:
	    		transaction = withdraw(requestDto);
	    		break;
	    	case TRANSFER:
	    		transaction = transfer(requestDto);
	    		break;
	    	default:
	    		throw new TransactionApiException("Invalid Transaction Type");
	    }
	    
        emailService.sendTransactionEmail("akshatp1903@gmail.com", 
            "Account Transaction", 
            requestDto.getTransactionType() + " of amount: " + requestDto.getAmount());

        if(requestDto.getTransactionType() == TransactionType.TRANSFER) {
            emailService.sendTransactionEmail("akshatp1903@gmail.com",
                "Account Transaction", 
                "Transfer to your account of amount: " + requestDto.getAmount() + 
                " from AccountNo: " + requestDto.getSenderAccno());
        }
	    
	    TransactionResponseDto responseDto = modelMapper.map(transaction, TransactionResponseDto.class);
	    return responseDto;
	}

	private Transaction deposit(TransactionRequestDto requestDto) {
		Account account = accountRepository.findByAccountNo(requestDto.getSenderAccno());
		if(account == null) {
			throw new AccountApiException("No account found for this customer");
		}
		double updatedBalance = account.getBalance() + requestDto.getAmount();
	    account.setBalance(updatedBalance);

	    Transaction transaction = new Transaction();
	    transaction.setSenderAccno(account.getAccountNo());
	    transaction.setAmount(requestDto.getAmount());
	    transaction.setTransactionType(TransactionType.DEPOSIT);
	    transaction.setTransactionDate(LocalDateTime.now());
	    transaction.setDescription(requestDto.getDescription());

	    accountRepository.save(account);
	    return transactionRepository.save(transaction);
	}
	
	private Transaction withdraw(TransactionRequestDto requestDto) {
	    Account account = accountRepository.findByAccountNo(requestDto.getSenderAccno());
	    if(account == null) {
	        throw new AccountApiException("No account found for this customer");
	    }
	    
	    if(account.getBalance() - requestDto.getAmount() < 500) {
	        throw new InsufficientBalanceException("Insufficient balance for withdrawal");
	    }
	    
	    double updatedBalance = account.getBalance() - requestDto.getAmount();
	    account.setBalance(updatedBalance);
	    
	    Transaction transaction = new Transaction();
	    transaction.setSenderAccno(account.getAccountNo());
	    transaction.setAmount(requestDto.getAmount());
	    transaction.setTransactionType(TransactionType.WITHDRAW);
	    transaction.setTransactionDate(LocalDateTime.now());
	    transaction.setDescription(requestDto.getDescription());
	    
	    accountRepository.save(account);
	    return transactionRepository.save(transaction);
	}
	
	private Transaction transfer(TransactionRequestDto requestDto) {
	    Account senderAccount = accountRepository.findByAccountNo(requestDto.getSenderAccno());
	    if(senderAccount == null) {
	        throw new AccountApiException("Sender account not found");
	    }
	    
	    Account receiverAccount = accountRepository.findByAccountNo(requestDto.getReceiverAccno());
	    if(receiverAccount == null) {
	        throw new AccountApiException("Receiver account not found");
	    }
	    
	    if(senderAccount.getBalance() - requestDto.getAmount() < 500) {
	        throw new InsufficientBalanceException("Insufficient balance for transfer");
	    }
	    
	    double senderUpdatedBalance = senderAccount.getBalance() - requestDto.getAmount();
	    double receiverUpdatedBalance = receiverAccount.getBalance() + requestDto.getAmount();
	    
	    senderAccount.setBalance(senderUpdatedBalance);
	    receiverAccount.setBalance(receiverUpdatedBalance);
	    
	    Transaction transaction = new Transaction();
	    transaction.setSenderAccno(senderAccount.getAccountNo());
	    transaction.setReceiverAccno(receiverAccount.getAccountNo());
	    transaction.setAmount(requestDto.getAmount());
	    transaction.setTransactionType(TransactionType.TRANSFER);
	    transaction.setTransactionDate(LocalDateTime.now());
	    transaction.setDescription(requestDto.getDescription());
	    
	    accountRepository.save(senderAccount);
	    accountRepository.save(receiverAccount);
	    return transactionRepository.save(transaction);
	}


		
}
