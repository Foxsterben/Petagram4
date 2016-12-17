package com.ss_baez.petagram4.db;

/**
 * Created by SS_Baez on 14/12/2016.
 */

import android.content.ContentValues;
import android.content.Context;

import com.ss_baez.petagram4.R;
import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

/** Esta clase interactua con los métodos de la base de datos */

public class ConstructorPets {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorPets(Context context){
        this.context = context;
    }

    public ArrayList<Pet> obtenerDatos(){

    /** Aquí se va a ejecutar la conexión con la base de datos */

        BaseDatos sqLiteDatabase = new BaseDatos(context);
        insertarPets(sqLiteDatabase);

        return sqLiteDatabase.obtenerTodosLosPets();                            /** obtenerTodosLosPets viene de BaseDatos */


    }

    public void insertarPets(BaseDatos sqLiteDatabase){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Toby");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet1);
        sqLiteDatabase.insertarPet(contentValues);                                /** insertarPet viene de BaseDatos */

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Chaks");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet2);
        sqLiteDatabase.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Vektor");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet3);
        sqLiteDatabase.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "René");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet4);
        sqLiteDatabase.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Paco");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet5);
        sqLiteDatabase.insertarPet(contentValues);


    }

    public void darLikePet (Pet pet){

        /** Aquí se abre y se instancia la base de datos */
        BaseDatos sqLiteDatabase = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_PET, pet.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        sqLiteDatabase.darLikePetA(contentValues);                                /** darLikePetA viene de BaseDatos */

    }

    public int obtenerLikePet (Pet pet){

        BaseDatos sqLiteDatabase = new BaseDatos(context);
        return sqLiteDatabase.obtenerLikesPetA(pet);                               /** obtenerLikesPetA viene de BaseDatos */

    }


}
