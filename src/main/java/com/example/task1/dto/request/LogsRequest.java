package com.example.task1.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LogsRequest {

    private Long id;
    private String loginDate;
    private String loginTime;
}
