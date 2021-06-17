package com.example.yashshah.colorhuntgame;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main49Activity extends AppCompatActivity {

    private AlertDialog.Builder adb;
    private AlertDialog ad;

    public CountDownTimer t3;

    private int i1=5;
    private int i2=i1;
    private int t=3;
    private int temp=t;

    private int counter=0;

    private boolean ans;

    private int crow=0;
    //private String cbutt="";
    //private String cbcol="";

    private String r1="";
    private String r1col="";

    private String r2="";
    private String r2col="";

    private String r3="";
    private String r3col="";

    private String r4="";
    private String r4col="";

    private String r5="";
    private String r5col="";

    private Button bt00;
    private Button bt01;
    private Button bt02;
    private Button bt03;


    private String s00;
    private String s01;
    private String s02;
    private String s03;

    private Button bt10;
    private Button bt11;
    private Button bt12;


    private String s10;
    private String s11;
    private String s12;

    private String sbcol10="white";
    private String sbcol11="black";
    private String sbcol12="white";


    private Button bt20;
    private Button bt21;
    private Button bt22;

    private String s20;
    private String s21;
    private String s22;

    private String sbcol20="black";
    private String sbcol21="white";
    private String sbcol22="black";

    private Button bt30;
    private Button bt31;
    private Button bt32;


    private String s30;
    private String s31;
    private String s32;

    private String sbcol30="white";
    private String sbcol31="black";
    private String sbcol32="white";

    private Button bt40;
    private Button bt41;
    private Button bt42;


    private String s40;
    private String s41;
    private String s42;


    private String sbcol40="black";
    private String sbcol41="white";
    private String sbcol42="black";

    private Button bt50;
    private Button bt51;
    private Button bt52;


    private String s50;
    private String s51;
    private String s52;

    private String sbcol50="white";
    private String sbcol51="black";
    private String sbcol52="white";


    private int score=0;

    private int hscore;
    private String hsname;


    private ProgressDialog progress;

    private TextView tvtr2;

    private int time=8;
    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvtr2=(TextView)findViewById(R.id.tvtr2);
        tvtr2.setText(""+t);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Storing Results");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(25);

        bt00=(Button)findViewById(R.id.bt00);
        bt01=(Button)findViewById(R.id.bt01);
        bt02=(Button)findViewById(R.id.bt02);
        bt03=(Button)findViewById(R.id.bt03);

        bt10=(Button)findViewById(R.id.bt10);
        bt11=(Button)findViewById(R.id.bt11);
        bt12=(Button)findViewById(R.id.bt12);


        bt20=(Button)findViewById(R.id.bt20);
        bt21=(Button)findViewById(R.id.bt21);
        bt22=(Button)findViewById(R.id.bt22);

        bt30=(Button)findViewById(R.id.bt30);
        bt31=(Button)findViewById(R.id.bt31);
        bt32=(Button)findViewById(R.id.bt32);

        bt40=(Button)findViewById(R.id.bt40);
        bt41=(Button)findViewById(R.id.bt41);
        bt42=(Button)findViewById(R.id.bt42);

        bt50=(Button)findViewById(R.id.bt50);
        bt51=(Button)findViewById(R.id.bt51);
        bt52=(Button)findViewById(R.id.bt52);

        bt00.setBackgroundColor(Color.parseColor("red"));
        bt00.setText("red");
        bt00.setTextColor(Color.parseColor("red"));

        bt01.setBackgroundColor(Color.parseColor("green"));
        bt01.setText("green");
        bt01.setTextColor(Color.parseColor("green"));

        bt02.setBackgroundColor(Color.parseColor("blue"));
        bt02.setText("blue");
        bt02.setTextColor(Color.parseColor("blue"));

        bt03.setBackgroundColor(Color.parseColor("yellow"));
        bt03.setText("yellow");
        bt03.setTextColor(Color.parseColor("yellow"));

        bt11.setText("red");
        bt11.setTextColor(Color.parseColor("blue"));
        s11="blue";
        crow=0;
        r1="bt11";
        r1col=sbcol11;


        bt20.setText("green");
        bt20.setTextColor(Color.parseColor("red"));
        s20="red";
        r2="bt20";
        r2col=sbcol20;

        bt32.setText("red");
        bt32.setTextColor(Color.parseColor("green"));
        s32="green";
        r3="bt32";
        r3col=sbcol32;

        bt42.setText("blue");
        bt42.setTextColor(Color.parseColor("blue"));
        s42="blue";
        r4="bt42";
        r4col=sbcol42;


        bt50.setText("yellow");
        bt50.setTextColor(Color.parseColor("yellow"));
        s50="yellow";
        r5="bt50";
        r5col=sbcol50;

        i1-=1;

        adb=new AlertDialog.Builder(this);
        t3=new  CountDownTimer((t*1000), 1000) {
            public void onTick(long millisUntilFinished) {
                if(flag) {
                    tvtr2.setText(String.valueOf(time / 2));
                    time = time - 1;
                }
                else
                {
                    tvtr2.setText(String.valueOf(time));
                    time = time - 1;
                }
            }
            public void onFinish() {
                t3.cancel();
                adb.setCancelable(false);
                i1+=1;
                adb.setMessage("Your Score is:"+score);
                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Intent intent=new Intent(Main49Activity.this,Main2Activity.class);
                        Main49Activity.this.startActivity(intent);
                        Main49Activity.this.finish();
                    }
                });
                adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Main49Activity.this.finish();
                        Intent intent=new Intent(Main49Activity.this,Main49Activity.class);
                        Main49Activity.this.startActivity(intent);
                    }
                });
                ad=adb.create();
                ad.setTitle("Level Failed");
                ad.show();
            }
        };
        t3.start();

        bt00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bt00.getText().toString());
            }
        });

        bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bt01.getText().toString());
            }
        });

        bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bt02.getText().toString());
            }
        });

        bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bt03.getText().toString());
            }
        });
    }
    public void check(String s)
    {
        crow+=1;
        if(crow==1)
        {
            if(r1.equals("bt10") || r1.equals("bt12"))
            {
                ans=word_match(s,r1);
                if(ans)
                {
                    bt10.setText("");
                    bt12.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                {
                    Failed();
                }
            }
            else
            {
                ans=color_match(s,s11);
                if(ans)
                {
                    bt11.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
        }
        else if(crow==2)
        {
            if(r2.equals("bt20"))
            {
                ans=color_match(s,s20);
                if(ans)
                {
                    bt20.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
            else if(r2.equals("bt22"))
            {
                ans=color_match(s,s22);
                if(ans)
                {
                    bt22.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
            else
            {
                ans=word_match(s,r2);
                if(ans)
                {
                    bt21.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
        }
        else if(crow==3)
        {
            if(r3.equals("bt30") || r3.equals("bt32"))
            {
                ans=word_match(s,r3);
                if(ans)
                {
                    bt30.setText("");
                    bt32.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
            else
            {
                ans=color_match(s,s31);
                if(ans)
                {
                    bt31.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
        }
        else if(crow==4)
        {
            if(r4.equals("bt40"))
            {
                ans=color_match(s,s40);
                if(ans)
                {
                    bt40.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
            else if(r4.equals("bt42"))
            {
                ans=color_match(s,s42);
                if(ans)
                {
                    bt42.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
            else
            {
                ans=word_match(s,r4);
                if(ans)
                {
                    bt41.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    t3.start();
                }
                else
                    Failed();
            }
        }
        else
        {
            if(r5.equals("bt50") || r5.equals("bt52"))
            {
                ans=word_match(s,r5);
                if(ans)
                {
                    bt50.setText("");
                    bt52.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;

                    set();
                }
                else
                    Failed();

            }
            else
            {
                ans=color_match(s,s51);
                if(ans)
                {
                    bt51.setText("");
                    t3.cancel();
                    time=3;
                    flag=false;
                    set();
                }
                else
                    Failed();
            }
        }
    }


    public boolean word_match(String s,String s2)
    {
        if(s2.equals("bt10"))
        {
            if(s.equals(bt10.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }
        }
        else if(s2.equals("bt12"))
        {
            if(s.equals(bt12.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }

        }
        else if(s2.equals("bt21"))
        {
            if(s.equals(bt21.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {return false;
            }

        }
        else if(s2.equals("bt30"))
        {
            if(s.equals(bt30.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }

        }
        else if(s2.equals("bt32"))
        {
            if(s.equals(bt32.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }
        }
        else if(s2.equals("bt41"))
        {
            if(s.equals(bt41.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }
        }
        else if (s2.equals("bt50"))
        {
            if(s.equals(bt50.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(s.equals(bt52.getText().toString().toLowerCase()))
            {
                score=(score)+(1*10*time); return true; 
            }
            else
            {
                return false;
            }
        }

    }
    public boolean color_match(String s,String s2)
    {
        if(s.toLowerCase().equals(s2.toLowerCase()))
        {
            score=(score)+(1*10*time); return true; 
        }
        else
        {
            return false;
        }
    }
    public void set()
    {
        if(i1>0) {
            crow = 0;
            Random ran = new Random();
            int n2 = ran.nextInt(3) + 1;

            switch (n2) {
                case 1:
                    int n3 = ran.nextInt(4) + 1;
                    switch (n3) {
                        case 1:
                            bt10.setText("red");
                            break;
                        case 2:
                            bt10.setText("blue");
                            break;
                        case 3:
                            bt10.setText("green");
                            break;
                        case 4:
                            bt10.setText("yellow");
                            break;
                    }
                    int n4 = ran.nextInt(4) + 1;
                    switch (n4) {
                        case 1:
                            bt10.setTextColor(Color.parseColor("red"));
                            s10 = "red";
                            break;
                        case 2:
                            bt10.setTextColor(Color.parseColor("blue"));
                            s10 = "blue";
                            break;
                        case 3:
                            bt10.setTextColor(Color.parseColor("green"));
                            s10 = "green";
                            break;
                        case 4:
                            bt10.setTextColor(Color.parseColor("yellow"));
                            s10 = "yellow";
                            break;
                    }
                    crow = 0;
                    r1 = "bt10";
                    r1col = sbcol10;
                    break;

                case 2:
                    int n5 = ran.nextInt(4) + 1;
                    switch (n5) {
                        case 1:
                            bt11.setText("red");
                            break;
                        case 2:
                            bt11.setText("blue");
                            break;
                        case 3:

                            bt11.setText("green");
                            break;
                        case 4:
                            bt11.setText("yellow");
                            break;
                    }
                    int n6 = ran.nextInt(4) + 1;
                    switch (n6) {
                        case 1:
                            bt11.setTextColor(Color.parseColor("red"));
                            s11 = "red";
                            break;
                        case 2:
                            bt11.setTextColor(Color.parseColor("blue"));
                            s11 = "blue";
                            break;
                        case 3:
                            bt11.setTextColor(Color.parseColor("green"));
                            s11 = "green";
                            break;
                        case 4:
                            bt11.setTextColor(Color.parseColor("yellow"));
                            s11 = "yellow";
                            break;
                    }
                    crow = 0;
                    r1 = "bt11";
                    r1col = sbcol11;
                    break;

                case 3:
                    int n7 = ran.nextInt(4) + 1;
                    switch (n7) {
                        case 1:
                            bt12.setText("red");
                            break;
                        case 2:
                            bt12.setText("blue");
                            break;
                        case 3:
                            bt12.setText("green");
                            break;
                        case 4:
                            bt12.setText("yellow");
                            break;
                    }
                    int n8 = ran.nextInt(4) + 1;
                    switch (n8) {
                        case 1:
                            bt12.setTextColor(Color.parseColor("red"));
                            s12 = "red";
                            break;
                        case 2:
                            bt12.setTextColor(Color.parseColor("blue"));
                            s12 = "blue";
                            break;
                        case 3:
                            bt12.setTextColor(Color.parseColor("green"));
                            s12 = "green";
                            break;
                        case 4:
                            bt12.setTextColor(Color.parseColor("yellow"));
                            s12 = "yellow";
                            break;
                    }
                    crow = 0;
                    r1 = "bt12";
                    r1col = sbcol12;
                    break;
            }


            int n9 = ran.nextInt(3) + 1;

            switch (n9) {
                case 1:
                    int n3 = ran.nextInt(4) + 1;
                    switch (n3) {
                        case 1:
                            bt20.setText("red");
                            break;
                        case 2:
                            bt20.setText("blue");
                            break;
                        case 3:
                            bt20.setText("green");
                            break;
                        case 4:
                            bt20.setText("yellow");
                            break;
                    }
                    int n4 = ran.nextInt(4) + 1;
                    switch (n4) {
                        case 1:
                            bt20.setTextColor(Color.parseColor("red"));
                            s20 = "red";
                            break;
                        case 2:
                            bt20.setTextColor(Color.parseColor("blue"));
                            s20 = "blue";
                            break;
                        case 3:
                            bt20.setTextColor(Color.parseColor("green"));
                            s20 = "green";
                            break;
                        case 4:
                            bt20.setTextColor(Color.parseColor("yellow"));
                            s20 = "yellow";
                            break;
                    }
                    r2 = "bt20";
                    r2col = sbcol20;
                    break;

                case 2:
                    int n5 = ran.nextInt(4) + 1;
                    switch (n5) {
                        case 1:
                            bt21.setText("red");
                            break;
                        case 2:
                            bt21.setText("blue");
                            break;
                        case 3:
                            bt21.setText("green");
                            break;
                        case 4:
                            bt21.setText("yellow");
                            break;
                    }
                    int n6 = ran.nextInt(4) + 1;
                    switch (n6) {
                        case 1:
                            bt21.setTextColor(Color.parseColor("red"));
                            s21 = "red";
                            break;
                        case 2:
                            bt21.setTextColor(Color.parseColor("blue"));
                            s21 = "blue";
                            break;
                        case 3:
                            bt21.setTextColor(Color.parseColor("green"));
                            s21 = "green";
                            break;
                        case 4:
                            bt21.setTextColor(Color.parseColor("yellow"));
                            s21 = "yellow";
                            break;
                    }
                    r2 = "bt21";
                    r2col = sbcol21;
                    break;

                case 3:
                    int n7 = ran.nextInt(4) + 1;
                    switch (n7) {
                        case 1:
                            bt22.setText("red");
                            break;
                        case 2:
                            bt22.setText("blue");
                            break;
                        case 3:
                            bt22.setText("green");
                            break;
                        case 4:
                            bt22.setText("yellow");
                            break;
                    }
                    int n8 = ran.nextInt(4) + 1;
                    switch (n8) {
                        case 1:
                            bt22.setTextColor(Color.parseColor("red"));
                            s22 = "red";
                            break;
                        case 2:
                            bt22.setTextColor(Color.parseColor("blue"));
                            s22 = "blue";
                            break;
                        case 3:
                            bt22.setTextColor(Color.parseColor("green"));
                            s22 = "green";
                            break;
                        case 4:
                            bt22.setTextColor(Color.parseColor("yellow"));
                            s22 = "yellow";
                            break;
                    }
                    r2 = "bt22";
                    r2col = sbcol22;
                    break;
            }

            int n10 = ran.nextInt(3) + 1;

            switch (n10) {
                case 1:
                    int n3 = ran.nextInt(4) + 1;
                    switch (n3) {
                        case 1:
                            bt30.setText("red");
                            break;
                        case 2:
                            bt30.setText("blue");
                            break;
                        case 3:
                            bt30.setText("green");
                            break;
                        case 4:
                            bt30.setText("yellow");
                            break;
                    }
                    int n4 = ran.nextInt(4) + 1;
                    switch (n4) {
                        case 1:
                            bt30.setTextColor(Color.parseColor("red"));
                            s30 = "red";
                            break;
                        case 2:
                            bt30.setTextColor(Color.parseColor("blue"));
                            s30 = "blue";
                            break;
                        case 3:
                            bt30.setTextColor(Color.parseColor("green"));
                            s30 = "green";
                            break;
                        case 4:
                            bt30.setTextColor(Color.parseColor("yellow"));
                            s30 = "yellow";
                            break;
                    }
                    r3 = "bt30";
                    r3col = sbcol30;
                    break;

                case 2:
                    int n5 = ran.nextInt(4) + 1;
                    switch (n5) {
                        case 1:
                            bt31.setText("red");
                            break;
                        case 2:
                            bt31.setText("blue");
                            break;
                        case 3:
                            bt31.setText("green");
                            break;
                        case 4:
                            bt31.setText("yellow");
                            break;
                    }
                    int n6 = ran.nextInt(4) + 1;
                    switch (n6) {
                        case 1:
                            bt31.setTextColor(Color.parseColor("red"));
                            s31 = "red";
                            break;
                        case 2:
                            bt31.setTextColor(Color.parseColor("blue"));
                            s31 = "blue";
                            break;
                        case 3:
                            bt31.setTextColor(Color.parseColor("green"));
                            s31 = "green";
                            break;
                        case 4:
                            bt31.setTextColor(Color.parseColor("yellow"));
                            s31 = "yellow";
                            break;
                    }
                    r3 = "bt31";
                    r3col = sbcol31;
                    break;

                case 3:
                    int n7 = ran.nextInt(4) + 1;
                    switch (n7) {
                        case 1:
                            bt32.setText("red");
                            break;
                        case 2:
                            bt32.setText("blue");
                            break;
                        case 3:
                            bt32.setText("green");
                            break;
                        case 4:
                            bt32.setText("yellow");
                            break;
                    }
                    int n8 = ran.nextInt(4) + 1;
                    switch (n8) {
                        case 1:
                            bt32.setTextColor(Color.parseColor("red"));
                            s32 = "red";
                            break;
                        case 2:
                            bt32.setTextColor(Color.parseColor("blue"));
                            s32 = "blue";
                            break;
                        case 3:
                            bt32.setTextColor(Color.parseColor("green"));
                            s32 = "green";
                            break;
                        case 4:
                            bt32.setTextColor(Color.parseColor("yellow"));
                            s32 = "yellow";
                            break;
                    }
                    r3 = "bt32";
                    r3col = sbcol32;
                    break;
            }

            int n11 = ran.nextInt(3) + 1;

            switch (n11) {
                case 1:
                    int n3 = ran.nextInt(4) + 1;
                    switch (n3) {
                        case 1:
                            bt40.setText("red");
                            break;
                        case 2:
                            bt40.setText("blue");
                            break;
                        case 3:
                            bt40.setText("green");
                            break;
                        case 4:
                            bt40.setText("yellow");
                            break;
                    }
                    int n4 = ran.nextInt(4) + 1;
                    switch (n4) {
                        case 1:
                            bt40.setTextColor(Color.parseColor("red"));
                            s40 = "red";
                            break;
                        case 2:
                            bt40.setTextColor(Color.parseColor("blue"));
                            s40 = "blue";
                            break;
                        case 3:
                            bt40.setTextColor(Color.parseColor("green"));
                            s40 = "green";
                            break;
                        case 4:
                            bt40.setTextColor(Color.parseColor("yellow"));
                            s40 = "yellow";
                            break;
                    }
                    r4 = "bt40";
                    r4col = sbcol40;
                    break;

                case 2:
                    int n5 = ran.nextInt(4) + 1;
                    switch (n5) {
                        case 1:
                            bt41.setText("red");
                            break;
                        case 2:
                            bt41.setText("blue");
                            break;
                        case 3:
                            bt41.setText("green");
                            break;
                        case 4:
                            bt41.setText("yellow");
                            break;
                    }
                    int n6 = ran.nextInt(4) + 1;
                    switch (n6) {
                        case 1:
                            bt41.setTextColor(Color.parseColor("red"));
                            s41 = "red";
                            break;
                        case 2:
                            bt41.setTextColor(Color.parseColor("blue"));
                            s41 = "blue";
                            break;
                        case 3:
                            bt41.setTextColor(Color.parseColor("green"));
                            s41 = "green";
                            break;
                        case 4:
                            bt41.setTextColor(Color.parseColor("yellow"));
                            s41 = "yellow";
                            break;
                    }
                    r4 = "bt41";
                    r4col = sbcol41;
                    break;

                case 3:
                    int n7 = ran.nextInt(4) + 1;
                    switch (n7) {
                        case 1:
                            bt42.setText("red");
                            break;
                        case 2:
                            bt42.setText("blue");
                            break;
                        case 3:
                            bt42.setText("green");
                            break;
                        case 4:
                            bt42.setText("yellow");
                            break;
                    }
                    int n8 = ran.nextInt(4) + 1;
                    switch (n8) {
                        case 1:
                            bt42.setTextColor(Color.parseColor("red"));
                            s42 = "red";
                            break;
                        case 2:
                            bt42.setTextColor(Color.parseColor("blue"));
                            s42 = "blue";
                            break;
                        case 3:
                            bt42.setTextColor(Color.parseColor("green"));
                            s42 = "green";
                            break;
                        case 4:
                            bt42.setTextColor(Color.parseColor("yellow"));
                            s42 = "yellow";
                            break;
                    }
                    r4 = "bt42";
                    r4col = sbcol42;
                    break;
            }

            int n12 = ran.nextInt(3) + 1;

            switch (n12) {
                case 1:
                    int n3 = ran.nextInt(4) + 1;
                    switch (n3) {
                        case 1:
                            bt50.setText("red");
                            break;
                        case 2:
                            bt50.setText("blue");
                            break;
                        case 3:
                            bt50.setText("green");
                            break;
                        case 4:
                            bt50.setText("yellow");
                            break;
                    }
                    int n4 = ran.nextInt(4) + 1;
                    switch (n4) {
                        case 1:
                            bt50.setTextColor(Color.parseColor("red"));
                            s50 = "red";
                            break;
                        case 2:
                            bt50.setTextColor(Color.parseColor("blue"));
                            s50 = "blue";
                            break;
                        case 3:
                            bt50.setTextColor(Color.parseColor("green"));
                            s50 = "green";
                            break;
                        case 4:
                            bt50.setTextColor(Color.parseColor("yellow"));
                            s50 = "yellow";
                            break;
                    }
                    r5 = "bt50";
                    r5col = sbcol50;
                    break;
                case 2:
                    int n5 = ran.nextInt(4) + 1;
                    switch (n5) {
                        case 1:
                            bt51.setText("red");
                            break;
                        case 2:
                            bt51.setText("blue");
                            break;
                        case 3:
                            bt51.setText("green");
                            break;
                        case 4:
                            bt51.setText("yellow");
                            break;
                    }
                    int n6 = ran.nextInt(4) + 1;
                    switch (n6) {
                        case 1:
                            bt51.setTextColor(Color.parseColor("red"));
                            s51 = "red";
                            break;
                        case 2:
                            bt51.setTextColor(Color.parseColor("blue"));
                            s51 = "blue";
                            break;
                        case 3:
                            bt51.setTextColor(Color.parseColor("green"));
                            s51 = "green";
                            break;
                        case 4:
                            bt51.setTextColor(Color.parseColor("yellow"));
                            s51 = "yellow";
                            break;
                    }
                    r5 = "bt51";
                    r5col = sbcol51;
                    break;

                case 3:
                    int n7 = ran.nextInt(4) + 1;
                    switch (n7) {
                        case 1:
                            bt52.setText("red");
                            break;
                        case 2:
                            bt52.setText("blue");
                            break;
                        case 3:
                            bt52.setText("green");
                            break;
                        case 4:
                            bt52.setText("yellow");
                            break;
                    }
                    int n8 = ran.nextInt(4) + 1;
                    switch (n8) {
                        case 1:
                            bt52.setTextColor(Color.parseColor("red"));
                            s52 = "red";
                            break;
                        case 2:
                            bt52.setTextColor(Color.parseColor("blue"));
                            s52 = "blue";
                            break;
                        case 3:
                            bt52.setTextColor(Color.parseColor("green"));
                            s52 = "green";
                            break;
                        case 4:
                            bt52.setTextColor(Color.parseColor("yellow"));
                            s52 = "yellow";
                            break;
                    }
                    r5 = "bt52";
                    r5col = sbcol52;
                    break;
            }
            i1-=1;
            t3.start();
        }
        else
        {
            //passed();
            //score=score;
            //pass();

            progress.setProgress(60);
            progress.show();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/writing.php?uid="+SignInActivity.uid+"&gid="+"5"+"&glevel="+"4"+"&time="+String.valueOf(t)+"&score="+String.valueOf(score),
                    new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response){
//                                        Toast.makeText(Main49Activity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                            if (response.trim().equalsIgnoreCase("Failure")){
                                progress.dismiss();
                                //pass();
                                //Toast.makeText(Main49Activity.this, response+"Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();
                            }else {
                                //Toast.makeText(MainActivity.this,"In Else Block",Toast.LENGTH_LONG).show();
                                try {
                                    //progress.dismiss();

                                    JSONObject jsonObject = new JSONObject(response);
                                    JSONArray result = jsonObject.getJSONArray("result");
                                    JSONObject Data = result.getJSONObject(0);

                                    progress.setProgress(60);
                                    progress.show();

                                    String error = "error";
                                    hscore=Integer.parseInt(Data.getString("score"));
                                    hsname=Data.getString("hsname");

                                    if(Data.getString(error)=="false")
                                    {
                                        // Toast.makeText(MainActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();
                                        //progress.dismiss();
                                    }
                                    else
                                    {

                                        //Toast.makeText(MainActivity.this,"Log In Failed",Toast.LENGTH_LONG).show();
                                    }
                                    progress.dismiss();
                                    passed();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Main49Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    //Adding parameters to request
                    params.put("uid", SignInActivity.uid);
                    params.put("gid", "5");
                    params.put("glevel","4");
                    params.put("time", String.valueOf(t));
                    params.put("score", String.valueOf(score));

                    // params.put(Config.KEY_SEM, sem);
                    //params.put(Config.KEY_BRANCH, branch);
                    //returning parameter
                    return params;
                }
            };
            //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
            RequestQueue requestQueue = Volley.newRequestQueue(Main49Activity.this);
            requestQueue.add(stringRequest);


        }
    }
    public void passed()
    {
        t3.cancel();
        t3.cancel();

        progress.dismiss();
        progress.dismiss();

        //t1.setText("level Passed");
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        i1+=1;
        adb.setMessage("Your Score is:"+score+"\n High Score:"+hscore+" by "+hsname);
        adb.setPositiveButton("Next", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Intent intent=new Intent(Main49Activity.this,Main50Activity.class);
                Main49Activity.this.startActivity(intent);
                Main49Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main49Activity.this.finish();
                Intent intent=new Intent(Main49Activity.this,Main49Activity.class);
                Main49Activity.this.startActivity(intent);
            }
        });
        ad=adb.create();
        ad.setTitle("Level Passed");
        ad.show();
    }
    public void Failed()
    {
        t3.cancel();
        //t1.setText("level Failed");
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        i1+=1;
        adb.setMessage("Your Score is:"+score);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Intent intent=new Intent(Main49Activity.this,Main2Activity.class);
                Main49Activity.this.startActivity(intent);
                Main49Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main49Activity.this.finish();
                Intent intent=new Intent(Main49Activity.this,Main49Activity.class);
                Main49Activity.this.startActivity(intent);
            }
        });
        ad=adb.create();
        ad.setTitle("Level Failed");
        ad.show();
    }
    @Override
    public void onBackPressed() {
        t3.cancel();
        Intent intent =new Intent(Main49Activity.this,Main2Activity.class);
        Main49Activity.this.startActivity(intent);
        Main49Activity.this.finish();
    }
    @Override
    protected void onPause() {
        t3.cancel();
        super.onPause();
    }

    @Override
    public void onResume() {

        t3.start();
        super.onResume();
    }
}
