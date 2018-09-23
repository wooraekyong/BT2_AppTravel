package com.wooraekyong.bt2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

public class EatActivity extends AppCompatActivity {

    private ImageButton imgbtn;
    private SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);
        anhxa();
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void anhxa(){
        imgbtn = (ImageButton) findViewById(R.id.imageButton);
        search = (SearchView) findViewById(R.id.seach_view);
    }
}
