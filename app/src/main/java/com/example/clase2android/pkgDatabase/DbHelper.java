package com.example.clase2android.pkgDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public  class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String   DATABASE_NAME = "agenda_byron.db";
    public static final String TABLE_CONTACTOS = "t_contactos";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, mail TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(db);
    }

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }
}
