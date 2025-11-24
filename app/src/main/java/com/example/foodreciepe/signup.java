package com.example.foodreciepe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class signup extends AppCompatActivity {

    EditText etName, etMobile, etPassword, etOtp;
    Button btnGenerateOtp, btnVerifyOtp, btnSignup;
    int generatedOtp = 0;
    boolean isOtpVerified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);


        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        etOtp = findViewById(R.id.etOtp);

        btnGenerateOtp = findViewById(R.id.btnGenerateOtp);
        btnVerifyOtp = findViewById(R.id.btnVerifyOtp);
        btnSignup = findViewById(R.id.btnSignup);

        // 🔹 Generate OTP
        btnGenerateOtp.setOnClickListener(v -> {
            String mobile = etMobile.getText().toString().trim();

            if (mobile.length() != 10) {
                Toast.makeText(this, "Enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
                return;
            }

            generatedOtp = new Random().nextInt(9000) + 1000;
            Toast.makeText(this, "OTP generated: " + generatedOtp + " (Demo)", Toast.LENGTH_LONG).show();
        });

        // 🔹 Verify OTP
        btnVerifyOtp.setOnClickListener(v -> {
            String enteredOtp = etOtp.getText().toString().trim();

            if (enteredOtp.isEmpty()) {
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                return;
            }

            if (String.valueOf(generatedOtp).equals(enteredOtp)) {
                isOtpVerified = true;
                Toast.makeText(this, "OTP Verified ✅", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect OTP ❌", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔹 Sign Up
        btnSignup.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (name.isEmpty() || mobile.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isOtpVerified) {
                Toast.makeText(this, "Please verify OTP first", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", name);
            editor.putString("mobile", mobile);
            editor.putString("password", password);
            editor.apply();

            Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(signup.this, Login.class));
            finish();
        });
    }
}
