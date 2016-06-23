package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.Column;
import com.debughao.column.model.ColumnListModel;
import com.debughao.column.model.impl.ColumnListModelImpl;
import com.debughao.column.presenter.ColumnPresenter;
import com.debughao.column.view.ColumnsListView;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/22 14:04
 * description :专栏列表Presenter类
 */
public class ColumnPresenterImpl implements ColumnPresenter, ColumnListModelImpl.OnLoadColumnListListener {
    private ColumnsListView mColumnsListView;
    private ColumnListModel mColumnListModel;
    private Context mContext;

    public ColumnPresenterImpl(ColumnsListView mColumnsListView, Context context) {
        this.mColumnsListView = mColumnsListView;
        this.mContext = context;
        this.mColumnListModel = new ColumnListModelImpl();
    }

    @Override
    public void onLoadColumnList(int pageIndex) {
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (pageIndex == 0) {
            mColumnsListView.showLoading();
        }
        mColumnListModel.onLoadColumnList(mContext, Urls.PAZE_SIZE, pageIndex, 11, this);
    }

    @Override
    public void onSuccess(List<Column> columns) {
        mColumnsListView.hideLoading();
        mColumnsListView.onRefreshData(columns);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mColumnsListView.hideLoading();
        mColumnsListView.showMsg(msg);
    }
}
