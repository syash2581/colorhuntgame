package com.example.yashshah.colorhuntgame;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private EditText etUname;
    public EditText etPassword;
    private Button btnlogin;

    private Button Register;

    private TextView info;
    private int counter=5;
    private TextView text;

    private Button b1;
    public static boolean flag=false;

    private AlertDialog.Builder adb;
    private AlertDialog ad;
    //private SQLiteDatabase db;

    private ProgressDialog progress;

    private TextView t1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etUname=(EditText)findViewById(R.id.editText2);
        etPassword=(EditText)findViewById(R.id.editText3);

        btnlogin=(Button)findViewById(R.id.button);
        Register=(Button)findViewById(R.id.button2);

        info=(TextView)findViewById(R.id.textView9);
        info.setText("No of Attempts Remaining:"+String.valueOf(counter));

        text=(TextView)findViewById(R.id.tvtr2) ;

        b1=(Button)findViewById(R.id.button19);
        etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);

        adb=new AlertDialog.Builder(this);

        t1=(TextView)findViewById(R.id.textView2);
        t2=(TextView)findViewById(R.id.textView);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Verification in Progress");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(0);

        adb.setCancelable(false);
            adb.setMessage("=>It is an online Game.\n=>It requires an Internet Connection.\n\n=>Design And Developed by \n\"YASH H SHAH\"\n   BBIT-CE(GIA) DEPT.");
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface di, int id){}
            });
           ad=adb.create();
           ad.setTitle("Acknowledgement");
           ad.show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(flag==false){
                        etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        b1.setBackground(getResources().getDrawable(R.drawable.baseline_visibility_off_black_36dp));
                        flag=true;
                    }
                    else{
                        etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                        b1.setBackground(getResources().getDrawable(R.drawable.baseline_visibility_black_36dp));
                        flag=false;
                    }
                }
        });

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String user=etUname.getText().toString();
                final String pwd=etPassword.getText().toString();

                if(etUname.getText().toString().equals("") && etPassword.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please Fill All Details First",Toast.LENGTH_LONG).show();
                }
                else {

                    //progress.dismiss();
                    progress.setProgress(60);
                    progress.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.GET,
                            "http://send-otp-for-free.000webhostapp.com/Color_Hunt_Game/login.php?login="+user+"&password="+pwd,
                            new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response){
                                    //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                    if (response.trim().equalsIgnoreCase("Failure")){
                                        validate();
                                        progress.dismiss();
                                        Toast.makeText(MainActivity.this, "Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();

                                    }else {
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
                                            if(Data.getString(error)=="false")
                                            {
                                                SignInActivity.uid=user;
                                                SignInActivity.password=pwd;
                                                
                                                Toast.makeText(MainActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                                MainActivity.this.startActivity(intent);
                                                MainActivity.this.finish();
                                            }
                                            else
                                            {
                                                validate();
                                                Toast.makeText(MainActivity.this,"Log In Failed",Toast.LENGTH_LONG).show();
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
                            //Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "Check Your Internet Connection\nAnd Try Again Later...", Toast.LENGTH_LONG).show();
                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put("login", user);
                            params.put("password", pwd);
                            // params.put(Config.KEY_SEM, sem);
                            //params.put(Config.KEY_BRANCH, branch);
                            //returning parameter
                            return params;
                        }
                    };
                    //progress.dismiss();
                    progress.setProgress(20);
                    progress.show();
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);


                    //Toast.makeText(MainActivity.this,"After request Queue",Toast.LENGTH_LONG).show();
                }
            }
            //validate();
            });


        Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
    public void validate() {

        //db = openOrCreateDatabase("color", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        //db.execSQL("create table if not exists player_info(uid text primary key,uname text,udob text,uemail text,upassword text)");

        //String key;
        //key=Name.getText().toString();
        //Cursor c=db.query("player_info",null,"uid=?",new String[]{key},null,null,null,null);

        //if(c.getCount()<=0)
        //{
        //    Name.setText("");
        //    Password.setText("");
        //    adb.setCancelable(false);
        //    adb.setMessage("Id is not registered....\nPlease complete the registration first...");
        //    adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
        //        public void onClick(DialogInterface di, int id){}
        //    });
        //    ad=adb.create();
        //    ad.setTitle("Acknowledgement");
        //    ad.show();
        //}
        //else
        //{
        //    if(c.moveToFirst())
        //    {
        //        if (uname.equals(c.getString(0)) && pwd.equals(c.getString(4)))
        //        {
        //            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        //            MainActivity.this.startActivity(intent);
        //           MainActivity.this.finish();
        //      }
        //     else
        //   {
        //      Name.setText("");
        //    Password.setText("");
        //   adb.setCancelable(false);
        //  adb.setMessage("User Id or Password may be incorrect....\nPlease enter correct Id Password...");
        // adb.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
        //  public void onClick(DialogInterface di, int id){}
        // });
        // ad=adb.create();
        // ad.setTitle("Acknowledgement");
        //ad.show();

                    counter--;
                    etPassword.setText("");
                    info.setText("No of Attempts Remaining:" + String.valueOf(counter));

                    if (counter == 0)
                    {
                        //login.setBackgroundColor(Color.parseColor("grey"));
                        btnlogin.setBackground(getResources().getDrawable(R.drawable.layout2));
                        btnlogin.setEnabled(false);
                        new CountDownTimer(30000, 1000) {
                            public void onTick(long millisUntilFinished) {
                                info.setText("Waiting For " + millisUntilFinished / 1000+" Seconds");
                            }
                            public void onFinish() {
                                counter=5;
                                info.setText("No of attempts remaining"+counter);
                                btnlogin.setEnabled(true);
                                btnlogin.setBackground(getResources().getDrawable(R.drawable.layout));
                            }
                        }.start();
                    }
                }
        //}
        //db.close();

    //}

    public void click(View view){
        //Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("http://send-otp-for-free.000webhostapp.com"));
        //startActivity(browser);
        Intent browser=new Intent(MainActivity.this,Main55Activity.class );
        MainActivity.this.startActivity(browser);
        MainActivity.this.finish();
    }
}