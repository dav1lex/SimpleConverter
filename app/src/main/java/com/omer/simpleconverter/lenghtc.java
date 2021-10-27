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


public class lenghtc extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    Spinner sp1, sp2;
    Button enter_button;
    TextView textView_sonucu;
    EditText girmekutusu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght);
        createmenu();

        sp1 = findViewById(R.id.from_metre_spinner);
        sp2 = findViewById(R.id.to_metre_spinner);
        enter_button = findViewById(R.id.button_convert);
        textView_sonucu = findViewById(R.id.textview_sonuc);
        girmekutusu = findViewById(R.id.editText_from);


        String[] from = {"Inch", "Foot","Yard", "Mile" };

        ArrayAdapter ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Centimeter", "Meter", "Kilometer"};
        ArrayAdapter abc = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(abc);



        enter_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                klavyekapat();

                double girilenmiktar = Double.parseDouble(girmekutusu.getText().toString());
                double oran;
                double temp;

                try {
                    Double.parseDouble(girmekutusu.getText().toString());
                    if (sp1.getSelectedItem().toString() == "Inch" && sp2.getSelectedItem().toString() == "Meter") {

                        oran = girilenmiktar * 0.0254;
                        textView_sonucu.setText(oran + " M");

                    } else if (sp1.getSelectedItem().toString() == "Inch" && sp2.getSelectedItem().toString() == "Kilometer") {

                        oran = girilenmiktar * 0.000254;
                        textView_sonucu.setText(oran + " Km");
                    } else if (sp1.getSelectedItem().toString() == "Foot" && sp2.getSelectedItem().toString() == "Centimeter") {
                        oran = girilenmiktar * 30.48;
                        textView_sonucu.setText(oran + " Cm");


                    } else if (sp1.getSelectedItem().toString() == "Foot" && sp2.getSelectedItem().toString() == "Meter") {
                        oran = girilenmiktar * 0.3048;
                        textView_sonucu.setText(oran + " M");

                    } else if (sp1.getSelectedItem().toString() == "Foot" && sp2.getSelectedItem().toString() == "Kilometer") {
                        oran = girilenmiktar * 0.0003048;
                        textView_sonucu.setText(oran + " Km");

                    } else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Centimeter") {
                        oran = girilenmiktar * 160934.4;
                        textView_sonucu.setText(oran + " Cm");

                    } else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Meter") {
                        oran = girilenmiktar * 1609.344;
                        textView_sonucu.setText(oran + " M");

                    } else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Kilometer") {
                        oran = girilenmiktar * 1.609344;
                        textView_sonucu.setText(oran + " Km");

                    } else if (sp1.getSelectedItem().toString() == "Yard" && sp2.getSelectedItem().toString() == "Centimeter") {
                        oran = girilenmiktar * 91.44;
                        textView_sonucu.setText(oran + " Cm");

                    } else if (sp1.getSelectedItem().toString() == "Yard" && sp2.getSelectedItem().toString() == "Meter") {
                        oran = girilenmiktar * 0.9144;
                        textView_sonucu.setText(oran + " M");

                    } else if
                    (sp1.getSelectedItem().toString() == "Yard" && sp2.getSelectedItem().toString() == "Kilometer") {
                        oran = girilenmiktar * 0.0009144;
                        textView_sonucu.setText(oran + " Km");

                    } else if (sp1.getSelectedItem().toString() == "Inch" && sp2.getSelectedItem().toString() == "Centimeter") {

                        oran = girilenmiktar * 2.54;
                        textView_sonucu.setText(oran + " Cm");
                    }

                } catch (NumberFormatException e) {
                    girilenmiktar = 0;
                    makeToast("omer");//somehow doesnt work please enter value and hit convert thx
                }


            }

//            void hideKeyboard() {
//                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(
//                        Context.INPUT_METHOD_SERVICE);
//                View focusedView = getActivity().getCurrentFocus();
//                /*
//                 * If no view is focused, an NPE will be thrown
//                 *
//                 * Maxim Dmitriev
//                 */
//                if (focusedView != null) {
//                    inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
//                            InputMethodManager.HIDE_NOT_ALWAYS);
//                }
//            }

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

    public void createmenu() {
        navigationView = (NavigationView) findViewById(R.id.nav_menu_uzunluk);
        drawerLayout = findViewById(R.id.drawer_uzunluk);
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