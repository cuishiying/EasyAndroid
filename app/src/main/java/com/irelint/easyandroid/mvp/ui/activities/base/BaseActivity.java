package com.irelint.easyandroid.mvp.ui.activities.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.irelint.easyandroid.R;
import com.irelint.easyandroid.annotation.BindValues;
import com.irelint.easyandroid.mvp.ui.activities.DetailActivity;
import com.irelint.easyandroid.mvp.ui.activities.MainActivity;
import com.irelint.easyandroid.mvp.ui.activities.GalleryActivity;
import com.irelint.easyandroid.utils.AppManager;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;

/**
 * 作者：当我遇上你 on 2016-9-26 19:46
 * 邮箱：cuishiying163@163.com
 */

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private Class mClass;
    protected boolean mIsHasNavigationView;

    public abstract int getLayoutId();
    public abstract void initViews();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAnnotation();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initToolBar();
        initViews();
        if (mIsHasNavigationView) {
            initDrawerLayout();
        }
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        // 结束Activity从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initDrawerLayout() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (mClass != null) {
                    Intent intent = new Intent(BaseActivity.this, mClass);
                    // 此标志用于启动一个Activity的时候，若栈中存在此Activity实例，则把它调到栈顶。不创建多一个
                    //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    mClass = null;
                }
            }
        });
    }

    private void initAnnotation() {
        if (getClass().isAnnotationPresent(BindValues.class)) {
            BindValues annotation = getClass().getAnnotation(BindValues.class);
            mIsHasNavigationView = annotation.mIsHasNavigationView();
        }
    }

    @Override
    public void onBackPressed() {
        if (mIsHasNavigationView && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            mClass = MainActivity.class;
        } else if (id == R.id.nav_gallery) {
            mClass = GalleryActivity.class;
        } else if (id == R.id.nav_slideshow) {
            mClass = DetailActivity.class;
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    public void setImageUrl(Context context, ImageView view, String url){
        Picasso.with(context).load(url).placeholder(R.color.image_place_holder).error(R.drawable.ic_load_fail).into(view);
    }

    /**
     * 显示空页面
     */
    protected void showEmptyView(){

    }
    /**
     * 显示错误页面
     */
    protected void showErrorView(){

    }
    /**
     * 显示数据面
     */
    protected void showDataView(){

    }
    /**
     * 显示加载页面
     */
    protected void showLoadingView(){

    }
}
