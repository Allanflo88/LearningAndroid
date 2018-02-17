package com.allan.nuvemdereceitas.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.allan.nuvemdereceitas.R;
import com.allan.nuvemdereceitas.model.Receita;

import java.util.Date;

/**
 * Created by allan on 03/02/18.
 */

public class AddActivity extends AppCompatActivity {
    EditText edTitulo, edDescr;
    TextView txtAddUrl;
    Receita receita;
    Button btSalvar, btCancelar;
    Intent list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        receita = new Receita();
        edDescr = findViewById(R.id.edDescr);
        edTitulo = findViewById(R.id.edTitulo);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
        txtAddUrl = findViewById(R.id.txtAddUrl);
        list = new Intent(AddActivity.this, ListActivity.class);

        txtAddUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder addUrl = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.activity_dialog, null);
                addUrl.setTitle("Adicionar URL");
                addUrl.setView(v);
                /*addUrl.setPositiveButton("Salvar", null);
                addUrl.setNegativeButton("Cancelar", null);*/
                addUrl.show();


            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(list);
            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receita.setTitulo(edTitulo.getText().toString());
                receita.setDescricao(edDescr.getText().toString());
                receita.setData_add(new Date(System.currentTimeMillis()));
                list.putExtra("Receita",receita);
                startActivity(list);
            }
        });


    }
}
