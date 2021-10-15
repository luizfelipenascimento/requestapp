package com.example.requestapp.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class HttpRequest {

    protected String url;
    private Map<String, String> headers;
    private String method;

    protected HttpRequest(String method, String url) throws MalformedURLException {
        this.url = url;
        this.method = method;
        headers = new HashMap<>();
    }

    public synchronized HttpURLConnection getHttpConnection() throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(this.method);

        for (Map.Entry<String, String> entry: headers.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        return connection;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
