package com.salario.calculodesalario;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SalarioActivity extends AppCompatActivity {
    private RadioGroup rgOpcoes;
    private Button btCalcular;
    private EditText edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edSalario = (EditText) findViewById(R.id.edSalario);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(edSalario.getText().toString());

                int op = rgOpcoes.getCheckedRadioButtonId();

                if (op == R.id.rb40)
                    salario = salario + (salario * 0.4);
                else if (op == R.id.rb45)
                    salario = salario + (salario * 0.45);
                else
                    salario = salario + (salario * 0.5);

                AlertDialog.Builder dialog = new AlertDialog.Builder(SalarioActivity.this);
                dialog.setTitle("Novo salário");
                dialog.setMessage("Seu novo salário é: " + String.valueOf(salario));
                dialog.setNeutralButton("OK", null);
                dialog.show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        getMenuInflater().inflate(R.menu.menu_salario, menu);
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