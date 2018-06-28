package com.allan.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText edtTitulo, edtSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtSubtitulo = findViewById(R.id.edtSubtitulo);

        edtTitulo.setText(getIntent().getStringExtra("todo"));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
