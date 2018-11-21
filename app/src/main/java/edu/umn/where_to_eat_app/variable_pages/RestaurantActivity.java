package edu.umn.where_to_eat_app.variable_pages;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.net.Uri;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.data.Users;

public class RestaurantActivity extends AppCompatActivity {

    private Restaurant restaurant = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

        setTitle("Restaurant Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int idx = extras.getInt("Index");
            restaurant = Restaurants.getRestaurantArrayList().get(idx);
        }

        // Populate info
        ((ImageView) findViewById(R.id.restaurantImage)).setImageResource(restaurant.getImgSrc());
        ((TextView) findViewById(R.id.restaurantName)).setText(restaurant.getName());
        ((TextView) findViewById(R.id.restaurantRating)).setText(Double.toString(restaurant.getRating()) + "★");
        ((TextView) findViewById(R.id.restaurantAddress)).setText(restaurant.getAddress());

        boolean first = true;
        LinearLayout hScroll = findViewById(R.id.restaurantCuisine);
        for(Restaurants.type t : restaurant.getCuisine()) {
            TextView cuisine = new TextView(getApplicationContext());
            cuisine.setText(t.toString().replace('_', ' '));
            cuisine.setBackgroundColor(Color.DKGRAY);
            cuisine.setTextColor(getResources().getColor(R.color.white));
            cuisine.setPadding(5, 2, 5, 2);

            Space space = new Space(getApplicationContext());
            space.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

            if(first) {
                first = false;
            } else {
                hScroll.addView(space);
            }
            hScroll.addView(cuisine);
        }

        Button favoriteButton = findViewById(R.id.favoriteButton);
        if(Users.getCurrentUserObject().getFavoriteRestaurants().contains(restaurant)) {
            favoriteButton.setBackgroundColor(Color.GRAY);
            favoriteButton.setText("Remove from favorites");
        }

        favoriteButton.setOnClickListener((e) -> {
            if(Users.getCurrentUserObject().getFavoriteRestaurants().contains(restaurant)) {
                Users.getCurrentUserObject().removeFavoriteRestaurant(restaurant.getName());
                favoriteButton.setBackgroundColor(getResources().getColor(R.color.darkRed));
                favoriteButton.setText("Add to favorites");
            } else {
                Users.getCurrentUserObject().addFavoriteRestaurant(restaurant.getName());
                favoriteButton.setBackgroundColor(Color.GRAY);
                favoriteButton.setText("Remove from favorites");
            }
        });

        Button mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener((e) -> {
            // Setting a google maps query suing the restaurant's address
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + restaurant.getName() +
                    " " + restaurant.getAddress());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                // Opening google maps externally pointing to the Google Maps App
                startActivity(mapIntent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
