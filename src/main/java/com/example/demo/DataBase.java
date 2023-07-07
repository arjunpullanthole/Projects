package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class DataBase implements IDataBase{
    public HashMap<UUID,SubmissionRequest> db = new HashMap<>();
    @Override
    public SubmissionRequest store(SubmissionRequest sr) {
        db.put(sr.getId(),sr);
        return sr;
    }
    @Override
    public SubmissionRequest fetch(UUID id) {
        return db.get(id);
    }
    @Override
    public SubmissionRequest update(SubmissionRequest sr) {
        db.put(sr.getId(),sr);
        return sr;
    }
    @Override
    public SubmissionRequest delete(UUID id) {
        return db.remove(id);
    }
    @Override
    public List<SubmissionRequest> fetchAll() {
        List<SubmissionRequest> lst = new ArrayList<>();
        db.forEach((k, v) ->lst.add(v));
        return lst;
    }
}
