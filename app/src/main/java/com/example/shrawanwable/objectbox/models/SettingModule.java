package com.example.shrawanwable.objectbox.models;

import android.support.v4.app.Fragment;

public class SettingModule {
    Fragment fragment;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public SettingModule(Fragment fragment) {

        this.fragment = fragment;
    }

    public SettingModule() {

    }
}
