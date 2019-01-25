package com.example.erik.alarmmanagerservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class DataService extends IntentService {


    public DataService(){
        super("default");
    }
    public DataService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent progressIntent = new Intent("update_progress");


        for (int i = 1; i <= 100; i++) {
            progressIntent.putExtra("progress", i);
            sendBroadcast(progressIntent);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Data processing finished successfully!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
