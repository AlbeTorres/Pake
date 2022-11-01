package com.albertcode.eureka.pake;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.view.MenuItem;

import com.albertcode.eureka.pake.Interfaces.Enviar_Datos;
import com.albertcode.eureka.pake.POJO.Cliente;
import com.albertcode.eureka.pake.POJO.Disco;
import com.albertcode.eureka.pake.fragments.Clientes;
import com.albertcode.eureka.pake.fragments.Contenedor;
import com.albertcode.eureka.pake.fragments.Discos;
import com.albertcode.eureka.pake.fragments.Fondos;
import com.albertcode.eureka.pake.fragments.Modificar_Disco;
import com.albertcode.eureka.pake.fragments.Pendientes;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements Enviar_Datos {

    BottomNavigationView bottomNavigationView;
    Disco disco1;
    Cliente cliente1;
    Fragment fragment;
    int alarmID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView= (BottomNavigationView)findViewById(R.id.bottonmenu);
        setDefaultFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.entregasItem) {
                fragment= new Contenedor();
                changeFragment(fragment);
            } else if (item.getItemId() == R.id.clientesItem) {
                fragment= new Clientes();
                changeFragment(fragment);

            }else if (item.getItemId() == R.id.discoItem) {
                fragment= new Discos();
                changeFragment(fragment);

            }

            return false;
        }
    });
    }






    private static void SetAlarm(int i,long timestamp, Context context){

        AlarmManager alarmManager= (AlarmManager)context.getSystemService(ALARM_SERVICE);
        Intent alarmIntem =new Intent(context,AlarmReciver.class);
        PendingIntent pendingIntent;
        pendingIntent= PendingIntent.getBroadcast(context,i,alarmIntem,PendingIntent.FLAG_ONE_SHOT);
        alarmIntem.setData(Uri.parse("custom://"+System.currentTimeMillis()));
        alarmManager.set(AlarmManager.RTC,timestamp,pendingIntent);


    }


    private void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame,fragment)
                .commit();
    }

    private void setDefaultFragment(){
        changeFragment(new Contenedor());

    }

    @Override
    public void EnviarCliente(Cliente cliente) {
        cliente1=cliente;


    }

    @Override
    public Cliente RecibirCliente() {
        return cliente1;
    }

    @Override
    public void EnviarDisco(Disco disco) {
        disco1=disco;

    }

    @Override
    public Disco RecibirDisco() {
        return disco1;
    }

    @Override
    public void ActivarAlarma(Calendar calendar) {
        SetAlarm(alarmID,calendar.getTimeInMillis(),MainActivity.this);
    }
}
