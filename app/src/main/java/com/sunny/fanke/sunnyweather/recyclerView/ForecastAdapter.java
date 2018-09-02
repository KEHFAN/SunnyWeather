package com.sunny.fanke.sunnyweather.recyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sunny.fanke.sunnyweather.R;

import java.util.List;

public class ForecastAdapter extends ArrayAdapter<Forecast> {

    private int resourceID;

    public ForecastAdapter(@NonNull Context context, int resource, List<Forecast> objects) {
        super(context, resource,objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Forecast forecast=getItem(position);//获取当前Forecast实例
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView textViewdate=(TextView) view.findViewById(R.id.weather_view_forecast_date);
        TextView textViewweather=(TextView) view.findViewById(R.id.weather_view_forecast_weather);
        TextView textViewtmp=(TextView)view.findViewById(R.id.weather_view_forecast_tmp);
        textViewdate.setText(forecast.getDate());
        textViewweather.setText(forecast.getWeathertxt());
        textViewtmp.setText(forecast.getTmpMaxMin());
        return view;
    }
}
