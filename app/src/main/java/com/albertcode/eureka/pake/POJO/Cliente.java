package com.albertcode.eureka.pake.POJO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Comparator;

/**
 * Created by Eureka on 20/02/2021.
 */

public class Cliente implements Serializable  {
    private int id;
    private String nombre;
    private String telefono;
    private Calendar fecha;
    private int dia;
    private int ingreso;
    private int estado;

    public Cliente (int id,String nombre, String telefono, Calendar fecha, int dia, int estado, int ingreso){
        this.id = id;
        this.nombre= nombre;
        this.telefono= telefono;
        this. fecha= fecha;
        this.dia= dia;
        this.ingreso= ingreso;
        this.estado= estado;
    }

    public Cliente (int id,String nombre, Calendar fecha, int dia,int estado, int ingreso){
        this.id = id;
        this.nombre= nombre;
        this. fecha= fecha;
        this.dia= dia;
        this.estado= estado;
        this.ingreso=ingreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }




}
