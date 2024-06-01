package com.example.ezmailpresuniv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLoginUser, buttonLoginAdmin;
    TextView registerTextView;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.emailEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        buttonLoginUser = findViewById(R.id.buttonLoginUser);
        buttonLoginAdmin = findViewById(R.id.buttonLoginAdmin);
        registerTextView = findViewById(R.id.registerTextView);

        databaseHelper = new DatabaseHelper(this);

        buttonLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        buttonLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAdmin();
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean isValidUser = databaseHelper.checkUser(username, password);
            if (isValidUser) {
                Toast.makeText(LoginActivity.this, "User login successful", Toast.LENGTH_SHORT).show();
                // Redirect to regular user dashboard
                // Example:
                 Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                 startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loginAdmin() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean isAdmin = databaseHelper.checkAdmin(username, password);
            if (isAdmin) {
                Toast.makeText(LoginActivity.this, "Admin login successful", Toast.LENGTH_SHORT).show();
                // Redirect to admin dashboard
                // Example:
                Intent intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
