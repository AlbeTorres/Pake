package com.albertcode.eureka.pake.fragments;


import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.R;

import java.util.Calendar;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Datos_cliente extends Fragment {

    View vista;
    Button btnatrasDC;
    TextView nombrecliente;
    TextView telefono;
    TextView diadatos;
    TextView ingresodatos;
    TextView fechadatos;
    TextView entregasdatos;
    TextView gananciadatos;
    Enviar_Datos ed;
    Cliente cliente;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Enviar_Datos){
            this.ed=(Enviar_Datos) context;

        }

    }



    public Datos_cliente() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista =inflater.inflate(R.layout.fragment_datos_cliente, container, false);
        nombrecliente= (TextView)vista.findViewById(R.id.textNombreDC);
        telefono=(TextView)vista.findViewById(R.id.textelefonoDC);
        diadatos=(TextView)vista.findViewById(R.id.texdiaentregaDC);
        ingresodatos= (TextView)vista.findViewById(R.id.texIngresoDC);
        fechadatos=(TextView)vista.findViewById(R.id.texFechaDC);
        entregasdatos=(TextView)vista.findViewById(R.id.texentregasDC);
        gananciadatos=(TextView)vista.findViewById(R.id.texgantotalesDC);





        cliente= ed.RecibirCliente();

        nombrecliente.setText(cliente.getNombre());
        telefono.setText(cliente.getTelefono());
        diadatos.setText(Selectdia(cliente.getDia()));
        ingresodatos.setText(Integer.toString(cliente.getIngreso()));
        fechadatos.setText(""+cliente.getFecha().get(Calendar.DAY_OF_MONTH)+"/"+cliente.getFecha().get(Calendar.MONTH)+"/"+cliente.getFecha().get(Calendar.YEAR));




        btnatrasDC = (Button)vista.findViewById(R.id.btnAtrasDC);

        btnatrasDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Clientes())
                        .commit();
            }
        });
        return vista;
         }


         public String Selectdia(int i){

        switch (i){
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 7:
                return "Domingo";
            default:
                return "false";


         }

        }

    }


