package com.example.task1.repository;

import com.example.task1.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts getAccountsById(Long id);

}
