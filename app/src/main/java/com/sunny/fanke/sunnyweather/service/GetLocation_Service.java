package com.sunny.fanke.sunnyweather.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.sunny.fanke.sunnyweather.MyApplication.MyApplication;
import com.sunny.fanke.sunnyweather.data.UseData_LocationLL;
import com.sunny.fanke.sunnyweather.db.NowLocation;

import org.litepal.tablemanager.Connector;

import static android.content.ContentValues.TAG;

public class GetLocation_Service extends Service {

    private AMapLocationClient aMapLocationClient=null;

    public GetLocation_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"服务运行中。。。。。。。");

        AMapLocationListener aMapLocationListener=null;

        AMapLocationClientOption aMapLocationClientOption=null;
        aMapLocationClientOption=new AMapLocationClientOption();
        //高精度定位模式
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        //该方法默认为false。
        aMapLocationClientOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        aMapLocationClientOption.setOnceLocationLatest(true);
        //连续定位时间间隔1000ms
        aMapLocationClientOption.setInterval(1000);
        //不返回地址信息
        aMapLocationClientOption.setNeedAddress(false);
        //单次定位超时时间20000ms
        aMapLocationClientOption.setHttpTimeOut(20000);
        //关闭缓存
        aMapLocationClientOption.setLocationCacheEnable(false);

        aMapLocationClient=new AMapLocationClient(MyApplication.getContext());
        //设置参数
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        //监听器
        aMapLocationListener=new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        Log.d(TAG,"定位成功...........定位成功。。。。。。。。。");
                        LocalBroadcastManager localBroadcastManager=LocalBroadcastManager.getInstance(MyApplication.getContext());
                        Intent intent1=new Intent("com.sunny.broadcast.MY_BROADCAST");
                        UseData_LocationLL useData_locationLL=new UseData_LocationLL();
                        useData_locationLL.setLongitude(aMapLocation.getLongitude());
                        useData_locationLL.setLatitude(aMapLocation.getLatitude());
                        intent1.putExtra("NowLocationData",useData_locationLL);
                        localBroadcastManager.sendBroadcast(intent1);

                        //停止服务
                        aMapLocationClient.stopLocation();
                        aMapLocationClient.onDestroy();
                        stopSelf();
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.d("AmapError","location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        };
        //设置监听
        aMapLocationClient.setLocationListener(aMapLocationListener);
        //启动定位
        aMapLocationClient.startLocation();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //aMapLocationClient.stopLocation();
        //aMapLocationClient.onDestroy();
        Log.d(TAG,"服务停止。。。。。。。");
    }
}
