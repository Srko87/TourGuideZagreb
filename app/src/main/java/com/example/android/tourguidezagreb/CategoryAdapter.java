package com.example.android.tourguidezagreb;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new CityFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new NightlifeFragment();
        } else {
            return new SightseeingFragment();
        }
    }

    @Override
    public int getCount() {
        int tabAmount = 5;
        return tabAmount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getResources().getString(R.string.home);
        } else if (position == 1) {
            return mContext.getResources().getString(R.string.city);
        } else if (position == 2) {
            return mContext.getResources().getString(R.string.food);
        } else if (position == 3) {
            return mContext.getResources().getString(R.string.nightlife);
        } else {
            return mContext.getResources().getString(R.string.sightseeing);
        }
    }
}
