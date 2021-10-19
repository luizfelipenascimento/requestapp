package com.example.requestapp.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpRequestHelper {

    private ExecutorService executorService;
    private HttpResponse httpResponse;

    public HttpRequestHelper() {
        executorService = Executors.newSingleThreadExecutor();
    }

    public void makeRequest(final HttpRequest request) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final HttpURLConnection connection = request.getHttpConnection();
                    InputStream in = connection.getInputStream();
                    System.out.println(in);
                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }
}
