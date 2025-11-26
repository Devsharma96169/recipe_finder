package com.example.foodreciepe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dinner extends AppCompatActivity {

    ImageView back_Arrow;

    Button fav1, fav2, fav3, fav4, fav5, fav6, fav7, fav8, fav9, fav10;
    Button details1, details2, details3, details4, details5, details6, details7, details8, details9, details10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dinner);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        back_Arrow = findViewById(R.id.backArrow);
        back_Arrow.setOnClickListener(v -> finish());

        // Initialize favorite buttons
        fav1 = findViewById(R.id.fav1);
        fav2 = findViewById(R.id.fav2);
        fav3 = findViewById(R.id.fav3);
        fav4 = findViewById(R.id.fav4);
        fav5 = findViewById(R.id.fav5);
        fav6 = findViewById(R.id.fav6);
        fav7 = findViewById(R.id.fav7);
        fav8 = findViewById(R.id.fav8);
        fav9 = findViewById(R.id.fav9);
        fav10 = findViewById(R.id.fav10);

        // Initialize details buttons
        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        details3 = findViewById(R.id.details3);
        details4 = findViewById(R.id.details4);
        details5 = findViewById(R.id.details5);
        details6 = findViewById(R.id.details6);
        details7 = findViewById(R.id.details7);
        details8 = findViewById(R.id.details8);
        details9 = findViewById(R.id.details9);
        details10 = findViewById(R.id.details10);

        // Set click listeners for detail buttons
        details1.setOnClickListener(v -> openRecipe("Paneer Butter Masala"));
        details2.setOnClickListener(v -> openRecipe("Dal Tadka"));
        details3.setOnClickListener(v -> openRecipe("Veg Biryani"));
        details4.setOnClickListener(v -> openRecipe("Butter Chicken"));
        details7.setOnClickListener(v -> openRecipe("Rajma Chawal"));
        details9.setOnClickListener(v -> openRecipe("Veg Pulao"));
    }

    // This method must be outside onCreate()
    private void openRecipe(String recipeName) {
        Intent intent = new Intent(dinner.this, recipe.class);
        intent.putExtra("recipeName", recipeName);
        startActivity(intent);
    }
}
