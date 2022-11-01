package com.albertcode.eureka.pake.fragments;


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
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.R;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Crear_Cliente extends Fragment {
    View vista;
    Toolbar toolbar;
    EditText nombrecliente;
    EditText telefono;
    EditText ingreso;
    Spinner diaentrega;
    Date fecha;
    int dia;
    List<String> diasemana = new ArrayList<>();
    Button btncancelarCC;
    Access access;
    int diafecha;
    int mesfecha;
    int anofecha;
    Calendar d;






    public Crear_Cliente() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_crear__cliente, container, false);

        access= new Access(getActivity().getBaseContext());

        d= Calendar.getInstance();
        mesfecha= d.get(Calendar.MONTH)+1;
        d.set(Calendar.MONTH,mesfecha);



        toolbar= (Toolbar)vista.findViewById(R.id.toolbarcrearcliente);
        toolbar.setTitle("Presiona para añadir cliente");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.inflateMenu(R.menu.crear_cliente);

        nombrecliente= (EditText)vista.findViewById(R.id.crear_nombre_cliente);
        telefono= (EditText)vista.findViewById(R.id.crear_telefono_cliente);
        ingreso= (EditText) vista.findViewById(R.id.crear_ingreso_cliente);
        btncancelarCC= (Button)vista.findViewById(R.id.btnCancelarCC);
        diaentrega= (Spinner)vista.findViewById(R.id.spinnercrearcliente);


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


        btncancelarCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Clientes())
                        .commit();
            }
        });



        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Cliente cliente= new Cliente(1, nombrecliente.getText().toString(), telefono.getText().toString(),
                        d,dia,0,Integer.parseInt(ingreso.getText().toString()));

                long result=access.InsertarCliente(cliente);
                Toast.makeText(getActivity().getBaseContext(),cliente.getFecha().get(Calendar.DATE)+" ",Toast.LENGTH_LONG).show();

                return true;
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
