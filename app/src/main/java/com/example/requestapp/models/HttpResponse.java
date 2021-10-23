package com.example.requestapp.models;

public class HttpResponse {

    private String header;
    private short statusCode;
    private String body;

    public HttpResponse(String body) {
        this.body = body;
    }

}
