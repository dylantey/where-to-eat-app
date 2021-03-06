package edu.umn.where_to_eat_app.starting_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import edu.umn.where_to_eat_app.R;

public class TitleScreen extends AppCompatActivity {

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
                setResult(1, new Intent().setData(Uri.parse("OK")));
                finish();
            }
        }
    }

    private void setActivity(String s) {
        switch(s) {
            case "login":
                startActivityForResult(new Intent(TitleScreen.this, LoginScreen.class), 10);
                break;
            case "register":
                startActivity(new Intent(TitleScreen.this, RegisterScreen.class));
                break;
            default:
                break;
        }
    }
}
