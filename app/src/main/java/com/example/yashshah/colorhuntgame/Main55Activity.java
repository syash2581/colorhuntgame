package com.example.yashshah.colorhuntgame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main55Activity extends AppCompatActivity {

    private Button b1;

    private TextView t5;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;

    private EditText et5;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;

    String otp;
    String uemail;


    private ProgressDialog progress;

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Main55Activity.this,MainActivity.class);
        startActivity(intent);
        Main55Activity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Verification in Progress");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(0);

        b1=(Button)findViewById(R.id.submit);

        t5=(TextView)findViewById(R.id.uid);
        t1=(TextView)findViewById(R.id.uemail);
        t2=(TextView)findViewById(R.id.uotp);
        t3=(TextView)findViewById(R.id.upwd);
        t4=(TextView)findViewById(R.id.unpwd);

        et5=(EditText)findViewById(R.id.ID);
        et1=(EditText)findViewById(R.id.EMAIL);
        et2=(EditText)findViewById(R.id.OTP);
        et3=(EditText)findViewById(R.id.PWD);
        et4=(EditText)findViewById(R.id.NPWD);


        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);

        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);

        b1.setText("Get OTP");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1.getText().toString().equals("Get OTP"))
                {
                    if((!(et1.getText().toString().equals(""))) & (!(et5.getText().toString().equals(""))))
                    {
                            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                                "http://send-otp-for-free.000webhostapp.com/send-text-email.php?uemail="+et1.getText().toString(),
                                new Response.Listener<String>(){
                                    @Override
                                    public void onResponse(String response){
                                        //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                        if (response.trim().equalsIgnoreCase("Failure")){

                                            //progress.dismiss();
                                            Toast.makeText(Main55Activity.this, "Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();

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
                                                String otp2="otp";
                                                String uemail2="uemail";
                                                otp=Data.getString(otp2);
                                                uemail=Data.getString(uemail2);
                                                //String msg = "msg";

                                                //Toast.makeText(MainActivity.this,"After jsons objects"+error+" "+msg,Toast.LENGTH_LONG).show();

                                                progress.setProgress(100);
                                                progress.dismiss();
                                                if(Data.getString(error).equalsIgnoreCase("false"))
                                                {
                                                    t2.setVisibility(View.VISIBLE);
                                                    et2.setVisibility(View.VISIBLE);

                                                    b1.setText("Submit");
                                                    Toast.makeText(Main55Activity.this,"OTP has been sent on given email",Toast.LENGTH_LONG).show();}
                                                else
                                                {

                                                    Toast.makeText(Main55Activity.this,"OTP has been not send on given email",Toast.LENGTH_LONG).show();
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
                                //progress.dismiss();
                                //Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                Toast.makeText(Main55Activity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                            }
                        })
                     {
                         @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                //Adding parameters to request
                                params.put("uemail", et1.getText().toString());

                                // params.put(Config.KEY_SEM, sem);
                                //params.put(Config.KEY_BRANCH, branch);
                                //returning parameter
                                return params;
                            }
                    };
                    //progress.dismiss();
                    //progress.setProgress(20);
                    //progress.show();
                    RequestQueue requestQueue = Volley.newRequestQueue(Main55Activity.this);
                    requestQueue.add(stringRequest);
                }
                else
                    {
                        Toast.makeText(Main55Activity.this,"Enter Email ID and User ID First...",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(b1.getText().toString().equals("Submit"))
                {
                        if(et2.getText().toString().equals(otp))
                        {
                            t3.setVisibility(View.VISIBLE);
                            t4.setVisibility(View.VISIBLE);
                            et3.setVisibility(View.VISIBLE);
                            et4.setVisibility(View.VISIBLE);

                            b1.setText("Change Password");
                        }
                        else
                        {
                            Toast.makeText(Main55Activity.this,"Enter Correct OTP First",Toast.LENGTH_SHORT).show();
                        }
                }
                else
                {
                    if (et5.getText().toString()!="" & et1.getText().toString().equals(uemail) & et2.getText().toString().equals(otp))
                    {
                        if(et3.getText().toString().equals(et4.getText().toString()))
                        {
                            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                                    "http://send-otp-for-free.000webhostapp.com/write.php?uemail="+et1.getText().toString()+"&password="+et3.getText().toString()+"&uid="+et5.getText().toString(),
                                    new Response.Listener<String>(){
                                        @Override
                                        public void onResponse(String response){
                                            //Toast.makeText(MainActivity.this,"In onResponse Method",Toast.LENGTH_LONG).show();
                                            if (response.trim().equalsIgnoreCase("Failure")){

                                                //progress.dismiss();
                                                Toast.makeText(Main55Activity.this, "Invalid user id or Password or\nmay be user is not registered", Toast.LENGTH_LONG).show();

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
                                                        Toast.makeText(Main55Activity.this,"Password Changed....",Toast.LENGTH_LONG).show();
                                                        Intent intent=new Intent(Main55Activity.this,MainActivity.class);
                                                        startActivity(intent);
                                                        Main55Activity.this.finish();
                                                    }
                                                    else
                                                    {
                                                        Toast.makeText(Main55Activity.this,"Failed",Toast.LENGTH_LONG).show();
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
                                    //progress.dismiss();
                                    //Toast.makeText(Main55Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                                    Toast.makeText(Main55Activity.this, "Some Error Occurred\nPlease Try Again Later...", Toast.LENGTH_LONG).show();
                                }
                            })
                            {
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String, String> params = new HashMap<>();
                                    //Adding parameters to request
                                    params.put("uid", et5.getText().toString());
                                    params.put("uemail", et1.getText().toString());
                                    params.put("password", et3.getText().toString());

                                    // params.put(Config.KEY_SEM, sem);
                                    //params.put(Config.KEY_BRANCH, branch);
                                    //returning parameter
                                    return params;
                                }
                            };
                            //progress.dismiss();
                            //progress.setProgress(20);
                            //progress.show();
                            RequestQueue requestQueue = Volley.newRequestQueue(Main55Activity.this);
                            requestQueue.add(stringRequest);
                        }
                        else
                        {
                            Toast.makeText(Main55Activity.this,"Enter Same Password....",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Main55Activity.this,"Enter Correct Email or OTP....",Toast.LENGTH_SHORT).show();
                    }

                }

                }

        });


    }
    /*public void sendEmail(String s)
    {
        String temp="";
        if(s.equals("Get OTP"))
        {
            String To=et1.getText().toString();
            String[] CC={""};
            Intent emailIntent=new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL,To);
            emailIntent.putExtra(Intent.EXTRA_CC,CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Verification");

            Random r1=new Random();
            int n=r1.nextInt(9999)+1;
            temp=String.valueOf(n);

            emailIntent.putExtra(Intent.EXTRA_TEXT,temp);


            try{
                startActivity(Intent.createChooser(emailIntent,"Send Mail..."));
                finish();
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(Main55Activity.this,"There is no email client installed",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if(et2.getText().toString().equals(temp))
            {
                Toast.makeText(Main55Activity.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
            }
            else
            {

            }
        }

    }*/
}
