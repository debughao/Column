package com.debughao.column.ui.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.debughao.column.R;
import com.debughao.column.base.BaseActivity;
import com.debughao.column.parm.LoginParm;
import com.debughao.column.presenter.LoginPresenter;
import com.debughao.column.presenter.impl.LoginPresenterImpl;
import com.debughao.column.utils.MyToast;
import com.debughao.column.utils.SPUtils;
import com.debughao.column.view.LoginView;
import com.debughao.column.widget.view.CircleImageView;

import butterknife.Bind;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {
    private LoginPresenter mLoginPresenter;
    @Bind(R.id.iv_login_avatar)
    CircleImageView mAvatar;
    @Bind(R.id.tv_forgetPassword)
    TextView mForgetPassword;
    @Bind(R.id.tv_Register)
    TextView mRegister;
    @Bind(R.id.et_Password)
    EditText mPassword;
    @Bind(R.id.et_phone)
    EditText mphone;
    @Bind(R.id.btn_login)
    Button mLogin;
    private boolean isLoginSuccess = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mLogin.setOnClickListener(this);
        mLoginPresenter = new LoginPresenterImpl(mContext, this);
        mLoginPresenter.getXsrf();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }


    @Override
    public void onSuccess() {
        MyToast.showShort("登录成功！");
        isLoginSuccess = false;
    }

    @Override
    public void showMsg(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            MyToast.showShort(msg);
            isLoginSuccess = false;
        }
    }

    @Override
    public void showLoading() {

    }



    @Override
    public void hideLoading() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String password = mPassword.getText().toString().trim();
                String phone = mphone.getText().toString().trim();

                if (TextUtils.isEmpty(password)) {
                    MyToast.showLong("密码不能为空");
                } else if (TextUtils.isEmpty(phone)) {
                    MyToast.showLong("手机号不能为空");
                } else {
//                    if (!isLoginSuccess) {//登录不成功再次登录要再次获取xrsf
//                        SPUtils.remove(mContext,"xrsf");
//                        mLoginPresenter.getXsrf();
//                    }
                    String xrsf = String.valueOf(SPUtils.get(mContext, "xrsf", ""));
                    LoginParm loginParm = new LoginParm(xrsf, password, false, phone);
                    mLoginPresenter.login(loginParm);
                }
                break;
            case R.id.tv_forgetPassword:
                break;
            case R.id.tv_Register:
                break;
            default:
                break;
        }

    }
}

