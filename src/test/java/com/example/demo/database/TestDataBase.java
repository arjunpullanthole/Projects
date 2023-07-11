package com.example.demo.database;

import com.example.demo.dto.SubmissionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class TestDataBase {
    private DataBase db;
    @BeforeEach
    public void setup()
    {
        db = new DataBase();
        db.store(new SubmissionRequest(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b"),"Name1","100","vendor1","TCS","Java","Lead1","Confirmed"));
        db.store(new SubmissionRequest(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb5123b"),"Name2","70","vendor2","Wipro","Angular","Lead2","Confirmed"));
        db.store(new SubmissionRequest(UUID.fromString("b1a134b7-2d65-43c4-823a-cb834bb54b3b"),"Name3","120","vendor3","Infosys","React","Lead3","Confirmed"));
    }

    @Test
    public void testStore()
    {
        SubmissionRequest sr = db.store(new SubmissionRequest(UUID.fromString("a1a134b7-2d65-43c4-823a-cb834bb54b3b"),"Name4","120","vendor3","Infosys","React","Lead3","Confirmed"));
        Assertions.assertNotNull(sr);
        Assertions.assertEquals(4,db.fetchAll().size());
        Assertions.assertEquals(UUID.fromString("a1a134b7-2d65-43c4-823a-cb834bb54b3b"),sr.getId());
    }

    @Test
    public void testFetch()
    {
        SubmissionRequest sr = db.fetch(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b"));

        Assertions.assertEquals(sr.getId(),UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b"));
        Assertions.assertEquals("100",sr.getRate());
    }

    @Test
    public void testUpdate()
    {
        Boolean b1 = db.update(new SubmissionRequest(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b"),"Name0","100","vendor1","TCS","Java","Lead1","Confirmed"));
        Boolean b2 = db.update(new SubmissionRequest(UUID.fromString("b1b134b7-2d65-43c4-823a-cb837bb54b3b"),"Name3","100","vendor1","TCS","Java","Lead1","Confirmed"));

        Assertions.assertTrue(b1);
        Assertions.assertFalse(b2);
    }

    @Test
    public void testDelete()
    {
        db.delete(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b"));

        Assertions.assertEquals(2,db.fetchAll().size());
        Assertions.assertNull(db.fetch(UUID.fromString("b1a134b7-2d65-43c4-823a-cb837bb54b3b")));
    }

    @Test
    public void testFetchAll()
    {
        List<SubmissionRequest> lst = db.fetchAll();

        Assertions.assertNotNull(lst);
        Assertions.assertEquals(3,lst.size());
    }
}
