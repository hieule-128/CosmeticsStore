package com.example.cosmeticsstore.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cosmeticsstore.MainActivity;
import com.example.cosmeticsstore.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText usernameLogin, passwordLogin;
    Button loginButton;
    TextView toRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        loginButton = findViewById(R.id.signInButton);
        toRegistration = findViewById(R.id.toRegistration);

        loginButton.setOnClickListener(view -> {
            if (!validateUsername() | !validatePassword()){

            }
            else{
                checkUser();
            }
        });
        toRegistration.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    public Boolean validateUsername(){
        String value = usernameLogin.getText().toString();
        if(value.isEmpty()){
            usernameLogin.setError("Username cannot be empty!");
            return false;
        }
        else{
            usernameLogin.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String value = passwordLogin.getText().toString();
        if(value.isEmpty()){
            passwordLogin.setError("Password cannot be empty!");
            return false;
        }
        else{
            passwordLogin.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = usernameLogin.getText().toString().trim();
        String userPassword = passwordLogin.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query check = reference.orderByChild("username").equalTo(userUsername);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    usernameLogin.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userPassword)){
                        usernameLogin.setError(null);

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    }
                    else{
                        passwordLogin.setError("Invalid Credentials");
                        passwordLogin.requestFocus();
                    }
                }
                else{
                    usernameLogin.setError("User does not exist!");
                    usernameLogin.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}