package edu.umn.where_to_eat_app.voting_screens;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Restaurants;

public class RestaurantFiltering extends AppCompatActivity{

    private int price = -1;
    private int rating = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_filtering);

        setTitle("Select Filter Criteria");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
                for(Button b : filterPrice) {
                    b.setBackgroundColor(getResources().getColor(R.color.lightGray));
                    b.setTextColor(getResources().getColor(R.color.black));
                }
                if(price == index + 1) {
                    price = -1;
                    filterPrice[index].setBackgroundColor(getResources().getColor(R.color.lightGray));
                    filterPrice[index].setTextColor(getResources().getColor(R.color.black));
                } else {
                    price = index + 1;
                    filterPrice[index].setBackgroundColor(getResources().getColor(R.color.darkRed));
                    filterPrice[index].setTextColor(getResources().getColor(R.color.white));
                }
            });
        }

        for(int i = 0; i < 5; i++) {
            final int index = i;
            filterRating[i].setOnClickListener((e) -> {
                for(Button b : filterRating) {
                    b.setBackgroundColor(getResources().getColor(R.color.lightGray));
                    b.setTextColor(getResources().getColor(R.color.black));
                }
                if(rating == index + 1) {
                    rating = -1;
                    filterRating[index].setBackgroundColor(getResources().getColor(R.color.lightGray));
                    filterRating[index].setTextColor(getResources().getColor(R.color.black));
                } else {
                    rating = index + 1;
                    filterRating[index].setBackgroundColor(getResources().getColor(R.color.darkRed));
                    filterRating[index].setTextColor(getResources().getColor(R.color.white));
                }
            });
        }

        submitButton.setOnClickListener((e) -> {


            String distString = filterDistance.getText().toString();
            double distance = -1;
            if(!distString.equals("")) {
                distance = Double.parseDouble(filterDistance.getText().toString());
            }

            String cuisine = String.valueOf(filterSpinner.getSelectedItem()).toUpperCase().replace(' ', '_');
            if(!cuisine.equals("---")) {
                Restaurants.type cuisineEnum = Restaurants.type.valueOf(cuisine);
                Restaurants.filter(distance, rating, price, cuisineEnum);
            } else {
                Restaurants.filter(distance, rating, price);
            }
            if(Restaurants.getFilteredRestaurants().size() == 0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("No results found!\nTry to widen search criteria.");
                alertDialogBuilder.create().show();
            } else {
                startActivity(new Intent(RestaurantFiltering.this, InformationPage.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
