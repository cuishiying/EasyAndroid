package com.irelint.easyandroid;

import android.app.Application;
import android.content.Context;

/**
 * 作者：当我遇上你 on 2016-9-26 18:44
 * 邮箱：cuishiying163@163.com
 */

public class App extends Application {
    private static Context sAppContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
    }
    public static Context getAppContext() {
        return sAppContext;
    }
}
