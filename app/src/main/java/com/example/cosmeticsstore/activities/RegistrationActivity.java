package com.example.cosmeticsstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cosmeticsstore.HelperClass;
import com.example.cosmeticsstore.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    EditText registerName, registerEmail, registerUsername, registerPassword;
    Button registerButton;
    TextView toSignIn;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerName = findViewById(R.id.fullNameRegistration);
        registerEmail = findViewById(R.id.emailRegistration);
        registerUsername = findViewById(R.id.usernameRegistration);
        registerPassword = findViewById(R.id.passwordRegistration);
        registerButton = findViewById(R.id.registerButton);
        toSignIn = findViewById(R.id.toSignIn);

        registerButton.setOnClickListener(view -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
            String name = registerName.getText().toString();
            String email = registerEmail.getText().toString();
            String username = registerUsername.getText().toString();
            String password = registerPassword.getText().toString();
            HelperClass helperClass = new HelperClass(name, email, username, password);
            reference.child(username).setValue(helperClass);

            Toast.makeText(RegistrationActivity.this, "You have registered successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        toSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}