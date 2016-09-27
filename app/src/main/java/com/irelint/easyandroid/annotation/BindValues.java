package com.irelint.easyandroid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：当我遇上你 on 2016-9-26 22:20
 * 邮箱：cuishiying163@163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BindValues {
    boolean mIsHasNavigationView() default false;
}
