package com.example.task1.service.impl;

import com.example.task1.dto.AccountsDto;
import com.example.task1.dto.request.AccountsRequest;
import com.example.task1.model.Accounts;
import com.example.task1.repository.AccountsRepository;
import com.example.task1.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

    final AccountsRepository accountsRepository;

    @Override
    public AccountsDto getAccountsById(Long id) {
        Accounts accounts = accountsRepository.getAccountsById(id);
        return AccountsDto.builder()
                .accName(accounts.getAccName())
                .build();
    }

    @Override
    public void saveAccounts(AccountsRequest accountsRequest) {

        Accounts accounts = Accounts.builder()
                .accName(accountsRequest.getAccName())
                .build();

        accountsRepository.save(accounts);

    }

    @Override
    public void updateAccounts(AccountsRequest accountsRequest) {

        Accounts accounts = Accounts.builder()
                .id(accountsRequest.getId())
                .accName(accountsRequest.getAccName())
                .build();

        accountsRepository.save(accounts);

    }

    @Override
    public List<AccountsDto> getAll() {
        List<Accounts> accounts = accountsRepository.findAll();
        List<AccountsDto> accountsDtos = new ArrayList<>();

        for(Accounts accounts1 : accounts){
            AccountsDto accountsDto = AccountsDto.builder()
                    .accName(accounts1.getAccName())
                    .build();



            accountsDtos.add(accountsDto);
        }

        return accountsDtos;
    }



    @Override
    public void deleteById(Long id) {

        Accounts accounts = accountsRepository.getAccountsById(id);
        if(accounts.getId().equals(null)) {
            throw new RuntimeException("");
        } else {
            accountsRepository.deleteById(id);
        }

    }

}
