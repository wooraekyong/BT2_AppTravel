package com.wooraekyong.bt2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT_Contact = 5000;  //chờ 5 giây
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {

                Intent Contact = new Intent(ContactActivity.this,MainActivity.class);
                startActivity(Contact);
                finish();

            }

        },SPLASH_TIME_OUT_Contact);
    }
}
