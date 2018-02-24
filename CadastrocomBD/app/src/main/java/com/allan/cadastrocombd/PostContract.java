package com.allan.cadastrocombd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by allan on 23/02/18.
 */

public final class PostContract {

    public PostContract() {}

    public static class PostEntry implements BaseColumns{
        public static final String table = "pessoa";
        public static final String id = "id";
        public static final String nome = "nome";
        public static final String email = "email";
        public static final String nascimento = "nascimento";
        public static final String telefone = "telefone";
        public static final String sexo = "sexo";
        public static final String COMMA = ",";
        public static final String TXT = " TEXT";
        public static final String IDTYPE = " INTEGER PRIMARY KEY AUTOINCREMENT";

    }

    public static class DbHelper extends SQLiteOpenHelper {
        private static final String SQL_CREATE = "CREATE TABLE " + PostEntry.table + "("+ PostEntry.id + PostEntry.IDTYPE + PostEntry.COMMA + PostEntry.nome + PostEntry.TXT + PostEntry.COMMA +
                                                    PostEntry.telefone  + PostEntry.TXT+ PostEntry.COMMA + PostEntry.email  + PostEntry.TXT+ PostEntry.COMMA + PostEntry.nascimento
                                                     + PostEntry.TXT+ PostEntry.COMMA + PostEntry.sexo + PostEntry.TXT +");";
        private static final String SQL_DELETE = "DELETE TABLE IF EXISTS" + PostEntry.table;

        public DbHelper(Context context) {
            super(context,PostEntry.table, null, 1);
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

        @Override
        public void onDowngrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            onUpgrade(sqLiteDatabase, i, i1);
        }

    }
}
