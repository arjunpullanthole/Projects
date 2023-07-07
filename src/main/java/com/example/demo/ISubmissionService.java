package com.example.demo;

import java.util.List;
import java.util.UUID;

public interface ISubmissionService {
    public SubmissionRequest submit(SubmissionRequest sr);
    public SubmissionRequest retrieve(UUID id);
    public SubmissionRequest remove(UUID id);
    public SubmissionRequest update(SubmissionRequest sr);
    public List<SubmissionRequest> retrieveAll();

}
