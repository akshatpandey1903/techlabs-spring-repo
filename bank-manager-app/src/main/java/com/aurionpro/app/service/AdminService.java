package com.aurionpro.app.service;

import com.aurionpro.app.dto.AccountRequestDto;
import com.aurionpro.app.dto.AccountResponseDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserRequestDto;
import com.aurionpro.app.dto.UserResponseDto;

public interface AdminService {
	UserResponseDto createUser(UserRequestDto userRequestDto);
	PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize);
	PageResponse<TransactionResponseDto> getAllTransactions(int pageNumber, int pageSize);
    AccountResponseDto addAccountForUser(int userId, AccountRequestDto accountRequestDto);
}
