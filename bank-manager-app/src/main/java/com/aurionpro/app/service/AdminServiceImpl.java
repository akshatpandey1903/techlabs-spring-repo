package com.aurionpro.app.service;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.app.dto.AccountRequestDto;
import com.aurionpro.app.dto.AccountResponseDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserRequestDto;
import com.aurionpro.app.dto.UserResponseDto;
import com.aurionpro.app.entity.Account;
import com.aurionpro.app.entity.Role;
import com.aurionpro.app.entity.Transaction;
import com.aurionpro.app.entity.User;
import com.aurionpro.app.exceptions.RoleApiException;
import com.aurionpro.app.exceptions.UserApiException;
import com.aurionpro.app.repository.AccountRepository;
import com.aurionpro.app.repository.RoleRepository;
import com.aurionpro.app.repository.TransactionRepository;
import com.aurionpro.app.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	private ModelMapper modelMapper;
	
	public AdminServiceImpl() {
		this.modelMapper = new ModelMapper();
	}
	
	private User requestToUser(UserRequestDto userRequestDto) {
		User user = new User();
		user.setName(userRequestDto.getName());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());
		user.setAge(userRequestDto.getAge());
		user.setUsername(userRequestDto.getUsername());
		return user;
	}
	
	private UserResponseDto userToResponse(User user) {
		UserResponseDto responseDto = new UserResponseDto();
		responseDto.setAge(user.getAge());
		responseDto.setId(user.getId());
		responseDto.setEmail(user.getEmail());
		responseDto.setName(user.getName());
		responseDto.setUsername(user.getUsername());
		return responseDto;
	}

	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		Role role = roleRepository.findById(userRequestDto.getRoleId())
				.orElseThrow(() ->
				new RoleApiException("Role with ID:" + userRequestDto.getRoleId() + " not found"));
		User user = requestToUser(userRequestDto);
		user.setRole(role);
		User userDb = userRepository.save(user);
		UserResponseDto responseDto = userToResponse(userDb);
		responseDto.setRoleName(userDb.getRole().getRoleName());
		return responseDto;
	}

	@Override
	public PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Role customerRole = roleRepository.findByRoleName("CUSTOMER")
				.orElseThrow(() -> new RoleApiException("CUSTOMER role not found"));
		Page<User> usersPage = userRepository.findByRole(customerRole, pageable);
		
		List<UserResponseDto> users = usersPage.getContent()
				.stream()
				.map(user -> {
					UserResponseDto userDb = userToResponse(user);;
					userDb.setRoleName(user.getRole().getRoleName());
					return userDb;
				})
				.toList();
		PageResponse<UserResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(users);
		pageResponse.setLast(usersPage.isLast());
		pageResponse.setPageSize(usersPage.getSize());
		pageResponse.setTotalPages(usersPage.getTotalPages());
		pageResponse.setTotalElements(usersPage.getTotalElements());
		return pageResponse;
	}

	@Override
	public PageResponse<TransactionResponseDto> getAllTransactions(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Transaction> transactionsPage = transactionRepository.findAll(pageable);
		List<TransactionResponseDto> transactionsDto = transactionsPage.getContent()
				.stream()
				.map(transaction -> modelMapper.map(transaction, TransactionResponseDto.class))
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
	public AccountResponseDto addAccountForUser(int userId, AccountRequestDto accountRequestDto) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserApiException("User with Id:" + userId + " does not exist"));
		Account newAccount = modelMapper.map(accountRequestDto, Account.class);
		newAccount.setUser(user);
		newAccount.setAccountNo(generateAccountNo());
		accountRepository.save(newAccount);
		user.getAccounts().add(newAccount);
		userRepository.save(user);
		AccountResponseDto responseDto = modelMapper.map(newAccount, AccountResponseDto.class);
		responseDto.setUserId(user.getId());;
		return responseDto;
	}
	
	public String generateAccountNo() {
		Random random = new Random();
		return "ACC" + (random.nextInt(99999 - 10000 + 1) + 10000);
	}
}
