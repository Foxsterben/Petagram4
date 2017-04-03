package com.ss_baez.petagram4.vista.fragment;

import com.ss_baez.petagram4.adapter.PetAdaptador;
import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 15/12/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public PetAdaptador crearAdaptador(ArrayList<Pet> pets);

    public void inicializarAdaptadorRV(PetAdaptador adaptador);

}
