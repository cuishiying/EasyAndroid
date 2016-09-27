package com.irelint.easyandroid.mvp.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.irelint.easyandroid.R;
import com.irelint.easyandroid.annotation.BindValues;
import com.irelint.easyandroid.mvp.entity.GirlData;
import com.irelint.easyandroid.mvp.presenter.impl.GalleryPresenter;
import com.irelint.easyandroid.mvp.ui.activities.base.BaseActivity;
import com.irelint.easyandroid.mvp.view.IGallery;
import com.irelint.easyandroid.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：当我遇上你 on 2016-9-26 20:06
 * 邮箱：cuishiying163@163.com
 */
@BindValues(mIsHasNavigationView = true)
public class TabActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener,IGallery {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.photo_rv)
    RecyclerView mPhotoRv;

    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private GalleryPresenter mPresenter;
    private BaseQuickAdapter<GirlData.PhotoGirl> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tab;
    }

    @Override
    public void initViews() {
        initSwipeRefreshLayout();
        initRecyclerView();
        initPresenter();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.gplus_colors));
    }
    private void initRecyclerView() {
        mPhotoRv.setHasFixedSize(true);
        mPhotoRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mPhotoRv.setItemAnimator(new DefaultItemAnimator());
        List<GirlData.PhotoGirl> data = new ArrayList<GirlData.PhotoGirl>();
        mAdapter = new BaseQuickAdapter<GirlData.PhotoGirl>(R.layout.item_photo, data) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, GirlData.PhotoGirl resultsEntity) {
                ImageView view = baseViewHolder.getView(R.id.photo_iv);
                setImageUrl(mContext,view,resultsEntity.url);
            }
        };
        mPhotoRv.setAdapter(mAdapter);
    }
    private void initPresenter() {
        mPresenter = new GalleryPresenter();
        mPresenter.attachView(this);
        mPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setData(GirlData data) {
        LogUtils.e(data.toString());
        mAdapter.setNewData(data.results);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
