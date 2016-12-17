package com.ss_baez.petagram4;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ss_baez.petagram4.adapter.PageAdapter;
import com.ss_baez.petagram4.vista.fragment.PerfilFragment;
import com.ss_baez.petagram4.vista.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Cast
        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        setSupportActionBar(miActionBar);
        setUpViewPager();

        //Elimina el título por default y "setea" el logo
        miActionBar.setTitle("");
        miActionBar.setLogo(R.drawable.ic_huella);


        //Para habilitar menu de opciones y sea visible
        if (miActionBar != null){

            setSupportActionBar(miActionBar);

        }

    }

    /** Menu de opciones, método para "inflar" las distintas opciones */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    /** Menu opciones, método para controlar que va a suceder dependiendo la selección  */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_likes:
                Toast.makeText(this, "Mascotas Favoritas", Toast.LENGTH_SHORT).show();
                Intent objIntent = new Intent(MainActivity.this, LikesMascotas.class);
                startActivity(objIntent);
                break;

            case R.id.menu_contacto:
                Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                Intent objIntent2 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(objIntent2);
                break;

            case R.id.menu_acercade:
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();
                Intent objIntent3 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(objIntent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Lo siguientes dos métodos se crean después de creado el PageAdapter */

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        /** Este es lo que se mostrará en los "tap" */
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    /** Este método lo que hará, será poner en orbita los fragments */
    private void setUpViewPager(){

        /** Aquí se esta pasando la lista de fragments que se quieren agregar a PageAdapter */
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        /** Una vez que ya se tiene el viewpager configurado se debe agregar a: */
        tabLayout.setupWithViewPager(viewPager);

        /** Aquí se agrega el texto o los iconos de cada tap */
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pets);
        tabLayout.setPadding(5,0,0,0);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_my_dog);

    }

}
