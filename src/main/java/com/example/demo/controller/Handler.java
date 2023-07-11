package com.example.demo.controller;

import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PutRequest;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Resource")
public class Handler {
    @Autowired
    DataService ds;
    @GetMapping
    public String home()
    {
        return "<h1>Service Running<h1>";
    }
    @GetMapping("/data")
    public List<String> get()
    {
        return ds.fetch();
    }
    @PostMapping("/data")
    public void post(@RequestBody PostRequest rq)
    {
        ds.add(rq.getArgument());
    }
    @PutMapping("/data")
    public void put(@RequestBody PutRequest rq)
    {
        ds.update(rq.getArgument1(),rq.getArgument2());
    }
    @DeleteMapping("/data")
    public void delete(@RequestBody PostRequest rq)
    {
        ds.delete(rq.getArgument());
    }
}
