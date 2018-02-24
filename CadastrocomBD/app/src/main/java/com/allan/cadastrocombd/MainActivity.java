package com.allan.cadastrocombd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtNome, txtNascimento, txtEmail, txtTelefone;
    RadioGroup rdgSexo;
    Button btnsalvar, btnCancelar;
    PostContract.DbHelper helper;
    SQLiteDatabase db;
    List<String> list;
    ArrayAdapter<String> adapter;
    ListView ltPessoas;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new PostContract.DbHelper(getApplicationContext());


        txtEmail = findViewById(R.id.txtEmail);
        txtNascimento = findViewById(R.id.txtNascimento);
        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);
        rdgSexo = findViewById(R.id.rdgSexo);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnsalvar = findViewById(R.id.btnSalvar);
        ltPessoas = findViewById(R.id.ltPessoas);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.activity_listview, list);
        ltPessoas.setAdapter(adapter);




        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEmail.setText("");
                txtNascimento.setText("");
                txtNome.setText("");
                txtTelefone.setText("");
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = helper.getWritableDatabase();
                ContentValues val = new ContentValues();
                val.put(PostContract.PostEntry.id, i);

                val.put(PostContract.PostEntry.nome, txtNome.getText().toString());
                val.put(PostContract.PostEntry.telefone, txtTelefone.getText().toString());
                val.put(PostContract.PostEntry.email, txtEmail.getText().toString());
                val.put(PostContract.PostEntry.nascimento,txtNascimento.getText().toString());
                String sexo;
                if(rdgSexo.getCheckedRadioButtonId() == R.id.rdbMaculino){
                    sexo = "M";
                }
                else{
                    sexo = "F";
                }
                val.put(PostContract.PostEntry.sexo, sexo);
                long newRowId = db.insert(PostContract.PostEntry.table, null, val);
                Toast.makeText(getApplicationContext(), String.valueOf(newRowId), Toast.LENGTH_LONG).show();
                adapter.clear();
                onStart();

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        db = helper.getReadableDatabase();
        final String[] projection= {PostContract.PostEntry.nome};
        Cursor cursor = db.rawQuery("SELECT * FROM " + PostContract.PostEntry.table + ";", null);

        cursor.moveToFirst();
        while(cursor.moveToNext()){
            adapter.add(cursor.getString(cursor.getColumnIndexOrThrow(PostContract.PostEntry.nome)));

        }
        cursor.moveToLast();
        i = cursor.getInt(cursor.getColumnIndexOrThrow(PostContract.PostEntry.id)) + 1;
    }
}
