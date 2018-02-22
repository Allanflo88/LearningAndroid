package com.allan.randomcolorgenerator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView txtNumber;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = findViewById(R.id.txtNumber);
        linearLayout = findViewById(R.id.layout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color =  "#" + Integer.toHexString(Integer.parseInt(String.valueOf((int) (Math.random() * 16777215))));
                txtNumber.setText(color);
                try{
                    linearLayout.setBackgroundColor(Color.parseColor(color));
                }
                catch (Exception e){
                    Log.w(TAG, color);
                }

            }

        });

    }
}
