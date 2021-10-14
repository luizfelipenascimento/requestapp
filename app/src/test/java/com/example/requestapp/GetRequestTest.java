package com.example.requestapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.requestapp.models.GetRequest;
import com.example.requestapp.models.HttpRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GetRequestTest {

    private String url;

    @Before
    public void configure() {
        this.url = "http://example.com/user";
    }

    @Test
    public void shouldConfigureURLParametersWhenNoneIsProvided() throws IOException {
        GetRequest getRequest = new GetRequest(this.url);
        getRequest.addParameter("nome", "luiz");
        getRequest.addParameter("age", "26");

        HttpURLConnection connection = getRequest.getHttpConnection();
        String url = connection.getURL().toString();

        String expectedUrl = this.url + "?nome=luiz&age=26";
        assertEquals(expectedUrl, url);
        assertEquals("nome=luiz&age=26", connection.getURL().getQuery());
    }
    
    @Test
    public void shouldAppendNewURLParameter() throws IOException {
        String expectedUrl = this.url + "?nome=luiz&age=26";

        GetRequest getRequest = new GetRequest(expectedUrl);
        getRequest.addParameter("cpf", "000000000");

        expectedUrl += "&cpf=000000000";

        HttpURLConnection connection = getRequest.getHttpConnection();
        String url = connection.getURL().toString();

        assertEquals(expectedUrl, url);
    }
}