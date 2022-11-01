package com.albertcode.eureka.pake.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eureka on 03/03/2021.
 */

public class Database extends SQLiteOpenHelper {

    Context context;


    public Database(Context context)  {
        super(context, Constants.DATABASE_NAME,null, Constants.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaCliente= "CREATE TABLE "+ Constants.TABLE_CLIENTE + "("+
                Constants.ID_CLIENTE        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.NOMBRE    + " TEXT, " +
                Constants.TELEFONO + " TEXT, " +
                Constants.DIA_C + " INTEGER, " +
                Constants.MES_C      + " INTEGER, " +
                Constants.ANO_C      + " INTEGER, " +
                Constants.DIA_ENTREGAR     + " INTEGER, " +
                Constants.ESTADO     + " INTEGER, " +
                Constants.INGRESO     + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaCliente);



        String queryCrearTablaDisco= "CREATE TABLE "+ Constants.TABLE_DISCO + "("+
                Constants.ID_DISCO        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.NOMBRE_DISCO    + " TEXT, " +
                Constants.VIDA + " INTEGER, " +
                Constants.DIA_D + " INTEGER, " +
                Constants.MES_D     + " INTEGER, " +
                Constants.ANO_D     + " INTEGER, " +
                Constants.ENTREGAS      + " INTEGER, " +
                Constants.ESTADO_DISCO     + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaDisco);


        String queryCrearTablaEntregas= "CREATE TABLE "+ Constants.TABLE_ENTREGA + "("+
                Constants.ID_ENTREGA        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.ENTREGA_ID_CLIENTE    + " INTEGER, " +
                Constants.ENTREGA_ID_DISCO    + " INTEGER, " +
                Constants.NOMBRE_CLIENTE + " TEXT, " +
                Constants.NOMBRE_DISCO_ENTREGA + " TEXT, " +
                Constants.DIA_E + " INTEGER, " +
                Constants.MES_E     + " INTEGER, " +
                Constants.ANO_E      + " INTEGER, " +
                Constants.HORA_ENTREGA + " INTEGER, " +
                Constants.MIN_ENTREGA + " INTEGER, " +
                Constants.SEC_ENTREGA + " INTEGER, " +
                Constants.HORA_RECOGIDA + " INTEGER, " +
                Constants.MIN_RECOGIDA + " INTEGER, " +
                Constants.SEC_RECOGIDA + " INTEGER, " +
                Constants.ESTADO_ENTREGA     + " INTEGER," +
                Constants.INGRESO_ENTREGA      + " INTEGER " +

                ")";

        db.execSQL(queryCrearTablaEntregas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_DISCO);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_ENTREGA);

    }
}
