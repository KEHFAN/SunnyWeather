package com.sunny.fanke.sunnyweather.location;


import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;


public class Location{
    private Double Longitude=0.0;//经度
    private Double Latitude=0.0;//纬度
    private String City=null;//城市
    private String CityCode=null;//城市编码
    private String AdCode=null;//区域编码
    private String address=null;//地址
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;

    public Location(Context context){
        //初始化定位
        mLocationClient = new AMapLocationClient(context);
        //设置定位回调监听
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        Longitude = amapLocation.getLongitude();
                        Latitude = amapLocation.getLatitude();
                        City=amapLocation.getCity();
                        CityCode=amapLocation.getCityCode();
                        AdCode=amapLocation.getAdCode();
                        address = ("地址：" + amapLocation.getAddress() + "\n"
                                + "经度：" + amapLocation.getLongitude() + "\n"
                                + "纬度：" + amapLocation.getLatitude() + "\n");
                    }
                }
            }
        };
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    }
    public void startLocation(){
        mLocationClient.startLocation();
    }
    public void stopLocation(){
        mLocationClient.stopLocation();
    }
    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public String getAdCode() {
        return AdCode;
    }

    public String getCityCode() {
        return CityCode;
    }

    public String getCity() {
        return City;
    }
}
