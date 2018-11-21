package edu.umn.where_to_eat_app.starting_screen;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Users;

public class RegisterScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");

        Button registerButton = findViewById(R.id.loginButton);
        EditText inputUsername = findViewById(R.id.inputUsername);
        EditText inputName = findViewById(R.id.inputName);
        EditText inputPassword = findViewById(R.id.inputPassword);
        EditText confirmPassword = findViewById(R.id.inputPassword2);

        registerButton.setOnClickListener((e) -> {
            if(!inputPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                alert("Passwords do not match!");
            } else {
                String val = createAccount(inputUsername.getText().toString(),
                        inputPassword.getText().toString(), inputName.getText().toString());
                if(val.equals("OK")) {
                    finish();
                } else {
                    alert(val);
                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private String createAccount(String username, String password, String name) {
        return Users.createAccount(username, password, name);
    }

    private void alert(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.create().show();
    }
}
