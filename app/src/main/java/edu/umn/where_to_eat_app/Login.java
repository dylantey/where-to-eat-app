package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener((e) -> setActivity("login"));
        registerButton.setOnClickListener((e) -> setActivity("register"));
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        if(requestCode == 10) {
            if(resultCode == 1) {
                finish();
            }
        }
    }

    private void setActivity(String s) {
        switch(s) {
            case "login":
                startActivityForResult(new Intent(Login.this, LoginScreen.class), 10);
                break;
            case "register":
                startActivity(new Intent(Login.this, RegisterScreen.class));
                break;
            default:
                break;
        }
    }
}
