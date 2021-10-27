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

import org.w3c.dom.Text;

import static java.lang.Double.parseDouble;


public class sicaklik extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    Spinner sp1;
    Button enter_butonumuz;
    TextView birim1, birim1sonuc, birim2, birim2sonuc;
    EditText girmekutusu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        menuyuyarat();
        sp1 = findViewById(R.id.to_metre_spinner);
        enter_butonumuz = findViewById(R.id.button_convert);
        girmekutusu = findViewById(R.id.editText_from);
        birim1 = findViewById(R.id.birim1);
        birim2 = findViewById(R.id.birim2);
        birim1sonuc = findViewById(R.id.tv_birim1_sonuc);
        birim2sonuc = findViewById(R.id.tv_birim2_sonuc);


        String[] to = {"Celcius", "Fahrenheit", "Kelvin"};
        ArrayAdapter abc = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        sp1.setAdapter(abc);


        enter_butonumuz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                klavyekapat();

                double girilenmiktar = Double.parseDouble(girmekutusu.getText().toString());
                float birinci, ikinci;


                if (sp1.getSelectedItem().toString() == "Celcius") {
                    birim1.setText("K");
                    birim2.setText("F");
                    ikinci = (float) (girilenmiktar + 273.15);
                    birim1sonuc.setText("" + ikinci);
                    birinci = (float) (girilenmiktar * 1.8 + 32);
                    birim2sonuc.setText("" + birinci);

                } else if (sp1.getSelectedItem().toString() == "Fahrenheit") {
                    birim1.setText("C");
                    birinci = (float) ((girilenmiktar - 32) / 1.8);
                    birim1sonuc.setText("" + birinci);

                    birim2.setText("K");
//                    K = 273.5 + ((F - 32.0) * (5.0/9.0))
                    ikinci = (float) (273.5 + ((girilenmiktar - 32) * (5f / 9f)));
                    birim2sonuc.setText("" + ikinci);


                } else {
                    birim1.setText("C");
                    birinci = (float) (girilenmiktar - 273.15);
                    birim1sonuc.setText("" + birinci);
                    ikinci = (float) (((girilenmiktar - 273.15) * 9 / 5) + 32);
                    birim2sonuc.setText("" + ikinci);
                    birim2.setText("F");

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
                        Intent int1 = new Intent(getApplicationContext(), agirlik.class);
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


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void menuyuyarat() {
        navigationView = (NavigationView) findViewById(R.id.nav_menu_sicaklik);
        drawerLayout = findViewById(R.id.drawer_sicaklik);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}