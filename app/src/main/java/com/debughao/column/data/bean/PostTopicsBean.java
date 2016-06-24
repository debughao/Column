package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/24 09:56
 * description :
 */
public class PostTopicsBean  implements Serializable {
    private int postsCount;
    private int id;
    private String name;

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}