package com.example.shrawanwable.objectbox.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.models.SettingModule;

import java.util.List;

public class SettingsModulesRVAdapter extends RecyclerView.Adapter<SettingsModulesRVAdapter.SMRVAViewHolder> {

    List<SettingModule> settingModules;

    FragmentManager fragmentManager;

    Context mCtx;

    public SettingsModulesRVAdapter(List<SettingModule> settingModules, FragmentManager fragmentManager, Context mCtx) {
        this.settingModules = settingModules;
        this.fragmentManager = fragmentManager;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public SMRVAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.smrv_item_layout, parent, false);
        return new SMRVAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SMRVAViewHolder h, int position) {
        SettingModule s = settingModules.get(position);
        int containerId = h.flSMRVILFragmentContainer.getId();
        Fragment oldFragment = fragmentManager.findFragmentById(containerId);
        if(oldFragment != null) {
            fragmentManager.beginTransaction().remove(oldFragment).commit();
        }
        int newContainerId = GetUniqueID();// My method
        h.flSMRVILFragmentContainer.setId(newContainerId);// Set container id
        fragmentManager.beginTransaction().replace(newContainerId, s.getFragment()).commit();
    }


    public int GetUniqueID() {
        return 111 + (int) (Math.random() * 9999);
    }

    @Override
    public int getItemCount() {
        return settingModules.size();
    }

    class SMRVAViewHolder extends RecyclerView.ViewHolder {
        FrameLayout flSMRVILFragmentContainer;
        public SMRVAViewHolder(View v) {
            super(v);
            flSMRVILFragmentContainer = v.findViewById(R.id.flSMRVILFragmentContainer);
        }
    }
}
