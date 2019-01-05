package com.nyuciverse.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Manjeet Dayal on 07-08-2018.
 */

public class MyWebViewClient extends WebViewClient {

    private Context context;
    private String TAG = "WebViewClient";

    public MyWebViewClient(Context context){
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {


        if(request.getUrl().getHost().equals("passwords.google.com"))
            return false;
        else if(request.getUrl().equals(Uri.parse("https://myaccount.google.com/security"))){
//            TODO listener

            Log.d(TAG,"backClickedInWebView");
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());

        context.startActivity(intent);

        return true;

//        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        //started loading

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        //finished loading
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);

        Log.e(TAG,"Error");

    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);

        Log.d(TAG,"receivedHttpAuthRequest");
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
        Log.d(TAG,"receivedLoginRequest");
    }
}


