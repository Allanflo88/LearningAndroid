package com.allan.nuvemdereceitas.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.allan.nuvemdereceitas.R;

public class DialogActivity extends AppCompatActivity{
    EditText edUrlDialog;
    Button btCancelarDialog, btSalvarDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        edUrlDialog = findViewById(R.id.edUrlDialog);
        btCancelarDialog = findViewById(R.id.btCancelarDialog);
        btSalvarDialog = findViewById(R.id.btSalvarDialog);

        btCancelarDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
