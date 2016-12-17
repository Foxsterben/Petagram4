package com.ss_baez.petagram4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //agrega el action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //ocultar el nombre de la app que muestra por defecto
        getSupportActionBar().setTitle(null);
        //agregar la flechita que da hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
