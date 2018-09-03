package com.example.shrawanwable.objectbox.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.fragments.DetailsFragment;
import com.example.shrawanwable.objectbox.fragments.HomeFragment;
import com.example.shrawanwable.objectbox.fragments.SettingsFragment;
import com.example.shrawanwable.objectbox.utils.Utils;

public class MainActivity extends AppCompatActivity {

    TabLayout tlMATabs;
    Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 101
            );
        } else {
            MAIN();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Utils.showToast(mCtx, "Please allow all permissions");
                finish();
                return;
            }
        }
        MAIN();
    }

    private void MAIN() {
        tlMATabs = findViewById(R.id.tlMATabs);

        setupTabs();

        changeFragment(HomeFragment.getInstance(), true);

    }

    private void setupTabs() {
        final TabLayout.Tab HomeTab = tlMATabs.newTab();
        HomeTab.setText("Home");

        final TabLayout.Tab DetailsTab = tlMATabs.newTab();
        DetailsTab.setText("Details");

        final TabLayout.Tab SettingsTab = tlMATabs.newTab();
        SettingsTab.setText("Settings");

        tlMATabs.addTab(HomeTab);
        tlMATabs.addTab(DetailsTab);
        tlMATabs.addTab(SettingsTab);

        tlMATabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == HomeTab) {
                    changeFragment(HomeFragment.getInstance(), true);
                } else if (tab == DetailsTab) {
                    changeFragment(DetailsFragment.getInstance(), true);
                } else if (tab == SettingsTab) {
                    changeFragment(SettingsFragment.getInstance(), true);
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void changeFragment(Fragment fragment, boolean isFirst) {
        Fragment existingFragment = getSupportFragmentManager().findFragmentById(R.id.flMAFragmentContainer);
        if (existingFragment == fragment) {
            //DO NOTHING
        } else {

            if (isFirst) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMAFragmentContainer, fragment)
                        .commit();
            } else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMAFragmentContainer, fragment)
                        .addToBackStack("Yes")
                        .commit();
            }
        }
    }

}
