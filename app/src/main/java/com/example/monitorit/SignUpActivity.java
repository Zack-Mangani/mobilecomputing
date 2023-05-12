package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup;
    TextView textView;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        repassword = findViewById(R.id.repassword);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)) {
                    // Check if any field is empty
                    Toast.makeText(SignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();

                }else{
                        if (pass.equals(repass)) {
                            // Check if passwords match
                            Boolean checkuser = DB.CheckUsername(user);
                            if (checkuser == false) {
                                // Check if username is available
                                Boolean insert = DB.insertData(user, pass);
                                if (insert == true) {
                                    // Insert the user's data into the database
                                    Toast.makeText(SignUpActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Registered Failed!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(SignUpActivity.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(SignUpActivity.this, "Password are not identical", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

        });


        textView = findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}