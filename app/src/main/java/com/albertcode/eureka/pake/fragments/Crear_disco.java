package com.albertcode.eureka.pake.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.R;

import java.util.Calendar;
import java.util.Date;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Crear_disco extends Fragment {
    View vista;
    int diafecha;
    int mesfecha;
    int anofecha;
    Access access;
    EditText nomDisco;
    EditText vidDisco;
    Button crearDisco;
    Button cancelCrearDisco;
    Calendar c;


    public Crear_disco() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista=inflater.inflate(R.layout.fragment_crear_disco, container, false);
        c= Calendar.getInstance();
        mesfecha= c.get(Calendar.MONTH)+1;
        c.set(Calendar.MONTH,mesfecha);

        access= new Access(getActivity().getBaseContext());

        nomDisco=(EditText)vista.findViewById(R.id.textViewNombreDisco_Crear);
        vidDisco=(EditText)vista.findViewById(R.id.textViewVidaDisco_Crear);
        crearDisco=(Button)vista.findViewById(R.id.buttonCrearDisco);
        cancelCrearDisco=(Button)vista.findViewById(R.id.buttonCancelarCrearDisco);

        crearDisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disco disco= new Disco(1,nomDisco.getText().toString(),Integer.parseInt(vidDisco.getText().toString()),c,0,1);

                long result= access.InsertarDisco(disco);
                Toast.makeText(getActivity().getBaseContext(),"añadido"+result,Toast.LENGTH_LONG).show();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Discos())
                        .commit();
            }
        });

        cancelCrearDisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Discos())
                        .commit();
            }
        });




        return vista;
    }

}
