package com.allan.allan_player;

import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.net.URI;

/**
 * Created by allan on 18/02/18.
 */

public class ExternalStorage {

    String path;

    public ExternalStorage(String path) {
        this.path = path;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public Uri getMusic(){
        File music = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), path);

        return Uri.fromFile(music);
    }
}
