package com.sunny.fanke.sunnyweather.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;
import com.sunny.fanke.sunnyweather.MyApplication.MyApplication;
import com.sunny.fanke.sunnyweather.data.UseData_LocationLL;
import com.sunny.fanke.sunnyweather.gson.WeatherData_weatherBean;

import java.io.IOException;
import java.io.Serializable;
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

            //Log.d(TAG, "run: "+response.body().string());
            //此处解析天气信息
            String jsonData=String.valueOf(response.body().string());
            // 初始化GSON
            Gson gson=new Gson();
            // 使用Gson提供的fromJson将String格式的Json数据转为对象
            WeatherData_weatherBean weatherBean=gson.fromJson(jsonData,WeatherData_weatherBean.class);
            // 解析出第一层的数据
            List<WeatherData_weatherBean.HeWeather6Bean> heWeather6Beans=weatherBean.getHeWeather6();
            //解析第二层"status"数据
            String status="状态："+heWeather6Beans.get(0).getStatus();
            //解析第二层"basic"数据
            WeatherData_weatherBean.HeWeather6Bean.BasicBean basicBean=heWeather6Beans.get(0).getBasic();
            String basic=basicBean.getLocation();
            //解析第二层"now"数据
            WeatherData_weatherBean.HeWeather6Bean.NowBean nowBean=heWeather6Beans.get(0).getNow();
            String now=nowBean.getCond_txt();
            String tmp=nowBean.getTmp();
            String fl=nowBean.getFl();
            //解析第二层"daily_forecast"数据
            String [][] daily_forecast=new String[15][3];
            List<WeatherData_weatherBean.HeWeather6Bean.DailyForecastBean> dailyForecastBean=heWeather6Beans.get(0).getDaily_forecast();
            int dailyForecastBeani=dailyForecastBean.size();
            for (int i = 0; i < dailyForecastBeani; i++) {
                String date=dailyForecastBean.get(i).getDate();
                daily_forecast[i][0]=date.substring(5,date.length());
                daily_forecast[i][1]=dailyForecastBean.get(i).getCond_txt_d();
                String tmpMaxMin=dailyForecastBean.get(i).getTmp_max()+"℃/"+
                        dailyForecastBean.get(i).getTmp_min()+"℃";
                daily_forecast[i][2]=tmpMaxMin;
            }
            //解析第二层"hourly"数据
            String [][] hourly=new String[24][2];
            List<WeatherData_weatherBean.HeWeather6Bean.HourlyBean> hourlyBeanList=heWeather6Beans.get(0).getHourly();
            int hourlyBeanListi=hourlyBeanList.size();
            for (int i = 0; i < hourlyBeanListi; i++) {
                String hour=hourlyBeanList.get(i).getTime();
                hourly[i][0]=hour.substring(11,hour.length());
                hourly[i][1]=hourlyBeanList.get(i).getTmp()+"℃";
            }
            Intent intent1=new Intent("com.sunny.broadcast.WeaData");

            intent1.putExtra("NowLocationWeather_status", status);
            intent1.putExtra("NowLocationWeather_basic_city", basic);
            intent1.putExtra("NowLocationWeather_now_cond_txt",now);
            intent1.putExtra("NowLocationWeather_now_tmp",tmp);//气温
            intent1.putExtra("NowLocationWeather_now_fl",fl);//体感温度
            //传递第二层"daily_forecast"数据
            intent1.putExtra("NowLocationWeather_forecasti",String.valueOf(dailyForecastBeani));
            for (int i = 0; i < dailyForecastBeani; i++) {
                String name="NowLocationWeather_forecast"+i;
                intent1.putExtra(name,daily_forecast[i]);
            }
            //传递第二层"hourly"数据
            intent1.putExtra("NowLocationWeather_hourlyi",String.valueOf(hourlyBeanListi));
            for (int i = 0; i < hourlyBeanListi; i++) {
                String name="NowLocationWeather_hourly"+i;
                intent1.putExtra(name,hourly[i]);
            }

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
