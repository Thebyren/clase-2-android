package com.example.clase2android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase2android.pkgDatabase.DbContactos;

public class ContactsActivity extends AppCompatActivity {

    private EditText txtName, txtPhone, txtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initializeViews();
        setupSaveButton();
        setupWindowInsets();
    }


    private void initializeViews() {
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtMail = findViewById(R.id.txtMail);
    }

    private void setupSaveButton() {
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> saveContact());

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> finish());
    }

    private void saveContact() {
        DbContactos dbContactos = new DbContactos(this);
        long id = dbContactos.insertarContactos(
                txtName.getText().toString(),
                txtPhone.getText().toString(),
                txtMail.getText().toString()
        );

        if (id > 0) {
            clearInputFields();
            Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al Guardar Contacto", Toast.LENGTH_LONG).show();
        }
    }

    private void clearInputFields() {
        txtName.setText("");
        txtMail.setText("");
        txtPhone.setText("");
    }

    private void setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}