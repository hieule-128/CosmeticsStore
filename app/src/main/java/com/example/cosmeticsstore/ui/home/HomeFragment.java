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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView categoryRec, prodRec;
    private List<HomeHorModel> list;
    private HomeHorAdapter categoryAdapter;
    private List<HomeProductModel> prodList;
    private HomeProductAdapter prodAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        categoryRec = root.findViewById(R.id.home_hor_recycler);
        prodRec = root.findViewById(R.id.home_product_recycler);
        //For category
        list = new ArrayList<>();
        list.add(new HomeHorModel(R.drawable.beauty, "Skincare"));
        list.add(new HomeHorModel(R.drawable.makeup, "Makeup"));
        list.add(new HomeHorModel(R.drawable.perfume, "Perfume"));
        list.add(new HomeHorModel(R.drawable.body, "Body"));
        list.add(new HomeHorModel(R.drawable.hair, "Hair"));

        categoryAdapter = new HomeHorAdapter(getActivity(), list);
        categoryRec.setAdapter(categoryAdapter);
        categoryRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false ));
        categoryRec.setHasFixedSize(true);
        categoryRec.setNestedScrollingEnabled(false);

        //For product item
        prodList = new ArrayList<>();
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.makeup1));
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.body1));
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.hair1));
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.skincare1));
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.perfume1));
        prodList.add(new HomeProductModel("Vaseline Original Healing Jelly", "49g", "65.000đ", R.drawable.perfume2));

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