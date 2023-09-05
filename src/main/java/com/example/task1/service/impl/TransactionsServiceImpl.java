package com.example.task1.service.impl;

import com.example.task1.dto.TransactionsDto;
import com.example.task1.dto.request.TransactionRequest;
import com.example.task1.model.Reports;
import com.example.task1.model.Transactions;
import com.example.task1.repository.TransactionsRepository;
import com.example.task1.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionsServiceImpl implements TransactionsService {

    final TransactionsRepository transactionsRepository;

    @Override
    public TransactionsDto getTransactionsById(Long id) {

        Transactions transactions = transactionsRepository.getTransactionsById(id);
        return TransactionsDto.builder()
                .name(transactions.getName())
                .build();
    }

    @Override
    public void saveTransactions(TransactionRequest transactionRequest) {

        Transactions transactions = Transactions.builder()
                .name(transactionRequest.getName())
                .build();

        transactionsRepository.save(transactions);


    }

    @Override
    public void updateTransactions(TransactionRequest transactionRequest) {

        Transactions transactions = Transactions.builder()
                .id(transactionRequest.getId())
                .name(transactionRequest.getName())
                .build();

        transactionsRepository.save(transactions);




    }

    @Override
    public List<TransactionsDto> getAll() {

        List<Transactions> transactions = transactionsRepository.findAll();
        List<TransactionsDto> transactionsDtos = new ArrayList<>();

        for(Transactions transactions1 : transactions){
            TransactionsDto transactionsDto = TransactionsDto.builder()
                    .name(transactions1.getName())
                    .build();

            transactionsDtos.add(transactionsDto);

        }



        return transactionsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Transactions transactions = transactionsRepository.getTransactionsById(id);
        if(transactions.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            transactionsRepository.deleteById(id);
        }
    }
}
