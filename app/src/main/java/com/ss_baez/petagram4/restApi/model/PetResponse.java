package com.ss_baez.petagram4.restApi.model;

import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 30/03/2017.
 */

public class PetResponse {

    ArrayList<Pet> pets;

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
