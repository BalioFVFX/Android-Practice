package com.example.erik.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST = "PACKAGE_NAME.android.action.broadcast";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySuperBroadcastReceiver mySuperBroadcastReceiver = new MySuperBroadcastReceiver();
        registerReceiver(mySuperBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
}
