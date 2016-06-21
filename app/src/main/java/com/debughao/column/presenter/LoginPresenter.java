package com.debughao.column.presenter;

import android.content.Context;

import com.debughao.column.parm.LoginParm;

/**
 * Created by admin on 2016/6/21.
 */
public interface LoginPresenter {
     void getXsrf();
     void login(LoginParm loginParm);
}
