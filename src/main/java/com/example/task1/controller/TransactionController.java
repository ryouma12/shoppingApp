package com.example.task1.controller;

import com.example.task1.dto.ReportsDto;
import com.example.task1.dto.TransactionsDto;
import com.example.task1.dto.request.ReportsRequest;
import com.example.task1.dto.request.TransactionRequest;
import com.example.task1.service.ReportsService;
import com.example.task1.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/transactions")
public class TransactionController {

    final TransactionsService transactionsService;

    @GetMapping(value = "/transactionsList")
    public List<TransactionsDto> getTransactionsInfo(){
        return transactionsService.getAll();
    }

    @GetMapping(value = "/getTransactionsById/{id}")
    public TransactionsDto getTransactionsById(@PathVariable(value = "id")Long id){
        return transactionsService.getTransactionsById(id);
    }

    @PostMapping(value = "/saveTransactions")
    public void saveTransactions(@RequestBody TransactionRequest transactionRequest){
        transactionsService.saveTransactions(transactionRequest);

    }

    @PostMapping(value = "/updateTransactions")
    public void updateTransactions(@RequestBody TransactionRequest transactionRequest){
        transactionsService.updateTransactions(transactionRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        transactionsService.deleteById(id);
    }


}
