package com.sunny.fanke.sunnyweather.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.fanke.sunnyweather.R;

import java.util.List;

public class ForecastAdapter_RecyclerView extends RecyclerView.Adapter<ForecastAdapter_RecyclerView.ViewHolder> {
    private List<Forecast> mForecast;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewdate;
        TextView textViewweather;
        TextView textViewtmp;
        
        public ViewHolder(View view){
            super(view);
            textViewdate=(TextView) view.findViewById(R.id.weather_view_forecast_date);
            textViewweather=(TextView) view.findViewById(R.id.weather_view_forecast_weather);
            textViewtmp=(TextView)view.findViewById(R.id.weather_view_forecast_tmp);
        }
    }

    public ForecastAdapter_RecyclerView(List<Forecast> forecastList){
        mForecast=forecastList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_view_forecast_item,
                parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        Forecast forecast=mForecast.get(position);
        holder.textViewdate.setText(forecast.getDate());
        holder.textViewweather.setText(forecast.getWeathertxt());
        holder.textViewtmp.setText(forecast.getTmpMaxMin());
    }

    public int getItemCount(){
        return mForecast.size();
    }
}
