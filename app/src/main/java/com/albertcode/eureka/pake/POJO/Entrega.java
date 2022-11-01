package com.albertcode.eureka.pake.POJO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;

/**
 * Created by Eureka on 20/02/2021.
 */

public class Entrega implements Serializable {

    int id;
    int id_cliente;
    int id_disco;
    String nombre_cliente;
    String nombre_disco;
    Calendar fecha;
    Calendar hora_recogida;
    int estado;
    int ingreso;

    public Entrega ( int id, int id_cliente, int id_disco, String nombre_cliente,  String nombre_disco,Calendar fecha, Calendar hora_recogida, int estado, int ingreso){
        this.id = id;
        this.id_cliente= id_cliente;
        this.id_disco= id_disco;
        this.fecha= fecha;
        this.hora_recogida = hora_recogida;
        this.estado = estado;
        this.ingreso= ingreso;
        this.nombre_cliente= nombre_cliente;
        this.nombre_disco= nombre_disco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora_recogida() {
        return hora_recogida;
    }

    public void setHora_recogida(Calendar hora_recogida) {
        this.hora_recogida = hora_recogida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_disco() {
        return nombre_disco;
    }

    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
    }
}
