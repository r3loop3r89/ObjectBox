package com.example.shrawanwable.objectbox.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.shrawanwable.objectbox.models.LocationEntry;
import com.example.shrawanwable.objectbox.models.SelectableTimeUnit;
import com.example.shrawanwable.objectbox.recievers.AutoStartReciever;
import com.example.shrawanwable.objectbox.utils.Utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.example.shrawanwable.objectbox.App.locationEntryBox;
import static com.example.shrawanwable.objectbox.App.spm;
import static com.example.shrawanwable.objectbox.utils.Utils.TAG;

public class BgService extends Service {
    private static BgService IN = null;
    Context mCtx;
    Location currentLocation = null;
    LocationManager locationManager;
    LocationListener ll = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            currentLocation = location;
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
    };
    ScheduledExecutorService scheduledExecutorService;

    public static BgService getInstance() {
        return IN;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IN = this;
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart: ");
    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        mCtx = getApplicationContext();
        locationManager = (LocationManager) mCtx.getSystemService(LOCATION_SERVICE);

        locationManager.requestLocationUpdates(
                spm.getPROVIDER(), 0L, 0F,
                ll
        );

        scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(
                () -> {
                    if (currentLocation != null) {
                        int batteryLevel = Utils.getBatteryPercentage(mCtx);
                        LocationEntry locationEntry = new LocationEntry(
                                currentLocation.getLatitude(),
                                currentLocation.getLongitude(),
                                System.currentTimeMillis(),
                                batteryLevel
                        );

                        locationEntryBox.put(locationEntry);
                    }
                }
                , 0L,
                spm.getPERIOD(),
                SelectableTimeUnit.getList().get(spm.getSELECTEDTIMEUNITPOSITION()).getTimeUnit()
        );

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            locationManager.removeUpdates(ll);
        }
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                scheduledExecutorService.shutdown();
            }
        }
        IN = null;
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d(TAG, "onTrimMemory: ");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, "onTaskRemoved: ");
    }
}
