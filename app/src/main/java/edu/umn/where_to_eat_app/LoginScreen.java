package edu.umn.where_to_eat_app;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class LoginScreen extends AppCompatActivity {

    private HashMap<String, String> users = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");

        Button loginButton = findViewById(R.id.loginButton);
        EditText inputUsername = findViewById(R.id.inputUsername);
        EditText inputPassword = findViewById(R.id.inputPassword);

        loginButton.setOnClickListener((e) -> login(inputUsername, inputPassword));

        new Users();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void login(EditText inputUsername, EditText inputPassword) {
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        boolean validLogin = Users.checkCredentials(username, password);

        if(validLogin) {
            Users.setCurrentUser(username);
            System.out.println("Valid Login!");
            setResult(1, new Intent().setData(Uri.parse("OK")));
            finish();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Invalid Username/Password!");
            alertDialogBuilder.create().show();

            inputUsername.setText("");
            inputPassword.setText("");

            inputUsername.requestFocus();
        }
    }


}