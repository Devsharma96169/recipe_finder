package com.example.foodreciepe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class breakfast extends AppCompatActivity {

    Button fav1, fav2, fav3, fav4, fav5, fav6, fav7, fav8, fav9, fav10;
    Button details1, details2, details3, details4, details5, details6, details7, details8, details9, details10;
    ImageView back_Arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_breakfast);

        // immersive fullscreen
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // find views
        back_Arrow = findViewById(R.id.backArrow);
        fav1 = findViewById(R.id.fav1); fav2 = findViewById(R.id.fav2);
        fav3 = findViewById(R.id.fav3); fav4 = findViewById(R.id.fav4);
        fav5 = findViewById(R.id.fav5); fav6 = findViewById(R.id.fav6);
        fav7 = findViewById(R.id.fav7); fav8 = findViewById(R.id.fav8);
        fav9 = findViewById(R.id.fav9); fav10 = findViewById(R.id.fav10);

        details1 = findViewById(R.id.details1); details2 = findViewById(R.id.details2);
        details3 = findViewById(R.id.details3); details4 = findViewById(R.id.details4);
        details5 = findViewById(R.id.details5); details6 = findViewById(R.id.details6);
        details7 = findViewById(R.id.details7); details8 = findViewById(R.id.details8);
        details9 = findViewById(R.id.details9); details10 = findViewById(R.id.details10);

        // back button
        back_Arrow.setOnClickListener(v -> finish());

        // open recipe details
        details1.setOnClickListener(v -> openRecipe("Poha"));
        details2.setOnClickListener(v -> openRecipe("Upma"));
        details3.setOnClickListener(v -> openRecipe("Idli"));
        details4.setOnClickListener(v -> openRecipe("Dosa"));
        details5.setOnClickListener(v -> openRecipe("Paratha"));
        details6.setOnClickListener(v -> openRecipe("Vegetable Sandwich"));
        details7.setOnClickListener(v -> openRecipe("Chole Bhature"));
        details8.setOnClickListener(v -> openRecipe("Aloo Puri"));
        details9.setOnClickListener(v -> openRecipe("Dhokla"));
        details10.setOnClickListener(v -> openRecipe("Masala Omelette"));

        // add to favorites
        fav1.setOnClickListener(v -> addToFavorites("Poha"));
        fav2.setOnClickListener(v -> addToFavorites("Upma"));
        fav3.setOnClickListener(v -> addToFavorites("Idli"));
        fav4.setOnClickListener(v -> addToFavorites("Dosa"));
        fav5.setOnClickListener(v -> addToFavorites("Paratha"));
        fav6.setOnClickListener(v -> addToFavorites("Vegetable Sandwich"));
        fav7.setOnClickListener(v -> addToFavorites("Chole Bhature"));
        fav8.setOnClickListener(v -> addToFavorites("Aloo Puri"));
        fav9.setOnClickListener(v -> addToFavorites("Dhokla"));
        fav10.setOnClickListener(v -> addToFavorites("Masala Omelette"));
    }

    // open recipe details
    private void openRecipe(String recipeName) {
        Intent intent = new Intent(breakfast.this, recipe.class);
        intent.putExtra("recipeName", recipeName);
        startActivity(intent);
    }

    // ✅ Save favorite (fixed to match favourite.java)
    private void addToFavorites(String recipeName) {
        SharedPreferences prefsUser = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isLoggedIn = prefsUser.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            Toast.makeText(this, "Please login to add favorites ❤️", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(breakfast.this, Login.class));
            return;
        }

        // ✅ Use same SharedPreferences and format as favourite.java
        SharedPreferences prefs = getSharedPreferences("Favourites", MODE_PRIVATE);
        Set<String> favs = prefs.getStringSet("favList", new HashSet<>());

        Set<String> updatedFavs = new HashSet<>(favs);
        updatedFavs.add(recipeName);

        prefs.edit().putStringSet("favList", updatedFavs).apply();

        Toast.makeText(this, recipeName + " added to Favourites ❤️", Toast.LENGTH_SHORT).show();
    }
}
