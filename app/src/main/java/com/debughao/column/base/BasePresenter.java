package com.debughao.column.base;

import android.content.Context;

/**
 * Created by debguhao on 2016-6-17 17:20:52.
 */
public abstract class BasePresenter<E, T> {
    public Context context;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {

    }
}
