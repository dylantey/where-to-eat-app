package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RestaurantFiltering extends AppCompatActivity{

    private int price = -1;
    private int rating = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Spinner filterSpinner = findViewById(R.id.filterSpinner);
        Button[] filterPrice = new Button[] {
                findViewById(R.id.filterMoney1),
                findViewById(R.id.filterMoney2),
                findViewById(R.id.filterMoney3),
                findViewById(R.id.filterMoney4)
        };
        Button[] filterRating = new Button[] {
                findViewById(R.id.filterRating1),
                findViewById(R.id.filterRating2),
                findViewById(R.id.filterRating3),
                findViewById(R.id.filterRating4),
                findViewById(R.id.filterRating5)
        };
        EditText filterDistance = findViewById(R.id.filterDistance);
        Button submitButton = findViewById(R.id.filterButton);

        for(int i = 0; i < 4; i++) {
            final int index = i;
            filterPrice[i].setOnClickListener((e) -> {
                if(price == index + 1) {
                    price = -1;
                    filterPrice[index].setBackgroundResource(android.R.drawable.btn_default);
                    filterRating[index].setTextColor(getResources().getColor(R.color.black));
                } else {
                    price = index + 1;
                    filterRating[index].setBackgroundColor(getResources().getColor(R.color.darkRed));
                    filterRating[index].setTextColor(getResources().getColor(R.color.white));
                }
            });
        }

        for(int i = 0; i < 5; i++) {
            final int index = i;
            filterRating[i].setOnClickListener((e) -> {
                if(rating == index + 1) {
                    rating = -1;
                    filterRating[index].setBackgroundResource(android.R.drawable.btn_default);
                    filterRating[index].setTextColor(getResources().getColor(R.color.black));
                } else {
                    price = index + 1;
                    filterRating[index].setBackgroundColor(getResources().getColor(R.color.darkRed));
                    filterRating[index].setTextColor(getResources().getColor(R.color.white));
                }
            });
        }

        submitButton.setOnClickListener((e) -> {


            String cuisine = String.valueOf(filterSpinner.getSelectedItem()).toUpperCase().replace(' ', '_');
            Restaurants.type cuisineEnum = Restaurants.type.valueOf(cuisine);
            double distance = Double.parseDouble(filterDistance.getText().toString());

            Restaurants.filter(distance, rating, price, cuisineEnum);

            startActivity(new Intent(RestaurantFiltering.this, InformationPage.class));
        });
    }
}
