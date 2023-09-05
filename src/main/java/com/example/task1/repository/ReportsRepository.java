package com.example.task1.repository;

import com.example.task1.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long> {
    Reports getReportsById(Long id);
}
