package com.example.clase2android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase2android.pkgDatabase.DbHelper;

public class MainActivity extends AppCompatActivity {
    Button btn_creardb;
    Button btnAbrirContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_creardb = findViewById(R.id.btnCrearDb);
        btnAbrirContactos = findViewById(R.id.btnAbrirContactos);

        btn_creardb.setOnClickListener(v -> {
            try (DbHelper dbHelper = new DbHelper(this)) {
                dbHelper.getWritableDatabase();
                Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();

            } catch (Exception e) {
                Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_LONG).show();
            }
        });

        btnAbrirContactos.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}