package com.sunny.fanke.sunnyweather.data;

import java.io.Serializable;

public class UseData_LocationLL implements Serializable{
    /**
     * 传递位置信息 序列化
     */
    private double Longitude=0.0;//经度
    private double Latitude=0.0;//纬度

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
