package com.allan.nuvemdereceitas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.allan.nuvemdereceitas.R;
import com.allan.nuvemdereceitas.model.Receita;

import java.io.Serializable;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView receitas_view;
    ArrayList<Receita> receitas_list;
    ArrayAdapter<Receita> adapter;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        receitas_view = findViewById(R.id.ltReceitas);
        receitas_list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.activity_listview, receitas_list);
        receitas_view.setAdapter(adapter);
        if(getIntent().getExtras() != null){
            adapter.add((Receita) getIntent().getExtras().get("Receita"));
        }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ListActivity.this, AddActivity.class));
            }
        });

        receitas_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent visualizar = new Intent(ListActivity.this, VisualizarActivity.class);

                Receita receita = (Receita) adapterView.getAdapter().getItem(i);

                visualizar.putExtra("Receita",receita);

                startActivity(visualizar);
            }



        });

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
