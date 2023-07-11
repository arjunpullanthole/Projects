package com.example.demo.database;

import com.example.demo.dto.SubmissionRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class DataBase implements IDataBase {
    public HashMap<UUID, SubmissionRequest> db = new HashMap<>();
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
    public boolean update(SubmissionRequest sr) {
        if(db.containsKey(sr.getId()))
        {
            db.put(sr.getId(),sr);
            return true;
        }
        return false;
    }
    @Override
    public void delete(UUID id) {
        db.remove(id);
    }
    @Override
    public List<SubmissionRequest> fetchAll() {
        List<SubmissionRequest> lst = new ArrayList<>();
        db.forEach((k, v) ->lst.add(v));
        return lst;
    }
}
