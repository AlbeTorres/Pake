package com.albertcode.eureka.pake.Adaptador;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertcode.eureka.pake.Interfaces.OnrecycleClickInterface;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Eureka on 26/02/2021.
 */

public class Recliente_frameadapter extends RecyclerView.Adapter<Recliente_frameadapter.ViewHolder>{
    Context context;
    List<Cliente> clientes;
    private OnrecycleClickInterface onrecycleClickInterface;

    public Recliente_frameadapter(Context context,List<Cliente> clientes, OnrecycleClickInterface onrecycleClickInterface){
        this.context= context;
        this.clientes= clientes;
        this.onrecycleClickInterface = onrecycleClickInterface;
    }

    @Override
    public Recliente_frameadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clientefragment_item,parent,false);
        Recliente_frameadapter.ViewHolder viewHolder= new Recliente_frameadapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Recliente_frameadapter.ViewHolder holder, final int position) {
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
        ImageButton imageViewedit;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre= (TextView)itemView.findViewById(R.id.nombre_cliente);
            diasemana= (TextView)itemView.findViewById(R.id.textdiacliente);
            imageViewdelete= (ImageView) itemView.findViewById(R.id.imagedeletecliente);
            imageViewedit= (ImageButton) itemView.findViewById(R.id.imageeditcliente);





            imageViewdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClickDelete(getAdapterPosition());

                }
            });

            imageViewedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClickArchivar(getAdapterPosition());

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onrecycleClickInterface.OnItemClic(getAdapterPosition());

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
