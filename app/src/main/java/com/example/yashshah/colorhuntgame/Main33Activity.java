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

public class Main33Activity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    public TextView t1;
    private TextView t2;
    int i1=42;
    int i2=i1;
    private AlertDialog.Builder adb;
    private AlertDialog ad;
    public int t=2;
    public CountDownTimer t3;
    public String bcol;
    private int score=0;

    private int hscore;
    private String hsname;


    private ProgressDialog progress;

    private TextView tvtr2;

    private int time=6;
    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Storing Results");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(25);

        tvtr2=(TextView)findViewById(R.id.tvtr2);
        tvtr2.setText(""+t);

        t1=(TextView)findViewById(R.id.textView10);
        t1.setText("Red");
        //bcol="Blue";
        t2=(TextView)findViewById(R.id.textView3);
        t2.setVisibility(View.VISIBLE);
        t2.setText("Word Match");
        t2.setTextColor(Color.parseColor("white"));

        set();


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
                adb.setMessage("Your Score is:"+score);
                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Intent intent=new Intent(Main33Activity.this,Main2Activity.class);
                        Main33Activity.this.startActivity(intent);
                        Main33Activity.this.finish();
                    }
                });
                adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Main33Activity.this.finish();
                        Intent intent=new Intent(Main33Activity.this,Main33Activity.class);
                        Main33Activity.this.startActivity(intent);
                    }
                });
                ad=adb.create();
                ad.setTitle("Level Failed");
                ad.show();
            }
        };
        t3.start();

        //t1.setBackgroundColor();

        b1=(Button)findViewById(R.id.btRed);
        b2=(Button)findViewById(R.id.btGreen);
        b3=(Button)findViewById(R.id.btBlue);
        b4=(Button)findViewById(R.id.btYellow);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(b1.getText().toString(),t2.getText().toString());
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(b2.getText().toString(),t2.getText().toString());
            }});
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(b3.getText().toString(),t2.getText().toString());
            }});
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(b4.getText().toString(),t2.getText().toString());
            }
        });
    }
    public void check(String s,String s1)
    {
        String s2=t1.getText().toString();
        if(s1.equals("Word Match"))
        {

            if(s.equals(s2))
            {
                score=(score)+(1*10*time);
                t3.cancel();
                //t1.setText("Correct");
                time=2;
                flag=false;

                i1--;//set();
                if(i1==0)
                {
                    //pass();
                    t1.setText(" ");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);

                    //score=score;
                    //pass();

                    progress.setProgress(90);
                    progress.show();
                    StringRequest stringRequest = new StringRequest(Request.Method.GET,
                            "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/writing.php?uid="+SignInActivity.uid+"&gid="+"4"+"&glevel="+"8"+"&time="+String.valueOf(t)+"&score="+String.valueOf(score),
                            new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response){
                                    //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                    if (response.trim().equalsIgnoreCase("Failure")){
                                        progress.dismiss();
                                        pass();
                                        //Toast.makeText(Main6Activity.this, response+"Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();
                                    }else {
                                        //Toast.makeText(MainActivity.this,"In Else Block",Toast.LENGTH_LONG).show();
                                        try {
                                            //Toast.makeText(MainActivity.this,"In Try Block"+response.trim(),Toast.LENGTH_LONG).show();
                                            //progress.dismiss();


                                            JSONObject jsonObject = new JSONObject(response);
                                            JSONArray result = jsonObject.getJSONArray("result");
                                            JSONObject Data = result.getJSONObject(0);

                                            progress.setProgress(60);
                                            progress.show();

                                            String error = "error";
                                            hscore=Integer.parseInt(Data.getString("score"));
                                            hsname=Data.getString("hsname");

                                            //String msg = "msg";

                                            //Toast.makeText(MainActivity.this,"After jsons objects"+error+" "+msg,Toast.LENGTH_LONG).show();
                                            if(Data.getString(error)=="false")
                                            {
                                                // Toast.makeText(MainActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();

                                            }
                                            else
                                            {

                                                //Toast.makeText(MainActivity.this,"Log In Failed",Toast.LENGTH_LONG).show();
                                            }
                                            progress.dismiss();
											pass();
                                            //Toast.makeText(MainActivity.this, "Output:=" + Data.getString(error) + " " + Data.getString(msg), Toast.LENGTH_LONG).show();

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            //Toast.makeText(Main6Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                            //Toast.makeText(MainActivity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put("uid", SignInActivity.uid);
                            params.put("gid", "4");
                            params.put("glevel","8");
                            params.put("time", String.valueOf(t));
                            params.put("score", String.valueOf(score));

                            // params.put(Config.KEY_SEM, sem);
                            //params.put(Config.KEY_BRANCH, branch);
                            //returning parameter
                            return params;
                        }
                    };
                    //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
                    RequestQueue requestQueue = Volley.newRequestQueue(Main33Activity.this);
                    requestQueue.add(stringRequest);


                }
                else
                {

                    Random r1=new Random();
                    int n=r1.nextInt(4)+1;
                    switch (n)
                    {
                        case 1:
                            t1.setText("Red");
                            set();
                            break;
                        case 2:
                            t1.setText("Green");
                            set();
                            break;
                        case 3:
                            t1.setText("Blue");
                            set();
                            break;
                        case 4:
                            t1.setText("Yellow");
                            set();
                            break;
                    }
                    t3.start();
                }
            }
            else
            {
                t3.cancel();
                //t1.setText("level Failed");
                adb=new AlertDialog.Builder(this);
                adb.setCancelable(false);
                adb.setMessage("Your Score is:"+score);
                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Intent intent=new Intent(Main33Activity.this,Main2Activity.class);
                        Main33Activity.this.startActivity(intent);
                        Main33Activity.this.finish();
                    }
                });
                adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Main33Activity.this.finish();
                        Intent intent=new Intent(Main33Activity.this,Main33Activity.class);
                        Main33Activity.this.startActivity(intent);
                    }
                });
                ad=adb.create();
                ad.setTitle("Level Failed");
                ad.show();
            }

        }
        else
        {
            if(bcol.equals(s))
            {
                score=(score)+(1*10*time);
                t3.cancel();
                //t1.setText("Correct");
                time=2;
                flag=false;
                i1--;//set();
                if(i1==0)
                {
                  //pass();
                    t1.setText(" ");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);

                    //score=score;
                    //pass();

                    progress.setProgress(90);
                    progress.show();
                    StringRequest stringRequest = new StringRequest(Request.Method.GET,
                            "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/writing.php?uid="+SignInActivity.uid+"&gid="+"4"+"&glevel="+"8"+"&time="+String.valueOf(t)+"&score="+String.valueOf(score),
                            new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response){
                                    //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                    if (response.trim().equalsIgnoreCase("Failure")){
                                        progress.dismiss();
                                        pass();
                                        //Toast.makeText(Main6Activity.this, response+"Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();
                                    }else {
                                        //Toast.makeText(MainActivity.this,"In Else Block",Toast.LENGTH_LONG).show();
                                        try {
                                            //Toast.makeText(MainActivity.this,"In Try Block"+response.trim(),Toast.LENGTH_LONG).show();
                                            //progress.dismiss();


                                            JSONObject jsonObject = new JSONObject(response);
                                            JSONArray result = jsonObject.getJSONArray("result");
                                            JSONObject Data = result.getJSONObject(0);

                                            progress.setProgress(60);
                                            progress.show();

                                            String error = "error";
                                            hscore=Integer.parseInt(Data.getString("score"));
                                            hsname=Data.getString("hsname");

                                            //String msg = "msg";

                                            //Toast.makeText(MainActivity.this,"After jsons objects"+error+" "+msg,Toast.LENGTH_LONG).show();
                                            if(Data.getString(error)=="false")
                                            {
                                                // Toast.makeText(MainActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();

                                            }
                                            else
                                            {

                                                //Toast.makeText(MainActivity.this,"Log In Failed",Toast.LENGTH_LONG).show();
                                            }
                                            progress.dismiss();
											pass();
                                            //Toast.makeText(MainActivity.this, "Output:=" + Data.getString(error) + " " + Data.getString(msg), Toast.LENGTH_LONG).show();

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            //Toast.makeText(Main6Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                            //Toast.makeText(MainActivity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put("uid", SignInActivity.uid);
                            params.put("gid", "4");
                            params.put("glevel","8");
                            params.put("time", String.valueOf(t));
                            params.put("score", String.valueOf(score));

                            // params.put(Config.KEY_SEM, sem);
                            //params.put(Config.KEY_BRANCH, branch);
                            //returning parameter
                            return params;
                        }
                    };
                    //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
                    RequestQueue requestQueue = Volley.newRequestQueue(Main33Activity.this);
                    requestQueue.add(stringRequest);



                }
                else
                {

                    Random r1=new Random();
                    int n=r1.nextInt(4)+1;
                    switch (n)
                    {
                        case 1:
                            t1.setText("Red");
                            set();
                            break;
                        case 2:
                            t1.setText("Green");
                            set();
                            break;
                        case 3:
                            t1.setText("Blue");
                            set();
                            break;
                        case 4:
                            t1.setText("Yellow");
                            set();
                            break;
                    }
                    t3.start();
                }
            }
            else
            {
                t3.cancel();
                //t1.setText("level Failed");
                adb=new AlertDialog.Builder(this);
                adb.setCancelable(false);
                adb.setMessage("Your Score is:"+score);
                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Intent intent=new Intent(Main33Activity.this,Main2Activity.class);
                        Main33Activity.this.startActivity(intent);
                        Main33Activity.this.finish();
                    }
                });
                adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Main33Activity.this.finish();
                        Intent intent=new Intent(Main33Activity.this,Main33Activity.class);
                        Main33Activity.this.startActivity(intent);
                    }
                });
                ad=adb.create();
                ad.setTitle("Level Failed");
                ad.show();
            }

        }

    }

    public void set()
    {
        Random r2=new Random();
        int n2=r2.nextInt(4)+1;

        Random r3=new Random();
        int n3=r3.nextInt(2)+1;

        switch (n2) {
            case 1:
                t1.setTextColor(Color.parseColor("red"));
                bcol="Red";
                switch (n3)
                {
                    case    1:
                        t2.setText("Word Match");
                        break;
                    case 2:
                        t2.setText("Color Match");
                }
                break;
            case 2:
                t1.setTextColor(Color.parseColor("Green"));
                bcol="Green";
                switch (n3)
                {
                    case    1:
                        t2.setText("Word Match");
                        break;
                    case 2:
                        t2.setText("Color Match");
                }
                break;
            case 3:
                t1.setTextColor(Color.parseColor("Blue"));
                bcol="Blue";
                switch (n3)
                {
                    case    1:
                        t2.setText("Word Match");
                        break;
                    case 2:
                        t2.setText("Color Match");
                }
                break;
            case 4:
                t1.setTextColor(Color.parseColor("Yellow"));
                bcol="Yellow";
                switch (n3)
                {
                    case    1:
                        t2.setText("Word Match");
                        break;
                    case 2:
                        t2.setText("Color Match");
                }
                break;
        }

    }
    public void pass()
    {
        t3.cancel();

        progress.dismiss();
        progress.dismiss();


        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setMessage("Your Score is:"+score+"\n High Score:"+hscore+" by "+hsname);
        adb.setPositiveButton("Next", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Intent intent=new Intent(Main33Activity.this,Main34Activity.class);
                Main33Activity.this.startActivity(intent);
                Main33Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main33Activity.this.finish();
                Intent intent=new Intent(Main33Activity.this,Main33Activity.class);
                Main33Activity.this.startActivity(intent);
            }
        });
        ad=adb.create();
        ad.setTitle("Level Passed");
        ad.show();
    }
    @Override
    public void onBackPressed() {
        t3.cancel();
        Intent intent =new Intent(Main33Activity.this,Main2Activity.class);
        Main33Activity.this.startActivity(intent);
        Main33Activity.this.finish();
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

