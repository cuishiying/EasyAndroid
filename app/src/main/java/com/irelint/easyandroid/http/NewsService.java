package com.irelint.easyandroid.http;

import com.irelint.easyandroid.mvp.entity.GirlData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 作者：当我遇上你 on 2016-9-27 00:29
 * 邮箱：cuishiying163@163.com
 */

public interface NewsService {
    @GET("data/福利/{size}/{page}")
    Observable<GirlData> getPhotoList(
            @Path("size") int size,
            @Path("page") int page);
}
