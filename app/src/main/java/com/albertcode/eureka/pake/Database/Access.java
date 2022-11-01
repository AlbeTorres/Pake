package com.albertcode.eureka.pake.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.POJO.Entrega;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Eureka on 20/02/2021.
 */

public class Access {
    private Context context;


    public Access(Context context){
        this.context = context;


    }

    public void Caragardatosdiscos(List<Disco> discos){
        discos.clear();

        Database db= new Database(context);

        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_DISCO ,null);

        if( cur.moveToFirst()){

            /*cur != null*/
            do{

                Calendar d= new GregorianCalendar();
                d.set(Calendar.DAY_OF_MONTH,cur.getInt(3));
                d.set(Calendar.MONTH,cur.getInt(4));
                d.set(Calendar.YEAR, cur.getInt(5));

                discos.add( new Disco(cur.getInt(0),
                            cur.getString(1),cur.getInt(2),
                            d, cur.getInt(6),cur.getInt(7)));

                } while(cur.moveToNext());
            }

        }

    public void Caragardatosclientes(List<Cliente> clientes){

        clientes.clear();

        Database db= new Database(context);

        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_CLIENTE ,null);

        if( cur.moveToFirst()){

            /*cur != null*/
            do{
                Calendar c= new GregorianCalendar();
                c.set(Calendar.DAY_OF_MONTH,cur.getInt(3));
                c.set(Calendar.MONTH,cur.getInt(4));
                c.set(Calendar.YEAR, cur.getInt(5));

                clientes.add( new Cliente(cur.getInt(0), cur.getString(1), cur.getString(2),c, cur.getInt(6), cur.getInt(7), cur.getInt(8)));

            } while(cur.moveToNext());
        }



    }

    public void CargarEntregas(List<Entrega> entregas){

        entregas.clear();

        Database db= new Database(context);

        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_ENTREGA ,null);

        if( cur.moveToFirst()){

            /*cur != null*/
            do{
                Calendar e= new GregorianCalendar();
                e.set(Calendar.DAY_OF_MONTH,cur.getInt(5));
                e.set(Calendar.MONTH,cur.getInt(6));
                e.set(Calendar.YEAR,cur.getInt(7));
                e.set(Calendar.HOUR,cur.getInt(8));
                e.set(Calendar.MINUTE,cur.getInt(9));
                e.set(Calendar.SECOND,cur.getInt(10));

                Calendar f= new GregorianCalendar();
                f.set(Calendar.DAY_OF_MONTH,cur.getInt(5));
                f.set(Calendar.MONTH,cur.getInt(6));
                f.set(Calendar.YEAR,cur.getInt(7));
                f.set(Calendar.HOUR,cur.getInt(11));
                f.set(Calendar.MINUTE,cur.getInt(12));
                f.set(Calendar.SECOND,cur.getInt(13));

                entregas.add( new Entrega(cur.getInt(0),cur.getInt(1),cur.getInt(2),cur.getString(3), cur.getString(4), e, f, cur.getInt(14), cur.getInt(15)));

            } while(cur.moveToNext());
        }




    }


    public long InsertarDisco(Disco disco){

        Database db= new Database(context);

        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE_DISCO,disco.getNombre());
        contentValues.put(Constants.VIDA,disco.getVida());
        contentValues.put(Constants.DIA_D,disco.getFecha().get(Calendar.DAY_OF_MONTH));
        contentValues.put(Constants.MES_D,disco.getFecha().get(Calendar.MONTH));
        contentValues.put(Constants.ANO_D,disco.getFecha().get(Calendar.YEAR));
        contentValues.put(Constants.ENTREGAS,disco.getEntregas());
        contentValues.put(Constants.ESTADO_DISCO,disco.getEstado());

        long resul= database.insert(Constants.TABLE_DISCO,null,contentValues);

        database.close();

        return resul;

    }

    public long InsertarCliente(Cliente cliente){

        Database db= new Database(context);

        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE,cliente.getNombre());
        contentValues.put(Constants.TELEFONO,cliente.getTelefono());
        contentValues.put(Constants.DIA_C,cliente.getFecha().get(Calendar.DAY_OF_MONTH));
        contentValues.put(Constants.MES_C,cliente.getFecha().get(Calendar.MONTH));
        contentValues.put(Constants.ANO_C,cliente.getFecha().get(Calendar.YEAR));
        contentValues.put(Constants.DIA_ENTREGAR,cliente.getDia());
        contentValues.put(Constants.ESTADO,cliente.getEstado());
        contentValues.put(Constants.INGRESO,cliente.getIngreso());

        long resul= database.insert(Constants.TABLE_CLIENTE,null,contentValues);

        database.close();

        return resul;

    }

    public long InsertarEntrega(Entrega entrega){

        Database db= new Database(context);

        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.ID_CLIENTE,entrega.getId_cliente());
        contentValues.put(Constants.ID_DISCO,entrega.getId_disco());
        contentValues.put(Constants.NOMBRE_CLIENTE,entrega.getNombre_cliente());
        contentValues.put(Constants.NOMBRE_DISCO_ENTREGA,entrega.getNombre_disco());
        contentValues.put(Constants.DIA_E,entrega.getFecha().get(Calendar.DAY_OF_MONTH));
        contentValues.put(Constants.MES_E,entrega.getFecha().get(Calendar.MONTH));
        contentValues.put(Constants.ANO_E,entrega.getFecha().get(Calendar.YEAR));
        contentValues.put(Constants.HORA_ENTREGA,entrega.getFecha().get(Calendar.HOUR));
        contentValues.put(Constants.MIN_ENTREGA,entrega.getFecha().get(Calendar.MINUTE));
        contentValues.put(Constants.SEC_ENTREGA,entrega.getFecha().get(Calendar.SECOND));
        contentValues.put(Constants.HORA_RECOGIDA,entrega.getHora_recogida().get(Calendar.HOUR));
        contentValues.put(Constants.MIN_RECOGIDA,entrega.getHora_recogida().get(Calendar.MINUTE));
        contentValues.put(Constants.SEC_RECOGIDA,entrega.getHora_recogida().get(Calendar.SECOND));
        contentValues.put(Constants.ESTADO_ENTREGA,entrega.getEstado());
        contentValues.put(Constants.INGRESO_ENTREGA,entrega.getIngreso());


        long resul= database.insert(Constants.TABLE_ENTREGA,null,contentValues);

        database.close();

        return resul;

    }


    public long EliminarDatosDiscos(Integer id){
        Database db= new Database(context);
        SQLiteDatabase database = db.getWritableDatabase();

        long result = database.delete(Constants.TABLE_DISCO , Constants.ID_DISCO + "=" + id,null);

        return result;
    }

    public long EliminarDatosClientes(Integer id){
        Database db= new Database(context);
        SQLiteDatabase database = db.getWritableDatabase();

        long result = database.delete(Constants.TABLE_CLIENTE , Constants.ID_CLIENTE + "=" + id,null);

        return result;
    }

    public long EliminarDatosEntregas(Integer id){
        Database db= new Database(context);
        SQLiteDatabase database = db.getWritableDatabase();

        long result = database.delete(Constants.TABLE_ENTREGA , Constants.ID_ENTREGA + "=" + id,null);

        return result;
    }


    public long ModificarDatosDisco(Disco disco, Integer id){

        Database db= new Database(context);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE_DISCO,disco.getNombre());
        contentValues.put(Constants.VIDA,disco.getVida());
        contentValues.put(Constants.DIA_D,disco.getFecha().get(Calendar.DAY_OF_MONTH));
        contentValues.put(Constants.MES_D,disco.getFecha().get(Calendar.MONTH));
        contentValues.put(Constants.ANO_D,disco.getFecha().get(Calendar.YEAR));
        contentValues.put(Constants.ENTREGAS,disco.getEntregas());
        contentValues.put(Constants.ESTADO_DISCO,disco.getEstado());

        long result = database.update( Constants.TABLE_DISCO, contentValues, Constants.ID_DISCO + "=" + id,null);
        database.close();
        return result;
    }

    public long ModificarDatosCliente(Cliente cliente, Integer id){

        Database db= new Database(context);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE,cliente.getNombre());
        contentValues.put(Constants.TELEFONO,cliente.getTelefono());
        contentValues.put(Constants.DIA_C,cliente.getFecha().get(Calendar.DAY_OF_MONTH));
        contentValues.put(Constants.MES_C,cliente.getFecha().get(Calendar.MONTH));
        contentValues.put(Constants.ANO_C,cliente.getFecha().get(Calendar.YEAR));
        contentValues.put(Constants.DIA_ENTREGAR,cliente.getDia());
        contentValues.put(Constants.ESTADO,cliente.getEstado());
        contentValues.put(Constants.INGRESO,cliente.getIngreso());

        long result = database.update( Constants.TABLE_CLIENTE, contentValues, Constants.ID_CLIENTE + "=" + id,null);
        database.close();
        return result;
    }




}
