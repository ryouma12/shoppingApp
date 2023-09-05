package com.example.task1.service.impl;


import com.example.task1.dto.LogsDto;
import com.example.task1.dto.request.LogsRequest;
import com.example.task1.model.Logs;
import com.example.task1.repository.LogsRepository;
import com.example.task1.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LogsServiceImpl implements LogsService {

    final LogsRepository logsRepository;

    @Override
    public LogsDto getLogsById(Long id) {

        Logs logs = logsRepository.getReferenceById(id);

        return LogsDto.builder()
                .loginDate(logs.getLoginDate())
                .loginTime(logs.getLoginTime())
                .build();


    }

    @Override
    public void saveLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .loginDate(logsRequest.getLoginDate())
                .loginTime(logsRequest.getLoginTime())
                .build();

        logsRepository.save(logs);

    }

    @Override
    public void updateLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .id(logsRequest.getId())
                .loginTime(logsRequest.getLoginTime())
                .loginDate(logsRequest.getLoginDate())
                .build();

        logsRepository.save(logs);

    }

    @Override
    public List<LogsDto> getAll() {
        List<Logs> logs = logsRepository.findAll();
        List<LogsDto> logsDtos = new ArrayList<>();

        for(Logs logs1 : logs){

            LogsDto logsDto = LogsDto.builder()
                    .loginTime(logs1.getLoginTime())
                    .loginDate(logs1.getLoginDate())
                    .build();

            logsDtos.add(logsDto);


        }

        return logsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Logs logs = logsRepository.getLogsById(id);
        if (logs.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            logsRepository.deleteById(id);
        }
    }
}
