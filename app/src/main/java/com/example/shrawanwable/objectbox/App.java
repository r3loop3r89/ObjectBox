package com.example.shrawanwable.objectbox;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.shrawanwable.objectbox.utils.SharedPreferenceManager;

public class App extends Application {
    public static SharedPreferenceManager spm;

    @Override
    public void onCreate() {
        super.onCreate();
        spm = SharedPreferenceManager.getInstance(this);
        Utils.init(this);
    }
}
