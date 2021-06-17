package com.example.yashshah.colorhuntgame;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class Main35Activity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private int lvl=0;

    public String gid="6";

    public StringRequest stringRequest;
    public String glevel="";

    private ProgressDialog progress;

    private AlertDialog.Builder adb;
    private AlertDialog ad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading Your Data...");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(25);
        progress.show();

        stringRequest = new StringRequest(Request.Method.GET,
                "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/reading.php?uid="+SignInActivity.uid+"&gid="+gid,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        progress.setProgress(60);
                        progress.show();

                        //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                        if (response.trim().equalsIgnoreCase("Failure")){
                            //Toast.makeText(getApplicationContext(), "Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();

                        }else {
                            //Toast.makeText(MainActivity.this,"In Else Block",Toast.LENGTH_LONG).show();
                            try {
                                //Toast.makeText(MainActivity.this,"In Try Block"+response.trim(),Toast.LENGTH_LONG).show();
                                //progress.dismiss();


                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray result = jsonObject.getJSONArray("result");
                                JSONObject Data = result.getJSONObject(0);

                                String error = "error";
                                String lstatus="lstatus" ;
                                //String msg = "msg";

                                //Toast.makeText(MainActivity.this,"After jsons objects"+error+" "+msg,Toast.LENGTH_LONG).show();

                                if(Data.getString(error)=="false")
                                {
                                    //Toast.makeText(MainActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();

                                        progress.setProgress(90);
                                        progress.show();
                                        lvl=Integer.parseInt(Data.getString(lstatus));
                                        //progress.dismiss();
                                        test();


                                    glevel=Data.getString(lstatus);
                                }
                                else
                                {
                                    //Toast.makeText(getApplication(),"Log In Failed",Toast.LENGTH_LONG).show();
                                }
                                //Toast.makeText(MainActivity.this, "Output:=" + Data.getString(error) + " " + Data.getString(msg), Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put("uid", SignInActivity.uid);
                params.put("gid", gid);
                // params.put(Config.KEY_SEM, sem);
                //params.put(Config.KEY_BRANCH, branch);
                //returning parameter
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Main35Activity.this);
        requestQueue.add(stringRequest);


        b1=(Button)findViewById(R.id.button10);
        b2=(Button)findViewById(R.id.button11);
        b3=(Button)findViewById(R.id.button12);
        b4=(Button)findViewById(R.id.button13);
        b5=(Button)findViewById(R.id.button14);
        b6=(Button)findViewById(R.id.button15);
        b7=(Button)findViewById(R.id.button16);
        b8=(Button)findViewById(R.id.button17);
        b9=(Button)findViewById(R.id.button18);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main36Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main37Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main38Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main39Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main40Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main41Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main42Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main43Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main35Activity.this,Main44Activity.class);
                Main35Activity.this.startActivity(intent);
                Main35Activity.this.finish();
            }
        });
    }
public void test()
{
    switch (lvl)
    {
        case 0:
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout2));
            b3.setBackground(getResources().getDrawable(R.drawable.layout2));
            b4.setBackground(getResources().getDrawable(R.drawable.layout2));
            b5.setBackground(getResources().getDrawable(R.drawable.layout2));
            b6.setBackground(getResources().getDrawable(R.drawable.layout2));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));

            adb=new AlertDialog.Builder(this);
            adb.setCancelable(false);
            adb.setMessage("=>In this game blocks of different colors shown and player have to memorized the color as the shown.\n=>After few seconds the blocks turns in to white color.\n=>After that block of color shown at the left color and player must select appropriate block which match with given color.");
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){
                }
            });
            ad=adb.create();
            ad.setTitle("How To Play ??");
            ad.show();
            break;
        case 1:
            b2.setEnabled(true);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout2));
            b4.setBackground(getResources().getDrawable(R.drawable.layout2));
            b5.setBackground(getResources().getDrawable(R.drawable.layout2));
            b6.setBackground(getResources().getDrawable(R.drawable.layout2));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 2:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout2));
            b5.setBackground(getResources().getDrawable(R.drawable.layout2));
            b6.setBackground(getResources().getDrawable(R.drawable.layout2));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;
        case 3:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout2));
            b6.setBackground(getResources().getDrawable(R.drawable.layout2));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 4:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout5));
            b6.setBackground(getResources().getDrawable(R.drawable.layout2));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 5:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout5));
            b6.setBackground(getResources().getDrawable(R.drawable.layout5));
            b7.setBackground(getResources().getDrawable(R.drawable.layout2));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 6:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout5));
            b6.setBackground(getResources().getDrawable(R.drawable.layout5));
            b7.setBackground(getResources().getDrawable(R.drawable.layout5));
            b8.setBackground(getResources().getDrawable(R.drawable.layout2));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 7:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(false);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout5));
            b6.setBackground(getResources().getDrawable(R.drawable.layout5));
            b7.setBackground(getResources().getDrawable(R.drawable.layout5));
            b8.setBackground(getResources().getDrawable(R.drawable.layout5));
            b9.setBackground(getResources().getDrawable(R.drawable.layout2));
            break;

        case 8:
        case 9:
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            b2.setBackground(getResources().getDrawable(R.drawable.layout5));
            b3.setBackground(getResources().getDrawable(R.drawable.layout5));
            b4.setBackground(getResources().getDrawable(R.drawable.layout5));
            b5.setBackground(getResources().getDrawable(R.drawable.layout5));
            b6.setBackground(getResources().getDrawable(R.drawable.layout5));
            b7.setBackground(getResources().getDrawable(R.drawable.layout5));
            b8.setBackground(getResources().getDrawable(R.drawable.layout5));
            b9.setBackground(getResources().getDrawable(R.drawable.layout5));

            break;
    }
    progress.setProgress(100);
    progress.show();
    progress.dismiss();

}

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main35Activity.this,Main2Activity.class);
        Main35Activity.this.startActivity(intent);
        Main35Activity.this.finish();
    }

}

