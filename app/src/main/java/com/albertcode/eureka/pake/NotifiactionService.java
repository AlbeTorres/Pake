package com.albertcode.eureka.pake;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


/**
 * Created by Eureka on 17/03/2021.
 */

public class NotifiactionService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */


    NotificationManager notificationManager;
    PendingIntent pendingIntent;
    int notification_id=1;
    Notification notification;

    public NotifiactionService(String name) {
        super(name);
    }

    public NotifiactionService() {
        super("SERVICE");
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        String notificacion_chanel=getApplicationContext().getString(R.string.app_name);
        Context context = this.getApplicationContext();
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent nintent = new Intent(this,MainActivity.class);
        Resources res= this.getResources();
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        String mesage="Recoge el disco";

        if (Build.VERSION.SDK_INT >= 26){

            final int notifi_id =0;
            String id= notificacion_chanel;
            String title = notificacion_chanel;
            PendingIntent pendingIntent;
            NotificationCompat.Builder builder;
            int importance = NotificationManager.IMPORTANCE_HIGH;








        }


    }
}
