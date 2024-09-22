package com.example.ecobit;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initNavigation();
    }

    private void initNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Definir listeners para cada item de menu
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Intent intent = null;

            if (item.getItemId() == R.id.menu_home) {
                intent = new Intent(MainActivity.this, Home.class);
            } else if (item.getItemId() == R.id.menu_profile) {
                intent = new Intent(MainActivity.this, Profile.class);
            } else if (item.getItemId() == R.id.menu_location) {
                intent = new Intent(MainActivity.this, Locations.class);
            } else if (item.getItemId() == R.id.menu_add) {
                intent = new Intent(MainActivity.this, Donate.class);
            } else if (item.getItemId() == R.id.menu_messages) {
                intent = new Intent(MainActivity.this, Messages.class);
            }

            if (intent != null) {
                startActivity(intent);
                return true;
            } else {
                return false;
            }
        });
    }
}
