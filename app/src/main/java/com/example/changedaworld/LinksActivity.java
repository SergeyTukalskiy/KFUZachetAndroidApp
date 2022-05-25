package com.example.changedaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.changedaworld.util.fragments.FragmentList;
import com.example.changedaworld.util.fragments.WebActivity;
import com.example.changedaworld.util.fragments.WebFragment;

public class LinksActivity extends AppCompatActivity implements FragmentList.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
    }

    @Override
    public void onSendData(String selectedItem) {
        WebFragment fragment = (WebFragment) getSupportFragmentManager()
                .findFragmentById(R.id.webFragment);
        if (fragment != null && fragment.isVisible()){
            WebView browser = findViewById(R.id.webBrowser);
            browser.loadUrl(selectedItem);
        }
        else {
            Intent intent = new Intent(getApplicationContext(),
                    WebActivity.class);
            intent.putExtra("url", selectedItem);
            startActivity(intent);
        }
    }

    public void goMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}