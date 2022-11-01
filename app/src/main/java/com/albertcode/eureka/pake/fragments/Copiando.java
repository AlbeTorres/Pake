package com.albertcode.eureka.pake.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.albertcode.eureka.pake.Adaptador.Re_ClienteAdapter;
import com.albertcode.eureka.pake.Adaptador.Re_CopiandoAdapter;
import com.albertcode.eureka.pake.Database.Access;
import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Entrega;
import com.albertcode.eureka.pake.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Copiando extends Fragment implements OnrecycleClickInterface{
    View vista;
    RecyclerView recyclerCopiando;
    TextView saldo;
    List<Entrega> entregas = new ArrayList<>();
    Access access;
    Re_CopiandoAdapter re_copiandoAdapter;
    int monto= 0;


    public Copiando() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fragment_copiando, container, false);

        access= new Access(getActivity().getBaseContext());

        access.CargarEntregas(entregas);

        saldo= (TextView)vista.findViewById(R.id.textView4);
        saldo.setText(Integer.toString(monto));

        if(!entregas.isEmpty()){

            recyclerCopiando= (RecyclerView) vista.findViewById(R.id.recyclerViewcopiando);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getBaseContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerCopiando.setLayoutManager(linearLayoutManager);
            re_copiandoAdapter = new Re_CopiandoAdapter(getActivity().getBaseContext(),entregas,this);
            recyclerCopiando.setAdapter(re_copiandoAdapter);
        }else {

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framecopiando,new NotEntregas())
                    .commit();

        }

        return vista;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){

            access.CargarEntregas(entregas);
            re_copiandoAdapter.notifyDataSetChanged();


        }



    }

    @Override
    public void OnItemClickDelete(int position) {

         monto= monto+ entregas.get(position).getIngreso();
         Toast.makeText(getActivity().getBaseContext(),"has ganado "+entregas.get(position).getIngreso(),Toast.LENGTH_LONG).show();
         re_copiandoAdapter.notifyItemRemoved(position);
         entregas.remove(position);
         saldo.setText(Integer.toString(monto));

         if (entregas.isEmpty()){
             getActivity().getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.framecopiando,new NotEntregas())
                     .commit();

         }


    }

    @Override
    public void OnItemClickArchivar(int position) {

    }

    @Override
    public void OnItemLongClick(int position) {
        Toast.makeText(getActivity().getBaseContext(),"hora entrega "+entregas.get(position).getFecha().get(Calendar.HOUR)+" "+entregas.get(position).getFecha().get(Calendar.MINUTE),Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnItemClic(int position) {

        Toast.makeText(getActivity().getBaseContext(),"hora recogida "+entregas.get(position).getHora_recogida().get(Calendar.HOUR)+" "+entregas.get(position).getHora_recogida().get(Calendar.MINUTE),Toast.LENGTH_LONG).show();

    }


}
