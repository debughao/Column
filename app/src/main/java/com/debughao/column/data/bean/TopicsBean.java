package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/24 09:55
 * description :
 */
public class TopicsBean implements Serializable {
    private String url;
    private String id;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
