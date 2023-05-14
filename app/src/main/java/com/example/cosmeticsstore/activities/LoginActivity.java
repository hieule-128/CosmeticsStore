package com.example.cosmeticsstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cosmeticsstore.MainActivity;
import com.example.cosmeticsstore.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void register(View view){
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
    public void mainActivity(View view){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}