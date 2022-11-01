package com.albertcode.eureka.pake;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


/**
 * Created by Eureka on 17/03/2021.
 */

public class AlarmReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 =new Intent(context,NotifiactionService.class);
        service1.setData(Uri.parse("custom://"+System.currentTimeMillis()));
        context.startService(service1);


    }
}
