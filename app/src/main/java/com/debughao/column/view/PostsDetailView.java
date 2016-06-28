package com.debughao.column.view;

import android.webkit.WebView;

import com.debughao.column.base.BaseView;
import com.debughao.column.data.bean.PostsBean;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/28 18:11
 * description :
 */
public interface PostsDetailView extends BaseView {
    void  loadWebView(PostsBean postsBean);
}
