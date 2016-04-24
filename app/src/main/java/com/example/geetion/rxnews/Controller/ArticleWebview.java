package com.example.geetion.rxnews.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.geetion.rxnews.R;


public class ArticleWebview extends AppCompatActivity {

    private WebView mwebView;

    private String murl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        murl = intent.getStringExtra("url");

        mwebView = (WebView) findViewById(R.id.mywebView);
        mwebView.loadUrl(murl);

    }
}
