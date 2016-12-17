package com.ss_baez.petagram4.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 15/12/2016.
 */

/** Este PageAdapter ayudará a manejar toda la parte de estar incrustando un fragment en cada "tap"*/

public class PageAdapter extends FragmentPagerAdapter {

    /** Un arreglo de fragmentos como variable */
    private ArrayList<Fragment> fragments;

    /** Al constructor se le agrega un ArrayList */
    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    /** Lo que se va a estar devolviendo sera un fragment en particular, a partir de la posición */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /** Se estará devolviendo el tamaño de la lista de fragments */
    @Override
    public int getCount() {
        return fragments.size();
    }
}
