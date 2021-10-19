package com.example.requestapp;

import androidx.lifecycle.ViewModel;

import com.example.requestapp.models.HttpRequest;
import com.example.requestapp.models.HttpRequestHelper;

public class RequestViewModel extends ViewModel {

    private final HttpRequestHelper httpRequestHelper = new HttpRequestHelper();

    public void prepareRequest(HttpRequest request) {
        httpRequestHelper.makeRequest(request);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        System.out.println("on cleared called");
    }
}
