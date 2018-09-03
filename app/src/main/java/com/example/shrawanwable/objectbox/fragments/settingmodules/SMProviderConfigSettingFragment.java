package com.example.shrawanwable.objectbox.fragments.settingmodules;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.utils.Utils;

import static com.example.shrawanwable.objectbox.App.spm;

public class SMProviderConfigSettingFragment extends Fragment {
    RadioButton rbSMPCSFNetworkProvider;
    RadioButton rbSMPCSFGpsProvider;
    Context mCtx;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.sm_provider_config_setting_fragment, container, false);

        initViews(v);

        checkSelectedProviderStatus();

        rbSMPCSFGpsProvider.setOnClickListener(rb -> {
            spm.setPROVIDER(LocationManager.GPS_PROVIDER);
            Utils.showRestartServiceToast(mCtx);
        });

        rbSMPCSFNetworkProvider.setOnClickListener(rb -> {
            spm.setPROVIDER(LocationManager.NETWORK_PROVIDER);
            Utils.showRestartServiceToast(mCtx);
        });

        return v;
    }

    private void checkSelectedProviderStatus() {
        if (spm.getPROVIDER().equals(LocationManager.GPS_PROVIDER)) {
            rbSMPCSFGpsProvider.setChecked(true);
        } else if (spm.getPROVIDER().equals(LocationManager.NETWORK_PROVIDER)) {
            rbSMPCSFNetworkProvider.setChecked(true);
        }
    }

    private void initViews(View v) {
        rbSMPCSFNetworkProvider = v.findViewById(R.id.rbSMPCSFNetworkProvider);
        rbSMPCSFGpsProvider = v.findViewById(R.id.rbSMPCSFGpsProvider);
    }
}
