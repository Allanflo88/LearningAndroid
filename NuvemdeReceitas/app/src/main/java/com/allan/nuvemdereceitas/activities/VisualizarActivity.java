package com.allan.nuvemdereceitas.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.allan.nuvemdereceitas.R;
import com.allan.nuvemdereceitas.model.Receita;

/**
 * Created by allan on 03/02/18.
 */

public class VisualizarActivity extends AppCompatActivity {

    EditText edTitulo, edUrl, edDescr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        edTitulo = findViewById(R.id.edTitulo);
        edDescr = findViewById(R.id.edDescrVisu);
        edUrl = findViewById(R.id.edUrl);
        setSupportActionBar(toolbar);
        Receita receita = (Receita) getIntent().getExtras().get("Receita");

        edTitulo.setText(receita.getTitulo());
        edDescr.setText(receita.getDescricao());
        edUrl.setText(receita.getUrl());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
