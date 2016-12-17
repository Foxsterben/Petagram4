package com.ss_baez.petagram4.db;

/**
 * Created by SS_Baez on 14/12/2016.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "pets";
    public static final int DATABASE_VERSION = 1;

    //Aquí se le da nombre a cada columna que conformará la tabla

    public static final String TABLE_PETS = "pet";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NOMBRE = "nombre";
    public static final String TABLE_PETS_FOTO = "foto";

    public static final String TABLE_LIKES_PET = "pet_likes";
    public static final String TABLE_LIKES_ID = "id";
    public static final String TABLE_LIKES_ID_PET = "id_pet";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes";

}
