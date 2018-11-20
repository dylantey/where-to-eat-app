package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class JoinAFriendsRoom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_a_friends_room);

        Button friendsRoom1Button = findViewById(R.id.FriendsRoom1);
        Button friendsRoom2Button = findViewById(R.id.FriendsRoom2);
        Button friendsRoom3Button = findViewById(R.id.FriendsRoom3);
        Button backButton = findViewById(R.id.Back);

        friendsRoom1Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(JoinAFriendsRoom.this,Lobby.class));
        });

        friendsRoom2Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(JoinAFriendsRoom.this,Lobby.class));
        });

        friendsRoom3Button.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(JoinAFriendsRoom.this,Lobby.class));
        });

        backButton.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(JoinAFriendsRoom.this,JoinARoomLoggedIn.class));
        });
    }
}