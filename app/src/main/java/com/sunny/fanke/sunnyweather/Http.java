package com.sunny.fanke.sunnyweather;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Http extends AppCompatActivity {
    private String string=null;
    TextView textView=null;
    public Http(TextView textView){
        this.textView=textView;
    }
    public String sendHttps(final String url){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        Log.d("Http","Http:"+string);
        return string;
    }
    private void setString(String s){
        this.string=s;
    }
}
