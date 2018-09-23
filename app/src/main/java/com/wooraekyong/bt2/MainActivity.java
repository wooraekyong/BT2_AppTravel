package com.wooraekyong.bt2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnExit;

    private RadioButton radio_1;
    private RadioButton radio_2;
    private RadioButton radio_3;
    private RadioGroup radio_group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ánh xạ
        Anhxa();



        //code
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 radio_1.setChecked(false);
                 radio_2.setChecked(false);
                 radio_3.setChecked(false);
                showAlertDialog();
            }
        });
        XulyRadioButton();
    }
    // xử lý cảnh báo khi nhất nút Exit

    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Travel Around Pattaya");
        builder.setMessage("Do you want to exit?");

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {  //nút negative là bên trái
            @Override
            public void onClick(DialogInterface dialog, int which) { //tắt ứng dụng

//                finish();
//                System.exit(1);
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
         builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 dialog.dismiss();
             }
         });
         //set giao diện vào AlertDialog và show lên
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

// CÁCH NÀY SAI!!!!
//    public void XulyRadioButton(){
//       int idChecked = radio_group.getCheckedRadioButtonId();
//       switch (idChecked){
//           case R.id.rbtn_1:
//               Intent intent_see = new Intent(MainActivity.this, SeeActivity.class);
//               startActivity(intent_see);
//               break;
//           case R.id.rbtn_2:
//               Intent intent_eat = new Intent(MainActivity.this, EatActivity.class);
//               startActivity(intent_eat);
//               break;
//           case R.id.rbtn_3:
//               Intent intent_contact = new Intent(MainActivity.this, ContactActivity.class);
//               startActivity(intent_contact);
//               break;
//
//       }
//
//    }
    // CÁCH NÀY CŨNG SAI !!!
//    public void XulyRadioButton(){
////
//////        if (radio_1.isChecked()==true){
//////            Intent intent_see = new Intent(MainActivity.this, SeeActivity.class);
//////            startActivity(intent_see);
//////
//////        }
////////        else if(radio_2.isChecked()){
////////            Intent intent_eat = new Intent(MainActivity.this, EatActivity.class);
////////            startActivity(intent_eat);
////////        } else if (radio_3.isChecked()){
////////            Intent intent_contact = new Intent(MainActivity.this, ContactActivity.class);
////////            startActivity(intent_contact);
////////        }
////
////
////
////    }

    public void XulyRadioButton(){
//        radio_group.check(R.id.rbtn_1); // ban đầu tick ô ở radio 1 trước :v
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              if (checkedId == R.id.rbtn_1) {
                  Intent intent_see = new Intent(MainActivity.this, SeeActivity.class);
                startActivity(intent_see);
              } else if(checkedId == R.id.rbtn_2){
                  Intent intent_eat = new Intent(MainActivity.this, EatActivity.class);
                startActivity(intent_eat);
              } else if (checkedId == R.id.rbtn_3){
                  Toast.makeText(MainActivity.this, "Waiting 5 secs...", Toast.LENGTH_SHORT).show();
                  Intent intent_contact = new Intent(MainActivity.this, ContactActivity.class);
                  startActivity(intent_contact);
              }
            }
        });
    }
    public void Anhxa(){

        btnExit = (ImageButton) findViewById(R.id.btn_exit);

        radio_1 = (RadioButton) findViewById(R.id.rbtn_1);
        radio_2 = (RadioButton) findViewById(R.id.rbtn_2);
        radio_3 = (RadioButton) findViewById(R.id.rbtn_3);
        radio_group = (RadioGroup) findViewById(R.id.radiogroup);
    }
}
