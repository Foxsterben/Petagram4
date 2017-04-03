package com.ss_baez.petagram4.restApi;

import com.ss_baez.petagram4.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SS_Baez on 29/03/2017.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER2)
    Call<PetResponse> getRecentMedia1();


}
