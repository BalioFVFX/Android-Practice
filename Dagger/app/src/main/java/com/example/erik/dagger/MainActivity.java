package com.example.erik.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.erik.dagger.dagger.component.DaggerMyApplicationComponent;
import com.example.erik.dagger.dagger.component.MyApplicationComponent;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplicationComponent component = DaggerMyApplicationComponent.builder().build();

        OkHttpClient okHttpClient = component.getOkHttpClient();
        OkHttpClient okHttpClient2 = component.getOkHttpClient();


        Log.d("First OKHTTP", okHttpClient.toString());
        Log.d("Second OKHTTP", okHttpClient2.toString());

        // D/First OKHTTP: okhttp3.OkHttpClient@ca28309
        // D/Second OKHTTP: okhttp3.OkHttpClient@ca28309
    }
}
