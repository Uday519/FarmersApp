package com.kavya.farmersapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavya.farmersapp.Models.Farm;
import com.kavya.farmersapp.R;

import java.util.List;

public class FarmRecylerAdapter extends RecyclerView.Adapter<FarmRecylerAdapter.RecyclerViewHolder>{

    private List<Farm> farmList;
    private Context context;
    private LayoutInflater inflater;

    public FarmRecylerAdapter(List<Farm> farmList, Context context) {
        this.farmList = farmList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setFarmList(List<Farm> farmList) {
        this.farmList = farmList;
    }

    @NonNull
    @Override
    public FarmRecylerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.farm_list_row,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmRecylerAdapter.RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.owner_name.setText(farmList.get(i).farm_owner.toString());
        recyclerViewHolder.farm_pic.setImageResource(R.drawable.person);
    }

    @Override
    public int getItemCount() {
        return farmList.size();
    }

    public void updateList(List<Farm> list){
        farmList = list;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView owner_name;
        ImageView farm_pic;
        private RecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.owner_name = itemView.findViewById(R.id.owner_name);
            this.farm_pic = itemView.findViewById(R.id.farm_pic);
        }

    }
}
