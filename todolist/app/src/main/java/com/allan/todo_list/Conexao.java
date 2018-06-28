package com.allan.todo_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by allan on 04/03/18.
 */

public class Conexao{

    private DbHelper helper;
    private SQLiteDatabase db;
    static String select = "SELECT * FROM todo";

    public Conexao(Context context) {
        helper = new DbHelper(context);
    }

    public ArrayAdapter<String> getData(ArrayAdapter<String> adapter){
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select,null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            adapter.add(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        }
        db.close();
        return adapter;
    }

    public void add(String data, int i){
        db = helper.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("id", i);
        val.put("titulo", data);
        db.insert("todo", null, val);
        db.close();
    }

    public void delete(long item){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(select,null);
        cursor.move((int)item);
        db.delete("todo", "id = " + cursor.getString(cursor.getColumnIndexOrThrow("id")), null);
    }

    public int getLast(){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToLast();
        return cursor.getInt(cursor.getColumnIndexOrThrow("id")) + 1;
    }
}
