package com.example.myiliad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myiliad.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView mWebView = findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if(ContextCompat.checkSelfPermission(MainActivity.this, //getActivity()
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED){

            //Chiama una nuova activity con un messaggio di errore che chiuderà l'app.
            Intent intent = new Intent(this, Error.class);
            String message = getString(R.string.error_NoInternet);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }else
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://iliad.it/areapersonale/");
    }
}
