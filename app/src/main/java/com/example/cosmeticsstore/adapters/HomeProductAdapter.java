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
import com.example.cosmeticsstore.models.HomeProductModel;

import java.util.List;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.ProductViewHolder> {
    private Context context;
    private List<HomeProductModel> list;

    public HomeProductAdapter(Context context, List<HomeProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeProductAdapter.ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProductAdapter.ProductViewHolder holder, int position) {
        holder.prodImage.setImageResource(list.get(position).getProductImage());
        holder.prodName.setText(list.get(position).getProductName());
        holder.prodQty.setText(list.get(position).getProductQty());
        holder.prodPrice.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName = itemView.findViewById((R.id.prod_name));
            prodQty = itemView.findViewById((R.id.prod_qty));
            prodPrice = itemView.findViewById((R.id.prod_price));
            prodImage = itemView.findViewById((R.id.prod_image));
        }
    }
}
