package com.example.yashshah.colorhuntgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private AlertDialog.Builder adb;
    private AlertDialog ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     b1=(Button)findViewById(R.id.button3);
     b2=(Button)findViewById(R.id.button4);
     b3=(Button)findViewById(R.id.button5);
     b4=(Button)findViewById(R.id.button6);

     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent =new Intent(Main2Activity.this,Main65Activity.class);
             Main2Activity.this.startActivity(intent);
             Main2Activity.this.finish();
         }
     });
     b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent =new Intent(Main2Activity.this,Main4Activity.class);
             Main2Activity.this.startActivity(intent);
             Main2Activity.this.finish();
         }
     });
     b3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent =new Intent(Main2Activity.this,Main45Activity.class);
             Main2Activity.this.startActivity(intent);
             Main2Activity.this.finish();
         }
     });
     b4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent =new Intent(Main2Activity.this,Main35Activity.class);
             Main2Activity.this.startActivity(intent);
             Main2Activity.this.finish();
         }
     });
     adb=new AlertDialog.Builder(this);
     adb.setCancelable(false);
     adb.setMessage("Do you really want to exit?");
     adb.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                finish();
            }
        });
     adb.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){

            }
        });
        ad=adb.create();
        ad.setTitle("Yes or no?");


    }

    @Override
    public void onBackPressed() {
        ad.show();
    }
}
