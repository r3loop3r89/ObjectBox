package com.example.shrawanwable.objectbox;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.shrawanwable.objectbox.models.LocationEntry;
import com.example.shrawanwable.objectbox.models.MyObjectBox;
import com.example.shrawanwable.objectbox.utils.SharedPreferenceManager;
import com.mapbox.mapboxsdk.Mapbox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {
    public static SharedPreferenceManager spm;
    public static Box<LocationEntry> locationEntryBox;
    public static String DATEFORMAT;
    BoxStore boxStore;


    @Override
    public void onCreate() {
        super.onCreate();
        spm = SharedPreferenceManager.getInstance(this);
        Utils.init(this);

        boxStore = MyObjectBox.builder().androidContext(this).build();

        locationEntryBox = boxStore.boxFor(LocationEntry.class);

        DATEFORMAT = getResources().getString(R.string.date_format);

        Mapbox.getInstance(this, "pk.eyJ1Ijoic2hyYW9uZSIsImEiOiJjajV4N2M2NXcwMWY1Mndxc3Ewb3dkNWRzIn0.dOL3KOiPib89uF_fSFhYnA");

    }

}
