package com.ss_baez.petagram4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ss_baez.petagram4.adapter.PetAdaptador;
import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

public class LikesMascotas extends AppCompatActivity {

    private ArrayList<Pet> pets;
    private RecyclerView listaPets;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes_mascotas);

        /** Agrega el action bar */
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        /** Ocultar el nombre de la app que muestra por defecto */
        getSupportActionBar().setTitle(null);

        /** Agregar la flechita que da hacia atras */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaPets = (RecyclerView) findViewById(R.id.rv_pets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();

    }

    public PetAdaptador objAdaptador;
    public void inicializarAdaptador(){
        objAdaptador = new PetAdaptador(pets, this);
        listaPets.setAdapter(objAdaptador);
    }

    public void inicializarListaPets(){
        pets = new ArrayList<Pet>();

       /* pets.add(new Pet("Paco", R.drawable.pet5, 3));
        pets.add(new Pet("René", R.drawable.pet4, 10));
        pets.add(new Pet("Chaks", R.drawable.pet2, 5));
        pets.add(new Pet("Vektor", R.drawable.pet3, 4));
        pets.add(new Pet("Toby", R.drawable.pet1, 4));*/
    }
}

