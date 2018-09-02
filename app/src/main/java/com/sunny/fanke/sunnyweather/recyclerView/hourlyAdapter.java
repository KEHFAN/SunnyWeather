package com.sunny.fanke.sunnyweather.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.fanke.sunnyweather.R;

import java.util.List;

public class hourlyAdapter extends RecyclerView.Adapter<hourlyAdapter.ViewHolder>{

    private List<Hour> hourList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewtime;
        //图片
        TextView textViewtmp;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewtime=(TextView)itemView.findViewById(R.id.weather_view_hourly_time);
            textViewtmp=(TextView)itemView.findViewById(R.id.weather_view_hourly_tmp);
        }
    }

    public hourlyAdapter(List<Hour> hours){
        this.hourList=hours;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weather_view_hourly_item,viewGroup,true);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Hour hour=hourList.get(i);
        viewHolder.textViewtime.setText(hour.getTime());
        viewHolder.textViewtmp.setText(hour.getTmp());
    }

    @Override
    public int getItemCount() {
        return hourList.size();
    }
}
