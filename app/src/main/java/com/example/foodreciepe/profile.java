package com.example.foodreciepe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    TextView tvUsername, tvPhone;
    ImageView imgUser;
    Button btnLogout, btnEditProfile;
    ImageButton btnBackHomeProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        getWindow().getDecorView().setSystemUiVisibility(
                android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | android.view.View.SYSTEM_UI_FLAG_FULLSCREEN);

        // 🔗 Initialize UI elements
        tvUsername = findViewById(R.id.tvUsername);
        tvPhone = findViewById(R.id.tvPhone);
        imgUser = findViewById(R.id.imgUser);
        btnLogout = findViewById(R.id.btnLogout);
        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnBackHomeProfile = findViewById(R.id.btnBackHomeProfile);

        // 🧠 Load user data from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        String username = prefs.getString("name", "Guest User");  // ✅ match key
        String phone = prefs.getString("mobile", "Not Available"); // ✅ match key

        // 🧾 Display saved user data
        tvUsername.setText(username);
        tvPhone.setText(phone);

        // 🖼️ Set default image
        imgUser.setImageResource(R.drawable.user);

        // 🔙 Back Button → Go to Home Page
        btnBackHomeProfile.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // 🚪 Logout → Clear data & go to Login
        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(profile.this, Login.class);
            startActivity(intent);
            finish();
        });

        // ✏️ Edit Profile (optional)
        btnEditProfile.setOnClickListener(v -> {
            // startActivity(new Intent(profile.this, EditProfileActivity.class));
        });
    }
}
