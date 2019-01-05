package com.nyuciverse.passwordmanager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ImageView homeBtn;
    private static final String GOOGLE_PASSWORDS_URL = "https://passwords.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        homeBtn = findViewById(R.id.web_home_btn);

        getSupportActionBar().setTitle(R.string.webView_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        getSupportActionBar().setIcon(R.drawable.ic_lock_outline);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient(this));
        loadPage(GOOGLE_PASSWORDS_URL);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(GOOGLE_PASSWORDS_URL);
            }
        });

    }

    public void loadPage(String url){

        webView.loadUrl(url);

    }
}
