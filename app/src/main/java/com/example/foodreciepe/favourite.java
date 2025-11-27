package com.example.foodreciepe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class favourite extends AppCompatActivity {
    ImageView back_Arrow;
    LinearLayout favContainer;
    ImageButton menuToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        back_Arrow = findViewById(R.id.btnBackHome);
        favContainer = findViewById(R.id.favContainer);
        menuToggle = findViewById(R.id.menuToggle);

        back_Arrow.setOnClickListener(v -> finish());

        // ✅ Show/hide menu based on login
        SharedPreferences prefsUser = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isLoggedIn = prefsUser.getBoolean("isLoggedIn", false);
        menuToggle.setVisibility(isLoggedIn ? View.VISIBLE : View.GONE);

        // ✅ Menu toggle setup
        menuToggle.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(favourite.this, v);
            popupMenu.getMenu().add("❤️ Favorite Recipes");
            popupMenu.getMenu().add("👤 Profile");
            popupMenu.getMenu().add("🚪 Logout");

            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getTitle().toString()) {
                    case "❤️ Favorite Recipes":
                        Toast.makeText(this, "Already on Favourites ❤️", Toast.LENGTH_SHORT).show();
                        break;
                    case "👤 Profile":
                        startActivity(new Intent(this, profile.class));
                        break;
                    case "🚪 Logout":
                        logoutUser();
                        break;
                }
                return true;
            });
            popupMenu.show();
        });

        // ✅ Load favourites
        loadFavourites();
    }

    private void loadFavourites() {
        favContainer.removeAllViews();

        SharedPreferences prefs = getSharedPreferences("Favourites", MODE_PRIVATE);
        Set<String> favs = prefs.getStringSet("favList", null);

        if (favs != null && !favs.isEmpty()) {
            LayoutInflater inflater = LayoutInflater.from(this);

            for (String recipe : favs) {
                View card = inflater.inflate(R.layout.fav_card_item, favContainer, false);
                ImageView image = card.findViewById(R.id.favImage);
                TextView name = card.findViewById(R.id.favName);

                name.setText(recipe);

                // ✅ Set correct image for each recipe
                if (recipe.contains("Poha")) image.setImageResource(R.drawable.poha);
                else if (recipe.contains("Upma")) image.setImageResource(R.drawable.upma);
                else if (recipe.contains("Idli")) image.setImageResource(R.drawable.idli);
                else if (recipe.contains("Dosa")) image.setImageResource(R.drawable.dosa);
                else if (recipe.contains("Paratha")) image.setImageResource(R.drawable.pratha);
                else if (recipe.contains("Vegetable Sandwich")) image.setImageResource(R.drawable.sandwich);
                else if (recipe.contains("Chole Bhature")) image.setImageResource(R.drawable.chhole);
                else if (recipe.contains("Aloo Puri")) image.setImageResource(R.drawable.puri);
                else if (recipe.contains("Dhokla")) image.setImageResource(R.drawable.dhokla);
                else if (recipe.contains("Masala Omelette")) image.setImageResource(R.drawable.omlette);
                else if (recipe.contains("Paneer")) image.setImageResource(R.drawable.paneer);
                else if (recipe.contains("Pulao")) image.setImageResource(R.drawable.pulao);
                else if (recipe.contains("Dal")) image.setImageResource(R.drawable.makhani);
                else if (recipe.contains("Curry")) image.setImageResource(R.drawable.cc);
                else if (recipe.contains("Jeera Rice")) image.setImageResource(R.drawable.jeera);
                else if (recipe.contains("Chicken")) image.setImageResource(R.drawable.chicken);
                else if (recipe.contains("Biryani")) image.setImageResource(R.drawable.veg);





                else image.setImageResource(R.drawable.ic_launcher_background);

                // ✅ Click to open full recipe
                card.setOnClickListener(v -> {
                    Intent intent = new Intent(favourite.this, recipe.class);
                    intent.putExtra("recipeName", recipe);
                    startActivity(intent);
                });

                favContainer.addView(card);
            }
        } else {
            TextView empty = new TextView(this);
            empty.setText("No favourites yet! ❤️");
            empty.setTextSize(18);
            empty.setTextColor(getResources().getColor(android.R.color.darker_gray));
            favContainer.addView(empty);
        }
    }

    private void logoutUser() {
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        prefs.edit().putBoolean("isLoggedIn", false).apply();
        Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
