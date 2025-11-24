package com.example.foodreciepe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnLogin, btnShowHide, btnSignup, btnLogout;
    boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);




        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnShowHide = findViewById(R.id.btnShowHide);
        btnSignup = findViewById(R.id.btnSignup);
        btnLogout = findViewById(R.id.btnLogout);

        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

        // 🔹 Auto-login if already logged in
        if (isLoggedIn) {
            Intent i = new Intent(Login.this, favourite.class);
            startActivity(i);
            finish();
            return;
        }

        // 👁 Password show/hide toggle
        btnShowHide.setOnClickListener(v -> {
            if (passwordVisible) {
                etPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                btnShowHide.setText("👁");
            } else {
                etPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                btnShowHide.setText("🙈");
            }
            passwordVisible = !passwordVisible;
            etPass.setSelection(etPass.getText().length());
        });

        // 🔹 Login Button
        btnLogin.setOnClickListener(v -> {
            String enteredUser = etUser.getText().toString().trim();
            String enteredPass = etPass.getText().toString().trim();

            if (enteredUser.isEmpty() || enteredPass.isEmpty()) {
                Toast.makeText(Login.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String savedMobile = prefs.getString("mobile", "");
            String savedPass = prefs.getString("password", "");

            if (enteredUser.equals(savedMobile) && enteredPass.equals(savedPass)) {
                // Save login state in cache
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                Toast.makeText(Login.this, "Login Successful ✅", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, favourite.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(Login.this, "Invalid credentials ❌", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔹 Signup Button
        btnSignup.setOnClickListener(v -> {
            Intent i = new Intent(Login.this, signup.class);
            startActivity(i);
        });

        // 🔹 Logout Button
        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();

            Toast.makeText(Login.this, "Logged out successfully 🚪", Toast.LENGTH_SHORT).show();

            // Refresh screen
            Intent i = new Intent(Login.this, Login.class);
            startActivity(i);
            finish();
        });

        // Hide Logout button when not logged in
        btnLogout.setVisibility(View.GONE);
    }
}
