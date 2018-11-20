package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
            startActivity(new Intent(VotingResults.this,MainActivity.class));
        });

        map2Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(VotingResults.this,MainActivity.class));
        });

        homeButton.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(VotingResults.this,MainActivity.class));
        });
    }
}
