package com.deleir.alc_1_challenge;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class ActivityB extends AppCompatActivity {
    String url = "https://andela.com/alc/";
    private ProgressBar mProgressLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mProgressLoading = findViewById(R.id.pb_loading);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.toolAbout);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setTitle(getString(R.string.about_alc));
        //getSupportActionBar(getColor(R.color.toolbarText));
        //myToolbar.setTitle(getString(R.string.about_alc));
        //myToolbar.setTitleTextColor(getResources().getColor(R.color.toolbarText));

        //add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Webview loading url
        WebView webView = findViewById(R.id.myWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mProgressLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressLoading.setVisibility(View.INVISIBLE);
            }
        });



    }
}
