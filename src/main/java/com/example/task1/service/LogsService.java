package com.example.task1.service;

import com.example.task1.dto.LogsDto;
import com.example.task1.dto.request.LogsRequest;

import java.util.List;

public interface LogsService {

    LogsDto getLogsById(Long id);

    void saveLogs(LogsRequest logsRequest);

    void updateLogs(LogsRequest logsRequest);

    List<LogsDto> getAll();

    void deleteById(Long id);


}
