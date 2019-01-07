package com.example.erik.locationmanager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.erik.locationmanager.dagger.DaggerMainComponent;
import com.example.erik.locationmanager.dagger.LocationModule;
import com.example.erik.locationmanager.dagger.MainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

    private TextView latitudeTextView;
    private TextView longitudeTextView;

    @Inject
    MySuperLocationManager mySuperLocationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.latitudeTextView = findViewById(R.id.tv_latitude);
        this.longitudeTextView = findViewById(R.id.tv_longitude);


        MainComponent daggerMainComponent = DaggerMainComponent.builder().locationModule(new LocationModule(this, getApplicationContext())).build();
        daggerMainComponent.inject(this);

        this.mySuperLocationManager.askForPermission(new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitudeTextView.setText("Latitude: " + location.getLatitude());
                longitudeTextView.setText("Longitude: " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });


    }

}
