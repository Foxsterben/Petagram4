package com.ss_baez.petagram4.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss_baez.petagram4.restApi.ConstantesRestApi;
import com.ss_baez.petagram4.restApi.EndpointsApi;
import com.ss_baez.petagram4.restApi.deserializador.PetDeserializador;
import com.ss_baez.petagram4.restApi.model.PetResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SS_Baez on 30/03/2017.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());

        return gsonBuilder.create();

    }

}
