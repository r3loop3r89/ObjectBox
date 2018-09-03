package com.example.shrawanwable.objectbox.fragments.settingmodules;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.models.SelectableTimeUnit;
import com.example.shrawanwable.objectbox.utils.Utils;

import java.util.List;

import static com.example.shrawanwable.objectbox.App.spm;

public class SMDataSaveIntervalConfigSettingFragment extends Fragment {

    EditText etSMDSICSF_Period;
    Spinner spSMDSICSF_TimeUnit;
    Button bSMDSICSF_Save;
    Context mCtx;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.sm_data_save_interval_config_setting_fragment, container, false);

        initViews(v);

        fillupSpinner();

        loadSavedData();

        bSMDSICSF_Save.setOnClickListener(b -> {
            if (Utils.cantBeEmptyET(etSMDSICSF_Period)) return;
            String period = etSMDSICSF_Period.getText().toString().trim();
            spm.setPERIOD(Long.parseLong(period));
            spm.setSELECTEDTIMEUNITPOSITION(spSMDSICSF_TimeUnit.getSelectedItemPosition());
            Utils.showRestartServiceToast(mCtx);
        });

        return v;
    }

    private void loadSavedData() {
        etSMDSICSF_Period.setText("" + spm.getPERIOD());
        spSMDSICSF_TimeUnit.setSelection(spm.getSELECTEDTIMEUNITPOSITION());
    }

    private void fillupSpinner() {
        List<SelectableTimeUnit> selectableTimeUnits = SelectableTimeUnit.getList();
        ArrayAdapter<SelectableTimeUnit> selectableTimeUnitArrayAdapter
                = new ArrayAdapter<SelectableTimeUnit>(mCtx, android.R.layout.simple_spinner_item, selectableTimeUnits);
        selectableTimeUnitArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSMDSICSF_TimeUnit.setAdapter(selectableTimeUnitArrayAdapter);
    }

    private void initViews(View v) {
        etSMDSICSF_Period = v.findViewById(R.id.etSMDSICSF_Period);
        spSMDSICSF_TimeUnit = v.findViewById(R.id.spSMDSICSF_TimeUnit);
        bSMDSICSF_Save = v.findViewById(R.id.bSMDSICSF_Save);
    }
}
