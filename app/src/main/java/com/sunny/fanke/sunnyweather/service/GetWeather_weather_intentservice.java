package com.sunny.fanke.sunnyweather.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;
import com.sunny.fanke.sunnyweather.MyApplication.MyApplication;
import com.sunny.fanke.sunnyweather.data.UseData_LocationLL;
import com.sunny.fanke.sunnyweather.gson.WeatherBean;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetWeather_weather_intentservice extends IntentService {

    public GetWeather_weather_intentservice() {
        super("GetWeather_weather_intentservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //组装url
        String url="https://free-api.heweather.com/s6/weather?";
        UseData_LocationLL useData_locationLL=(UseData_LocationLL)intent.getSerializableExtra("nowlocation") ;
        String location="location="+useData_locationLL.getLongitude()+","+useData_locationLL.getLatitude();
        //String location="location=beijing";
        String key="&key=6a9d7453efdd44e886cbd0a468082e41";
        url=url+location+key;
        //查询天气
        final String finalUrl = url;

        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(finalUrl)
                .build();
        try {
            Response response=client.newCall(request).execute();
            //发送天气广播
            LocalBroadcastManager localBroadcastManager=LocalBroadcastManager.getInstance(MyApplication.getContext());
            Intent intent1=new Intent("com.sunny.broadcast.WeaData");
            //Log.d(TAG, "run: "+response.body().string());
            //此处解析天气信息
            String jsonData=String.valueOf(response.body().string());
            // 初始化GSON
            Gson gson=new Gson();
            // 使用Gson提供的fromJson将String格式的Json数据转为对象
            WeatherBean weatherBean=gson.fromJson(jsonData,WeatherBean.class);
            // 解析出第一层的数据
            List<WeatherBean.HeWeather6Bean> heWeather6Beans=weatherBean.getHeWeather6();
            //WeatherBean.HeWeather6Bean heWeather6Bean= (WeatherBean.HeWeather6Bean) weatherBean.getHeWeather6();
            //解析第二层"status"数据
            String status=heWeather6Beans.get(0).getStatus();
            //String status=heWeather6Beans.getStatus();


            //UseData_Weather useData_weather=new UseData_Weather();
            //useData_weather.setResponseBody(response.body());
            intent1.putExtra("NowLocationWeather", status);
            localBroadcastManager.sendBroadcast(intent1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
