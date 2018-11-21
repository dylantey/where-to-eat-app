package edu.umn.where_to_eat_app.variable_pages;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.User;
import edu.umn.where_to_eat_app.data.Users;
import edu.umn.where_to_eat_app.utils.ComponentFactory;

public class UserActivity extends AppCompatActivity {

    private User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int idx = extras.getInt("Index");
            user = Users.getUserByIndex(idx);
        }

        setTitle(user.getNickname() + "'s profile");


        TextView name = findViewById(R.id.profileName);
        name.setText(user.getNickname());

        ImageView profilePic = findViewById(R.id.profilePicture);
        profilePic.setImageResource(user.getImageSrc());

        // Populate restaurant list
        if(user.getFavoriteRestaurants().size() == 0) {
            TextView sad = new TextView(getApplicationContext());
            sad.setText("\n\n\n\nFavorites list is empty.");
            sad.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            sad.setGravity(Gravity.CENTER);
            sad.setTextSize(26);
            ((LinearLayout) findViewById(R.id.favoritesContainer)).addView(sad);
        } else {
            for (Restaurant r : user.getFavoriteRestaurants()) {
                LinearLayout ll = ComponentFactory.makeRestaurantBox(r, this);

                Space space = new Space(getApplicationContext());
                space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

                ((LinearLayout) findViewById(R.id.favoritesContainer)).addView(ll);
                ((LinearLayout) findViewById(R.id.favoritesContainer)).addView(space);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
