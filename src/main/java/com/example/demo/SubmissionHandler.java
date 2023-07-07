package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Submission")
public class SubmissionHandler {
    @Autowired
    SubmissionService ss;
    @GetMapping
    public List<SubmissionRequest> getAll()
//    public String getAll()
    {
        return ss.retrieveAll();
//        return "<h1>Service Running<h1>";
    }
    @GetMapping("/{id}")
    public SubmissionRequest get(@PathVariable("id") UUID uuid)
    {
        return ss.retrieve(uuid);
    }
    @PostMapping("/data")
    public SubmissionRequest post(@RequestBody SubmissionRequest sr)
    {
        return ss.submit(sr);
    }
    @PutMapping("/data")
    public SubmissionRequest put(@RequestBody SubmissionRequest sr)
    {
        return ss.update(sr);
    }
    @DeleteMapping("/{id}")
    public SubmissionRequest delete(@PathVariable("id") UUID uuid)
    {
        return ss.remove(uuid);
    }
}
