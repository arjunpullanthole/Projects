package com.example.demo.service;

import com.example.demo.database.DataBase;
import com.example.demo.dto.SubmissionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class TestSubmissionService {
    private SubmissionService ss;
    SubmissionRequest sr;

    @BeforeEach
    public void setup()
    {
        ss = new SubmissionService();
        ss.db = new DataBase();
        ss.submit(new SubmissionRequest(null,"Name1","100","vendor1","TCS","Java","Lead1","Confirmed"));
        ss.submit(new SubmissionRequest(null,"Name2","100","vendor1","TCS","Java","Lead1","Confirmed"));
        sr = ss.submit(new SubmissionRequest(null,"Name3","100","vendor1","TCS","Java","Lead1","Confirmed"));
    }

    @Test
    public void testSubmit()
    {
        SubmissionRequest sr1 = ss.submit(new SubmissionRequest(null,"Name4","100","vendor1","TCS","Java","Lead1","Confirmed"));

        Assertions.assertNotNull(sr1);
        Assertions.assertEquals("Name4",sr1.getName());
    }

    @Test
    public void testRetrieve()
    {
        SubmissionRequest sr1 = ss.retrieve(sr.getId());

        Assertions.assertEquals(sr1.getId(),sr.getId());
    }

    @Test
    public void testRemove()
    {
        ss.remove(sr.getId());

        Assertions.assertNull(ss.retrieve(sr.getId()));
    }

    @Test
    public void testUpdate()
    {
        Boolean b1 = ss.update(new SubmissionRequest(sr.getId(),"Name","100","vendor1","TCS","Java","Lead1","Confirmed"));
        Boolean b2 = ss.update(new SubmissionRequest(null,"Name","100","vendor1","TCS","Java","Lead1","Confirmed"));

        Assertions.assertFalse(b2);
        Assertions.assertTrue(b1);
        Assertions.assertEquals("Name",ss.retrieve(sr.getId()).getName());
    }

    @Test
    public void testRetrieveAll()
    {
        List<SubmissionRequest> lst = ss.retrieveAll();

        Assertions.assertEquals(3,lst.size());
    }

}
