package com.nyuciverse.passwordmanager.init;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.nyuciverse.passwordmanager.R;
import com.nyuciverse.passwordmanager.util.StateChecker;

public class WelcomeActivity extends AppCompatActivity {


    private static final int AUTO_HIDE_DELAY_MILLIS = 2000;

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        mHideHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,StartManagerActivity.class));
                finish();

            }
        },AUTO_HIDE_DELAY_MILLIS);

           }


}
