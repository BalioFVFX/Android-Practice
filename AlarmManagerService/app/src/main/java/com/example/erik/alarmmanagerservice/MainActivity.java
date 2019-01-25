package com.example.erik.alarmmanagerservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    UIBroadcastReceiverUpdater uiBroadcastReceiverUpdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.progressBar = findViewById(R.id.progress_horizontal_data);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, DataBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pendingIntent);
        Toast.makeText(getApplicationContext(), "Data processing will start in 5 seconds...", Toast.LENGTH_LONG).show();

        this.uiBroadcastReceiverUpdater = new UIBroadcastReceiverUpdater();
        registerReceiver(uiBroadcastReceiverUpdater, new IntentFilter("update_progress"));
    }


    private class UIBroadcastReceiverUpdater extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int dataProgress = intent.getIntExtra("progress", 0);
            progressBar.setProgress(dataProgress);
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(uiBroadcastReceiverUpdater);
        super.onDestroy();
    }
}
