package com.example.requestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.requestapp.models.GetRequest;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    private RequestViewModel requestViewModel;
    private EditText urlEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditView = this.findViewById(R.id.url_edit_text);
        requestViewModel = new ViewModelProvider(this).get(RequestViewModel.class);

        urlEditView.setFilters(new InputFilter[] {
                new InputFilter.AllCaps() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        return String.valueOf(source).toLowerCase();
                    }
                }
        });
    }

    public void sendRequest(View view) {
        String url = urlEditView.getText().toString();

        try {
            requestViewModel.prepareRequest(new GetRequest(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}