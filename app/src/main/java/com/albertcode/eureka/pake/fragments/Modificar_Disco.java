package com.albertcode.eureka.pake.fragments;


import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modificar_Disco extends Fragment {

    Enviar_Datos ed;
    View vista;
    EditText nombreDiscoModificar;
    EditText devida;
    Button aceptar;
    Button cancelar;
    Disco disco;
    Access access;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Enviar_Datos){
            this.ed=(Enviar_Datos) context;

        }

    }


    public Modificar_Disco() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        access= new Access(getActivity().getBaseContext());

        vista=  inflater.inflate(R.layout.fragment_modificar__disco, container, false);

        nombreDiscoModificar= (EditText)vista.findViewById(R.id.textViewNombreDisco_Modificar) ;
        devida= (EditText)vista.findViewById(R.id.textViewVidaDisco_Modificar) ;
        aceptar=(Button)vista.findViewById(R.id.buttonModificarDisco);
        cancelar=(Button)vista.findViewById(R.id.buttonCancelarModificarDisco);

        disco = ed.RecibirDisco();
        nombreDiscoModificar.setText(disco.getNombre());
        devida.setText(Integer.toString(disco.getVida()));


       cancelar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getActivity().getSupportFragmentManager()
                       .beginTransaction()
                       .replace(R.id.frame,new Discos())
                       .commit();
           }
       });

       aceptar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               disco.setNombre(nombreDiscoModificar.getText().toString());
               disco.setVida(Integer.parseInt(devida.getText().toString()));

               long result= access.ModificarDatosDisco(disco,disco.getId());

               Toast.makeText(getActivity().getBaseContext(),"modificado "+result,Toast.LENGTH_LONG).show();

           }
       });


        return vista;
    }

}
