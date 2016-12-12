package com.irelint.easyandroid.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.irelint.easyandroid.mvp.ui.fragment.NewsFragment;

/**
 * 作者：当我遇上你 on 2016-9-27 22:18
 * 邮箱：cuishiying163@163.com
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter {
    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + position;
    }
}
