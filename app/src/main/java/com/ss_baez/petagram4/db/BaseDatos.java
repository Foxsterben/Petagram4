package com.ss_baez.petagram4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 14/12/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    /** Lo que se crea aquí es la estructura de la base de datos, de la o de las tablas, es decir, su composición */

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaPet = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
                                    ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                                    ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER" +
                                    ")";

        String queryCrearTablaLikesPet = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET + "(" +
                                        ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_LIKES_ID_PET + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                                        "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_PET + ") " +
                                        "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID + ")" +
                                        ")";
        sqLiteDatabase.execSQL(queryCrearTablaPet);
        sqLiteDatabase.execSQL(queryCrearTablaLikesPet);

    }

    /** Este método se ejcutará si se necesita, la reestructura de la base de datos */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PET);
        onCreate(sqLiteDatabase);

    }

    /** Método que generará una consulta a la base de datos */

    public ArrayList<Pet> obtenerTodosLosPets(){

        ArrayList<Pet> pets = new ArrayList<>();

        /** Aquí se va a manejar toda la parte que va ejecutar un query */
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;

        /** Lo siguiente es abrir la base de datos en forma de escritura (writable) o en forma de solo lectura (readable) */
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        /** Lo siguiente es ejecutar el query */
        Cursor registros = sqLiteDatabase.rawQuery(query, null); //Este objeto ayudará a recorrer los registros

        /** Se utiliza while para recorrer los registros e ir llenando el objetos "pets" que esta en el return*/
        while (registros.moveToNext()){

            Pet petActual = new Pet(); //El segundo Pet debe crear un constructor en el POO Pet

            /** Aquí se va a construir el objeto que se va almacenar en la lista "pets" */
            /*petActual.setId(registros.getInt(0));
            petActual.setNombre(registros.getString(1));
            petActual.setFoto(registros.getInt(2));

             Traeme la suma del campo NUMERO_LIKES de la tabla LIKES_PET donde el id (ID_PET) coincida con el id que estoy trayendo del oBj petActual y guardala en queryLikes
            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_PET + "=" + petActual.getId();

            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){

                petActual.setLikes(registrosLikes.getInt(0));

            }else{

                petActual.setLikes(0);

            }

            pets.add(petActual);

            */

        }

        sqLiteDatabase.close();
        return pets;

    }

    /** Este método es genérico y se puede llamar cuantas veces se requiera */
    public void insertarPet(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues); //contentValues va a tener asociado el valor con su respectivo campo
        sqLiteDatabase.close();

    }

    public void darLikePetA(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        sqLiteDatabase.close();

    }

    public int obtenerLikesPetA(Pet pet){

        int likes = 0;

        /** Traeme la suma del campo NUMERO_LIKES de la tabla LIKES_PET donde el id (ID_PET) coincida con el id que estoy trayendo del oBj pet y guardala en query*/
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_PET + "=" + pet.getId();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registroLikes = sqLiteDatabase.rawQuery(query, null);

        if (registroLikes.moveToNext()){

            likes = registroLikes.getInt(0);

        }

        sqLiteDatabase.close();

        return likes;

    }
}
