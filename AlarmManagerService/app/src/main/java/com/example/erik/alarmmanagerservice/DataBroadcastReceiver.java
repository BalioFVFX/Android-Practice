package com.example.erik.alarmmanagerservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DataBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentService = new Intent(context, DataService.class);
        context.startService(intentService);
        Toast.makeText(context, "Started the data processing service...", Toast.LENGTH_SHORT).show();
    }



}
