package com.wooraekyong.bt2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeeActivity extends AppCompatActivity {
    private ImageButton imgbtn;
    private SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);

        anhxa();
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<Place> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this,image_details));

        //Khi ng dùng click vào cái ListItems




    }
    public void anhxa(){
        imgbtn = (ImageButton) findViewById(R.id.imageButton);
        search = (SearchView) findViewById(R.id.seach_view);
    }
    private  List<Place> getListData() {
        List<Place> list = new ArrayList<Place>();
        Place beach = new Place("Pattaya Beach", "logo_1.jpg", 320000);
        Place walkingstreet = new Place("Walking Street", "logo_2.png", 1000);
        Place show = new Place("Alcazar Show", "logo_3.png", 350);


        list.add(beach);
        list.add(walkingstreet);
        list.add(show);

        return list;
    }
}
