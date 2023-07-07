package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubmissionService implements ISubmissionService{
    @Autowired
    IDataBase db;
    @Override
    public SubmissionRequest submit(SubmissionRequest sr) {
        sr.setId(UUID.randomUUID());
        return db.store(sr);
    }
    @Override
    public SubmissionRequest retrieve(UUID id) {
        return db.fetch(id);
    }
    @Override
    public SubmissionRequest remove(UUID id) {
        return db.delete(id);
    }
    @Override
    public SubmissionRequest update(SubmissionRequest sr) {
        return db.update(sr);
    }
    @Override
    public List<SubmissionRequest> retrieveAll() {
        return db.fetchAll();
    }

}
