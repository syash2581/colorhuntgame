package com.example.yashshah.colorhuntgame;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


public class Main3Activity extends AppCompatActivity {

    private EditText etId;
    private EditText etName;
    private EditText etDob;
    private EditText etEmail;
    private EditText etPwd;
    private Button Reg;

    private AlertDialog.Builder adb;
    private AlertDialog ad;

    //private SQLiteDatabase db;

    private ProgressDialog progress;

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        Intent intent =new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
        Main3Activity.this.finish();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etId=(EditText)findViewById(R.id.editText2);
        etName=(EditText)findViewById(R.id.editText4);
        etDob=(EditText)findViewById(R.id.editText);
        etEmail=(EditText)findViewById(R.id.editText5);
        etPwd=(EditText)findViewById(R.id.editText6);
        Reg=(Button)findViewById(R.id.button);

        adb=new AlertDialog.Builder(this);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Verification in Progress");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(0);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String uid = etId.getText().toString();
                final String uname = etName.getText().toString();
                final String udob = etDob.getText().toString();
                final String uemail = etEmail.getText().toString();
                final String upassword = etPwd.getText().toString();


                if (etId.getText().toString().equals("") || etName.getText().toString().equals("") || etDob.getText().toString().equals("") || etEmail.getText().toString().equals("") || etPwd.getText().toString().equals("")) {
                    Toast.makeText(Main3Activity.this, "Please Fill All Details First", Toast.LENGTH_LONG).show();
                } else {

                    //progress.dismiss();
                    progress.setProgress(60);
                    progress.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.GET,
                            "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/register.php?uid=" + uid + "&uname=" + uname + "&udob=" + udob + "&uemail=" + uemail + "&upassword=" + upassword,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                    if (response.trim().equalsIgnoreCase("Failure")) {
                                        progress.dismiss();
                                        Toast.makeText(Main3Activity.this, "User Already Registered", Toast.LENGTH_LONG).show();

                                    } else {
                                        //Toast.makeText(MainActivity.this,"In Else Block",Toast.LENGTH_LONG).show();
                                        try {
                                            //Toast.makeText(MainActivity.this,"In Try Block"+response.trim(),Toast.LENGTH_LONG).show();
                                            //progress.dismiss();
                                            progress.setProgress(75);
                                            progress.show();


                                            JSONObject jsonObject = new JSONObject(response);
                                            JSONArray result = jsonObject.getJSONArray("result");
                                            JSONObject Data = result.getJSONObject(0);

                                            String error = "error";
                                            //String msg = "msg";

                                            //Toast.makeText(MainActivity.this,"After jsons objects"+error+" "+msg,Toast.LENGTH_LONG).show();

                                            progress.setProgress(100);
                                            progress.dismiss();
                                            if (Data.getString(error) == "false") {
                                                Toast.makeText(Main3Activity.this, "User Registred Successful", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                                                Main3Activity.this.startActivity(intent);
                                                Main3Activity.this.finish();
                                            } else {
                                                Toast.makeText(Main3Activity.this, "Registering Failed", Toast.LENGTH_LONG).show();
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
                            progress.dismiss();
                            Toast.makeText(Main3Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                            Toast.makeText(Main3Activity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put("uid", uid);
                            params.put("uname", uname);
                            params.put("udob", udob);
                            params.put("uemail", uemail);
                            params.put("upassword", upassword);
                            // params.put(Config.KEY_SEM, sem);
                            //params.put(Config.KEY_BRANCH, branch);
                            //returning parameter
                            return params;
                        }
                    };
                    //progress.dismiss();
                    progress.setProgress(20);
                    progress.show();
                    RequestQueue requestQueue = Volley.newRequestQueue(Main3Activity.this);
                    requestQueue.add(stringRequest);


                }
            }
        });

    }
}
/*if(etId.getText().toString().equals("") || etName.getText().toString().equals("") || etDob.getText().toString().equals("") || etEmail.getText().toString().equals("") || etPwd.getText().toString().equals(""))
                {
                    adb.setCancelable(false);
                    adb.setMessage("Please Fill All Details!!!!");
                    adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface di, int id){}
                    });
                    ad=adb.create();
                    ad.setTitle("Error");
                    ad.show();
                }
                else
                {
                    db = openOrCreateDatabase("color", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    db.execSQL("create table if not exists player_info(uid text primary key,uname text,udob text,uemail text,upassword text)");

                    String key;
                    key=etId.getText().toString();
                    Cursor c=db.query("player_info",null,"uid=?",new String[]{key},null,null,null,null);

                    if(c.getCount()>0)
                    {
                        etId.setText("");
                        adb.setCancelable(false);
                        adb.setMessage("Id already taken by another Player...\nPlease take another Id...");
                        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface di, int id){}
                        });
                        ad=adb.create();
                        ad.setTitle("Acknowledgement");
                        ad.show();
                    }
                    else
                    {
                        ContentValues cv=new ContentValues();
                        cv.put("uid",etId.getText().toString());
                        cv.put("uname",etName.getText().toString());
                        cv.put("udob",etDob.getText().toString());
                        cv.put("uemail",etEmail.getText().toString());
                        cv.put("upassword",etPwd.getText().toString());

                        db.insert("player_info",null,cv);

                        adb.setCancelable(false);
                        adb.setMessage("Player registered successfully....\nNow do login to play game...");
                        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface di, int id){}
                        });
                        ad=adb.create();
                        ad.setTitle("Acknowledgement");
                        ad.show();

                        etId.setText("");
                        etName.setText("");
                        etDob.setText("");
                        etEmail.setText("");
                        etPwd.setText("");

                        Intent intent=new Intent(Main3Activity.this,MainActivity.class);
                        Main3Activity.this.startActivity(intent);
                        Main3Activity.this.finish();


                    }
                    db.close();

                }*/
