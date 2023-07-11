package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class TestSubmissionHandler {

    static private HttpClient httpClient;
    static List<String> lst = new ArrayList<>();
    private static String url = "http://localhost:8080/Submission";

    @BeforeEach
    public void setUp() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void testGet() throws IOException
    {
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        BufferedReader reader = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody.toString());

        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
        Assertions.assertEquals("[]",responseBody.toString());
    }

    @Test
    public void testPost() throws IOException
    {
        HttpPost request = new HttpPost(url + "/data");
        String requestBody = "{\"name\":\"Name1\"," +
                "\"rate\":\"95\"," +
                "\"vendor\":\"vendor1\"," +
                "\"implementation\":\"TCS\"," +
                "\"technology\":\"Angular\","+
                "\"lead\":\"Praveen\",\n"+
                "\"status\":\"CONFIRMED\"}";
        request.setEntity(new StringEntity(requestBody));
        request.setHeader("Content-Type", "application/json");
        HttpResponse response = httpClient.execute(request);
        //get response body
        BufferedReader reader = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody.toString());
        lst.add(rootNode.get("id").asText());

        Assertions.assertEquals(201, response.getStatusLine().getStatusCode());
        Assertions.assertEquals("Name1",rootNode.get("name").asText());

    }

    @Test
    public void testPut() throws IOException
    {
        HttpPost request = new HttpPost(url + "/data");
        String requestBody = "{\"name\":\"Name3\"," +
                "\"rate\":\"95\"," +
                "\"vendor\":\"vendor3\"," +
                "\"implementation\":\"TCS\"," +
                "\"technology\":\"Angular\","+
                "\"lead\":\"Praveen\",\n"+
                "\"status\":\"CONFIRMED\"}";
        request.setEntity(new StringEntity(requestBody));
        request.setHeader("Content-Type", "application/json");
        HttpResponse response = httpClient.execute(request);
        //get response body
        BufferedReader reader = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody.toString());
        lst.add(rootNode.get("id").asText());
        //update using PUT
        HttpPut request1 = new HttpPut(url + "/data");
        String requestBody1 = "{\"id\":\""+ rootNode.get("id").asText()+ "\"," +
                "\"name\":\"Name2\"," +
                "\"rate\":\"95\"," +
                "\"vendor\":\"vendor2\"," +
                "\"implementation\":\"TCS\"," +
                "\"technology\":\"Angular\","+
                "\"lead\":\"Praveen\",\n"+
                "\"status\":\"CONFIRMED\"}";
        request1.setEntity(new StringEntity(requestBody1));
        request1.setHeader("Content-Type", "application/json");
        HttpResponse response1 = httpClient.execute(request1);

        Assertions.assertEquals(200, response1.getStatusLine().getStatusCode());
    }

    @Test
    public void testDelete() throws IOException
    {
        HttpDelete request = new HttpDelete(url + "/" +lst.get(0));
        HttpResponse response = httpClient.execute(request);

        Assertions.assertEquals(204,response.getStatusLine().getStatusCode());
    }

    @AfterAll
    public static void cleanup()
    {
        lst.forEach(s ->{
            HttpDelete request = new HttpDelete(url + "/" + s );
            try {
                HttpResponse response = httpClient.execute(request);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
