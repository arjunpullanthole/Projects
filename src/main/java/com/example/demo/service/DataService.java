package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    private static final List<String> lst = new ArrayList<String>();
    public List<String> fetch()
    {
        return lst;
    }
    public void add(String st)
    {
        lst.add(st);
    }
    public void update(String prev, String st)
    {
        Collections.replaceAll(lst,prev,st);
    }
    public void delete(String st)
    {
        lst.removeIf(s->s.equals(st));
    }
}
