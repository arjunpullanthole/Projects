package com.example.demo.service;

import com.example.demo.dto.SubmissionRequest;

import java.util.List;
import java.util.UUID;

public interface ISubmissionService {
    public SubmissionRequest submit(SubmissionRequest sr);
    public SubmissionRequest retrieve(UUID id);
    public void remove(UUID id);
    public boolean update(SubmissionRequest sr);
    public List<SubmissionRequest> retrieveAll();

}
