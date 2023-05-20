package com.example.cosmeticsstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cosmeticsstore.R;
import com.example.cosmeticsstore.models.HomeHorModel;

import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    private Context context;
    private List<HomeHorModel> list;

    public HomeHorAdapter(Context context, List<HomeHorModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Tao 1 view xac dinh UI cua list item, goi den layout xml da tao
        //LayoutInflater la component giup chuyen layout file .xml thanh view
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Khai bao ImageView
        ImageView imageView;
        //Khai bao TextView
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Khoi tao ImageView va TextView voi id
            imageView = itemView.findViewById(R.id.hor_img);
            textView = itemView.findViewById(R.id.hor_text);
        }
    }
}
