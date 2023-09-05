package com.example.task1.service.impl;


import com.example.task1.dto.ReportsDto;
import com.example.task1.dto.request.ReportsRequest;
import com.example.task1.model.Reports;
import com.example.task1.repository.ReportsRepository;
import com.example.task1.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportsServiceImpl implements ReportsService {

    final ReportsRepository reportsRepository;


    @Override
    public ReportsDto getReportsById(Long id) {

        Reports reports = reportsRepository.getReportsById(id);


        return ReportsDto.builder()
                .reportDate(reports.getReportDate())
                .reportName(reports.getReportName())
                .build();
    }

    @Override
    public void saveReports(ReportsRequest reportsRequest) {

        Reports reports = Reports.builder()
                .reportDate(reportsRequest.getReportDate())
                .reportName(reportsRequest.getReportName())

                .build();

        reportsRepository.save(reports);


    }

    @Override
    public void updateReports(ReportsRequest reportsRequest) {

        Reports reports = Reports.builder()
                .id(reportsRequest.getId())
                .reportName(reportsRequest.getReportName())
                .reportDate(reportsRequest.getReportDate())

                .build();
        reportsRepository.save(reports);

    }

    @Override
    public List<ReportsDto> getAll() {

        List<Reports> reports = reportsRepository.findAll();
        List<ReportsDto> reportsDtos = new ArrayList<>();

        for(Reports reports1 : reports){

            ReportsDto reportsDto = ReportsDto.builder()
                    .reportName(reports1.getReportName())
                    .reportDate(reports1.getReportDate())
                    .build();

            reportsDtos.add(reportsDto);
        }



        return reportsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Reports reports = reportsRepository.getReportsById(id);
        if(reports.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            reportsRepository.deleteById(id);
        }
    }
}
