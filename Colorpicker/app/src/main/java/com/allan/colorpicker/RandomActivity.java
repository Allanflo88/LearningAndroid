package com.allan.colorpicker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RandomActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView txtNumber;
    private String TAG;
    private Converter converter;

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

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        txtNumber = findViewById(R.id.txtNumber);
        linearLayout = findViewById(R.id.layout);
        converter = new Converter();

        txtNumber.setText("Touch on the screen to generate");

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = converter.intToString((int) (Math.random() * 16777215));
                txtNumber.setText(color);
                try{
                    linearLayout.setBackgroundColor(Color.parseColor(color));
                }
                catch (Exception e){
                    Log.w(TAG, color);
                }

            }

        });
    }

}
