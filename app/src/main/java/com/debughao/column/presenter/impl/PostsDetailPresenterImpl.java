package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.CommentBean;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.data.bean.SubColumn;
import com.debughao.column.model.PostsDetailModel;
import com.debughao.column.model.impl.PostsDetailModelImpl;
import com.debughao.column.presenter.PostsDetailPresenter;
import com.debughao.column.view.PostsDetailView;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/29 11:05
 * description :
 */
public class PostsDetailPresenterImpl implements PostsDetailPresenter, PostsDetailModelImpl.OnPostsDetailListener,
        PostsDetailModelImpl.OnSubColumnListener,PostsDetailModelImpl.OnCommentListener {
    private PostsDetailModel mPostsDetailModel;
    private PostsDetailView mPostsDetailView;

    public PostsDetailPresenterImpl(Context context, PostsDetailView mPostsDetailView) {
        this.mPostsDetailModel = new PostsDetailModelImpl(context);
        this.mPostsDetailView = mPostsDetailView;
    }

    @Override
    public void getPostsDetail(String columnName, int slug) {
        String url = Urls.POSTEDETAIl + "/" + slug;
        mPostsDetailModel.getPostDetail(url, this, columnName);
    }

    @Override
    public void getSubColumn(int slug) {
//        https://zhuanlan.zhihu.com/api/posts/20874580/contributed
        String url = Urls.POSTEDETAIl +"/" + slug+ "/contributed";
        mPostsDetailModel.getSubColumn(url,  this);
    }

    @Override
    public void getSubComment(int slug, int offset) {
        //https://zhuanlan.zhihu.com/api/posts/20234763/comments?limit=10&offset=10
        String url = Urls.POSTEDETAIl +"/" + slug+ "/comments";
        mPostsDetailModel.getComment(url,Urls.PAZE_SIZE,offset,this);
    }

    @Override
    public void onSuccess(PostsBean postsBean) {
        mPostsDetailView.loadWebView(postsBean);
    }

    @Override
    public void onSuccess(List<SubColumn> subColumn) {
        mPostsDetailView.loadSubColumnView(subColumn);
    }

    @Override
    public void onCommentSuccess(List<CommentBean> commentBean) {
        mPostsDetailView.loadCommentView(commentBean);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mPostsDetailView.showMsg(msg);
    }
}
