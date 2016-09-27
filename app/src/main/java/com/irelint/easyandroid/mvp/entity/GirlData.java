package com.irelint.easyandroid.mvp.entity;

import java.util.List;

/**
 * 作者：当我遇上你 on 2016-9-27 00:32
 * 邮箱：cuishiying163@163.com
 */

public class GirlData {
    public boolean isError;
    public List<PhotoGirl> results;
    public class PhotoGirl{
        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;
    }
}
