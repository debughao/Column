package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.model.PostsDetailModel;
import com.debughao.column.model.impl.PostsDetailModelImpl;
import com.debughao.column.presenter.PostsDetailPresenter;
import com.debughao.column.view.PostsDetailView;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/29 11:05
 * description :
 */
public class PostsDetailPresenterImpl implements PostsDetailPresenter,PostsDetailModelImpl.OnPostsDetailListener {
    private PostsDetailModel mPostsDetailModel;
    private PostsDetailView mPostsDetailView;

    public PostsDetailPresenterImpl(Context context, PostsDetailView mPostsDetailView) {
        this.mPostsDetailModel = new PostsDetailModelImpl(context);
        this.mPostsDetailView = mPostsDetailView;
    }

    @Override
    public void getPostsDetail(String columnName, int slug) {
      String url= Urls.POSTEDETAIl+"/"+slug;
        mPostsDetailModel.getPostDetail(url,this,columnName);
    }

    @Override
    public void onSuccess(PostsBean postsBean) {
       mPostsDetailView.loadWebView(postsBean);
    }

    @Override
    public void onFailure(String msg, Exception e) {
      mPostsDetailView.showMsg(msg);
    }
}
