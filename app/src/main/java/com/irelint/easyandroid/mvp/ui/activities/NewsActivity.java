package com.irelint.easyandroid.mvp.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.irelint.easyandroid.R;
import com.irelint.easyandroid.annotation.BindValues;
import com.irelint.easyandroid.mvp.entity.GirlData;
import com.irelint.easyandroid.mvp.presenter.impl.GalleryPresenter;
import com.irelint.easyandroid.mvp.ui.activities.base.BaseActivity;
import com.irelint.easyandroid.mvp.ui.adapter.NewsPagerAdapter;

import butterknife.BindView;

/**
 * 作者：当我遇上你 on 2016-9-26 20:06
 * 邮箱：cuishiying163@163.com
 */
@BindValues(mIsHasNavigationView = true)
public class NewsActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    private GalleryPresenter mPresenter;
    private BaseQuickAdapter<GirlData.PhotoGirl> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public void initViews() {
        initViewPager();
//        initPresenter();
    }

    private void initViewPager() {
        NewsPagerAdapter adapter = new NewsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

//    private void initPresenter() {
//        mPresenter = new GalleryPresenter();
//        mPresenter.attachView(this);
//        mPresenter.loadData();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mPresenter.detachView();
//    }
//
//    @Override
//    public void onRefresh() {
//        mPresenter.refresh();
//        mSwipeRefreshLayout.setRefreshing(false);
//    }
//
//    @Override
//    public void setData(GirlData data) {
//        mAdapter.addData(data.results);
//    }
//
//    @Override
//    public void showLoading() {
//        mViewContainer.showLoading();
//    }
//
//    @Override
//    public void hideLoading() {
//        mViewContainer.hide();
//    }
//
//    @Override
//    public void showError() {
//        if(mAdapter.getData().size()>0){
//            mViewContainer.hide();
//            mAdapter.notifyDataChangedAfterLoadMore(false);
//        }else{
//            mViewContainer.showError();
//        }
//    }
//
//    @Override
//    public void onLoadMoreRequested() {
//        mPresenter.loadMore(2);
//    }
}
