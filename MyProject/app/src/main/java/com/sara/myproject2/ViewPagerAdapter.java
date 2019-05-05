package com.sara.myproject2;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<android.support.v4.app.Fragment > fragmentList = new ArrayList<>();
    private final List<String> fragmentListTtiles = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return  fragmentListTtiles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTtiles.get(position);
    }

    public void AddFragment(android.support.v4.app.Fragment fragment,String Title){

        fragmentList.add(fragment);
        fragmentListTtiles.add(Title);
    }
}
