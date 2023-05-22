package com.example.cosmeticsstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cosmeticsstore.activities.LoginActivity;
import com.example.cosmeticsstore.activities.RegistrationActivity;
import com.example.cosmeticsstore.ui.home.HomeFragment;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
    }
    public void home(View view){
        startActivity(new Intent(ProductDetailsActivity.this, HomeFragment.class));
    }
}