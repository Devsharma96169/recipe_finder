package com.example.foodreciepe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class recipe extends AppCompatActivity {

    TextView title, ingredients, steps, makingSteps;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Link UI components
        title = findViewById(R.id.recipeTitle);
        ingredients = findViewById(R.id.ingredients);
        steps = findViewById(R.id.steps);
        makingSteps = findViewById(R.id.makingSteps);
        recipeImage = findViewById(R.id.recipeImage);

        String recipeName = getIntent().getStringExtra("recipeName");
        if (recipeName != null) {
            loadRecipeDetails(recipeName);
        }
    }

    private void loadRecipeDetails(String recipeName) {
        switch (recipeName) {

            case "Paneer Butter Masala":
                title.setText("Paneer Butter Masala");
                recipeImage.setImageResource(R.drawable.paneer);
                ingredients.setText("• Paneer (200g)\n• Tomato (3)\n• Butter (2 tbsp)\n• Cream (2 tbsp)\n• Spices (garam masala, salt, chili powder)");
                steps.setText("1. Fry paneer cubes lightly.\n2. Prepare tomato-onion gravy.\n3. Add butter, cream, and spices.\n4. Mix paneer and simmer for 5 minutes.");
                makingSteps.setText("1️⃣ Heat butter in a pan.\n2️⃣ Add chopped onions and sauté until golden.\n3️⃣ Add tomato puree, salt, and spices. Cook until oil separates.\n4️⃣ Add cream and a little water to adjust consistency.\n5️⃣ Finally, add fried paneer cubes and simmer for 5–7 mins.\n6️⃣ Serve hot with naan or jeera rice.");
                break;

            case "Chhole Bhature":
                title.setText("Chhole Bhature");
                recipeImage.setImageResource(R.drawable.chhole);
                ingredients.setText("• Boiled chickpeas (2 cups)\n• Onion, tomato, ginger-garlic paste\n• Spices (chole masala, turmeric, chili)\n• Flour & curd for bhature dough");
                steps.setText("1. Make spicy chole gravy.\n2. Knead dough for bhature.\n3. Fry bhature until golden.\n4. Serve together with pickle.");
                makingSteps.setText("1️⃣ Soak chickpeas overnight and boil them until soft.\n2️⃣ In a pan, heat oil and add onion-tomato paste with spices.\n3️⃣ Add boiled chickpeas and simmer for 10–15 mins.\n4️⃣ For bhature, knead dough with flour, curd, and salt; rest for 2 hours.\n5️⃣ Roll and deep fry until puffed and golden.\n6️⃣ Serve hot with onion salad and pickle.");
                break;

            case "Veg Pulao":
                title.setText("Veg Pulao");
                recipeImage.setImageResource(R.drawable.pulao);
                ingredients.setText("• Basmati rice (1 cup)\n• Mixed vegetables (1 cup)\n• Ghee or oil (2 tbsp)\n• Whole spices (bay leaf, cloves, cinnamon)");
                steps.setText("1. Fry vegetables.\n2. Add rice and water.\n3. Cook for 15 minutes.\n4. Serve hot with raita.");
                makingSteps.setText("1️⃣ Wash and soak rice for 20 mins.\n2️⃣ Heat ghee in a pan, add whole spices and let them crackle.\n3️⃣ Add chopped vegetables and sauté for 3–4 mins.\n4️⃣ Add soaked rice and salt, mix well.\n5️⃣ Pour 2 cups of water, cover and cook until rice is done.\n6️⃣ Fluff with a fork and serve warm.");
                break;

            case "Dal Makhani":
                title.setText("Dal Makhani");
                recipeImage.setImageResource(R.drawable.dal);
                ingredients.setText("• Whole black urad dal (1 cup)\n• Kidney beans (¼ cup)\n• Butter (3 tbsp)\n• Tomato puree (1 cup)\n• Fresh cream (2 tbsp)");
                steps.setText("1. Soak dal overnight.\n2. Pressure cook until soft.\n3. Make tomato gravy.\n4. Mix dal, butter, and cream; simmer and serve.");
                makingSteps.setText("1️⃣ Soak dal and rajma overnight.\n2️⃣ Pressure cook with salt until soft.\n3️⃣ In a pan, heat butter and sauté ginger-garlic paste.\n4️⃣ Add tomato puree, chili, and garam masala; cook until thick.\n5️⃣ Mix dal and simmer for 20 minutes on low flame.\n6️⃣ Add cream before serving for a rich flavor.");
                break;

                case "Poha":
                    title.setText("Poha");
                    recipeImage.setImageResource(R.drawable.poha);
                    ingredients.setText("• Flattened rice (poha)\n• Onion\n• Mustard seeds\n• Peanuts\n• Curry leaves\n• Turmeric\n• Lemon juice");
                    steps.setText("1. Wash and drain poha.\n2. Fry peanuts and mustard seeds.\n3. Add onions and spices.\n4. Mix poha and cook for a few minutes.");
                    makingSteps.setText("1️⃣ Rinse poha in water and drain well.\n2️⃣ Heat oil in a pan, add mustard seeds and let them splutter.\n3️⃣ Add curry leaves, peanuts, and onions. Sauté until onions turn soft.\n4️⃣ Add turmeric and salt; mix well.\n5️⃣ Add poha and stir gently until evenly coated.\n6️⃣ Sprinkle lemon juice and garnish with coriander before serving.");
                    break;

                case "Upma":
                    title.setText("Upma");
                    recipeImage.setImageResource(R.drawable.upma);
                    ingredients.setText("• Semolina (rava)\n• Onion, green chili\n• Curry leaves\n• Mustard seeds\n• Ghee or oil\n• Water, salt");
                    steps.setText("1. Roast rava.\n2. Prepare tempering.\n3. Add veggies, water, and salt.\n4. Cook and mix until thick.");
                    makingSteps.setText("1️⃣ Dry roast semolina in a pan until aromatic.\n2️⃣ Heat ghee or oil; add mustard seeds, curry leaves, and chopped green chili.\n3️⃣ Add onions and sauté until translucent.\n4️⃣ Pour water and salt; bring to a boil.\n5️⃣ Slowly add roasted rava while stirring to avoid lumps.\n6️⃣ Cook for 2–3 minutes until soft and serve hot with chutney.");
                    break;

                case "Idli":
                    title.setText("Idli");
                    recipeImage.setImageResource(R.drawable.idli);
                    ingredients.setText("• Idli rice\n• Urad dal\n• Salt\n• Water");
                    steps.setText("1. Soak dal and rice.\n2. Grind and ferment.\n3. Pour batter in mould.\n4. Steam until soft.");
                    makingSteps.setText("1️⃣ Soak rice and urad dal separately for 4–5 hours.\n2️⃣ Grind both into a smooth batter; mix with salt.\n3️⃣ Cover and ferment overnight.\n4️⃣ Pour batter into greased idli moulds.\n5️⃣ Steam for 10–12 minutes.\n6️⃣ Serve hot with coconut chutney and sambar.");
                    break;

                case "Dosa":
                    title.setText("Dosa");
                    recipeImage.setImageResource(R.drawable.dosa);
                    ingredients.setText("• Dosa rice\n• Urad dal\n• Fenugreek seeds\n• Salt\n• Oil");
                    steps.setText("1. Prepare fermented batter.\n2. Pour and spread thinly.\n3. Cook until crisp.\n4. Serve with chutney.");
                    makingSteps.setText("1️⃣ Soak dosa rice, urad dal, and fenugreek seeds for 5 hours.\n2️⃣ Grind to a smooth paste and ferment overnight.\n3️⃣ Heat tawa and grease lightly with oil.\n4️⃣ Pour a ladle of batter, spread circularly.\n5️⃣ Drizzle oil, cook until edges are crisp.\n6️⃣ Fold and serve with chutney or sambar.");
                    break;

                case "Paratha":
                    title.setText("Paratha");
                    recipeImage.setImageResource(R.drawable.pratha);
                    ingredients.setText("• Wheat flour\n• Stuffing (potato/paneer)\n• Salt\n• Oil or ghee");
                    steps.setText("1. Prepare dough.\n2. Add stuffing.\n3. Roll and cook on tawa.");
                    makingSteps.setText("1️⃣ Mix wheat flour, salt, and water to form soft dough.\n2️⃣ Prepare stuffing (mashed potato/paneer with spices).\n3️⃣ Roll a small dough ball, fill stuffing, seal and flatten.\n4️⃣ Cook on hot tawa using ghee until golden brown on both sides.\n5️⃣ Serve hot with curd or pickle.");
                    break;

                case "Vegetable Sandwich":
                    title.setText("Vegetable Sandwich");
                    recipeImage.setImageResource(R.drawable.sandwich);
                    ingredients.setText("• Bread slices\n• Butter\n• Veggies (cucumber, tomato, onion)\n• Chutney or mayonnaise");
                    steps.setText("1. Spread butter & chutney.\n2. Layer veggies.\n3. Grill or toast.");
                    makingSteps.setText("1️⃣ Apply butter and chutney evenly on bread slices.\n2️⃣ Layer with cucumber, tomato, and onion slices.\n3️⃣ Cover with another slice of bread.\n4️⃣ Toast or grill until golden brown.\n5️⃣ Serve with ketchup or green chutney.");
                    break;

                case "Chole Bhature":
                    title.setText("Chole Bhature");
                    recipeImage.setImageResource(R.drawable.chhole);
                    ingredients.setText("• Chickpeas\n• Onion-tomato masala\n• Spices (chole masala)\n• Flour for bhature");
                    steps.setText("1. Make spicy chole gravy.\n2. Prepare dough.\n3. Fry bhature & serve.");
                    makingSteps.setText("1️⃣ Soak chickpeas overnight and boil until soft.\n2️⃣ Heat oil, add onion-tomato paste and spices.\n3️⃣ Mix chickpeas and simmer for 10–15 mins.\n4️⃣ For bhature, knead dough with flour, curd, and salt; rest 2 hours.\n5️⃣ Roll and deep fry until puffed.\n6️⃣ Serve hot with pickle and onion rings.");
                    break;

                case "Aloo Puri":
                    title.setText("Aloo Puri");
                    recipeImage.setImageResource(R.drawable.puri);
                    ingredients.setText("• Wheat flour\n• Potatoes\n• Spices (turmeric, chili, cumin)");
                    steps.setText("1. Prepare aloo curry.\n2. Make puri dough.\n3. Roll and fry puris.");
                    makingSteps.setText("1️⃣ Boil and mash potatoes; cook with turmeric, chili, and cumin.\n2️⃣ Knead wheat flour with salt and water.\n3️⃣ Roll into small discs and deep fry until golden brown.\n4️⃣ Serve with spicy aloo sabzi.");
                    break;

                case "Dhokla":
                    title.setText("Dhokla");
                    recipeImage.setImageResource(R.drawable.dhokla);
                    ingredients.setText("• Gram flour\n• Yogurt\n• Eno or baking soda\n• Mustard seeds, curry leaves");
                    steps.setText("1. Make batter.\n2. Add Eno.\n3. Steam and temper.");
                    makingSteps.setText("1️⃣ Mix besan, yogurt, salt, and water into a smooth batter.\n2️⃣ Add Eno just before steaming; mix well.\n3️⃣ Pour into greased plate and steam for 15 minutes.\n4️⃣ Heat oil, add mustard seeds and curry leaves, and pour over dhokla.\n5️⃣ Cut into squares and serve.");
                    break;

                case "Masala Omelette":
                    title.setText("Masala Omelette");
                    recipeImage.setImageResource(R.drawable.omlette);
                    ingredients.setText("• Eggs\n• Onion, tomato, green chili\n• Salt, pepper\n• Butter or oil");
                    steps.setText("1. Beat eggs with veggies.\n2. Cook on pan.\n3. Serve hot.");
                    makingSteps.setText("1️⃣ Beat eggs with chopped onion, tomato, and green chili.\n2️⃣ Add salt, pepper, and a pinch of chili powder.\n3️⃣ Heat butter or oil in a pan and pour mixture.\n4️⃣ Cook both sides until golden.\n5️⃣ Serve hot with toast or tea.");
                    break;

            // 8. Aloo Gobi
            case "Aloo Gobi":
                title.setText("Aloo Gobi");
                recipeImage.setImageResource(R.drawable.gobi);
                ingredients.setText("• Potatoes\n• Cauliflower\n• Onion, tomato, ginger-garlic paste\n• Turmeric, chili powder, garam masala\n• Oil, salt, coriander leaves");
                steps.setText("1. Fry potatoes and cauliflower.\n2. Add spices and tomatoes.\n3. Cook until soft and flavorful.");
                makingSteps.setText("1️⃣ Heat oil and sauté onion, ginger-garlic paste, and tomatoes.\n2️⃣ Add spices and mix well.\n3️⃣ Add potatoes and cauliflower.\n4️⃣ Cover and cook till tender.\n5️⃣ Garnish with coriander and serve hot.");
                break;

// 9. Kadai Paneer
            case "Kadai Paneer":
                title.setText("Kadai Paneer");
                recipeImage.setImageResource(R.drawable.kadai);
                ingredients.setText("• Paneer cubes\n• Capsicum, onion, tomato\n• Kadai masala, chili powder, garam masala\n• Oil, salt, cream");
                steps.setText("1. Sauté onions and capsicum.\n2. Add spices and tomatoes.\n3. Mix paneer and simmer.");
                makingSteps.setText("1️⃣ Heat oil and sauté onion and capsicum.\n2️⃣ Add tomatoes and cook until soft.\n3️⃣ Mix in kadai masala and other spices.\n4️⃣ Add paneer cubes and cook for 5–7 mins.\n5️⃣ Garnish with cream and coriander before serving.");
                break;

// Veg Biryani
            case "Veg Biryani":
                title.setText("Veg Biryani");
                recipeImage.setImageResource(R.drawable.veg);
                ingredients.setText("• Basmati rice\n• Mixed vegetables\n• Yogurt, fried onions, mint\n• Biryani masala, saffron, ghee");
                steps.setText("1. Cook rice partially.\n2. Layer veggies and rice.\n3. Steam until fragrant.");
                makingSteps.setText("1️⃣ Sauté vegetables with spices and yogurt.\n2️⃣ Parboil basmati rice.\n3️⃣ In a pot, layer rice and vegetable mixture.\n4️⃣ Add saffron milk and fried onions.\n5️⃣ Cover and steam for 15–20 mins.\n6️⃣ Serve hot with raita.");
                break;

// Veg Korma
            case "Veg Korma":
                title.setText("Veg Korma");
                recipeImage.setImageResource(R.drawable.korma);
                ingredients.setText("• Mixed vegetables\n• Cashew paste, yogurt, cream\n• Onion, tomato, ginger-garlic paste\n• Garam masala, turmeric, salt");
                steps.setText("1. Make creamy masala.\n2. Add boiled vegetables.\n3. Cook till thick and rich.");
                makingSteps.setText("1️⃣ Blend cashews, yogurt, and spices into a paste.\n2️⃣ Sauté onion, tomato, and ginger-garlic paste.\n3️⃣ Add the cashew mix and cook till oil separates.\n4️⃣ Add boiled vegetables and simmer.\n5️⃣ Finish with cream and serve with naan or rice.");
                break;

// Rajma Chawal
            case "Rajma Chawal":
                title.setText("Rajma Chawal");
                recipeImage.setImageResource(R.drawable.rajma);
                ingredients.setText("• Kidney beans (rajma)\n• Onion, tomato, ginger-garlic paste\n• Garam masala, chili powder, turmeric\n• Cooked rice, oil, salt");
                steps.setText("1. Boil rajma.\n2. Cook with masala.\n3. Serve with steamed rice.");
                makingSteps.setText("1️⃣ Soak rajma overnight and pressure cook till soft.\n2️⃣ Sauté onion, tomato, and ginger-garlic paste in oil.\n3️⃣ Add spices and cooked rajma.\n4️⃣ Simmer for 10–15 mins.\n5️⃣ Serve hot with steamed rice.");
                break;

// Dal Tadka
            case "Dal Tadka":
                title.setText("Dal Tadka");
                recipeImage.setImageResource(R.drawable.dal);
                ingredients.setText("• Toor dal (split pigeon peas)\n• Onion, tomato, garlic\n• Cumin, mustard seeds, ghee, turmeric\n• Coriander leaves, salt");
                steps.setText("1. Boil dal.\n2. Prepare tadka.\n3. Mix and serve hot.");
                makingSteps.setText("1️⃣ Pressure cook dal with turmeric and salt.\n2️⃣ In ghee, add cumin, mustard seeds, and garlic.\n3️⃣ Pour this tadka over the cooked dal.\n4️⃣ Mix well and simmer for a few minutes.\n5️⃣ Garnish with coriander and serve with rice or roti.");
                break;

            case "Chicken Curry":
                title.setText("Chicken Curry");
                recipeImage.setImageResource(R.drawable.cc);
                ingredients.setText("• Chicken (500g)\n• Onions (2, finely chopped)\n• Tomatoes (2, pureed)\n• Ginger-garlic paste (2 tbsp)\n• Curd/Yogurt (½ cup)\n• Turmeric powder (½ tsp)\n• Red chili powder (1 tsp)\n• Coriander powder (1 tbsp)\n• Garam masala (1 tsp)\n• Oil (3 tbsp)\n• Fresh coriander (for garnish)");
                steps.setText("1. Marinate chicken.\n2. Fry onions and spices.\n3. Add chicken and cook.\n4. Add tomatoes and curd.\n5. Simmer until chicken is tender.");
                makingSteps.setText(
                        "1️⃣ Marinate chicken with curd, turmeric, chili powder, and salt; keep for 20 minutes.\n" +
                                "2️⃣ Heat oil and sauté chopped onions until golden brown.\n" +
                                "3️⃣ Add ginger-garlic paste and cook until raw smell goes.\n" +
                                "4️⃣ Mix coriander powder and cook for 1–2 minutes.\n" +
                                "5️⃣ Add chicken pieces and fry until they change color.\n" +
                                "6️⃣ Add tomato puree and cook until oil separates.\n" +
                                "7️⃣ Pour 1 cup water, cover, and cook for 20–25 minutes.\n" +
                                "8️⃣ Sprinkle garam masala and garnish with fresh coriander before serving."
                );
                break;
            case "Jeera Rice":
                title.setText("Jeera Rice");
                recipeImage.setImageResource(R.drawable.jeera);
                ingredients.setText("• Basmati rice (1 cup)\n• Cumin seeds / Jeera (1 tbsp)\n• Ghee (1–2 tbsp)\n• Bay leaf (1)\n• Cloves (2)\n• Cinnamon (1 small piece)\n• Water (2 cups)\n• Salt to taste\n• Fresh coriander (optional)");
                steps.setText("1. Wash rice.\n2. Sauté jeera.\n3. Add rice & spices.\n4. Add water.\n5. Cook until fluffy.");
                makingSteps.setText(
                        "1️⃣ Wash basmati rice 2–3 times and soak for 15–20 minutes.\n" +
                                "2️⃣ Heat ghee in a pan and add cumin seeds; let them crackle.\n" +
                                "3️⃣ Add bay leaf, cloves, and cinnamon; sauté for a few seconds.\n" +
                                "4️⃣ Add soaked rice and gently fry for 1–2 minutes.\n" +
                                "5️⃣ Add 2 cups water and salt; mix lightly.\n" +
                                "6️⃣ Cover and cook on low flame until rice becomes soft and fluffy.\n" +
                                "7️⃣ Garnish with fresh coriander and serve hot."
                );
                break;

            case "Mix Veg Curry":
                title.setText("Mix Veg Curry");
                recipeImage.setImageResource(R.drawable.curry);
                ingredients.setText(
                        "• Carrot (½ cup, chopped)\n" +
                                "• Green peas (½ cup)\n" +
                                "• Beans (½ cup, chopped)\n" +
                                "• Cauliflower (½ cup, florets)\n" +
                                "• Potato (1, diced)\n" +
                                "• Onion (1, finely chopped)\n" +
                                "• Tomato puree (1 cup)\n" +
                                "• Ginger-garlic paste (1 tbsp)\n" +
                                "• Turmeric powder (½ tsp)\n" +
                                "• Red chili powder (1 tsp)\n" +
                                "• Coriander powder (1 tbsp)\n" +
                                "• Garam masala (½ tsp)\n" +
                                "• Cream or milk (2 tbsp)\n" +
                                "• Oil (2 tbsp)\n" +
                                "• Salt to taste"
                );

                steps.setText("1. Chop vegetables.\n2. Sauté onions & spices.\n3. Add veggies.\n4. Add tomato gravy.\n5. Cook until vegetables soften.");

                makingSteps.setText(
                        "1️⃣ Chop all vegetables (carrot, beans, peas, cauliflower, potato).\n" +
                                "2️⃣ Heat oil in a pan and sauté chopped onions until golden brown.\n" +
                                "3️⃣ Add ginger-garlic paste and cook for a minute.\n" +
                                "4️⃣ Add turmeric, chili powder, and coriander powder; mix well.\n" +
                                "5️⃣ Pour in tomato puree and cook until oil separates.\n" +
                                "6️⃣ Add all vegetables and mix with the masala.\n" +
                                "7️⃣ Add 1 cup water and salt; cover and cook for 12–15 minutes.\n" +
                                "8️⃣ When vegetables turn soft, add cream or milk for richness.\n" +
                                "9️⃣ Sprinkle garam masala and cook for 2 more minutes.\n" +
                                "🔟 Serve hot with roti, naan, or rice."
                );
                break;





        }

        }
    }

