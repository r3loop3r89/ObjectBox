package com.example.shrawanwable.objectbox.fragments.settingmodules;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.shrawanwable.objectbox.R;

import static com.example.shrawanwable.objectbox.App.spm;

public class SMAutostartSettingFragment extends Fragment {
    Context mCtx;
    CheckBox cbSMASFAutostart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.sm_autostart_setting_fragment, container, false);

        initViews(v);

        cbSMASFAutostart.setChecked(spm.getAUTOSTART());

        cbSMASFAutostart.setOnClickListener(cb -> {
            CheckBox c = (CheckBox) cb;
            if (c.isChecked()) {
                spm.setAUTOSTART(true);
            } else {
                spm.setAUTOSTART(false);
            }
        });

        return v;
    }

    private void initViews(View v) {
        cbSMASFAutostart = v.findViewById(R.id.cbSMASFAutostart);
    }
}
