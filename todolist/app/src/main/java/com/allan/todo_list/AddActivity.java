package com.allan.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    Button btnSalvar;
    EditText edtTitulo, edtSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtSubtitulo = findViewById(R.id.edtSubtitulo);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conexao db = new Conexao(getApplicationContext());
                db.add(edtTitulo.getText().toString(),db.getLast());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }

}
