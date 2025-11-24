package com.example.foodreciepe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    Button fav1, fav2, fav3, fav4, details1, details2, details3, details4;
    EditText searchBar;
    View searchIcon;
    ImageButton menuToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // ✅ UI setup
        btn1 = findViewById(R.id.breakFast);
        btn2 = findViewById(R.id.lunch);
        btn3 = findViewById(R.id.dinner);

        fav1 = findViewById(R.id.fav1);
        fav2 = findViewById(R.id.fav2);
        fav3 = findViewById(R.id.fav3);
        fav4 = findViewById(R.id.fav4);

        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        details3 = findViewById(R.id.details3);
        details4 = findViewById(R.id.details4);

        searchBar = findViewById(R.id.searchBar);
        searchIcon = findViewById(R.id.searchIcon);
        menuToggle = findViewById(R.id.menuToggle);

        // ✅ Check login state
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        menuToggle.setVisibility(isLoggedIn ? View.VISIBLE : View.GONE);

        // ✅ Navigation buttons
        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, breakfast.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, lunch.class)));
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, dinner.class)));

        // ✅ Search function (fixed braces + combined breakfast/lunch/dinner)
        searchIcon.setOnClickListener(v -> {
            String query = searchBar.getText().toString().trim().toLowerCase();

            if (query.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a recipe name", Toast.LENGTH_SHORT).show();
                return;
            }

            // --------- Breakfast recipes ----------
            if (query.contains("poha")) {
                openRecipeDetails("Poha");
            } else if (query.contains("upma")) {
                openRecipeDetails("Upma");
            } else if (query.contains("idli")) {
                openRecipeDetails("Idli");
            } else if (query.contains("dosa")) {
                openRecipeDetails("Dosa");
            } else if (query.contains("paratha") || query.contains("parantha")) {
                openRecipeDetails("Paratha");
            } else if (query.contains("sandwich")) {
                openRecipeDetails("Vegetable Sandwich");
            } else if (query.contains("puri") || query.contains("aloo puri")) {
                openRecipeDetails("Aloo Puri");
            } else if (query.contains("dhokla")) {
                openRecipeDetails("Dhokla");
            } else if (query.contains("omelette") || query.contains("omelet") || query.contains("omlette")) {
                openRecipeDetails("Masala Omelette");

                // --------- Lunch & Dinner recipes ----------
            } else if (query.contains("paneer")) {
                openRecipeDetails("Paneer Butter Masala");
            } else if (query.contains("chole") || query.contains("bhature")) {
                openRecipeDetails("Chole Bhature");
            } else if (query.contains("pulao")) {
                openRecipeDetails("Veg Pulao");
            } else if (query.contains("dal")) {
                openRecipeDetails("Dal Makhani");

            } else {
                Toast.makeText(MainActivity.this, "Recipe not found!", Toast.LENGTH_SHORT).show();
            }
        });

        // ✅ Favourites
        fav1.setOnClickListener(v -> saveToFavourites("Paneer Butter Masala"));
        fav2.setOnClickListener(v -> saveToFavourites("Chole Bhature"));
        fav3.setOnClickListener(v -> saveToFavourites("Veg Pulao"));
        fav4.setOnClickListener(v -> saveToFavourites("Dal Makhani"));

        // ✅ Recipe Details buttons
        details1.setOnClickListener(v -> openRecipeDetails("Paneer Butter Masala"));
        details2.setOnClickListener(v -> openRecipeDetails("Chole Bhature"));
        details3.setOnClickListener(v -> openRecipeDetails("Veg Pulao"));
        details4.setOnClickListener(v -> openRecipeDetails("Dal Makhani"));

        // ✅ Menu toggle
        menuToggle.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
            popupMenu.getMenu().add("❤️ Favorite Recipes");
            popupMenu.getMenu().add("👤 Profile");
            popupMenu.getMenu().add("🚪 Logout");

            popupMenu.setOnMenuItemClickListener(item -> {
                String title = item.getTitle().toString();
                switch (title) {
                    case "❤️ Favorite Recipes":
                        startActivity(new Intent(MainActivity.this, favourite.class));
                        break;

                    case "👤 Profile":
                        startActivity(new Intent(MainActivity.this, profile.class));
                        break;

                    case "🚪 Logout":
                        logoutUser();
                        break;
                }
                return true;
            });
            popupMenu.show();
        });
    }

    // ✅ Save recipe to favourites
    private void saveToFavourites(String recipeName) {
        SharedPreferences prefs = getSharedPreferences("Favourites", MODE_PRIVATE);
        Set<String> favs = prefs.getStringSet("favList", new HashSet<>());
        Set<String> updatedFavs = new HashSet<>(favs);
        updatedFavs.add(recipeName);
        prefs.edit().putStringSet("favList", updatedFavs).apply();

        Toast.makeText(this, recipeName + " added to favourites ❤️", Toast.LENGTH_SHORT).show();

        SharedPreferences userPrefs = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isLoggedIn = userPrefs.getBoolean("isLoggedIn", false);
        if (!isLoggedIn) {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
        }
    }

    // ✅ Logout
    private void logoutUser() {
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        prefs.edit().putBoolean("isLoggedIn", false).apply();
        Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    // ✅ Open Recipe Details screen
    private void openRecipeDetails(String recipeName) {
        Intent intent = new Intent(MainActivity.this, recipe.class);
        intent.putExtra("recipeName", recipeName);
        startActivity(intent);
    }
}
