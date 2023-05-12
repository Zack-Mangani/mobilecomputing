package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText username, password;
Button login;
TextView textView;
DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views and database helper
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);

        // Set click listener for the login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered username and password
                String user= username.getText().toString();
                String pass= password.getText().toString();

                if(TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass))
                {
                    // Display a toast message if any field is empty
                    Toast.makeText(LoginActivity.this, "All fields required", Toast.LENGTH_SHORT).show();

                } else {
                    // Check if the entered username and password are valid
                    Boolean checkuserpass = DB.CheckUsernamePassword(user,pass);
                    if(checkuserpass == true) {
                        // Display a toast message for successful login and start the main activity
                        Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    } else {
                        // Display a toast message for failed login
                        Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        // Set click listener for the "Sign Up" text view
        textView = findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the sign up activity when the "Sign Up" text view is clicked
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

    }
}