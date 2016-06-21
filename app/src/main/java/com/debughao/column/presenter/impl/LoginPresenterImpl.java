package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.model.LoginModel;
import com.debughao.column.model.impl.LoginModelImpl;
import com.debughao.column.parm.LoginParm;
import com.debughao.column.presenter.LoginPresenter;
import com.debughao.column.view.LoginView;

/**
 * Created by admin on 2016/6/21.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginModelImpl.OnLoginListener {
    private Context mContext;
    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenterImpl(Context mContext, LoginView mLoginView) {
        this.mContext = mContext;
        this.mLoginView = mLoginView;
        this.mLoginModel = new LoginModelImpl();
    }

    @Override
    public void onSuccess() {
        mLoginView.onSuccess();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mLoginView.showMsg(msg);
    }

    @Override
    public void getXsrf() {
        mLoginModel.getXrsf(mContext);
    }

    @Override
    public void login(LoginParm loginParm) {
        mLoginModel.login(loginParm, this);
    }
}
