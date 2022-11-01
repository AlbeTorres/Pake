package com.albertcode.eureka.pake.fragments;


import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.albertcode.eureka.pake.Adaptador.ViewpageAdapter;
import com.albertcode.eureka.pake.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contenedor extends Fragment {
    ViewPager viewPager;
    View vista;
    Toolbar toolbar;
    TabLayout tabLayout;


    public Contenedor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        vista=inflater.inflate(R.layout.fragment_contenedor, container, false);

        toolbar= (Toolbar)vista.findViewById(R.id.toolbar);
        toolbar.setTitle("Entregas");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        tabLayout= (TabLayout)vista.findViewById(R.id.tab);
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));



        viewPager= (ViewPager) vista.findViewById(R.id.viewpage);
        FullViewpager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        return vista;


    }


    public void FullViewpager(ViewPager viewPager){
        ViewpageAdapter viewpageAdapter = new ViewpageAdapter(getFragmentManager());

        viewpageAdapter.AddFragmet(new Pendientes(),"Pendientes");
        viewpageAdapter.AddFragmet(new Copiando(),"Copiando");

        viewPager.setAdapter(viewpageAdapter);
    }

}
