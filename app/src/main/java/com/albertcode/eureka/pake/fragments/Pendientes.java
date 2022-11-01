package com.albertcode.eureka.pake.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.albertcode.eureka.pake.Adaptador.Re_ClienteAdapter;
import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.MainActivity;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.POJO.Entrega;

import com.albertcode.eureka.pake.R;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pendientes extends Fragment implements OnrecycleClickInterface {
    View vista;
    RecyclerView recyclerPendientes;
    Spinner spinnerDisco;
    List<Disco> discos = new ArrayList<>();
    List<String>nomdis = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    Access access;
    Disco disconombre;
    Re_ClienteAdapter re_clienteAdapter;
    TextView cantidadpendiente;
    int diafecha;
    int mesfecha;
    int anofecha;
    Calendar c;


    public Pendientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        access= new Access(getActivity().getBaseContext());

        vista=inflater.inflate(R.layout.fragment_pendientes, container, false);
        spinnerDisco= (Spinner) vista.findViewById(R.id.spinner);

        CargarSpiner(nomdis);

        access.Caragardatosclientes(clientes);

        cantidadpendiente= (TextView) vista.findViewById(R.id.cantpendientes);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(),android.R.layout.simple_dropdown_item_1line,nomdis);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisco.setAdapter(arrayAdapter);


        spinnerDisco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 if (!discos.isEmpty()){disconombre = discos.get(position);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(!clientes.isEmpty()){

            cantidadpendiente.setText(Integer.toString(clientes.size()));

            Collections.sort(clientes, new Comparator<Cliente>() {
                @Override
                public int compare(Cliente o1, Cliente o2) {
                    return o1.getDia()-o2.getDia();
                }
            });

            recyclerPendientes= (RecyclerView) vista.findViewById(R.id.recyclerViewpendientes);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getBaseContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerPendientes.setLayoutManager(linearLayoutManager);
            re_clienteAdapter = new Re_ClienteAdapter(getActivity().getBaseContext(),clientes,this);
            recyclerPendientes.setAdapter(re_clienteAdapter);

        }else {

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framependientes,new Notclientes())
                    .commit();

            cantidadpendiente.setText("0");
        }

        return vista;
    }

    public void CargarSpiner( List<String> nomdiscos){

        access.Caragardatosdiscos(discos);

        if (!discos.isEmpty()){

            for (int i=0;i<discos.size();i++){
            nomdiscos.add(discos.get(i).getNombre());
        }
        } else{
            nomdiscos.add("añade un disco");



            }}


    @Override
    public void OnItemClickDelete(int position) {
        clientes.remove(position);
        re_clienteAdapter.notifyItemRemoved(position);

        cantidadpendiente.setText(Integer.toString(clientes.size()));

        if(clientes.isEmpty()){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framependientes,new Notclientes())
                    .commit();
        }

    }

    @Override
    public void OnItemClickArchivar(int position) {

        Cliente cliente= clientes.get(position);


        c = Calendar.getInstance();
        mesfecha = c.get(Calendar.DAY_OF_MONTH)+1;
        c.set(Calendar.MONTH,mesfecha);

        Calendar e = Calendar.getInstance();
         e.add(Calendar.HOUR,3);


        Entrega entrega= new Entrega(1,cliente.getId(),disconombre.getId(),cliente.getNombre(),disconombre.getNombre(),c,e,1,cliente.getIngreso());

        long result= access.InsertarEntrega(entrega);

        Toast.makeText(getActivity().getBaseContext(),"archivado  "+entrega.getFecha().getTime()+"  "+result,Toast.LENGTH_LONG).show();

    }

    @Override
    public void OnItemLongClick(int position) {

    }

    @Override
    public void OnItemClic(int position) {

    }





}


