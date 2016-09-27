package com.irelint.easyandroid.mvp.presenter.base;

import android.os.Handler;
import android.os.Looper;

import com.irelint.easyandroid.mvp.view.base.IBaseView;

/**
 * 作者：当我遇上你 on 2016-9-27 00:03
 * 邮箱：cuishiying163@163.com
 */

public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private T mView;
    //必须在主线程中更新View
    public Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void attachView(T mvpView) {
        this.mView = mvpView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
    /**
     * 判断 view是否为空
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 返回目标view
     * @return
     */
    public T getMvpView() {
        return mView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    /**
     * 自定义异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
