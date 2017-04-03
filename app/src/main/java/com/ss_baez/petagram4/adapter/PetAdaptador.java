package com.ss_baez.petagram4.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.ss_baez.petagram4.DetalleContacto;
import com.ss_baez.petagram4.R;
import com.ss_baez.petagram4.db.ConstructorPets;
import com.ss_baez.petagram4.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 15/12/2016.
 */

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {

    ArrayList<Pet> pets;
    Activity objActivity;

    //Constructor que recibira un Arraylist
    public PetAdaptador(ArrayList<Pet> pets, Activity objActivity){
        this.pets = pets;
        this.objActivity = objActivity;
    }


    /** Se va a encargar de tomar el layout, que define cada elemento de toda la lista de RecyclerView,
     * y lo va a sincronizar con el ViewHolder -clase anidada- */
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_pet, parent, false);
        return new PetViewHolder(v);
    }


    /** Se va a encargar de colocar todos los datos de una lista o colección de datos a cada View de nuestro ViewHolder
    * Asocia cada elemento de la lista con cada view */
    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {

        final Pet objPet = pets.get(position);

        //holder.img_pet.setImageResource(objPet.getFoto());

        Picasso.with(objActivity)
                .load(objPet.getFoto())
                .placeholder(R.drawable.pet3)
                .into(holder.imgFotoCV);

        //holder.tv_nombrePet.setText(objPet.getNombre());

        /** Aquí se va a estar "seteando" al TextView tvLikes, el valor que debe de tener en ese momento */
        holder.tvLikes.setText(String.valueOf(objPet.getLikes()));

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** Este Intent nos llevará a la actividad DetalleContacto, además envía los parámetros */
                Intent objIntent = new Intent(objActivity, DetalleContacto.class);

                objIntent.putExtra("url", objPet.getFoto()); /** Se modifica el objeto contacto para ingresar el URL */
                objIntent.putExtra("like", objPet.getLikes());

                objActivity.startActivity(objIntent);

            }
        });

        /*
        holder.btnImg_boneLike.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(objActivity, "Diste Like a " + objPet.getNombre(), Toast.LENGTH_SHORT).show();

                //Con esto se inserta un like en la base de datos
                ConstructorPets constructorPets = new ConstructorPets(objActivity);
                constructorPets.darLikePet(objPet);

                holder.tv_contadorLikes.setText(String.valueOf(constructorPets.obtenerLikePet(objPet)));

            }
        });*/


    }

    /** Va a devolver el resultado de toda la cantidad de elementos que tenemos */
    @Override
    public int getItemCount() {

        /** Cantidad de elementos que contiene mi lista pets */
        return pets.size();
    }

    /** ViewHolder ayudará a manejar toda la conexión entre el Adaptador y todos los elementos Views
     *  que componen el renglón del RecyclerView o el elemento que se quiere mostrar en el recycler View */

    public static class PetViewHolder extends RecyclerView.ViewHolder{ /** Aquí inicia la clase anidada */

        /** Se van a declarar todos los Views que se tienen definidos en el CardView */
        private ImageView imgFotoCV;
        //private TextView tv_nombrePet;
        //private ImageButton btnImg_boneLike;
        public TextView tvLikes;


        /** En este método constructor es donde se van a asociar los obj de arriba con sus respectivos Views */
        public PetViewHolder(View itemView) {
            super(itemView);

            imgFotoCV             = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            //tv_nombrePet        = (TextView) itemView.findViewById(R.id.tv_nombrePet);
            //btnImg_boneLike     = (ImageButton) itemView.findViewById(R.id.btnImg_boneLike);
            tvLikes               = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}

