package com.albertcode.eureka.pake.Adaptador;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Eureka on 05/03/2021.
 */

public class Disco_Adapter extends RecyclerView.Adapter<Disco_Adapter.ViewHolder> {
    Context context;
    List<Disco> discos= new ArrayList<>();
    private OnrecycleClickInterface onrecycleClickInterface;

    public Disco_Adapter (Context context,List<Disco> discos,OnrecycleClickInterface onrecycleClickInterface){
        this.context= context;
        this.discos= discos;
        this.onrecycleClickInterface = onrecycleClickInterface;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.disco_item,parent,false);
        Disco_Adapter.ViewHolder viewHolder= new Disco_Adapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.entregas_disco.setText(Integer.toString(discos.get(position).getEntregas()));
        holder.nombre_disco.setText(discos.get(position).getNombre());
        holder.vidadisco.setText(Integer.toString(discos.get(position).getVida()));

    }

    @Override
    public int getItemCount() {
        return discos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView vidadisco;
        TextView entregas_disco;
        TextView nombre_disco;


        public ViewHolder(View itemView) {
            super(itemView);

            vidadisco= (TextView)itemView.findViewById(R.id.textViewVidaDisco);
            nombre_disco= (TextView)itemView.findViewById(R.id.textViewNombreDisco);
            entregas_disco= (TextView)itemView.findViewById(R.id.textViewEntregasDisco);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClic(getAdapterPosition());
                }
            });

        }
    }
}
