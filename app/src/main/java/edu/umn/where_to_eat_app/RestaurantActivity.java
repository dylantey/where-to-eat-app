package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

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

        boolean first = true;
        LinearLayout hScroll = findViewById(R.id.restaurantCuisine);
        for(Restaurants.type t : restaurant.getCuisine()) {
            TextView cuisine = new TextView(getApplicationContext());
            cuisine.setText(t.toString());
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
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
