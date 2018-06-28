package com.allan.colorpicker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by allan on 22/02/18.
 */

public class ColorDbHelper extends SQLiteOpenHelper{

    public ColorDbHelper(Context context) {
        super(context, "Colors", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE colors(id INTEGER PRIMARY KEY AUTOINCREMENT, color TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS colors;");
        onCreate(sqLiteDatabase);
    }
}
