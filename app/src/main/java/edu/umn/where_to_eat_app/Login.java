package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


public class Login extends AppCompatActivity {

    private boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
    }

    protected boolean getLoggedIn() { return loggedIn;}
}
