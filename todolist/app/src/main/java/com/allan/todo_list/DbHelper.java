package com.allan.todo_list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by allan on 04/03/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static String TABLE = "todo";
    private static String ID = "id";
    private static String TITULO = "titulo";
    private static String SUBTITULO = "subtitulo";
    private static String COMMA = ",";
    private static String TXT = " TEXT";
    private static String IDTYPE = " INTEGER PRIMARY KEY AUTOINCREMENT";

    private static final String SQL_CREATE = "create table " + TABLE + "(" + ID + IDTYPE + COMMA + TITULO + TXT + COMMA
                                            + SUBTITULO + TXT + ");";
    private static final String SQL_DELETE = "delete table if exists " + TABLE;

    public DbHelper(Context context) {
        super(context, TABLE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE);
        onCreate(sqLiteDatabase);
    }

    public static String getTABLE() {
        return TABLE;
    }

    public static String getID() {
        return ID;
    }

    public static String getTITULO() {
        return TITULO;
    }

    public static String getSUBTITULO() {
        return SUBTITULO;
    }
}
