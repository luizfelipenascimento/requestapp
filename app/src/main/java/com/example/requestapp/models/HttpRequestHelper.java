package com.example.requestapp.models;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestHelper {

    private URL url;
    private String method;
    private Map<String, String> headers;

    public HttpRequestHelper(String method, String url) throws MalformedURLException {
        this.method = method;
        this.url = new URL(url);
        this.headers = new HashMap<>();
    }

    public void makeRequest() {
        HttpURLConnection http;
            try {
                http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod(method);

                for(Map.Entry<String, String> entry : headers.entrySet())
                    http.addRequestProperty(entry.getKey(), entry.getValue());

                InputStream in = new BufferedInputStream(http.getInputStream());

                System.out.println(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
