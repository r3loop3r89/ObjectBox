package com.example.shrawanwable.objectbox.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.adapters.SettingsModulesRVAdapter;
import com.example.shrawanwable.objectbox.fragments.settingmodules.SMAutostartSettingFragment;
import com.example.shrawanwable.objectbox.fragments.settingmodules.SMBGServiceSettingFragment;
import com.example.shrawanwable.objectbox.fragments.settingmodules.SMDataSaveIntervalConfigSettingFragment;
import com.example.shrawanwable.objectbox.fragments.settingmodules.SMProviderConfigSettingFragment;
import com.example.shrawanwable.objectbox.models.SettingModule;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    private static SettingsFragment INSTANCE = null;
    RecyclerView rvSFSettingsModules;
    Context mCtx;

    public static SettingsFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();

        View v = inflater.inflate(R.layout.settings_fragment, container, false);

        initViews(v);

        List<SettingModule> settingModules = new ArrayList<>();
        settingModules.add(new SettingModule(new SMAutostartSettingFragment()));
        settingModules.add(new SettingModule(new SMBGServiceSettingFragment()));
        settingModules.add(new SettingModule(new SMProviderConfigSettingFragment()));
        settingModules.add(new SettingModule(new SMDataSaveIntervalConfigSettingFragment()));

        SettingsModulesRVAdapter adapter = new SettingsModulesRVAdapter(settingModules, getFragmentManager(), mCtx);
        rvSFSettingsModules.setAdapter(adapter);

        return v;
    }

    private void initViews(View v) {
        rvSFSettingsModules = v.findViewById(R.id.rvSFSettingsModules);
        rvSFSettingsModules.setLayoutManager(new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false));
    }
}
