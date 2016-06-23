package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.Column;
import com.debughao.column.model.ColumnListModel;
import com.debughao.column.nohttp.CallServer;
import com.debughao.column.nohttp.HttpListener;
import com.orhanobut.logger.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;


import java.util.List;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/2213:48
 * description :
 */
public class ColumnListModelImpl implements ColumnListModel, HttpListener<String>{
    private  OnLoadColumnListListener mOnLoadColumnListListener;
   private  Context mContext;
    @Override
    public void onLoadColumnList(Context context ,int limit, int offset, int seed, OnLoadColumnListListener onLoadColumnListListener) {
        this.mContext=context;
        this.mOnLoadColumnListListener=onLoadColumnListListener;
        Request<String> request = NoHttp.createStringRequest(Urls.RECOMMENDATIONS, RequestMethod.GET);
        request.add("limit", limit);
        request.add("offset", offset);
        request.add("seed", seed);
        CallServer.getRequestInstance().add(mContext, 0, request, this, false, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        JSONArray jsonArray;
        jsonArray= JSON.parseArray(response.get());
        List<Column>  columns= JSON.parseArray(jsonArray.toString(),Column.class);
        mOnLoadColumnListListener.onSuccess(columns);
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        mOnLoadColumnListListener.onFailure("",exception);
    }

    public   interface  OnLoadColumnListListener{
        void onSuccess(List<Column> columns);
        void onFailure(String msg, Exception e);
    }
}
