package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.model.ColumnDetailModel;
import com.debughao.column.nohttp.CallServer;
import com.debughao.column.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import java.util.List;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 10:50
 * description :
 */
public class ColumnDetailModelImpl implements ColumnDetailModel, HttpListener<String> {
    private Context mContext;
    private OnLoadColumnDetailListener mOnLoadColumnDetailListener;
    private OnLoadColumnPostsListListener mOnLoadColumnPostsListListener;

    public ColumnDetailModelImpl(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public void onLoadColumnDetail(String Url, OnLoadColumnDetailListener onLoadColumnDetailListener) {
        this.mOnLoadColumnDetailListener = onLoadColumnDetailListener;
        Request<String> request = NoHttp.createStringRequest(Url, RequestMethod.GET);
        CallServer.getRequestInstance().add(mContext, 0, request, this, false, false);
    }

    @Override
    public void onLoadColumnPostsList(int limit, int offset, String Url, OnLoadColumnPostsListListener onLoadColumnPostsListListener) {
        this.mOnLoadColumnPostsListListener = onLoadColumnPostsListListener;
        Request<String> request = NoHttp.createStringRequest(Url, RequestMethod.GET);
        request.add("limit", limit);
        request.add("offset", offset);
        CallServer.getRequestInstance().add(mContext, 1, request, this, false, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {

        String result = response.get();
        if (response.getHeaders().getResponseCode()==200||response.getHeaders().getResponseCode()==304) {
            switch (what) {
                case 0:
                    ColumnDetail columnDetail = JSON.parseObject(result, ColumnDetail.class);
                    mOnLoadColumnDetailListener.onSuccess(columnDetail);
                    break;
                case 1:
                    List<PostsBean> postsBeanList = JSON.parseArray(result, PostsBean.class);
                    mOnLoadColumnPostsListListener.onSuccess(postsBeanList);
                    break;
                default:
                    break;
            }
        }else {
            switch (what) {
                case 0:
                    mOnLoadColumnDetailListener.onFailure("获取数据失败!",null);
                    break;
                case 1:
                    mOnLoadColumnPostsListListener.onFailure("获取数据失败!",null);
                    break;

            }
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        switch (what) {
            case 0:
                mOnLoadColumnDetailListener.onFailure("",exception);
                break;
            case 1:
                mOnLoadColumnPostsListListener.onFailure("",exception);
                break;

        }

    }

    public interface OnLoadColumnDetailListener {
        void onSuccess(ColumnDetail columnDetail);

        void onFailure(String msg, Exception e);
    }

    public interface OnLoadColumnPostsListListener {
        void onSuccess(List<PostsBean> postses);

        void onFailure(String msg, Exception e);
    }
}
