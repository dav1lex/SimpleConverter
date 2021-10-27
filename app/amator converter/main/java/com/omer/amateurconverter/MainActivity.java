package com.omer.simpleconverter;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.ThemeUtils;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public ImageButton imgbuton1, imgbuton2, img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        createmenu();


        imgbuton1 = findViewById(R.id.activity_kilo_butonu);
        imgbuton2 = findViewById(R.id.activity_uzunluk_butonu);
        img3 = findViewById(R.id.activity_sicaklik_butonu);


        imgbuton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(), uzunluk.class);
                startActivity(int1);


            }
        });

        imgbuton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(getApplicationContext(), agirlik.class);
                startActivity(int2);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(), sicaklik.class);
                startActivity(int3);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_agirlik:
                        Intent int1 = new Intent(getApplicationContext(), agirlik.class);
                        startActivity(int1);
                        drawerLayout.closeDrawers();
                        finish();
                        break;

                    case R.id.item_anamenu:
                        Intent int2 = new Intent(getApplicationContext(), MainActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(int2);
                        finish();
                        break;

                    case R.id.item_uzunluk:
                        Intent int3 = new Intent(getApplicationContext(), uzunluk.class);
                        drawerLayout.closeDrawers();
                        startActivity(int3);
                        finish();
                        break;

                    case R.id.item_sicaklik:
                        Intent int5 = new Intent(getApplicationContext(), sicaklik.class);
                        drawerLayout.closeDrawers();
                        startActivity(int5);
                        finish();
                        break;

                }
                return false;
            }

        });


    }


    public void menuyuyarat() {
        navigationView = (NavigationView) findViewById(R.id.nav_menu);

        drawerLayout = findViewById(R.id.drawer_anamenu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayShowTitleEnabled(true); //uygulama ismini ust menuden kaldir ac komutu
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}