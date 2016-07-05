package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.debughao.column.data.bean.CommentBean;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.data.bean.SubColumn;
import com.debughao.column.model.PostsDetailModel;
import com.debughao.column.nohttp.CallServer;
import com.debughao.column.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/29 10:54
 * description :
 */
public class PostsDetailModelImpl implements PostsDetailModel, HttpListener<String> {
    private OnPostsDetailListener mOnPostsDetailListener;
    private OnSubColumnListener mOnSubColumnListener;
    private OnCommentListener mOnCommentListener;
    private Context mContext;

    public PostsDetailModelImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getPostDetail(String url, OnPostsDetailListener onPostsDetailListener, String refer) {
        this.mOnPostsDetailListener = onPostsDetailListener;
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.add("refer", refer);
        CallServer.getRequestInstance().add(mContext, 0, request, this, false, false);
    }

    @Override
    public void getSubColumn(String url, OnSubColumnListener onSubColumnListener) {
        this.mOnSubColumnListener = onSubColumnListener;
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        CallServer.getRequestInstance().add(mContext, 1, request, this, false, false);
    }

    @Override
    public void getComment(String url, int limit, int offset, OnCommentListener onCommentListener) {
        this.mOnCommentListener = onCommentListener;
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.add("limit", limit);
        request.add("offset", offset);
        CallServer.getRequestInstance().add(mContext, 2, request, this, false, false);
    }


    @Override
    public void onSucceed(int what, Response<String> response) {
        String result = response.get();
        if (response.getHeaders().getResponseCode() == 200) {
            switch (what) {
                case 0:
                    PostsBean postsBean = JSON.parseObject(result, PostsBean.class);
                    mOnPostsDetailListener.onSuccess(postsBean);
                    break;
                case 1:
                    List<SubColumn> subColumn = JSON.parseArray(result, SubColumn.class);
                    mOnSubColumnListener.onSuccess(subColumn);
                    break;
                case 2:
                    List<CommentBean> commentBeen = JSON.parseArray(result, CommentBean.class);
                    mOnCommentListener.onCommentSuccess(commentBeen);
                    break;
            }
        } else {
            switch (what) {
                case 0:
                    mOnPostsDetailListener.onFailure("获取文章内容失败", null);
                    break;
                case 1:
                    mOnSubColumnListener.onFailure("", null);
                case 2:
                    mOnCommentListener.onFailure("获取文章评论数据失败", null);
                    break;
            }
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        switch (what) {
            case 0:
                mOnPostsDetailListener.onFailure("", exception);
                break;
            case 1:
                mOnSubColumnListener.onFailure("", exception);
            case 2:
                mOnCommentListener.onFailure("", exception);
                break;
        }

    }

    public interface OnPostsDetailListener {
        void onSuccess(PostsBean postsBean);

        void onFailure(String msg, Exception e);
    }

    public interface OnSubColumnListener {
        void onSuccess(List<SubColumn> subColumn);

        void onFailure(String msg, Exception e);
    }

    public interface OnCommentListener {
        void onCommentSuccess(List<CommentBean> commentBeen);

        void onFailure(String msg, Exception e);
    }
}
