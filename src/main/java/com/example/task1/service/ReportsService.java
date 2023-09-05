package com.example.task1.service;

import com.example.task1.dto.ReportsDto;
import com.example.task1.dto.request.ReportsRequest;

import java.util.List;

public interface ReportsService {

    ReportsDto getReportsById(Long id);

    void saveReports(ReportsRequest reportsRequest);

    void updateReports(ReportsRequest reportsRequest);

    List<ReportsDto> getAll();

    void deleteById(Long id);



}
