package com.irelint.easyandroid.mvp.ui.activities;

import com.irelint.easyandroid.R;
import com.irelint.easyandroid.annotation.BindValues;
import com.irelint.easyandroid.mvp.ui.activities.base.BaseActivity;
@BindValues(mIsHasNavigationView = true)
public class MainActivity extends BaseActivity{

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }
}
