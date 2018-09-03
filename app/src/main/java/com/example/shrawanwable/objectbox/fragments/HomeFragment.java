package com.example.shrawanwable.objectbox.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.services.BgService;

public class HomeFragment extends Fragment {
    private static HomeFragment INSTANCE = null;
    TextView tvHFMyLocation;
    Button bHFLoadCurrentLocation;

    public static HomeFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);

        initViews(v);

        bHFLoadCurrentLocation.setOnClickListener(b -> {
            String text;
            text = "Background service to fetch location not running";
            if (BgService.getInstance() != null) {
                text = "Fetching location please wait";
                if (BgService.getInstance().getCurrentLocation() != null) {
                    text = "Current Location : " + BgService.getInstance().getCurrentLocation().getLatitude() + ", " + BgService.getInstance().getCurrentLocation().getLongitude();
                }
            }
            tvHFMyLocation.setText(text);
        });

        return v;
    }

    private void initViews(View v) {
        tvHFMyLocation = v.findViewById(R.id.tvHFMyLocation);
        bHFLoadCurrentLocation = v.findViewById(R.id.bHFLoadCurrentLocation);
    }
}
