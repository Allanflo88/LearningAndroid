package com.allan.nuvemdereceitas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.allan.nuvemdereceitas.R;

/**
 * Created by allan on 03/02/18.
 */

public class LoginActivity extends AppCompatActivity {
    Button btEntrar;
    EditText edEmail, edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btEntrar = findViewById(R.id.btEntrar);
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(list);
            }
        });

    }
}
