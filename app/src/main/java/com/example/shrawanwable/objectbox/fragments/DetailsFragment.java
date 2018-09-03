package com.example.shrawanwable.objectbox.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shrawanwable.objectbox.R;

public class DetailsFragment extends Fragment {

    private static DetailsFragment INSTANCE = null;

    public static DetailsFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DetailsFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.details_fragment, container, false);

        return v;
    }
}
