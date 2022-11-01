package com.albertcode.eureka.pake.Adaptador;


import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Eureka on 18/02/2021.
 */

public class ViewpageAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> listafraqgment = new ArrayList<>();
    private List<String> listatítulo = new ArrayList<>();



    public void AddFragmet(Fragment fragment,String titulo){
        listafraqgment.add(fragment);
        listatítulo.add(titulo);
    }

    public ViewpageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listafraqgment.get(position);
    }

    @Override
    public int getCount() {
        return listafraqgment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listatítulo.get(position);
    }



}
