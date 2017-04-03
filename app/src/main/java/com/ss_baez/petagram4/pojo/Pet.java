package com.ss_baez.petagram4.pojo;

/**
 * Created by SS_Baez on 14/12/2016.
 */

public class Pet {

    private String id;
    private String nombre;
    private String foto;
    private int likes;

    //El ID no debe de estar presente en el constructor


    public Pet(String nombre, String foto, int likes){

        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;

    }

    public Pet() {
        //Vacío por la database
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
