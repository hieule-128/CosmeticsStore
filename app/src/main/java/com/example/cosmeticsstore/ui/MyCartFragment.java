package com.example.cosmeticsstore.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cosmeticsstore.R;
import com.example.cosmeticsstore.adapters.CartAdapter;
import com.example.cosmeticsstore.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.hair1,"Order 1","30.000đ","4.3"));
        list.add(new CartModel(R.drawable.beauty,"Order 2","40.000đ","4.4"));
        list.add(new CartModel(R.drawable.beauty,"Order 3","50.000đ","4.5"));
        list.add(new CartModel(R.drawable.beauty,"Order 4","60.000đ","4.6"));
        list.add(new CartModel(R.drawable.beauty,"Order 5","70.000đ","4.7"));
        list.add(new CartModel(R.drawable.beauty,"Order 6","80.000đ","4.8"));
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        return view;
    }
}