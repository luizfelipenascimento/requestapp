package com.example.requestapp.models;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpRequestHelper {

    private static String TAG = "HttpRequestHelper";

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
                    InputStream in = new BufferedInputStream(connection.getInputStream());

                    String result = IOUtils.toString(in, StandardCharsets.UTF_8);
                    Log.d(TAG, "makeRequest: response received");
                    Log.d(TAG, "makeRequest: response: " + result);
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
