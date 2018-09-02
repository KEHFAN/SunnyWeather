package com.sunny.fanke.sunnyweather.recyclerView;

public class Hour {
    private String time;
    //private int imageID;//图片id
    private String tmp;

    public Hour(String time,String tmp){
        this.time=time;
        this.tmp=tmp;
    }

    public String getTime() {
        return time;
    }

    public String getTmp() {
        return tmp;
    }
}
