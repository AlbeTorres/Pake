package com.albertcode.eureka.pake.Interfaces;

import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Disco;

import java.util.Calendar;

/**
 * Created by Eureka on 10/03/2021.
 */

public interface Enviar_Datos {

    void EnviarCliente(Cliente cliente);
    Cliente RecibirCliente();
    void EnviarDisco(Disco disco);
    Disco RecibirDisco();
    void ActivarAlarma(Calendar calendar);
}
