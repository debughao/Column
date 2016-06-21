package com.debughao.column.model.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.JsoupUtils;
import com.debughao.column.model.LoginModel;
import com.debughao.column.nohttp.CallServer;
import com.debughao.column.nohttp.HttpListener;
import com.debughao.column.parm.LoginParm;
import com.debughao.column.utils.SPUtils;
import com.orhanobut.logger.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * Created by admin on 2016/6/21.
 */
public class LoginModelImpl implements LoginModel, HttpListener<String> {
    private Context mContext;
    private OnLoginListener mOnLoginListener;

    @Override
    public void getXrsf(Context context) {
        this.mContext = context;
        Logger.e("getXrsf-------------");
        Request<String> request = NoHttp.createStringRequest(Urls.HOST, RequestMethod.GET);
        request.setHeader("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER");
        CallServer.getRequestInstance().add(context, 0, request, this, false, false);
    }

    @Override
    public void login(LoginParm loginParm, OnLoginListener onLoginListener) {
        this.mOnLoginListener = onLoginListener;
        Request<String> request = NoHttp.createStringRequest(Urls.LOGIN, RequestMethod.POST);
        request.add("_xsrf", loginParm.get_xsrf());
        request.add("password", loginParm.getPassword());
        request.add("remember_me", loginParm.getRemember_me());
        request.add("phone_num", loginParm.getPhone_num());
        CallServer.getRequestInstance().add(mContext, 1, request, this, false, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        switch (what) {
            case 0:
                Logger.i("...." + response.get());
                String xrsf = JsoupUtils.getXrsf(response.get());
                SPUtils.put(mContext, "xrsf", xrsf);
                Logger.i("xrsf" + xrsf);
                break;
            case 1:
                Logger.i("login" + response.get());
                JSONObject jsonObject;
                jsonObject = JSON.parseObject(response.get());
                String r = jsonObject.getString("r");
                if ("0" == r) {
                    mOnLoginListener.onSuccess();
                } else if ("1" == r) {
                    String msg = jsonObject.getString("msg");
                    mOnLoginListener.onFailure(msg, null);
                }
                break;
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

    }

    public interface OnLoginListener {
        void onSuccess();

        void onFailure(String msg, Exception e);
    }
}
