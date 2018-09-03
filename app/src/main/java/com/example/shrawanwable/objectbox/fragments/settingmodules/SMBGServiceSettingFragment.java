package com.example.shrawanwable.objectbox.fragments.settingmodules;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.services.BgService;
import com.example.shrawanwable.objectbox.utils.Utils;

public class SMBGServiceSettingFragment extends Fragment {

    TextView tvSMBGSSFStatus;
    Button bSMBGSSFStartService;
    Button bSMBGSSFStopService;
    Context mCtx;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.sm_bgservice_setting_fragment, container, false);

        initViews(v);

        checkBgServiceStatus();

        Intent bgServiceIntent = new Intent(mCtx, BgService.class);

        bSMBGSSFStartService.setOnClickListener(b->{
            mCtx.startService(bgServiceIntent);
            checkBgServiceStatus();
        });

        bSMBGSSFStopService.setOnClickListener(b->{
            mCtx.stopService(bgServiceIntent);
            checkBgServiceStatus();
        });

        return v;
    }

    private void checkBgServiceStatus() {
        String statusText;
        if (Utils.isMyServiceRunning(mCtx, BgService.class)) {
            statusText="Service is <font color='green'>Running</font>";
            bSMBGSSFStartService.setEnabled(false);
            bSMBGSSFStopService.setEnabled(true);
        }else{
            statusText="Service is <font color='red'>Not Running</font>";
            bSMBGSSFStartService.setEnabled(true);
            bSMBGSSFStopService.setEnabled(false);
        }
        Spanned spanned = Html.fromHtml(statusText);
        tvSMBGSSFStatus.setText(spanned);
    }

    private void initViews(View v) {
        tvSMBGSSFStatus = v.findViewById(R.id.tvSMBGSSFStatus);
        bSMBGSSFStartService = v.findViewById(R.id.bSMBGSSFStartService);
        bSMBGSSFStopService = v.findViewById(R.id.bSMBGSSFStopService);
    }
}
