package com.example.network.daggernetwork;

import com.example.network.INetwork;
import com.example.network.NetworkImpl;
import com.example.network.models.Activity;
import com.google.gson.Gson;

import dagger.Component;
import okhttp3.OkHttpClient;

@NetworkScope
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    NetworkImpl<Activity> getNetwork();
    Gson getGson();
    OkHttpClient getOkHttpClient();
}
