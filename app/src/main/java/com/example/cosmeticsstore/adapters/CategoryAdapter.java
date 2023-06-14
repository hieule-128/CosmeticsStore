package com.example.cosmeticsstore.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cosmeticsstore.R;
import com.example.cosmeticsstore.models.CategoryModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    List<CategoryModel> list;
    public CategoryAdapter(List<CategoryModel> list) {this.list = list;}
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_nav,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.catImage.setImageResource(list.get(position).getCatImage());
        holder.catText.setText(list.get(position).getCatText());
        holder.productsNum.setText(list.get(position).getProductNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView catImage;
        TextView catText, productsNum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.category_img);
            catText = itemView.findViewById(R.id.category_text);
            productsNum = itemView.findViewById(R.id.category_products);
        }
    }
}
