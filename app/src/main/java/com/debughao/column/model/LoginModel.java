package com.debughao.column.model;


import android.content.Context;

import com.debughao.column.model.impl.LoginModelImpl;
import com.debughao.column.parm.LoginParm;

/**
 * Created by admin on 2016/6/21.
 */
public interface LoginModel  {
     void getXrsf(Context context);
     void login(LoginParm loginParm,LoginModelImpl.OnLoginListener onLoginListener);
}
