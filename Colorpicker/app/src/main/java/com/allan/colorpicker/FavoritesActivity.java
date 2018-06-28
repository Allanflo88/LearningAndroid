package com.allan.colorpicker;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private ListView ltFavorites;
    private List<String> colorList;
    private ArrayAdapter<String> adapter;
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
                    startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ltFavorites = findViewById(R.id.ltFavorites);
        colorList = new ArrayList<>();

        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.activity_listview,colorList);
        ltFavorites.setAdapter(adapter);

        converter = new Converter();
        adapter.add(converter.intToString(11111));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
