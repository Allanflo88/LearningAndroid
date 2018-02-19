package com.allan.allan_player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

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

        initialize();

        AssetFileDescriptor assetFileDescriptor = context.getResources().openRawResourceFd(resourdeId);

        try {
            mediaPlayer.setDataSource(assetFileDescriptor);
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
