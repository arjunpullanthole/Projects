package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SubmissionRequest {
    private UUID id;
    private String name;
    private String rate;
    private String vendor;
    private String implementation;
    private String technology;
    private String lead;
    private String status;
}
