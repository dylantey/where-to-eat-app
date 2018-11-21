package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import edu.umn.where_to_eat_app.main_screen.MainActivity;

public class JoinARoomLoggedIn extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_a_room_logged_in);

        Button joinAFriendsRoomButton = findViewById(R.id.JoinFriendsRoom);
        Button submitButton = findViewById(R.id.Submit);
        Button homeButton = findViewById(R.id.Home);

        joinAFriendsRoomButton.setOnClickListener((e) -> {
            // TODO: Go to join a friends room fragment
            startActivity(new Intent(JoinARoomLoggedIn.this,JoinAFriendsRoom.class));
        });

        submitButton.setOnClickListener((e) -> {
            // TODO: Go to voting results fragment
            startActivity(new Intent(JoinARoomLoggedIn.this,Lobby.class));
        });

        homeButton.setOnClickListener((e) -> {
            // TODO: Go to voting results fragment
            startActivity(new Intent(JoinARoomLoggedIn.this,MainActivity.class));
        });
    }

}
