package com.example.clase2android.pkgDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper {

    public DbContactos(@Nullable Context context) {
        super(context);
    }

    public long insertarContactos(String nombre, String telefono, String mail) {
        if (nombre.isEmpty() || telefono.isEmpty() || mail.isEmpty()) {
            return -1;
        }

        long id = -1;
        try (SQLiteDatabase db = getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("mail", mail);
            id = db.insert(DbHelper.TABLE_CONTACTOS, null, values);
        } catch (Exception e) {
            Log.e("DbContactos", "Error al insertar contacto", e);
        }
        return id;
    }
}
