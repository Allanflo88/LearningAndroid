package com.compras.sistemadecompras;

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
import android.widget.CheckBox;

public class ComprasActivity extends AppCompatActivity {
    private CheckBox chkCarne, chkLeite, chkArroz, chkFeijao;
    private Button btTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        chkArroz = (CheckBox) findViewById(R.id.chkArroz);
        chkCarne = (CheckBox) findViewById(R.id.chkCarne);
        chkFeijao = (CheckBox) findViewById(R.id.chkFeijao);
        chkLeite = (CheckBox) findViewById(R.id.chkLeite);
        btTotal = (Button) findViewById(R.id.btTotal);

        btTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;

                if(chkArroz.isChecked()){
                    total += 2.69;
                }
                if(chkCarne.isChecked()){
                    total += 5.00;
                }
                if(chkFeijao.isChecked()){
                    total += 9.70;
                }
                if(chkLeite.isChecked()){
                    total += 2.30;
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(ComprasActivity.this);
                dialog.setTitle("Aviso");
                dialog.setMessage("Valor da compra: " + String.valueOf(total));
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
        getMenuInflater().inflate(R.menu.menu_compras, menu);
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
