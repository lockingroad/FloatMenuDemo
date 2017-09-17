package com.huiben.app.floatmenudemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment>fragments;
    private String[]titles;
        public HomePagerAdapter(FragmentManager fm,List<Fragment>fragments,String[]titles) {
            super(fm);
            this.fragments=fragments;
            this.titles=titles;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }