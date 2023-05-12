package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set the activity to fullscreen
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    // Create a delay using a Handler to navigate to the next activity after a certain time
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
        }
    }, 4000); // Delay for 4 seconds (4000 milliseconds)



    }

}