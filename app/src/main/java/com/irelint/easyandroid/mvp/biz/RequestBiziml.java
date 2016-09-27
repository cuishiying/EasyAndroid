package com.irelint.easyandroid.mvp.biz;

import com.irelint.easyandroid.http.RetrofitManager;
import com.irelint.easyandroid.mvp.entity.GirlData;
import com.irelint.easyandroid.utils.LogUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dante on 2016/3/16.
 */
public class RequestBiziml implements RequestBiz{

    /**
     * 获取妹子数据
     * @param listener
     */
    @Override
    public void loadMeiziData(final OnRequestListener listener) {
        RetrofitManager.getInstance().getPhotoListObservable(20,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e);
                    }

                    @Override
                    public void onNext(GirlData girlData) {
                        if(null != listener){
                            listener.onSuccess(girlData);
                        }
                    }
                });
    }
}
