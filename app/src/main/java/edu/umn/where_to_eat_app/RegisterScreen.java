package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RegisterScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
