package com.ss_baez.petagram4.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ss_baez.petagram4.adapter.PetAdaptador;
import com.ss_baez.petagram4.R;
import com.ss_baez.petagram4.pojo.Pet;
import com.ss_baez.petagram4.presentador.IRecyclerViewFragmentPresenter;
import com.ss_baez.petagram4.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

/** Antes de utilizar "implements" se deben de poner los métodos en la Interface */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Pet> pets;
    private RecyclerView rv_pets;
    private IRecyclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        /** Esto es para enlazar el recyclerview del MainActivity ya que lo hicimos un objeto */
        rv_pets = (RecyclerView) v.findViewById(R.id.rv_pets);

        /** Se manda a llamar el Presentador */
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /** Inicia Interface */

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_pets.setLayoutManager(llm);

    }

    @Override
    public void generarGridLayout() {

        GridLayoutManager glm = new GridLayoutManager(getContext(),2);
        rv_pets.setLayoutManager(glm);

    }

    /** Ya se debe de tener creado el PetAdaptador.java */
    @Override
    public PetAdaptador crearAdaptador(ArrayList<Pet> pets) {

        PetAdaptador adaptador = new PetAdaptador(pets, getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PetAdaptador adaptador) {

        rv_pets.setAdapter(adaptador);

    }
}
