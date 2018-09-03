package com.example.shrawanwable.objectbox.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.shrawanwable.objectbox.models.TabFragment;

import java.util.List;

public class TabFragmentsPagerAdapter extends FragmentPagerAdapter {
    List<TabFragment> tabFragmentList;

    public TabFragmentsPagerAdapter(FragmentManager fm, List<TabFragment> tabFragmentList) {
        super(fm);
        this.tabFragmentList = tabFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragmentList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabFragmentList.get(position).getTitle();
    }
}
