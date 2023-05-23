package com.example.cosmeticsstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cosmeticsstore.activities.LoginActivity;
import com.example.cosmeticsstore.activities.RegistrationActivity;
import com.example.cosmeticsstore.ui.MyCartFragment;
import com.example.cosmeticsstore.ui.home.HomeFragment;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetailsActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}