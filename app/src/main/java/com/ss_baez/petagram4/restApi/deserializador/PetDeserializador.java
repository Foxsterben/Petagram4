package com.ss_baez.petagram4.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ss_baez.petagram4.pojo.Pet;
import com.ss_baez.petagram4.restApi.JsonKeys;
import com.ss_baez.petagram4.restApi.model.PetResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by SS_Baez on 30/03/2017.
 */

public class PetDeserializador implements JsonDeserializer<PetResponse> {

    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        PetResponse petResponse = gson.fromJson(json, PetResponse.class);

        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        petResponse.setPets(deserializarPetDeJson(petResponseData));

        return petResponse;
    }

    private ArrayList<Pet> deserializarPetDeJson(JsonArray petResponseData){

        ArrayList<Pet> pets = new ArrayList<>();

        for (int i = 0; i < petResponseData.size(); i++){

            JsonObject petResponseDataObject = petResponseData.get(i).getAsJsonObject();

            JsonObject userJson = petResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombre = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String foto = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pet petActual =  new Pet();
            petActual.setId(id);
            petActual.setNombre(nombre);
            petActual.setFoto(foto);
            petActual.setLikes(likes);

            pets.add(petActual);

        }

        return pets;

    }
}
