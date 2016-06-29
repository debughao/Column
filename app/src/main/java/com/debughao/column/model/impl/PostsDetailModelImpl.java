package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.model.PostsDetailModel;
import com.debughao.column.nohttp.CallServer;
import com.debughao.column.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/29 10:54
 * description :
 */
public class PostsDetailModelImpl implements PostsDetailModel, HttpListener<String> {
    private OnPostsDetailListener mOnPostsDetailListener;
    private Context mContext;

    public PostsDetailModelImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getPostDetail( String url, OnPostsDetailListener onPostsDetailListener, String refer) {
        this.mOnPostsDetailListener = onPostsDetailListener;
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.add("refer", refer);
        CallServer.getRequestInstance().add(mContext, 0, request, this, false, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String result = response.get();
        PostsBean postsBean = JSON.parseObject(result, PostsBean.class);
        mOnPostsDetailListener.onSuccess(postsBean);
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        mOnPostsDetailListener.onFailure("", exception);
    }

    public interface OnPostsDetailListener {
        void onSuccess(PostsBean postsBean);

        void onFailure(String msg, Exception e);
    }
}
