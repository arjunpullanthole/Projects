package com.example.demo;

import lombok.Data;

import java.util.UUID;

@Data
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
