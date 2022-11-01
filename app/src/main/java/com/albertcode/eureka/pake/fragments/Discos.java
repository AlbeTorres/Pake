package com.albertcode.eureka.pake.fragments;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.albertcode.eureka.pake.Adaptador.Disco_Adapter;
import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Discos extends Fragment implements OnrecycleClickInterface {

    RecyclerView recyclerView;
    Toolbar toolbar;
    View vista;
    List<Disco>discos= new ArrayList<>();
    Disco_Adapter disco_adapter;
    int pos;
    Access access;
    Enviar_Datos ed;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Enviar_Datos){
            this.ed=(Enviar_Datos) context;

        }

    }


    public Discos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista= inflater.inflate(R.layout.fragment_discos, container, false);

        toolbar= (Toolbar)vista.findViewById(R.id.toolbardisco);
        toolbar.setTitle("Discos");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.inflateMenu(R.menu.disco_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.creardiscoItem){

                    recyclerView.setVisibility(View.INVISIBLE);
                    toolbar.getMenu().clear();

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framecreardisco,new Crear_disco())
                            .commit();


                }

                if (item.getItemId()==R.id.eliminardiscoItem){
                    access.EliminarDatosDiscos(discos.get(pos).getId());
                    discos.remove(pos);
                    disco_adapter.notifyItemRemoved(pos);
                    toolbar.getMenu().clear();
                    toolbar.inflateMenu(R.menu.disco_menu);




                }

                if (item.getItemId()==R.id.modificardiscoItem){

                    toolbar.getMenu().clear();
                    ed.EnviarDisco(discos.get(pos));
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framecreardisco,new Modificar_Disco())
                            .commit();




                }


                return true;
            }
        });

        access= new Access(getActivity().getBaseContext());
        access.Caragardatosdiscos(discos);

        recyclerView = (RecyclerView)vista.findViewById(R.id.recyclerviewDisco);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getActivity().getBaseContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        disco_adapter= new Disco_Adapter(getActivity().getBaseContext(),discos,this);
        recyclerView.setAdapter(disco_adapter);


        return vista;
    }



    @Override
    public void OnItemClickDelete(int position) {

    }

    @Override
    public void OnItemClickArchivar(int position) {

    }

    @Override
    public void OnItemLongClick(int position) {


    }

    @Override
    public void OnItemClic(int position) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menudisco_eliminarmodificar);
        Toast.makeText(getActivity().getBaseContext(),"Seleccionado "+ discos.get(position).getNombre()+ discos.get(position).getFecha().get(Calendar.DAY_OF_MONTH)+" "+ discos.get(position).getFecha().get(Calendar.MONTH)+" "+discos.get(position).getFecha().get(Calendar.YEAR),Toast.LENGTH_LONG).show();
        pos=position;
    }
}
