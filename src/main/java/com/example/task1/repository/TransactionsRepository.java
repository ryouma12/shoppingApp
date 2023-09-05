package com.example.task1.repository;

import com.example.task1.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    Transactions getTransactionsById(Long id);

}
