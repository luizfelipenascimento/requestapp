package com.example.requestapp.models;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class PostRequest extends HttpRequest {

    private static final String METHOD = "POST";
    private String content;

    public PostRequest(String url, String content) throws MalformedURLException {
        super(METHOD, url);
        this.content = content;
    }

    @Override
    public HttpURLConnection getHttpConnection() throws IOException {
        HttpURLConnection connection = super.getHttpConnection();

        connection.setDoOutput(true);

        return connection;
    }
}
