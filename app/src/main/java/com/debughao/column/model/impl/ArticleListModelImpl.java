package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.RecommendPostsBean;
import com.debughao.column.model.ArticleListModel;
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
 * Date : 2016/7/11 22:22
 * description :
 */
public class ArticleListModelImpl implements ArticleListModel, HttpListener<String> {

    private  OnLoadPostsListener mOnLoadPostsListener;
    private  Context mContext;
    @Override
    public void onLoadColumnList(Context context ,int limit, int offset, int seed, OnLoadPostsListener onLoadColumnListListener) {
        this.mContext=context;
        this.mOnLoadPostsListener=onLoadColumnListListener;
        Request<String> request = NoHttp.createStringRequest(Urls.RECOMMENDARTICLE, RequestMethod.GET);
        request.add("limit", limit);
        request.add("offset", offset);
        request.add("seed", seed);
        CallServer.getRequestInstance().add(mContext, 0, request, this, false, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        JSONArray jsonArray;
        jsonArray= JSON.parseArray(response.get());
        List<RecommendPostsBean> recommendPostsBeen = JSON.parseArray(jsonArray.toString(),RecommendPostsBean.class);
        mOnLoadPostsListener.onSuccess(recommendPostsBeen);
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        mOnLoadPostsListener.onFailure("",exception);
    }

    public   interface  OnLoadPostsListener{
        void onSuccess(List<RecommendPostsBean> columnBeen);
        void onFailure(String msg, Exception e);
    }
}
