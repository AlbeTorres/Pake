package com.albertcode.eureka.pake.Database;

/**
 * Created by Eureka on 03/03/2021.
 */

public class Constants {


        public static final String DATABASE_NAME = "pake.db";
        public static final int DATABASE_VERSION = 1;

        public static final String TABLE_CLIENTE = "cliente";
        public static final String TABLE_DISCO = "disco";
        public static final String TABLE_ENTREGA = "entrega";

        //columnas tabla cliente

        public static final String ID_CLIENTE = "id_cliente";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String DIA_C = "dia";
        public static final String MES_C = "mes";
        public static final String ANO_C = "ano";
        public static final String DIA_ENTREGAR = "dia_entregar";
        public static final String INGRESO = "ingreso";
        public static final String ESTADO = "estado";

        //columnas tabla disco

        public static final String ID_DISCO = "id_disco";
        public static final String NOMBRE_DISCO = "nombre";
        public static final String VIDA = "vida";
        public static final String DIA_D = "dia";
        public static final String MES_D= "mes";
        public static final String ANO_D = "ano";
        public static final String ENTREGAS = "entregas";
        public static final String ESTADO_DISCO = "estado";

        //columnas tabla ENTREGA

        public static final String ID_ENTREGA = "id_entrega";
        public static final String ENTREGA_ID_CLIENTE = "id_cliente";
        public static final String ENTREGA_ID_DISCO = "id_disco";
        public static final String DIA_E = "dia";
        public static final String MES_E = "mes";
        public static final String ANO_E = "ano";
        public static final String HORA_ENTREGA = "hora_entrega";
        public static final String MIN_ENTREGA = "minuto_entrega";
        public static final String SEC_ENTREGA = "segundo_entrega";
        public static final String HORA_RECOGIDA = "hora_recogida";
        public static final String MIN_RECOGIDA = "minuto_recogida";
        public static final String SEC_RECOGIDA = "segundo_recogida";
        public static final String ESTADO_ENTREGA = "estado";
        public static final String NOMBRE_CLIENTE = "nombre_cliente";
        public static final String NOMBRE_DISCO_ENTREGA = "nombre_disco";
        public static final String INGRESO_ENTREGA = "ingreso";





}
