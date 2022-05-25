package com.example.changedaworld.util.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.changedaworld.R;

public class WebActivity extends AppCompatActivity {

    String selectedItem = "https://google.ru/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_web);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedItem = extras.getString("url");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebFragment fragment = (WebFragment) getSupportFragmentManager()
                .findFragmentById(R.id.webFragment);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        if (fragment != null){
            WebView browser = findViewById(R.id.webBrowser);
            browser.getSettings().setJavaScriptEnabled(true);
            System.out.println(selectedItem);
            browser.loadUrl(selectedItem);
        }
    }
}