package com.nyuciverse.passwordmanager.init;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.nyuciverse.passwordmanager.R;
import com.nyuciverse.passwordmanager.util.StateChecker;

public class StartManagerActivity extends AppCompatActivity {

    private StateChecker checker;
    private static final int REQUEST_SET_PIN = 102;

    private Intent intent;
    private Button btnSetPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_manager);

        intent = new Intent(StartManagerActivity.this, EnterPinActivity.class);
        btnSetPin = findViewById(R.id.set_pin_btn);

        if(checker.isPasscodeSet()){

            intent.putExtra("EXTRA_SET_PIN",false);
            askForPin();
        }

        btnSetPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("EXTRA_SET_PIN",true);
                askForPin();
            }
        });


    }

    protected void askForPin(){

        startActivityForResult(intent,REQUEST_SET_PIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {

            if (requestCode == REQUEST_SET_PIN) {
//            got to enter pin now
                checker.setPasscodeSet(true);
                askForPin();

            }
        }
    }
}
