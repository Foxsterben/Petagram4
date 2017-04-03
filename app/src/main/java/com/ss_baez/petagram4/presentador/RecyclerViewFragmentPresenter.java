package com.ss_baez.petagram4.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ss_baez.petagram4.db.ConstructorPets;
import com.ss_baez.petagram4.pojo.Pet;
import com.ss_baez.petagram4.restApi.EndpointsApi;
import com.ss_baez.petagram4.restApi.adapter.RestApiAdapter;
import com.ss_baez.petagram4.restApi.model.PetResponse;
import com.ss_baez.petagram4.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();

    }

    @Override
    public void obtenerContactosBaseDatos() {

        constructorPets = new ConstructorPets(context);
        pets = constructorPets.obtenerDatos(); /** obtenerDatos y ConstructorPets vienen de la Base de datos, package db */
        mostrarContactosRV();

    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<PetResponse> petResponseCall1 = endpointsApi.getRecentMedia1();
        /*Call<PetResponse> petResponseCall2 = endpointsApi.getRecentMedia2();
        Call<PetResponse> petResponseCall3 = endpointsApi.getRecentMedia3();*/

        petResponseCall1.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {

                PetResponse petResponse1 = response.body();
                pets = petResponse1.getPets();
                mostrarContactosRV();


            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {

                Toast.makeText(context, "Falló la conexión", Toast.LENGTH_SHORT).show();
                Log.e("FALLÓ LA CONEXIÓN", t.toString());

            }
        });


        /*petResponseCall2.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {

                PetResponse petResponse2 = response.body();
                pets = petResponse2.getPets();
                mostrarContactosRV();


            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {

                Toast.makeText(context, "Falló la conexión", Toast.LENGTH_SHORT).show();
                Log.e("FALLÓ LA CONEXIÓN", t.toString());

            }
        });*/

        /*petResponseCall3.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {

                PetResponse petResponse3 = response.body();
                pets = petResponse3.getPets();
                mostrarContactosRV();

            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {

                Toast.makeText(context, "Falló la conexión", Toast.LENGTH_SHORT).show();
                Log.e("FALLÓ LA CONEXIÓN", t.toString());

            }
        });*/

    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(pets)); /** crearAdaptador viene de IRecyclerViewFragmentView */

        /** Esto es para mostrar los elementos en el RecyclerView */
        iRecyclerViewFragmentView.generarGridLayout();


    }
}
