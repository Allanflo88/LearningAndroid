package com.allan.allan_player;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private PlayerAdapter playerAdapter;
    private Button btPlay, btPause, btStop;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerAdapter = new PlayerAdapter(MainActivity.this);
        btPause = findViewById(R.id.btPause);
        btPlay = findViewById(R.id.btPlay);
        btStop = findViewById(R.id.btStop);

        playerAdapter.initialize();
        playerAdapter.loadMedia(R.raw.you_give_love_a_bad_name);

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAdapter.pause();
            }
        });

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAdapter.play();

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAdapter.reset();
            }
        });


    }
}
