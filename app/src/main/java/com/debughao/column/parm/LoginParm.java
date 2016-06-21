package com.debughao.column.parm;

import java.io.Serializable;

/**
 * Created by admin on 2016/6/21.
 */
public class LoginParm implements Serializable {
    private String _xsrf;
    private String password;
    private boolean  remember_me;
    private String  phone_num;

    public LoginParm(String _xsrf, String password, boolean remember_me, String phone_num) {
        this._xsrf = _xsrf;
        this.password = password;
        this.remember_me = remember_me;
        this.phone_num = phone_num;
    }

    public String get_xsrf() {
        return _xsrf;
    }

    public void set_xsrf(String _xsrf) {
        this._xsrf = _xsrf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRemember_me() {
        return remember_me;
    }

    public void setRemember_me(boolean remember_me) {
        this.remember_me = remember_me;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
