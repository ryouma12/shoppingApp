package com.example.task1.repository;

import com.example.task1.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs,Long> {

    Logs getLogsById( Long id);

}
