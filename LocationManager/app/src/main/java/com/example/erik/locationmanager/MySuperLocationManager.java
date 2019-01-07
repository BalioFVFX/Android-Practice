package com.example.erik.locationmanager;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import static android.content.Context.LOCATION_SERVICE;

public class MySuperLocationManager {

    Activity activityContext;

    LocationManager locationManager;

    public MySuperLocationManager(Activity activityContext, LocationManager locationManager) {
        this.activityContext = activityContext;
        this.locationManager = locationManager;
    }



    public void askForPermission(LocationListener locationListener){
        if (ActivityCompat.checkSelfPermission(activityContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activityContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(activityContext, "WE NEED PERMISSION!", Toast.LENGTH_SHORT).show();
            if(Build.VERSION.SDK_INT >= 23){
                activityContext.requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, locationListener);
    }


}
