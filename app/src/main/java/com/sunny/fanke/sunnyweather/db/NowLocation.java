package com.sunny.fanke.sunnyweather.db;

import org.litepal.crud.DataSupport;

@SuppressWarnings("deprecation")
public class NowLocation extends DataSupport{
    private int flag;//标志，实时位置标志0，其他自然数
    private String city;//城市
    private String District;//城区
    private double Longitude;//经度
    private double Latitude;//纬度

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
