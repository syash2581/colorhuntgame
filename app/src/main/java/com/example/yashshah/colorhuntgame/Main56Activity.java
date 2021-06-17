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

public class Main56Activity extends AppCompatActivity {

    private AlertDialog.Builder adb;
    private AlertDialog ad;
    
    private int i1=18;
    private int i2=i1+1;
    private int t=9;



    public CountDownTimer t3;
    
    private Button blk;
    private String blkcol;

    private Button bA;
    private Button bB;
    private Button bC;
    private Button bD;
    private Button bE;
    private Button bF;
    private Button bG;
    private Button bH;
    private Button bI;
    private Button bJ;
    private Button bK;
    private Button bL;
    private Button bM;
    private Button bN;
    private Button bO;
    private Button bP;
    private Button bQ;
    private Button bR;
    private Button bS;
    private Button bT;
    private Button bU;
    private Button bV;
    private Button bW;
    private Button bX;
    private Button bY;
    private Button bZ;
    private int score=0;

    private int hscore;
    private String hsname;


    private ProgressDialog progress;

    private TextView tvtr2;

    private int time=22;
    private boolean flag=true;

    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tvtr2=(TextView)findViewById(R.id.tvtr2);
        tvtr2.setText(""+t);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Storing Results");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(25);


        blk=(Button)findViewById(R.id.Fme);
        bA=(Button)findViewById(R.id.A);
        bB=(Button)findViewById(R.id.B);
        bC=(Button)findViewById(R.id.C);
        bD=(Button)findViewById(R.id.D);
        bE=(Button)findViewById(R.id.E);
        bF=(Button)findViewById(R.id.F);
        bG=(Button)findViewById(R.id.G);
        bH=(Button)findViewById(R.id.H);
        bI=(Button)findViewById(R.id.I);
        bJ=(Button)findViewById(R.id.J);
        bK=(Button)findViewById(R.id.K);
        bL=(Button)findViewById(R.id.L);
        bM=(Button)findViewById(R.id.M);
        bN=(Button)findViewById(R.id.N);
        bO=(Button)findViewById(R.id.O);
        bP=(Button)findViewById(R.id.P);
        bQ=(Button)findViewById(R.id.Q);
        bR=(Button)findViewById(R.id.R);
        bS=(Button)findViewById(R.id.S);
        bT=(Button)findViewById(R.id.T);
        bU=(Button)findViewById(R.id.U);
        bV=(Button)findViewById(R.id.V);
        bW=(Button)findViewById(R.id.W);
        bX=(Button)findViewById(R.id.X);
        bY=(Button)findViewById(R.id.Y);
        bZ=(Button)findViewById(R.id.Z);
        

        
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
                i1+=2;
                adb.setMessage("Your Score is:"+score);
                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Intent intent=new Intent(Main56Activity.this,Main2Activity.class);
                        Main56Activity.this.startActivity(intent);
                        Main56Activity.this.finish();
                    }
                });
                adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int id){
                        Main56Activity.this.finish();
                        Intent intent=new Intent(Main56Activity.this,Main56Activity.class);
                        Main56Activity.this.startActivity(intent);
                    }
                });
                ad=adb.create();
                ad.setTitle("Level Failed");
                ad.show();
            }
        };


        set();
        t3.start();
        bA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bA.getText().toString());
            }
        });
        bB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bB.getText().toString());
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bC.getText().toString());
            }
        });
        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bD.getText().toString());
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bE.getText().toString());
            }
        });
        bF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bF.getText().toString());
            }
        });
        bG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bG.getText().toString());
            }
        });
        bH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bH.getText().toString());
            }
        });
        bI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bI.getText().toString());
            }
        });
        bJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bJ.getText().toString());
            }
        });
        bK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bK.getText().toString());
            }
        });
        bL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bL.getText().toString());
            }
        });
        bM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bM.getText().toString());
            }
        });
        bN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bN.getText().toString());
            }
        });
        bO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bO.getText().toString());
            }
        });
        bP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bP.getText().toString());
            }
        });
        bQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bQ.getText().toString());
            }
        });
        bR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bR.getText().toString());
            }
        });
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bS.getText().toString());
            }
        });
        bT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bT.getText().toString());
            }
        });
        bU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bU.getText().toString());
            }
        });
        bV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bV.getText().toString());
            }
        });
        bW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bW.getText().toString());
            }
        });
        bX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bX.getText().toString());
            }
        });
        bY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bY.getText().toString());
            }
        });
        bZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(bZ.getText().toString());
            }
        });
        
    }
    public void check(String s)
    {
        if(s.equals(blk.getText().toString()))
        {

            score=(score)+(1*10*time);
            t3.cancel();
            time=9;
            flag=false;
            set();
            //t3.start();
        }
        else
        {
            Failed();
        }
    }

    public void set()
    {
        if(i1>0)
        {
            Random n=new Random();
            int n2=n.nextInt(26)+1;
            
            switch (n2)
            {
                case 1:
                    blk.setText("A");
                    break;
                case 2:
                    blk.setText("B");
                    break;
                case 3:
                    blk.setText("C");
                    break;
                case 4:
                    blk.setText("D");
                    break;
                case 5:
                    blk.setText("E");
                    break;
                case 6:
                    blk.setText("F");
                    break;
                case 7:
                    blk.setText("G");
                    break;
                case 8:
                    blk.setText("H");
                    break;
                case 9:
                    blk.setText("I");
                    break;
                case 10:
                    blk.setText("J");
                    break;
                case 11:
                    blk.setText("K");
                    break;
                case 12:
                    blk.setText("L");
                    break;
                case 13:
                    blk.setText("M");
                    break;
                case 14:
                    blk.setText("N");
                    break;
                case 15:
                    blk.setText("O");
                    break;
                case 16:
                    blk.setText("P");
                    break;
                case 17:
                    blk.setText("Q");
                    break;
                case 18:
                    blk.setText("R");
                    break;
                case 19:
                    blk.setText("S");
                    break;
                case 20:
                    blk.setText("T");
                    break;
                case 21:
                    blk.setText("U");
                    break;
                case 22:
                    blk.setText("V");
                    break;
                case 23:
                    blk.setText("W");
                    break;
                case 24:
                    blk.setText("X");
                    break;
                case 25:
                    blk.setText("Y");
                    break;
                case 26:
                    blk.setText("Z");
                    break;
            }
            int n3=n.nextInt(4)+1;
            switch(n3)
            {
                case 1:
                    blk.setBackgroundColor(Color.parseColor("red"));
                    blkcol="red";
                    break;
                case 2:
                    blk.setBackgroundColor(Color.parseColor("blue"));
                    blkcol="blue";
                    break;
                case 3:
                    blk.setBackgroundColor(Color.parseColor("green"));
                    blkcol="green";
                    break;
                case 4:
                    blk.setBackgroundColor(Color.parseColor("black"));
                    blkcol="black";
                    break;
            }
            set2();
            i1-=1;
        }
        else
        {
            //passed();
            //score=score;
            //pass();

            progress.setProgress(60);
            progress.show();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/writing.php?uid="+SignInActivity.uid+"&gid="+"1"+"&glevel="+"1"+"&time="+String.valueOf(t)+"&score="+String.valueOf(score),
                    new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response){
//                                        Toast.makeText(Main56Activity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                            if (response.trim().equalsIgnoreCase("Failure")){
                                progress.dismiss();
                                //pass();
                                //Toast.makeText(Main56Activity.this, response+"Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();
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

                    Toast.makeText(Main56Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    //Adding parameters to request
                    params.put("uid", SignInActivity.uid);
                    params.put("gid", "3");
                    params.put("glevel","1");
                    params.put("time", String.valueOf(t));
                    params.put("score", String.valueOf(score));

                    // params.put(Config.KEY_SEM, sem);
                    //params.put(Config.KEY_BRANCH, branch);
                    //returning parameter
                    return params;
                }
            };
            //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
            RequestQueue requestQueue = Volley.newRequestQueue(Main56Activity.this);
            requestQueue.add(stringRequest);

        }
    }
    public void set2()
    {
        Random n=new Random(); 
        int r=n.nextInt(4)+1;
        int a;
        switch(r)
        {
            case 1:
                bA.setText("B");
                bB.setText("A");
                bC.setText("C");
                bD.setText("E");
                bE.setText("D");
                bF.setText("F");
                bG.setText("G");
                break;

            case 2:
                bA.setText("F");
                bB.setText("E");
                bC.setText("B");
                bD.setText("D");
                bE.setText("A");
                bF.setText("G");
                bG.setText("C");
                break;

            case 3:
                bA.setText("B");
                bB.setText("F");
                bC.setText("A");
                bD.setText("D");
                bE.setText("G");
                bF.setText("C");
                bG.setText("E");
                break;
            case 4:
                bA.setText("G");
                bB.setText("F");
                bC.setText("B");
                bD.setText("D");
                bE.setText("C");
                bF.setText("A");
                bG.setText("E");
                break;
        }
        r=n.nextInt(4)+1;
        switch(r)
        {
            case 1:
                bH.setText("I");
                bI.setText("H");
                bJ.setText("J");
                bK.setText("L");
                bL.setText("K");
                bM.setText("M");
                bN.setText("N");
                break;
                
            case 2:
                bH.setText("M");
                bI.setText("L");
                bJ.setText("I");
                bK.setText("K");
                bL.setText("H");
                bM.setText("N");
                bN.setText("J");
                break;

            case 3:
                bH.setText("I");
                bI.setText("M");
                bJ.setText("H");
                bK.setText("K");
                bL.setText("N");
                bM.setText("J");
                bN.setText("L");
                break;

            case 4:
                bH.setText("N");
                bI.setText("M");
                bJ.setText("I");
                bK.setText("K");
                bL.setText("J");
                bM.setText("H");
                bN.setText("L");
                break;
        }
        r=n.nextInt(4)+1;
        switch(r)
        {
            case 1:

                bO.setText("P");
                bP.setText("O");
                bQ.setText("Q");
                bR.setText("S");
                bS.setText("R");
                bT.setText("T");
                bU.setText("U");
                break;
                
                
            case 2:
                bO.setText("T");
                bP.setText("S");
                bQ.setText("P");
                bR.setText("R");
                bS.setText("O");
                bT.setText("U");
                bU.setText("Q");
                break;


            case 3:

                bO.setText("P");
                bP.setText("T");
                bQ.setText("O");
                bR.setText("R");
                bS.setText("U");
                bT.setText("Q");
                bU.setText("S");
                break;

            case 4:

                bO.setText("U");
                bP.setText("T");
                bQ.setText("P");
                bR.setText("R");
                bS.setText("Q");
                bT.setText("O");
                bU.setText("S");
                break;

        }
        r=n.nextInt(4)+1;
        switch  (r)
        {
            case 1:
                bV.setText("W");
                bW.setText("V");
                bX.setText("X");
                bY.setText("Z");
                bZ.setText("Y");
                break;
                
            case 2:
                bV.setText("Z");
                bW.setText("W");
                bX.setText("Y");
                bY.setText("V");
                bZ.setText("X");
                break;
            case 3:

                bV.setText("W");
                bW.setText("V");
                bX.setText("Y");
                bY.setText("X");
                bZ.setText("Z");
                break;
            case 4:
                bV.setText("W");
                bW.setText("V");
                bX.setText("X");
                bY.setText("Y");
                bZ.setText("Z");
                break;
        }
        set3();
    }
   public void set3()
   {
       bA.setBackgroundColor(Color.parseColor(blkcol));
       bB.setBackgroundColor(Color.parseColor(blkcol));
       bC.setBackgroundColor(Color.parseColor(blkcol));
       bD.setBackgroundColor(Color.parseColor(blkcol));
       bE.setBackgroundColor(Color.parseColor(blkcol));
       bF.setBackgroundColor(Color.parseColor(blkcol));
       bG.setBackgroundColor(Color.parseColor(blkcol));
       bH.setBackgroundColor(Color.parseColor(blkcol));
       bI.setBackgroundColor(Color.parseColor(blkcol));
       bJ.setBackgroundColor(Color.parseColor(blkcol));
       bK.setBackgroundColor(Color.parseColor(blkcol));
       bL.setBackgroundColor(Color.parseColor(blkcol));
       bM.setBackgroundColor(Color.parseColor(blkcol));
       bN.setBackgroundColor(Color.parseColor(blkcol));
       bO.setBackgroundColor(Color.parseColor(blkcol));
       bP.setBackgroundColor(Color.parseColor(blkcol));
       bQ.setBackgroundColor(Color.parseColor(blkcol));
       bR.setBackgroundColor(Color.parseColor(blkcol));
       bS.setBackgroundColor(Color.parseColor(blkcol));
       bT.setBackgroundColor(Color.parseColor(blkcol));
       bU.setBackgroundColor(Color.parseColor(blkcol));
       bV.setBackgroundColor(Color.parseColor(blkcol));
       bW.setBackgroundColor(Color.parseColor(blkcol));
       bX.setBackgroundColor(Color.parseColor(blkcol));
       bY.setBackgroundColor(Color.parseColor(blkcol));
       bZ.setBackgroundColor(Color.parseColor(blkcol));
       t3.start();
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
                Intent intent=new Intent(Main56Activity.this,Main57Activity.class);
                Main56Activity.this.startActivity(intent);
                Main56Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main56Activity.this.finish();
                Intent intent=new Intent(Main56Activity.this,Main56Activity.class);
                Main56Activity.this.startActivity(intent);
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
        i1+=2;
        adb.setMessage("Your Score is:"+score);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Intent intent=new Intent(Main56Activity.this,Main2Activity.class);
                Main56Activity.this.startActivity(intent);
                Main56Activity.this.finish();
            }
        });
        adb.setNegativeButton("Retry", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface di, int id){
                Main56Activity.this.finish();
                Intent intent=new Intent(Main56Activity.this,Main56Activity.class);
                Main56Activity.this.startActivity(intent);
            }
        });
        ad=adb.create();
        ad.setTitle("Level Failed");
        ad.show();
    }
    @Override
    public void onBackPressed() {
        t3.cancel();
        Intent intent =new Intent(Main56Activity.this,Main2Activity.class);
        Main56Activity.this.startActivity(intent);
        Main56Activity.this.finish();
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

