package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.Column;
import com.debughao.column.model.ColumnModel;
import com.debughao.column.model.impl.ColumnModelImpl;
import com.debughao.column.presenter.ColumnPresenter;
import com.debughao.column.view.ColumnsView;

import java.util.List;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/22 14:04
 * description :专栏列表Presenter类
 */
public class ColumnPresenterImpl implements ColumnPresenter, ColumnModelImpl.OnLoadColumnListListener {
    private ColumnsView mColumnsView;
    private ColumnModel mColumnModel;
    private Context mContext;

    public ColumnPresenterImpl(ColumnsView mColumnsView, Context context) {
        this.mColumnsView = mColumnsView;
        this.mContext = context;
        this.mColumnModel = new ColumnModelImpl();
    }

    @Override
    public void onLoadColumnList(int pageIndex) {
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (pageIndex == 0) {
            mColumnsView.showLoading();
        }
        mColumnModel.onLoadColumnList(mContext, Urls.PAZE_SIZE, pageIndex, 11, this);
    }

    @Override
    public void onSuccess(List<Column> columns) {
        mColumnsView.hideLoading();
        mColumnsView.onRefreshData(columns);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mColumnsView.hideLoading();
        mColumnsView.showMsg(msg);
    }
}
