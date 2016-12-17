package com.ss_baez.petagram4.presentador;

import android.content.Context;
import com.ss_baez.petagram4.db.ConstructorPets;
import com.ss_baez.petagram4.pojo.Pet;
import com.ss_baez.petagram4.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 15/12/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<Pet> pets;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();

    }

    @Override
    public void obtenerContactosBaseDatos() {

        constructorPets = new ConstructorPets(context);
        pets = constructorPets.obtenerDatos(); /** obtenerDatos y ConstructorPets vienen de la Base de datos, package db */
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(pets)); /** crearAdaptador viene de IRecyclerViewFragmentView */

        /** Esto es para mostrar los elementos en el RecyclerView */
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
