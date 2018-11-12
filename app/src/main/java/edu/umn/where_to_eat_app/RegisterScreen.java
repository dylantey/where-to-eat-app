package edu.umn.where_to_eat_app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class RegisterScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");

        Button registerButton = findViewById(R.id.loginButton);
        EditText inputUsername = findViewById(R.id.inputUsername);
        EditText inputPassword = findViewById(R.id.inputPassword);
        EditText confirmPassword = findViewById(R.id.inputPassword2);

        registerButton.setOnClickListener((e) -> {
            if(!inputPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                alert("Passwords do not match!");
            } else {
                int val = createAccount(inputUsername.getText().toString(),
                        inputPassword.getText().toString());
                switch(val) {
                    case Users.OK:
                        finish();
                        break;
                    case Users.USER_TAKEN:
                        alert("Username is already taken!");
                        break;
                    case Users.USER_BLANK:
                        alert("Please fill in the username field!");
                        break;
                    case Users.PASS_BLANK:
                        alert("Please fill in the password field!");
                        break;
                    case Users.BOTH_BLANK:
                        alert("Please fill in both the username and password fields!");
                        break;
                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private int createAccount(String username, String password) {
        return Users.createAccount(username, password);
    }

    private void alert(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.create().show();
    }
}
