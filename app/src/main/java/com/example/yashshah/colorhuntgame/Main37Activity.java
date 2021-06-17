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

public class Main37Activity extends AppCompatActivity {

    private Button tb1;
    private Button tb2;
    private Button pb1;
    private Button pb2;
    private Button blk;
    private String tbcol1;
    private String tbcol2;
    private String pbcol;
    private AlertDialog.Builder adb;
    private AlertDialog ad;
    private TextView tv;
    int i1=18;
    int i2=i1;
    private Boolean flag=false;
    private int t=4;

    private int score=0;


    private int hscore;
    private String hsname;


    private ProgressDialog progress;

    private TextView tvtr2;

    private int time=10;
    private boolean flag2=true;


    final CountDownTimer c1=new CountDownTimer(t*1000,1000) {
        @Override
        public void onTick(long t) {
            tv.setText("Waiting For " + ((t / 1000)+1)+" Seconds");

        }

        @Override
        public void onFinish() {
            tv.setText("");
            tb1.setBackgroundColor(Color.parseColor("white"));
            tb2.setBackgroundColor(Color.parseColor("white"));

            if(flag==false)
            {
                blk.setBackgroundColor(Color.parseColor("red"));
                blk.setText("red");
                blk.setTextColor(Color.parseColor("red"));
                flag=true;
            }
            else
            {
                set2(tbcol1,tbcol2);
            }

            tb1.setClickable(true);
            tb2.setClickable(true);

            tb1.setTextColor(Color.parseColor("white"));
            tb2.setTextColor(Color.parseColor("white"));

            c2.start();
        }
    };

