package com.example.task1.service;

import com.example.task1.dto.TransactionsDto;
import com.example.task1.dto.request.TransactionRequest;

import java.util.List;

public interface TransactionsService {

    TransactionsDto getTransactionsById(Long id);

    void saveTransactions(TransactionRequest transactionRequest);

    void updateTransactions(TransactionRequest transactionRequest);

    List<TransactionsDto> getAll();

    void deleteById(Long id);


}
