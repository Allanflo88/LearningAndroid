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

    private MediaPlayer mediaPlayer;
    private Button btPlay, btPause, btStop;
    private String TAG;
    AssetFileDescriptor afd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        btPause = findViewById(R.id.btPause);
        btPlay = findViewById(R.id.btPlay);
        btStop = findViewById(R.id.btStop);
        afd = getResources().openRawResourceFd(R.raw.you_give_love_a_bad_name);


        try {
            mediaPlayer.setDataSource(afd);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }



        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.reset();
                try {
                    mediaPlayer.setDataSource(afd);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
