package com.irelint.easyandroid.mvp.presenter.base;

import com.irelint.easyandroid.mvp.view.base.IBaseView;

/**
 * 作者：当我遇上你 on 2016-9-27 00:02
 * 邮箱：cuishiying163@163.com
 */

public interface IBasePresenter<T extends IBaseView> {
    /**
     * 绑定View
     * @param mvpView
     */
    void attachView(T mvpView);

    /**
     * 解绑View
     */
    void detachView();
}
