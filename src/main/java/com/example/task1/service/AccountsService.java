package com.example.task1.service;

import com.example.task1.dto.AccountsDto;
import com.example.task1.dto.request.AccountsRequest;

import java.util.List;

public interface AccountsService {

    AccountsDto getAccountsById(Long id);

    void saveAccounts(AccountsRequest accountsRequest);

    void updateAccounts(AccountsRequest accountsRequest);

    List<AccountsDto> getAll();

    void deleteById(Long id);
}
