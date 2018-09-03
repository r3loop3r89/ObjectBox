package com.example.shrawanwable.objectbox.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;

public class SharedPreferenceManager {
    private static SharedPreferenceManager INSTANCE = null;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private SharedPreferenceManager(Context mCtx) {
        sharedPreferences = mCtx.getSharedPreferences("shra2", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferenceManager getInstance(Context mCtx) {
        if (INSTANCE == null) {
            INSTANCE = new SharedPreferenceManager(mCtx);
        }
        return INSTANCE;
    }

    public boolean getAUTOSTART() {
        return sharedPreferences.getBoolean("AUTOSTART", false);
    }

    public void setAUTOSTART(boolean b) {
        editor.putBoolean("AUTOSTART", b);
        editor.commit();
    }

    public String getPROVIDER() {
        return sharedPreferences.getString("PROVIDER", LocationManager.NETWORK_PROVIDER);
    }

    public void setPROVIDER(String PROVIDER) {
        editor.putString("PROVIDER", PROVIDER);
        editor.commit();
    }

    public long getPERIOD() {
        return sharedPreferences.getLong("PERIOD", 2);
    }

    public void setPERIOD(long PERIOD) {
        editor.putLong("PERIOD", PERIOD);
        editor.commit();
    }

    public void setSELECTEDTIMEUNITPOSITION(int SELECTEDTIMEUNITPOSITION) {
        editor.putInt("SELECTEDTIMEUNITPOSITION", SELECTEDTIMEUNITPOSITION);
        editor.commit();
    }

    public  int getSELECTEDTIMEUNITPOSITION(){
        return sharedPreferences.getInt("SELECTEDTIMEUNITPOSITION", 0);
    }
}
