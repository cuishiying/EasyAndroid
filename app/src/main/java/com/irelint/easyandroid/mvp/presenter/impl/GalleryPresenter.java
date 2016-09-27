package com.irelint.easyandroid.mvp.presenter.impl;

import com.irelint.easyandroid.mvp.biz.OnRequestListener;
import com.irelint.easyandroid.mvp.biz.RequestBiz;
import com.irelint.easyandroid.mvp.biz.RequestBiziml;
import com.irelint.easyandroid.mvp.entity.GirlData;
import com.irelint.easyandroid.mvp.presenter.base.BasePresenter;
import com.irelint.easyandroid.mvp.view.IGallery;
import com.irelint.easyandroid.utils.LogUtils;

/**
 * 作者：当我遇上你 on 2016-9-27 00:14
 * 邮箱：cuishiying163@163.com
 */

public class GalleryPresenter extends BasePresenter<IGallery> {
    private RequestBiz requestBiz;
    public GalleryPresenter() {
        requestBiz = new RequestBiziml();
    }
    public void loadData(){
        checkViewAttached();//检查是否绑定
        getMvpView().showLoading();
        requestBiz.loadMeiziData(new OnRequestListener(){

            @Override
            public void onSuccess(final GirlData data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        getMvpView().hideLoading();
                        getMvpView().setData(data);
                    }
                });
            }

            @Override
            public void onFailed(Throwable e) {
                LogUtils.e(e.toString());
                getMvpView().showError();
            }
        });
    }
}
