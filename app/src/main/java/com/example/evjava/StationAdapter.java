package com.example.evjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder>{

    ArrayList<dbstation> list;

    public StationAdapter(ArrayList<dbstation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.activity_stationlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dbstation model= list.get(position);
        Picasso.get().load(model.getStat_pic()).placeholder(R.drawable.img_err).into(holder.itemImage);
        holder.stHeading.setText(model.stat_name);
        holder.show_avail.setText(model.stat_avail);
        holder.show_city.setText(model.stat_city);
        holder.show_desc.setText(model.stat_desc);
        holder.show_loc.setText(model.stat_loc);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView show_avail,show_city,show_desc,show_loc,stHeading;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stHeading=itemView.findViewById(R.id.stHeading);
            show_avail=itemView.findViewById(R.id.show_avail);
            show_city=itemView.findViewById(R.id.show_city);
            show_desc=itemView.findViewById(R.id.show_desc);
            show_loc=itemView.findViewById(R.id.show_loc);
            itemImage=itemView.findViewById(R.id.itemImage);
        }
    }
}