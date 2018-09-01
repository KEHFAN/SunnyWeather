package com.sunny.fanke.sunnyweather.MyApplication;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

public class MyApplication extends Application{
    private static Context context;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        context=getApplicationContext();
        //noinspection deprecation
        LitePalApplication.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
