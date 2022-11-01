package com.albertcode.eureka.pake.Adaptador;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Entrega;
import com.albertcode.eureka.pake.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Eureka on 22/02/2021.
 */

public class Re_CopiandoAdapter extends RecyclerView.Adapter <Re_CopiandoAdapter.ViewHolder>{
    Context context;
    List<Entrega> entregas;
    private OnrecycleClickInterface onrecycleClickInterface;


    public  Re_CopiandoAdapter(Context context, List<Entrega> entregas, OnrecycleClickInterface onrecycleClickInterface){
        this.context= context;
        this.entregas= entregas;
        this.onrecycleClickInterface= onrecycleClickInterface;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.copiando_item,parent,false);
        Re_CopiandoAdapter.ViewHolder viewHolder= new Re_CopiandoAdapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(entregas.get(position).getNombre_cliente());
        holder.nomdisco.setText(entregas.get(position).getNombre_disco());

    }

    @Override
    public int getItemCount() {
        return entregas.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        ImageView imageViewok;
        TextView nomdisco;


        public ViewHolder(View itemView) {
            super(itemView);

            nombre= (TextView)itemView.findViewById(R.id.copiando_recy);
            imageViewok= (ImageView) itemView.findViewById(R.id.imagecopaindook);
            nomdisco= (TextView)itemView.findViewById(R.id.textcopiando);

            imageViewok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClickDelete(getAdapterPosition());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClic(getAdapterPosition());

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    onrecycleClickInterface.OnItemLongClick(getAdapterPosition());
                    return true;
                }
            });

        }
    }



}
