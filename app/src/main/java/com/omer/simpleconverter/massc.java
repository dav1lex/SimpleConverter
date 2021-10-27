package com.omer.simpleconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class massc extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Spinner sp1, sp2;
    Button enter_butonumuz;
    TextView textView_sonucu;
    EditText girmekutusu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        menuyuyarat();

        sp1 = findViewById(R.id.from_metre_spinner);
        sp2 = findViewById(R.id.to_metre_spinner);
        enter_butonumuz = findViewById(R.id.button_convert);
        textView_sonucu = findViewById(R.id.textview_sonuc);
        girmekutusu = findViewById(R.id.editText_from);


        String[] from = {"Ounce", "Pound", "Stone"};

        ArrayAdapter ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Milligram", "Gram", "Kilogram"};
        ArrayAdapter abc = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(abc);


        enter_butonumuz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                klavyekapat();

                double girilenmiktar = Double.parseDouble(girmekutusu.getText().toString());
                double oran;

                try {
                    Double.parseDouble(girmekutusu.getText().toString());

                    if (sp1.getSelectedItem().toString() == "Ounce" && sp2.getSelectedItem().toString() == "Milligram") {

                        oran = (int) (girilenmiktar * 28350);
                        textView_sonucu.setText(" ~" + oran + " mg");
                    } else if (sp1.getSelectedItem().toString() == "Ounce" && sp2.getSelectedItem().toString() == "Gram") {
                        oran = (int) (girilenmiktar * 28.350);
                        textView_sonucu.setText(" ~" + oran + " g");


                    } else if (sp1.getSelectedItem().toString() == "Ounce" && sp2.getSelectedItem().toString() == "Kilogram") {
                        oran = (int) (girilenmiktar * 0.02835);
                        textView_sonucu.setText(" ~" + oran + " Kg");

                    } else if (sp1.getSelectedItem().toString() == "Pound" && sp2.getSelectedItem().toString() == "Kilogram") {
                        oran = (int) (girilenmiktar * 0.45359237);
                        textView_sonucu.setText(" ~" + oran + " Kg");

                    } else if (sp1.getSelectedItem().toString() == "Pound" && sp2.getSelectedItem().toString() == "Gram") {
                        oran = (int) (girilenmiktar * 453.59237);
                        textView_sonucu.setText(" ~" + oran + " g");

                    } else if (sp1.getSelectedItem().toString() == "Pound" && sp2.getSelectedItem().toString() == "Milligram") {
                        oran = (int) (girilenmiktar * 45359237);
                        textView_sonucu.setText(" ~" + oran + " mg");

                    } else if (sp1.getSelectedItem().toString() == "Stone" && sp2.getSelectedItem().toString() == "Milligram") {
                        oran = (int) (girilenmiktar * 6350293.18);
                        textView_sonucu.setText(" ~" + oran + " mg");

                    } else if (sp1.getSelectedItem().toString() == "Stone" && sp2.getSelectedItem().toString() == "Kilogram") {
                        oran = (int) (girilenmiktar * 6.35029318);
                        textView_sonucu.setText(" ~" + oran + " Kg");

                    } else if (sp1.getSelectedItem().toString() == "Stone" && sp2.getSelectedItem().toString() == "Gram") {
                        oran = (int) (girilenmiktar * 6350.29318);
                        textView_sonucu.setText(" ~" + oran + " g");

                    }

                } catch (NumberFormatException e) {
                    girilenmiktar = 0;
                    makeToast("omer");//somehow doesnt work please enter value and hit convert thx
                }


            }


            private void klavyekapat() {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_agirlik:
                        Intent int1 = new Intent(getApplicationContext(), massc.class);
                        drawerLayout.closeDrawers();
                        startActivity(int1);

                        finish();
                        break;

                    case R.id.item_anamenu:
                        Intent int2 = new Intent(getApplicationContext(), MainActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(int2);
                        finish();
                        break;

                    case R.id.item_uzunluk:
                        Intent int3 = new Intent(getApplicationContext(), lenghtc.class);
                        drawerLayout.closeDrawers();
                        startActivity(int3);
                        finish();
                        break;

                    case R.id.item_sicaklik:
                        Intent int5 = new Intent(getApplicationContext(), temperaturec.class);
                        drawerLayout.closeDrawers();
                        startActivity(int5);
                        finish();
                        break;

                }
                return false;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void menuyuyarat() {
        navigationView = (NavigationView) findViewById(R.id.nav_menu_agirlik);
        drawerLayout = findViewById(R.id.drawer_agirlik);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void makeToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}