    final CountDownTimer c2=new CountDownTimer(t*1000,1000) {
        @Override
        public void onTick(long t) {
            if(flag2) {
                tvtr2.setText(String.valueOf(time / 2));
                time = time - 1;
            }
            else
            {
                tvtr2.setText(String.valueOf(time));
                time = time - 1;
            }
        }

        @Override
        public void onFinish() {
            c1.cancel();
            c2.cancel();
            adb.setCancelable(false);
            adb.setMessage("Your Score is:"+score);
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){
                    Intent intent=new Intent(Main37Activity.this,Main2Activity.class);
                    Main37Activity.this.startActivity(intent);
                    Main37Activity.this.finish();
                }
            });
            adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){
                    Main37Activity.this.finish();
                    Intent intent=new Intent(Main37Activity.this,Main37Activity.class);
                    Main37Activity.this.startActivity(intent);
                }
            });
            ad=adb.create();
            ad.setTitle("Level Failed");
            ad.show();

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvtr2=(TextView)findViewById(R.id.tvtr2);
        tvtr2.setText(""+t);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Storing Results");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(25);

        adb=new AlertDialog.Builder(this);

        blk=(Button)findViewById(R.id.button20);
        tb1=(Button)findViewById(R.id.button21);
        tb2=(Button)findViewById(R.id.button22);
        pb1=(Button)findViewById(R.id.button21);
        pb2=(Button)findViewById(R.id.button22);
        tv=(TextView)findViewById(R.id.textView14);

        tb1.setClickable(false);
        tb2.setClickable(false);

        tb1.setBackgroundColor(Color.parseColor("red"));
        tb1.setText("red");
        tbcol1="red";
        tb1.setTextColor(Color.parseColor("red"));
        //tbcol1="red";

        tb2.setBackgroundColor(Color.parseColor("green"));
        tb2.setText("green");
        tb2.setTextColor(Color.parseColor("green"));
        tbcol2="green";
        //tbcol2="green";



        c1.start();

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(tb1.getText().toString());
            }
        });
        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(tb2.getText().toString());
            }
        });
    }
    public void check(String s)
    {
        if(s.equals(blk.getText().toString()))
        {
            score=(score)+(1*10*time);
            c2.cancel();
            time=4;
            flag2=false;
            i1--;
            tb1.setBackgroundColor(Color.parseColor(tbcol1));
            tb1.setTextColor(Color.parseColor(tbcol1));
            if(i1==0)
            {
                //progress.show();


                //score=score;
                //pass();

                progress.setProgress(60);
                progress.show();
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/writing.php?uid="+SignInActivity.uid+"&gid="+"6"+"&glevel="+"2"+"&time="+String.valueOf(t)+"&score="+String.valueOf(score),
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response){
//                                        Toast.makeText(Main37Activity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                if (response.trim().equalsIgnoreCase("Failure")){
                                    progress.dismiss();
                                    //pass();
                                    //Toast.makeText(Main37Activity.this, response+"Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();
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
                                        pass();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Main37Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                        //Toast.makeText(MainActivity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //Adding parameters to request
                        params.put("uid", SignInActivity.uid);
                        params.put("gid", "6");
                        params.put("glevel","2");
                        params.put("time", String.valueOf(t));
                        params.put("score", String.valueOf(score));

                        // params.put(Config.KEY_SEM, sem);
                        //params.put(Config.KEY_BRANCH, branch);
                        //returning parameter
                        return params;
                    }
                };
                //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
                RequestQueue requestQueue = Volley.newRequestQueue(Main37Activity.this);
                requestQueue.add(stringRequest);


            }
            else
            {
                set();
            }
            blk.setBackgroundColor(Color.parseColor("white"));
            blk.setText("");
            blk.setTextColor(Color.parseColor("white"));

        }
        else
        {
            c2.cancel();
            tb2.setBackgroundColor(Color.parseColor(tbcol2));
            tb2.setTextColor(Color.parseColor(tbcol2));

            adb.setCancelable(false);
            adb.setMessage("Your Score is:"+score);
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){
                    Intent intent=new Intent(Main37Activity.this,Main2Activity.class);
                    Main37Activity.this.startActivity(intent);
                    Main37Activity.this.finish();
                }
            });
            adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){
                    Main37Activity.this.finish();
                    Intent intent=new Intent(Main37Activity.this,Main37Activity.class);
                    Main37Activity.this.startActivity(intent);
                }
            });
            ad=adb.create();
            ad.setTitle("Level Failed");
            ad.show();
        }

    }
    public void set()
    {
        Random r1=new Random();
        int n=r1.nextInt(12)+1;
        switch (n)
        {
            case 1:
                tb1.setBackgroundColor(Color.parseColor("red"));
                tb1.setText("red");
                tbcol1="red";
                tb1.setTextColor(Color.parseColor("red"));

                tb2.setBackgroundColor(Color.parseColor("green"));
                tb2.setText("green");
                tb2.setTextColor(Color.parseColor("green"));
                tbcol2="green";

                c1.start();

                break;
            case 2:
                tb1.setBackgroundColor(Color.parseColor("red"));
                tb1.setText("red");
                tbcol1="red";
                tb1.setTextColor(Color.parseColor("red"));

                tb2.setBackgroundColor(Color.parseColor("blue"));
                tb2.setText("blue");
                tbcol2="blue";
                tb2.setTextColor(Color.parseColor("blue"));

                c1.start();
                break;
            case 3:
                tb1.setBackgroundColor(Color.parseColor("red"));
                tb1.setText("red");
                tbcol1="red";
                tb1.setTextColor(Color.parseColor("red"));

                tb2.setBackgroundColor(Color.parseColor("yellow"));
                tb2.setText("yellow");
                tbcol2="yellow";
                tb2.setTextColor(Color.parseColor("yellow"));

                c1.start();
                break;
            case 4:
                tb1.setBackgroundColor(Color.parseColor("green"));
                tb1.setText("green");
                tbcol1="green";
                tb1.setTextColor(Color.parseColor("green"));

                tb2.setBackgroundColor(Color.parseColor("red"));
                tb2.setText("red");
                tbcol2="red";
                tb2.setTextColor(Color.parseColor("red"));

                c1.start();

                break;
            case 5:
                tb1.setBackgroundColor(Color.parseColor("green"));
                tb1.setText("green");
                tbcol1="green";
                tb1.setTextColor(Color.parseColor("green"));

                tb2.setBackgroundColor(Color.parseColor("blue"));
                tb2.setText("blue");
                tbcol2="blue";
                tb2.setTextColor(Color.parseColor("blue"));

                c1.start();
                break;
            case 6:
                tb1.setBackgroundColor(Color.parseColor("green"));
                tb1.setText("green");
                tbcol1="green";
                tb1.setTextColor(Color.parseColor("green"));

                tb2.setBackgroundColor(Color.parseColor("yellow"));
                tb2.setText("yellow");
                tbcol2="yellow";
                tb2.setTextColor(Color.parseColor("yellow"));

                c1.start();
                break;
            case 7:
                tb1.setBackgroundColor(Color.parseColor("blue"));
                tb1.setText("blue");
                tbcol1="blue";
                tb1.setTextColor(Color.parseColor("blue"));

                tb2.setBackgroundColor(Color.parseColor("red"));
                tb2.setText("red");
                tbcol2="red";
                tb2.setTextColor(Color.parseColor("red"));

                c1.start();
                break;
            case 8:
                tb1.setBackgroundColor(Color.parseColor("blue"));
                tb1.setText("blue");
                tbcol1="blue";
                tb1.setTextColor(Color.parseColor("blue"));

                tb2.setBackgroundColor(Color.parseColor("green"));
                tb2.setText("green");
                tbcol2="green";
                tb2.setTextColor(Color.parseColor("green"));

                c1.start();
                break;
            case 9:
                tb1.setBackgroundColor(Color.parseColor("blue"));
                tb1.setText("blue");
                tbcol1="blue";
                tb1.setTextColor(Color.parseColor("blue"));

                tb2.setBackgroundColor(Color.parseColor("yellow"));
                tb2.setText("yellow");
                tbcol2="yellow";
                tb2.setTextColor(Color.parseColor("yellow"));

                c1.start();
                break;
            case 10:
                tb1.setBackgroundColor(Color.parseColor("yellow"));
                tb1.setText("yellow");
                tbcol1="yellow";
                tb1.setTextColor(Color.parseColor("yellow"));

                tb2.setBackgroundColor(Color.parseColor("red"));
                tb2.setText("red");
                tbcol2="red";
                tb2.setTextColor(Color.parseColor("red"));

                c1.start();
                break;
            case 11:
                tb1.setBackgroundColor(Color.parseColor("yellow"));
                tb1.setText("yellow");
                tbcol1="yellow";
                tb1.setTextColor(Color.parseColor("yellow"));

                tb2.setBackgroundColor(Color.parseColor("green"));
                tb2.setText("green");
                tbcol2="green";
                tb2.setTextColor(Color.parseColor("green"));

                c1.start();
                break;
            case 12:
                tb1.setBackgroundColor(Color.parseColor("yellow"));
                tb1.setText("yellow");
                tbcol1="yellow";
                tb1.setTextColor(Color.parseColor("yellow"));

                tb2.setBackgroundColor(Color.parseColor("blue"));
                tb2.setText("blue");
                tbcol2="blue";
                tb2.setTextColor(Color.parseColor("blue"));

                c1.start();
                break;

        }

    }
    public void set2(String s,String s2)
    {
        Random r1=new Random();
        int n=r1.nextInt(2)+1;
        switch(n)
        {
            case 1:
                blk.setBackgroundColor(Color.parseColor(s));
                blk.setText(s);
                blk.setTextColor(Color.parseColor(s));
                break;
            case 2:
                blk.setBackgroundColor(Color.parseColor(s2));
                blk.setText(s2);
                blk.setTextColor(Color.parseColor(s2));
                break;
        }

    }

    public void pass()
    {

        c1.cancel();
        c2.cancel();

        progress.dismiss();
        progress.dismiss();

        adb.setCancelable(false);
        adb.setMessage("Your Score is:"+score+"\n High Score:"+hscore+" by "+hsname);
        adb.setPositiveButton("Next", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Intent intent=new Intent(Main37Activity.this,Main38Activity.class);
                Main37Activity.this.startActivity(intent);
                Main37Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main37Activity.this.finish();
                Intent intent=new Intent(Main37Activity.this,Main37Activity.class);
                Main37Activity.this.startActivity(intent);
            }
        });
        ad=adb.create();
        ad.setTitle("Level Passed");
        ad.show();

    }
    @Override
    public void onBackPressed() {
        c1.cancel();
        c2.cancel();
        Intent intent =new Intent(Main37Activity.this,Main2Activity.class);
        Main37Activity.this.startActivity(intent);
        Main37Activity.this.finish();
    }
    @Override
    protected void onPause() {
        c1.cancel();
        c2.cancel();
        super.onPause();
    }

    @Override
    public void onResume() {

        c1.start();
        c2.start();
        super.onResume();
    }
}

