package com.example.wowsstats;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.http.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity{
    private WebView webView;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.shipweb);

            webView = new WebView(this);
            wireWidgets();
            webView.setWebViewClient(new WebViewClient());



           String url = getIntent().getStringExtra("url");
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

            webView.loadUrl(url);












        }




        public void wireWidgets()
        {
            webView =  findViewById(R.id.webview);



        }
    }






