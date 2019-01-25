package com.example.network.daggernetwork;

import com.example.network.INetwork;
import com.example.network.NetworkImpl;
import com.example.network.models.Activity;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {

    @NetworkScope
    @Provides
    NetworkImpl<Activity> getNetwork(){
        return new NetworkImpl<Activity>("");
    }

    @NetworkScope
    @Provides
    Gson getGson(){
        return new Gson();
    }

    @NetworkScope
    @Provides
    OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }
}
