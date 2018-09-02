package com.sunny.fanke.sunnyweather.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sunny.fanke.sunnyweather.R;
import java.util.List;
public class HourlyAdapter_RecyclerView extends RecyclerView.Adapter<HourlyAdapter_RecyclerView.ViewHolder>{
    private List<Hour> mHourList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTime;
        TextView textViewTmp;

        public ViewHolder(View view){
            super(view);
            textViewTime=(TextView)view.findViewById(R.id.weather_view_hourly_time);
            textViewTmp=(TextView)view.findViewById(R.id.weather_view_hourly_tmp);
        }
    }

    public HourlyAdapter_RecyclerView(List<Hour> hourList){
        mHourList=hourList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_view_hourly_item,
                parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        Hour hour=mHourList.get(position);
        holder.textViewTime.setText(hour.getTime());
        holder.textViewTmp.setText(hour.getTmp());
    }

    public int getItemCount(){
        return mHourList.size();
    }
}
