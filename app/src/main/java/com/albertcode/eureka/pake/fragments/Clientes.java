package com.albertcode.eureka.pake.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.albertcode.eureka.pake.Adaptador.Recliente_frameadapter;
import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Clientes extends Fragment implements OnrecycleClickInterface {
    View vista;
    RecyclerView recyclerViewcliente;
    List<Cliente> clientes = new ArrayList<>();
    Access access;
    Recliente_frameadapter recliente_frameadapter;
    Toolbar toolbarcliente;
    Enviar_Datos ed;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Enviar_Datos){
            this.ed=(Enviar_Datos) context;

        }

    }


    public Clientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista=inflater.inflate(R.layout.fragment_clientes, container, false);

        access= new Access(getActivity().getBaseContext());

        toolbarcliente = (Toolbar) vista.findViewById(R.id.toolbarclientes);
        toolbarcliente.setTitle("Clientes");
        toolbarcliente.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbarcliente.inflateMenu(R.menu.cliente_menu);
        toolbarcliente.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.addclienteItem){

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame,new Crear_Cliente())
                            .commit();


                }
                return true;
            }
        });


        access.Caragardatosclientes(clientes);



        if(!clientes.isEmpty()){
            Toast.makeText(getActivity().getBaseContext(),""+clientes.get(0).getDia(),Toast.LENGTH_LONG).show();

        recyclerViewcliente= (RecyclerView)vista.findViewById(R.id.recyclerViewcliente);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewcliente.setLayoutManager(linearLayoutManager);
        recliente_frameadapter= new Recliente_frameadapter(getActivity().getBaseContext(),clientes,this);
        recyclerViewcliente.setAdapter(recliente_frameadapter);

        }else {

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.clientesviewframe,new Notclientes())
                    .commit();
        }



        return vista;
    }


    @Override
    public void OnItemClickDelete(int position) {
        access.EliminarDatosClientes(clientes.get(position).getId());
        clientes.remove(position);
        recliente_frameadapter.notifyItemRemoved(position);



        if(clientes.isEmpty()){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.clientesviewframe,new Notclientes())
                    .commit();

    }}

    @Override
    public void OnItemClickArchivar(int position) {

        ed.EnviarCliente(clientes.get(position));

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame,new Modificar_cliente())
                .commit();

    }


    @Override
    public void OnItemLongClick(int position) {

    }

    @Override
    public void OnItemClic(int position) {
        ed.EnviarCliente(clientes.get(position));
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame,new Datos_cliente())
                .commit();


    }

}
