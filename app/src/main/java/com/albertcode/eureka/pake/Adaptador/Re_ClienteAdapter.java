package com.albertcode.eureka.pake.Adaptador;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Eureka on 20/02/2021.
 */

public class Re_ClienteAdapter extends RecyclerView.Adapter<Re_ClienteAdapter.ViewHolder> {
    Context context;
    List<Cliente> clientes;
    private OnrecycleClickInterface onrecycleClickInterface;

    public Re_ClienteAdapter(Context context,List<Cliente> clientes, OnrecycleClickInterface onrecycleClickInterface){
        this.context= context;
        this.clientes= clientes;
        this.onrecycleClickInterface = onrecycleClickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_item,parent,false);
            ViewHolder viewHolder= new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.nombre.setText(clientes.get(position).getNombre());
        holder.diasemana.setText(Setdia(clientes.get(position).getDia()));


    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView diasemana;
        ImageView imageViewdelete;
        ImageView imageViewarchive;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre= (TextView)itemView.findViewById(R.id.nombre_recy);
            diasemana= (TextView)itemView.findViewById(R.id.textdia);
            imageViewdelete= (ImageView) itemView.findViewById(R.id.imageView3);
            imageViewarchive= (ImageView) itemView.findViewById(R.id.imageView2);


            imageViewdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClickDelete(getAdapterPosition());

                }
            });

            imageViewarchive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClickArchivar(getAdapterPosition());
                }
            });

        }
    }

    public String Setdia( int dia){
        String diasemana;

        switch (dia){
            case 1:
                diasemana = "Lunes";
                return diasemana;
            case 2:
                diasemana = "Martes";
                return diasemana;
            case 3:
                diasemana = "Miércoles";
                return diasemana;
            case 4:
                diasemana = "Jueves";
                return diasemana;
            case 5:
                diasemana = "Viernes";
                return diasemana;
            case 6:
                diasemana = "Sábado";
                return diasemana;
            case 7:
                diasemana = "Domingo";
                return diasemana;
            default:
                    diasemana= "bien";
                return diasemana;

        }



    }

}
