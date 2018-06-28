package com.allan.colorpicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class PickerActivity extends AppCompatActivity {
    private SeekBar skbSearch;
    private TextView txtNumber;
    private String color, TAG;
    private LinearLayout layout;
    private Converter converter;
    private FloatingActionButton favorite;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_picker:
                    startActivity(new Intent(getApplicationContext(),PickerActivity.class));
                    return true;
                case R.id.navigation_random:
                    startActivity(new Intent(getApplicationContext(),RandomActivity.class));
                    return true;
                case R.id.navigation_favorites:
                    startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        txtNumber = findViewById(R.id.txtNumber);
        skbSearch = findViewById(R.id.skbSearch);
        layout = findViewById(R.id.layout);
        converter = new Converter();

        favorite = findViewById(R.id.floatingActionButton);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        skbSearch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                txtNumber.setText(converter.intToString(i));
                try{
                    layout.setBackgroundColor(Color.parseColor(converter.intToString(i)));
                    if(i == 0){
                        txtNumber.setTextColor(Color.parseColor("#ffffff"));
                    }
                    else{
                        txtNumber.setTextColor(Color.parseColor("#000000"));

                    }
                }
                catch (Exception e){
                    Log.w(TAG, converter.intToString(i));
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
