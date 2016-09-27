package com.irelint.easyandroid.mvp.view.base;

/**
 * 作者：当我遇上你 on 2016-9-27 00:01
 * 邮箱：cuishiying163@163.com
 */

public interface IBaseView {
    /**
     * 显示加载进度条
     */
    void showLoading();

    /**
     * 隐藏加载进度条
     */
    void hideLoading();
    /**
     * 加载失败
     */
    void showError();
}
