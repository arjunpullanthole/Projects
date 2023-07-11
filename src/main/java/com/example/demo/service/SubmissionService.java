package com.example.demo.service;

import com.example.demo.dto.SubmissionRequest;
import com.example.demo.database.IDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubmissionService implements ISubmissionService {
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
    public void remove(UUID id) {
        db.delete(id);
    }
    @Override
    public boolean update(SubmissionRequest sr) {
        return db.update(sr);
    }
    @Override
    public List<SubmissionRequest> retrieveAll() {
        return db.fetchAll();
    }

}
