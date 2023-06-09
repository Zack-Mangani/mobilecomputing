package com.example.monitorit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.monitorit.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class  MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Set the initial fragment to display (e.g., AthletesFragment)
        replaceFragment(new AthletesFragment());
        // Set listener for bottom navigation view item selection
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.athletes:
                    replaceFragment(new AthletesFragment());
                    break;
                case R.id.stopwatch:
                    replaceFragment(new StopwatchFragment());
                    break;
                case R.id.fixtures:
                    replaceFragment(new FixturesFragment());
                    break;


            }
            return true;
        });

    }
    // Replaces the current fragment with the provided fragment
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}