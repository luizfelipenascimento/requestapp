package com.example.requestapp.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetRequest extends HttpRequest {

    private static final String METHOD = "GET";
    private Map<String, String> parameters;

    public GetRequest(String url) throws MalformedURLException {
        super(METHOD, url);
        parameters = new HashMap<>();
    }

    private void configureParameters() {
        if (parameters.entrySet().isEmpty())
            return;

        String url = this.url;

        if (!url.contains("?")) url += "?";

        if (url.charAt(url.length() -1) != '?') url += "&";

        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();

            if (iterator.hasNext())
                url += entry.getKey() + "=" + entry.getValue() + "&";
            else
                url += entry.getKey() + "=" + entry.getValue();
        }

        this.url = url;
    }

    public void addParameter(String key, String value) {
        parameters.put(key, value);
    }

    @Override
    public HttpURLConnection getHttpConnection() throws IOException {
        configureParameters();
        System.out.println(url);
        return super.getHttpConnection();
    }
}
