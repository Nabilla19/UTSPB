package com.example.movietix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.movietix.R;
import com.example.movietix.view.fragment.HomeFragment;
import com.example.movietix.view.fragment.TheatersFragment;
import com.example.movietix.view.fragment.TicketsFragment;
import com.example.movietix.view.fragment.ProfileFragment;
import com.example.movietix.repository.DummyDataUploader; // ✅ Tambahkan ini
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        bottomNavigationView = findViewById(R.id.bottom_nav);

        // Check authentication state
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser == null) {
            redirectToLogin();
            return;
        }

        // ✅ Upload dummy data ke Firebase Realtime Database
        DummyDataUploader.uploadDummyData();

        // Setup navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                loadFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.nav_theaters) {
                loadFragment(new TheatersFragment());
                return true;
            } else if (itemId == R.id.nav_tickets) {
                loadFragment(new TicketsFragment());
                return true;
            } else if (itemId == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
                return true;
            }
            return false;
        });

        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void redirectToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish(); // Close MainActivity
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Double check auth state when activity resumes
        if (auth.getCurrentUser() == null) {
            redirectToLogin();
        }
    }
}
