package edu.umn.where_to_eat_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.data.Users;

public class VotingScreen extends AppCompatActivity {

    public int[] weights = new int[Restaurants.getSelectedRestaurants().size()];
    private VotingAdapter adapter;
    private int ballot = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_screen);

        setTitle("Voting Screen (Ballot 1)");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Adapter
        adapter = new VotingAdapter(this);

        //Recycler
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //set adapter
        rv.setAdapter(adapter);


        Button nextBallotButton = findViewById(R.id.nextBallotButton);
        Button finishButton = findViewById(R.id.finishButton);

        nextBallotButton.setOnClickListener((e)->{
            for(int i = 0; i < weights.length; i++) {
                weights[i] += adapter.getWeights()[i];
            }
            adapter = new VotingAdapter(this);
            rv.setAdapter(adapter);
            setTitle("Voting Screen (Ballot " + (++ballot) + ")");
        });

        finishButton.setOnClickListener((e)->{
            for(int i = 0; i < weights.length; i++) {
                weights[i] += adapter.getWeights()[i];
            }

            //TODO: Goto results
                Intent i = new Intent(VotingScreen.this, VotingResults.class);
                i.putExtra("Votes", weights);
                startActivity(i);
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
