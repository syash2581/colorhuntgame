package com.example.yashshah.colorhuntgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

        private Button b1;
        private Button b2;
        private Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);
        b3=(Button)findViewById(R.id.button9);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main4Activity.this,Main15Activity.class);
                Main4Activity.this.startActivity(intent);
                Main4Activity.this.finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main4Activity.this,Main5Activity.class);
                Main4Activity.this.startActivity(intent);
                Main4Activity.this.finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main4Activity.this,Main25Activity.class);
                Main4Activity.this.startActivity(intent);
                Main4Activity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main4Activity.this,Main2Activity.class);
        Main4Activity.this.startActivity(intent);
        Main4Activity.this.finish();
    }
}
