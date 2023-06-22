package com.example.cosmeticsstore.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cosmeticsstore.R;
import com.example.cosmeticsstore.adapters.CategoryAdapter;
import com.example.cosmeticsstore.databinding.FragmentCategoryBinding;
import com.example.cosmeticsstore.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    List<CategoryModel> list;
    CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;
    public CategoryFragment() {}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.category_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CategoryModel(R.drawable.beauty,"Skincare", "20 products"));
        list.add(new CategoryModel(R.drawable.makeup,"Make up", "5 products"));
        list.add(new CategoryModel(R.drawable.perfume,"Perfume", "8 products"));
        list.add(new CategoryModel(R.drawable.body,"Body","12 products"));
        list.add(new CategoryModel(R.drawable.hair, "Hair", "4 products"));
        categoryAdapter = new CategoryAdapter(list);
        recyclerView.setAdapter(categoryAdapter);
        return view;
    }

}