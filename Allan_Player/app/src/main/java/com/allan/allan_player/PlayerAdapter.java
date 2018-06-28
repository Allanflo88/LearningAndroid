package com.allan.allan_player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;

import java.io.IOException;
import java.net.URI;

/**
 * Created by allan on 18/02/18.
 */

public class PlayerAdapter {

    private MediaPlayer mediaPlayer;
    private Context context;
    private int resourceId;

    public PlayerAdapter(Context context) {
        this.context = context.getApplicationContext();
    }

    public void initialize(){
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }
    }

    public void loadMedia(int resourdeId){
        this.resourceId = resourdeId;

        System.out.println(Environment.getExternalStorageDirectory().getAbsoluteFile());
        ExternalStorage ext = new ExternalStorage("/storage/emulated/0/sdcard/Download/teste.mp3");

        Uri uri = ext.getMusic();
        initialize();

        AssetFileDescriptor assetFileDescriptor = context.getResources().openRawResourceFd(resourdeId);

        try {
            mediaPlayer.setDataSource(context.getApplicationContext(),uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public boolean isPlaying() {
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public void play(){
        if(mediaPlayer != null & !isPlaying()){
            mediaPlayer.start();
        }
    }

    public void pause(){
        if(mediaPlayer != null & isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void reset(){
        if(mediaPlayer != null){
            mediaPlayer.reset();
            loadMedia(resourceId);
        }
    }
}
