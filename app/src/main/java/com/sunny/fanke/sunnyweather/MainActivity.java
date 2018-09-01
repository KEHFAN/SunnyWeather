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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sunny.fanke.sunnyweather.MyApplication.MyApplication;
import com.sunny.fanke.sunnyweather.data.UseData_LocationLL;
import com.sunny.fanke.sunnyweather.service.GetLocation_Service;
import com.sunny.fanke.sunnyweather.service.GetWeather_weather_intentservice;

public class MainActivity extends AppCompatActivity {
    public TextView textView=null;
    public TextView weatherTextView=null;
    public Button button=null;
    public Button button2=null;

    public String address=null;
    private MyBroadcastreceiver mReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private WeaMyBroadReceiver wReceiver;
    private LocalBroadcastManager wlocalBroadcastManager;
    private boolean locationFlag=false;//标志位置是否确定
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.position_text_view);
        weatherTextView=(TextView)findViewById(R.id.weather_view);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);


        //运行时权限
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},2);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},4);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_PHONE_STATE},5);
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendRequestHttp();
                textView.setText("结束"+address);
                Http http=new Http(textView);
                address=http.sendHttps("https://www.baidu.com");
                Log.d("MainActivity", "onClick: "+address);

            }
        });
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSerivce=new Intent(MainActivity.this, GetLocation_Service.class);
                startService(startSerivce);
                textView.setText("启动location服务");
            }
        });
        Button button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("停止服务");
            }
        });


        //本地广播接收器location
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.sunny.broadcast.MY_BROADCAST");
        mReceiver=new MyBroadcastreceiver();
        localBroadcastManager=LocalBroadcastManager.getInstance(MyApplication.getContext());
        localBroadcastManager.registerReceiver(mReceiver,filter);
        //本地广播接收器weather
        IntentFilter filterWeather=new IntentFilter();
        filterWeather.addAction("com.sunny.broadcast.WeaData");
        wReceiver=new WeaMyBroadReceiver();
        wlocalBroadcastManager=LocalBroadcastManager.getInstance(MyApplication.getContext());
        wlocalBroadcastManager.registerReceiver(wReceiver,filterWeather);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(mReceiver);
        wlocalBroadcastManager.unregisterReceiver(wReceiver);
    }

    public class MyBroadcastreceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            UseData_LocationLL useData_locationLL=(UseData_LocationLL)intent.getSerializableExtra("NowLocationData");
            String str="收到广播：" +"\n"+
                    "经度："+useData_locationLL.getLongitude() +"\n"+
                    "纬度："+useData_locationLL.getLatitude();
            textView.setText(str);
            //启动天气服务
            Intent startWeatherSerivce=new Intent(MainActivity.this, GetWeather_weather_intentservice.class);
            startWeatherSerivce.putExtra("nowlocation",useData_locationLL);
            startService(startWeatherSerivce);
            textView.setText(str+"\n启动天气服务");
        }
    }

    public class WeaMyBroadReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String data=intent.getStringExtra("NowLocationWeather");

            weatherTextView.setText("天气数据：\n"+data);
        }
    }

    public void showData(String data){
        weatherTextView.setText(data);
    }
}
