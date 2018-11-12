package edu.umn.where_to_eat_app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener((e) -> {
            setFragment("login");
        });

        registerButton.setOnClickListener((e) -> {
            setFragment("register");
        });
    }

    protected boolean getLoggedIn() { return loggedIn;}

    private void setFragment(String s) {
        Fragment fragment = null;

        switch(s){
            case "login":
                fragment = new LoginScreen();
                break;
            case "register":
                fragment = new RegisterScreen();
                break;
            default:
                break;
        }

        // replacing the fragment
        if(fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
    }
}
