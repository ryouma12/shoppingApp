package com.example.task1.controller;

import com.example.task1.dto.AccountsDto;
import com.example.task1.dto.request.AccountsRequest;
import com.example.task1.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
@RequiredArgsConstructor
public class AccountsController {

    final AccountsService accountsService;

    @GetMapping(value = "/accountList")
    public List<AccountsDto> getAccountsInfo(){
        return accountsService.getAll();
    }

    @GetMapping(value = "/getAccountsById/{id}")
    public AccountsDto getAccountsById(@PathVariable(value = "id") Long id) {
        return accountsService.getAccountsById(id);
    }

    @PostMapping(value = "/saveAccounts")
    public void saveAccounts(@RequestBody AccountsRequest accountsRequest) {
        accountsService.saveAccounts(accountsRequest);
    }

    @PostMapping(value = "/updateAccounts")
    public void updateAccounts(@RequestBody AccountsRequest accountsRequest) {
        accountsService.updateAccounts(accountsRequest);
    }

    @DeleteMapping(value = "/deleteByAccID/{id}")
    public void deleteByAccID(@PathVariable(value = "id") Long id) {
        accountsService.deleteById(id);
    }

}
