package com.sunny.fanke.sunnyweather.recyclerView;

public class Forecast {
    private String date;//日期
    private String weathertxt;//天气描述 如：多云
    private String tmpMaxMin;//最高/最低气温

    public Forecast(String date,String weathertxt,String tmpMaxMin){
        this.date=date;
        this.weathertxt=weathertxt;
        this.tmpMaxMin=tmpMaxMin;
    }

    public String getDate() {
        return date;
    }

    public String getWeathertxt() {
        return weathertxt;
    }

    public String getTmpMaxMin() {
        return tmpMaxMin;
    }
}
