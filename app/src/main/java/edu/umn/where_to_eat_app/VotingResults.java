package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import edu.umn.where_to_eat_app.main_screen.MainActivity;

public class VotingResults extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_results);

        Button map1Button = findViewById(R.id.Directions1);
        Button map2Button = findViewById(R.id.Directions2);
        Button homeButton = findViewById(R.id.Back);

        map1Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(VotingResults.this,Map.class));
        });

        map2Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(VotingResults.this,Map.class));
        });

        homeButton.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(VotingResults.this,MainActivity.class));
        });
    }
}
