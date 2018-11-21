package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.main_screen.MainActivity;

public class VotingResults extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_results);

        // Get extra
        int[] weights = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            weights = extras.getIntArray("Votes");
        }
        int maxVotes = Integer.MIN_VALUE;
        for(int i : weights) {
            if(i > maxVotes) {
                maxVotes = i;
            }
        }
        ArrayList<Restaurant> winningRestaurants = new ArrayList<>();
        for(int i = 0; i < Restaurants.getSelectedRestaurants().size(); i++) {
            if(weights[i] == maxVotes) {
                winningRestaurants.add(Restaurants.getSelectedRestaurants().get(i));
            }
        }
        Collections.shuffle(winningRestaurants);
        Restaurant winner = winningRestaurants.get(0);

        // Update components
        ImageView winnerImage = findViewById(R.id.winnerPic);
        winnerImage.setImageResource(winner.getImgSrc());

        TextView winnerText = findViewById(R.id.winnerName);
        winnerText.setText(winner.getName());

        TextView voteCount = findViewById(R.id.voteCount);
        if(maxVotes == 1) {
            voteCount.setText(maxVotes + " Vote");
        } else {
            voteCount.setText(maxVotes + " Votes");
        }

        Button infoButton = findViewById(R.id.infoButton);
        Button directionsButton = findViewById(R.id.directionsButton);
        Button homeButton = findViewById(R.id.homeButton);

        infoButton.setOnClickListener((e) -> {
            int idx = Restaurants.getRestaurantArrayList().indexOf(winner);
            Intent i = new Intent(getApplicationContext(), RestaurantActivity.class);
            i.putExtra("Index", idx);
            startActivity(i);
        });

        directionsButton.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
        });

        homeButton.setOnClickListener((e) -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}
