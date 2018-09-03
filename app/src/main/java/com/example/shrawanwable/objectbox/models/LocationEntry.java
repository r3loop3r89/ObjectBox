package com.example.shrawanwable.objectbox.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LocationEntry {
    @Id
    long leid;
    double latitude;
    double longitude;
    long entryOnEpoch;
    int batteryLevel;

    public long getLeid() {
        return leid;
    }

    public void setLeid(long leid) {
        this.leid = leid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getEntryOnEpoch() {
        return entryOnEpoch;
    }

    public void setEntryOnEpoch(long entryOnEpoch) {
        this.entryOnEpoch = entryOnEpoch;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public LocationEntry(double latitude, double longitude, long entryOnEpoch, int batteryLevel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.entryOnEpoch = entryOnEpoch;
        this.batteryLevel = batteryLevel;
    }

    public LocationEntry() {

    }
}
