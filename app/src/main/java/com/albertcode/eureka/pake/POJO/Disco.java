package com.albertcode.eureka.pake.POJO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Eureka on 20/02/2021.
 */

public class Disco implements Serializable {
    int id;
    String nombre;
    int vida;
    Calendar fecha;
    int entregas;
    int estado;

    public Disco (int id,String nombre,int vida,Calendar fecha,int entregas, int estado){
        this.id= id;
        this.nombre= nombre;
        this.vida= vida;
        this.fecha= fecha;
        this.entregas =entregas;
        this.estado=estado;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getEntregas() {
        return entregas;
    }

    public void setEntregas(int entregas) {
        this.entregas = entregas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
