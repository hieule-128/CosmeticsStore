package com.example.cosmeticsstore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cosmeticsstore.R;
import com.example.cosmeticsstore.adapters.HomeHorAdapter;
import com.example.cosmeticsstore.adapters.HomeProductAdapter;
import com.example.cosmeticsstore.databinding.FragmentHomeBinding;
import com.example.cosmeticsstore.models.HomeHorModel;
import com.example.cosmeticsstore.models.HomeProductModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView categoryRec, prodRec;
    private ArrayList<HomeHorModel> list;
    private HomeHorAdapter categoryAdapter;
    private ArrayList<HomeProductModel> prodList;
    private HomeProductAdapter prodAdapter;
    FirebaseDatabase database;
    DatabaseReference reference = database.getInstance().getReference("category");
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        categoryRec = root.findViewById(R.id.home_hor_recycler);
        prodRec = root.findViewById(R.id.home_product_recycler);

        categoryRec.setHasFixedSize(true);
        categoryRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false ));
        categoryRec.setNestedScrollingEnabled(false);
        list = new ArrayList<>();
        categoryAdapter = new HomeHorAdapter(getActivity(), list);
        categoryRec.setAdapter(categoryAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    HomeHorModel category = dataSnapshot.getValue(HomeHorModel.class);
                    list.add(category);
                }
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //For product item
        prodList = new ArrayList<>();
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "45.000đ", R.drawable.makeup1));
        prodList.add(new HomeProductModel("On The Body Perfume Classic Pink", "500g", "130.000đ", R.drawable.body1));
        prodList.add(new HomeProductModel("Dove Damage Repair Shampoo", "640g", "160.000đ", R.drawable.hair1));
        prodList.add(new HomeProductModel("Biodermal Makeup Remover", "500ml", "300.000đ", R.drawable.skincare1));
        prodList.add(new HomeProductModel("VERSACE Eros EDT Perfume", "100ml", "2.500.000đ", R.drawable.perfume1));
        prodList.add(new HomeProductModel("MOSCHINO Toy 2 Perfume", "100ml", "2.400.000đ", R.drawable.perfume2));

        prodAdapter = new HomeProductAdapter(getActivity(), prodList);
        prodRec.setAdapter(prodAdapter);
        prodRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}