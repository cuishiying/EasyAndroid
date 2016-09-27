package com.irelint.easyandroid.mvp.biz;


import com.irelint.easyandroid.mvp.entity.GirlData;

/**
 * Created by Dante on 2016/3/16.
 */
public interface OnRequestListener {

    void onSuccess(GirlData data);
    void onFailed(Throwable e);
}
