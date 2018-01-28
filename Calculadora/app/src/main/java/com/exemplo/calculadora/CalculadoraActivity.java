package com.exemplo.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;
import android.app.*;


public class CalculadoraActivity extends AppCompatActivity {

    EditText ednumero1, ednumero2;
    Button btSomar, btSubtrair, btMultiplicar, btDividir;
    Double result;


    public EditText getEdnumero1() {
        return ednumero1;
    }

    public void setEdnumero1(EditText ednumero1) {
        this.ednumero1 = ednumero1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        ednumero1 = (EditText) findViewById(R.id.numero1); //Cria apontamento para EditText ednumero1
        ednumero2 = (EditText) findViewById(R.id.numero2);//Cria apontamento para EditText ednumero2
        btSomar = (Button) findViewById(R.id.btSomar); //Cria apontamento para Button btSomar
        btSubtrair = (Button) findViewById(R.id.btSubtrair); //Cria apontamento para Button btSubtrair
        btMultiplicar = (Button) findViewById(R.id.btMultiplicar);//Cria apontamento para Button btMultiplicar
        btDividir = (Button) findViewById(R.id.btDividir);//Cria apontamento para Button btDividir
        final AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this); //Instância caixa de diálogo
        dialogo.setTitle("Resultado");
        dialogo.setNeutralButton("OK", null);




        btSomar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){


                result = Double.parseDouble(ednumero1.getText().toString()) + Double.parseDouble(ednumero2.getText().toString());

                dialogo.setMessage("A soma é " + result);// Da Set no texto do botão da caixa e não realiza nenhuma ação quando clicado
                dialogo.show(); //Mostra caixa de diálogo

            }
        });
        btSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                result = Double.parseDouble(ednumero1.getText().toString()) - Double.parseDouble(ednumero2.getText().toString());

                dialogo.setMessage("A subtração é " + result);// Da Set no texto do botão da caixa e não realiza nenhuma ação quando clicado
                dialogo.show(); //Mostra caixa de diálogo

            }
        });
        btMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                result = Double.parseDouble(ednumero1.getText().toString()) * Double.parseDouble(ednumero2.getText().toString());

                dialogo.setMessage("A multiplicação é " + result);// Da Set no texto do botão da caixa e não realiza nenhuma ação quando clicado
                dialogo.show(); //Mostra caixa de diálogo

            }
        });
        btDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                result = Double.parseDouble(ednumero1.getText().toString()) / Double.parseDouble(ednumero2.getText().toString());

                dialogo.setMessage("A divisão é " + result);// Da Set no texto do botão da caixa e não realiza nenhuma ação quando clicado
                dialogo.show(); //Mostra caixa de diálogo

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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
