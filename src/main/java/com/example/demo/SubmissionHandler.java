package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Submission")
public class SubmissionHandler {
    @Autowired
    ISubmissionService ss;
    @GetMapping
    public ResponseEntity<List<SubmissionRequest>> getAll()
    {
        return new ResponseEntity<>(ss.retrieveAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubmissionRequest> get(@PathVariable("id") UUID uuid)
    {
        return new ResponseEntity<>(ss.retrieve(uuid),HttpStatus.OK);
    }
    @PostMapping("/data")
    public ResponseEntity<SubmissionRequest> post(@RequestBody SubmissionRequest sr)
    {
        return new ResponseEntity<>(ss.submit(sr),HttpStatus.CREATED);
    }
    @PutMapping("/data")
    public ResponseEntity<String> put(@RequestBody SubmissionRequest sr)
    {
        if(ss.update(sr))
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        return new ResponseEntity<>("ID is not present",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID uuid)
    {
        ss.remove(uuid);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }
}
