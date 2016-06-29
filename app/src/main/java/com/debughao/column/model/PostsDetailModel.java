package com.debughao.column.model;

import android.content.Context;

import com.debughao.column.model.impl.PostsDetailModelImpl;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/29 10:46
 * description :
 */
public interface PostsDetailModel {
 void getPostDetail( String url, PostsDetailModelImpl.OnPostsDetailListener onPostsDetailListener, String refer);
}
