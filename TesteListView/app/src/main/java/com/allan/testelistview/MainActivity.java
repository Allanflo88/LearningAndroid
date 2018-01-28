package com.allan.testelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] x = {"c","b","a"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView ltLista = findViewById(R.id.ltLista);

        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview, x);
        ltLista.setAdapter(adapter);
    }
}
