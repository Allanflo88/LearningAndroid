package com.teste.teste;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private String TAG;
    private EditText edNome, edEndereco, edTelefone;
    private Button btSalvar;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<Pessoa> list;
    private ListView ltLista;
    private ArrayAdapter adapter;
    private Pessoa[] pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = new ArrayList<>();
        edEndereco = findViewById(R.id.edEndereco);
        edNome = findViewById(R.id.edNome);
        edTelefone = findViewById(R.id.edTelefone);
        btSalvar = findViewById(R.id.btSalvar);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Pessoas");
        ltLista = findViewById(R.id.ltLista);
        adapter = new ArrayAdapter<Pessoa>(this, R.layout.activity_listview, list);
        ltLista.setAdapter(adapter);


        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(edNome.getText().toString());
                pessoa.setEndereco(edEndereco.getText().toString());
                pessoa.setTelefone(edTelefone.getText().toString());

                myRef.child(pessoa.getNome()).setValue(pessoa);



                edNome.setText("");
                edEndereco.setText("");
                edTelefone.setText("");
            }
        });
        myRef.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Pessoa pessoa;
                adapter.clear();
                Iterator<DataSnapshot> iterator = (dataSnapshot.getChildren()).iterator();
                while (iterator.hasNext()){
                    pessoa = iterator.next().getValue(Pessoa.class);
                    //pessoa.setNome(iterator.next().getValue(Pessoa.class).getNome());
                    adapter.add(pessoa);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
