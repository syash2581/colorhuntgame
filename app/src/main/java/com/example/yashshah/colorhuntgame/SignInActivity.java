package com.example.yashshah.colorhuntgame;

import android.os.AsyncTask;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SignInActivity extends AppCompatActivity{

    public static String uid;
    public static String password;

    public static final String score="score";
    public static final String hsname1="name";
    public static final String error = "error";

}
