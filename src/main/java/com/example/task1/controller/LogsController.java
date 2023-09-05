package com.example.task1.controller;

import com.example.task1.dto.LogsDto;
import com.example.task1.dto.request.LogsRequest;
import com.example.task1.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/logs")
public class LogsController {
    final LogsService logsService;

    @GetMapping(value = "/logsList")
    public List<LogsDto> getLogsInfo(){
        return logsService.getAll();
    }

    @GetMapping(value = "/getLogsById/{id}")
    public LogsDto getLogsById(@PathVariable(value = "id")Long id){
        return logsService.getLogsById(id);
    }

    @PostMapping(value = "/saveLogs")
    public void saveLogs(@RequestBody LogsRequest logsRequest){
        logsService.saveLogs(logsRequest);

    }

    @PostMapping(value = "/updateLogs")
    public void updateLogs(@RequestBody LogsRequest logsRequest){
        logsService.updateLogs(logsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        logsService.deleteById(id);
    }


}
