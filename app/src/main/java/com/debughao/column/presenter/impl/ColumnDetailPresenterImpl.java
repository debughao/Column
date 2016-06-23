package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.data.bean.Posts;
import com.debughao.column.model.ColumnDetailModel;
import com.debughao.column.model.impl.ColumnDetailModelImpl;
import com.debughao.column.presenter.ColumnDetailPresenter;
import com.debughao.column.view.ColumnDetailView;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 13:11
 * description :
 */
public class ColumnDetailPresenterImpl implements ColumnDetailPresenter,ColumnDetailModelImpl.OnLoadColumnDetailListener,ColumnDetailModelImpl.OnLoadColumnPostsListListener {
    private ColumnDetailView mColumnDetailView;
    private ColumnDetailModel mColumnDetailModel;
    private Context mContext;

    public ColumnDetailPresenterImpl(ColumnDetailView mColumnDetailView, Context mContext) {
        this.mColumnDetailView = mColumnDetailView;
        this.mColumnDetailModel = new ColumnDetailModelImpl(mContext);
        this.mContext = mContext;
    }

    @Override
    public void getColumnDetail(String columnName) {
        mColumnDetailModel.onLoadColumnDetail(Urls.COLUMNDETAIL+columnName,this);
    }

    @Override
    public void getColumnPostList(int pageIndex,String ColumnName) {
        if (pageIndex == 0) {
            mColumnDetailView.showLoading();
        }
        Urls.columnName=ColumnName;
        mColumnDetailModel.onLoadColumnPostsList(Urls.PAZE_SIZE,pageIndex,Urls.COLUMNPOSTS,this);
    }

    @Override
    public void onSuccess(ColumnDetail columnDetail) {
            mColumnDetailView.onRefreshColumnDetailData(columnDetail);
    }

    @Override
    public void onSuccess(List<Posts> postses) {

    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
