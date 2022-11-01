package com.albertcode.eureka.pake.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.R;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Modificar_cliente extends Fragment {
    View vista;
    Toolbar toolbar;
    EditText nombrecliente;
    EditText telefono;
    EditText ingreso;
    Spinner diaentrega;
    Date fecha;
    int dia;
    List<String> diasemana = new ArrayList<>();
    Button btncancelar;
    Access access;
    int diafecha;
    int mesfecha;
    int anofecha;
    Enviar_Datos ed;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Enviar_Datos){
            this.ed=(Enviar_Datos) context;

        }

    }



    public Modificar_cliente() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        access= new Access(getActivity().getBaseContext());

        Calendar c= Calendar.getInstance();
        diafecha= c.get(Calendar.DAY_OF_MONTH);
        mesfecha= c.get(Calendar.MONTH)+1;
        anofecha= c.get(Calendar.YEAR);
        // Inflate the layout for this fragment

        vista= inflater.inflate(R.layout.fragment_modificar_cliente, container, false);

        toolbar = (Toolbar) vista.findViewById(R.id.toolbarmodificarcliente);
        toolbar.setTitle("Presiona para guardar los cambios");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.inflateMenu(R.menu.crear_cliente);

        nombrecliente= (EditText)vista.findViewById(R.id.modificar_nombre_cliente);
        telefono= (EditText)vista.findViewById(R.id.modificar_telefono_cliente);
        ingreso= (EditText) vista.findViewById(R.id.modificar_ingreso_cliente);
        btncancelar= (Button)vista.findViewById(R.id.btnCancelarMC);
        diaentrega= (Spinner)vista.findViewById(R.id.spinnermodificarcliente);

        nombrecliente.setText(ed.RecibirCliente().getNombre());
        telefono.setText(ed.RecibirCliente().getTelefono());
        ingreso.setText(Integer.toString(ed.RecibirCliente().getIngreso()));


        CargarSpiner();
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(),android.R.layout.simple_dropdown_item_1line,diasemana);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diaentrega.setAdapter(arrayAdapter);
        diaentrega.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(diasemana.get(position).equals("Lunes")){
                    dia= 1;
                }
                if(diasemana.get(position).equals("Martes")){
                    dia= 2;
                }
                if(diasemana.get(position).equals("Miércoles")){
                    dia= 3;
                }
                if(diasemana.get(position).equals("Jueves")){
                    dia= 4;
                }
                if(diasemana.get(position).equals("Viernes")){
                    dia= 5;
                }
                if(diasemana.get(position).equals("Sábado")){
                    dia= 6;
                }
                if(diasemana.get(position).equals("Domingo")){
                    dia= 7;
                }


                Toast.makeText(getActivity().getBaseContext(),dia+" ",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Cliente cliente= ed.RecibirCliente();
                cliente.setNombre(nombrecliente.getText().toString());
                cliente.setTelefono(telefono.getText().toString());
                cliente.setIngreso(Integer.parseInt(ingreso.getText().toString()));
                cliente.setDia(dia);

                long result=access.ModificarDatosCliente(cliente,cliente.getId());
                Toast.makeText(getActivity().getBaseContext(),result+" ",Toast.LENGTH_LONG).show();



                return true;
            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
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

    public void CargarSpiner( ){

        diasemana.add("Lunes");
        diasemana.add("Martes");
        diasemana.add("Miércoles");
        diasemana.add("Jueves");
        diasemana.add("Viernes");
        diasemana.add("Sábado");
        diasemana.add("Domingo");


    }

}
