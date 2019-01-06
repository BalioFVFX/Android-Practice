package com.example.erik.broadcasts;

import android.app.ApplicationErrorReport;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class MySuperBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra(BatteryManager.EXTRA_LEVEL)) {
            Integer level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            Log.d("INFO", level + " %");
           Toast.makeText(context, "Battery level: " + level.toString() + "%", Toast.LENGTH_SHORT).show();
        }

    }


}
