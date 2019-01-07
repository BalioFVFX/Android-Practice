package com.example.erik.locationmanager.dagger;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;

import com.example.erik.locationmanager.MainActivity;
import com.example.erik.locationmanager.MySuperLocationManager;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationModule {

    private final Activity activity;
    private Context context;

    public LocationModule(Activity activity, Context context){
        this.activity = activity;
        this.context = context;
    }


    @LocationScope
    @Provides
    LocationManager locationManager(){
        return (LocationManager)this.context.getSystemService(Context.LOCATION_SERVICE);
    }

    @LocationScope
    @Provides
    MySuperLocationManager mySuperLocationManager(LocationManager locationManager){
        return new MySuperLocationManager(activity, locationManager);
    }
}
