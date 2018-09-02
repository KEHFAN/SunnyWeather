package com.sunny.fanke.sunnyweather;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sunny.fanke.sunnyweather.MyApplication.MyApplication;
import com.sunny.fanke.sunnyweather.data.UseData_LocationLL;
import com.sunny.fanke.sunnyweather.recyclerView.Forecast;
import com.sunny.fanke.sunnyweather.recyclerView.ForecastAdapter_RecyclerView;
import com.sunny.fanke.sunnyweather.recyclerView.Hour;
import com.sunny.fanke.sunnyweather.recyclerView.HourlyAdapter_RecyclerView;
import com.sunny.fanke.sunnyweather.service.GetLocation_Service;
import com.sunny.fanke.sunnyweather.service.GetWeather_weather_intentservice;

import java.util.ArrayList;
import java.util.List;

public class Weather_view extends AppCompatActivity {
    private Weather_view.MyBroadcastreceiver mReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private Weather_view.WeaMyBroadReceiver wReceiver;
    private LocalBroadcastManager wlocalBroadcastManager;
    //逐小时数据测试
    private List<Hour> hourList=new ArrayList<>();
    private List<Forecast> forecastList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();//隐藏系统标题栏
        }


        //运行时权限
        if(ContextCompat.checkSelfPermission(Weather_view.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Weather_view.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }
        if(ContextCompat.checkSelfPermission(Weather_view.this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Weather_view.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},2);
        }
        if(ContextCompat.checkSelfPermission(Weather_view.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Weather_view.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
        }
        if(ContextCompat.checkSelfPermission(Weather_view.this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Weather_view.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},4);
        }
        if(ContextCompat.checkSelfPermission(Weather_view.this,Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Weather_view.this,new String[]{Manifest.permission.READ_PHONE_STATE},5);
        }


        //启动位置天气服务
        Intent startSerivce=new Intent(Weather_view.this, GetLocation_Service.class);
        startService(startSerivce);


        //本地广播接收器location
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.sunny.broadcast.MY_BROADCAST");
        mReceiver=new Weather_view.MyBroadcastreceiver();
        localBroadcastManager= LocalBroadcastManager.getInstance(MyApplication.getContext());
        localBroadcastManager.registerReceiver(mReceiver,filter);
        //本地广播接收器weather
        IntentFilter filterWeather=new IntentFilter();
        filterWeather.addAction("com.sunny.broadcast.WeaData");
        wReceiver=new Weather_view.WeaMyBroadReceiver();
        wlocalBroadcastManager=LocalBroadcastManager.getInstance(MyApplication.getContext());
        wlocalBroadcastManager.registerReceiver(wReceiver,filterWeather);
    }

    /**
     * 逐小时数据测试
     */
    private void initHours(){
        for (int i = 0; i < 15; i++) {
            Hour hour=new Hour("20:00","20℃");
            hourList.add(hour);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(mReceiver);
        wlocalBroadcastManager.unregisterReceiver(wReceiver);
    }

    /**
     * 坐标广播接收器
     */
    public class MyBroadcastreceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            UseData_LocationLL useData_locationLL=(UseData_LocationLL)intent.getSerializableExtra("NowLocationData");
            //启动天气服务
            Intent startWeatherSerivce=new Intent(Weather_view.this, GetWeather_weather_intentservice.class);
            startWeatherSerivce.putExtra("nowlocation",useData_locationLL);
            startService(startWeatherSerivce);
        }
    }

    /**
     * 天气信息广播接收器
     */
    public class WeaMyBroadReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView titleCity=(TextView)findViewById(R.id.title_center);
            titleCity.setText(intent.getStringExtra("NowLocationWeather_basic_city"));
            TextView nowTem=(TextView)findViewById(R.id.weather_view_now_degree1);
            nowTem.setText(intent.getStringExtra("NowLocationWeather_now_tmp"));
            TextView nowTxt1=(TextView)findViewById(R.id.weather_view_now_txt1);
            nowTxt1.setText(intent.getStringExtra("NowLocationWeather_now_cond_txt"));
            //逐小时数据测试
            initHours();
            RecyclerView recyclerView_hour=(RecyclerView)findViewById(R.id.weather_view_hourly);
            LinearLayoutManager layoutManager_hour=new LinearLayoutManager(MyApplication.getContext());
            //设置水平滚动
            layoutManager_hour.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView_hour.setLayoutManager(layoutManager_hour);
            HourlyAdapter_RecyclerView adapter_recyclerView_hour=new HourlyAdapter_RecyclerView(hourList);
            recyclerView_hour.setAdapter(adapter_recyclerView_hour);
            //daily_forecast
            String [][] daily_forecast=new String[15][3];
            int dailyforecasti=Integer.valueOf(intent.getStringExtra("NowLocationWeather_forecasti"));
            for (int i = 0; i < dailyforecasti; i++) {
                String name="NowLocationWeather_forecast"+i;
                daily_forecast[i]=intent.getStringArrayExtra(name);
            }
            TextView textViewMaxMinToday=(TextView)findViewById(R.id.weather_view_now_maxMin);
            textViewMaxMinToday.setText(daily_forecast[0][2]);
            for (int i = 0; i < dailyforecasti; i++) {
                Forecast forecast=new Forecast(daily_forecast[i][0],daily_forecast[i][1],daily_forecast[i][2]);
                forecastList.add(forecast);
            }
            //使用ListView
            //ForecastAdapter forecastAdapter=new ForecastAdapter(Weather_view.this, R.layout.weather_view_forecast_item,forecastList);
            //ListView listView=(ListView) findViewById(R.id.weather_view_forecast);
            //listView.setAdapter(forecastAdapter);
            //使用RecyclerView
            RecyclerView recyclerView=(RecyclerView)findViewById(R.id.weather_view_forecast_recyclerview);
            LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
            recyclerView.setLayoutManager(layoutManager);
            ForecastAdapter_RecyclerView adapter_recyclerView=new ForecastAdapter_RecyclerView(forecastList);
            recyclerView.setAdapter(adapter_recyclerView);
        }
    }
}
