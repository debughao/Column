package com.debughao.column.presenter.impl;

import android.content.Context;

import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.RecommendPostsBean;
import com.debughao.column.model.ArticleListModel;
import com.debughao.column.model.impl.ArticleListModelImpl;
import com.debughao.column.presenter.ArticlePresenter;
import com.debughao.column.view.ArticleView;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/11 22:21
 * description :
 */
public class ArticlePresenterImpl implements ArticlePresenter,ArticleListModelImpl.OnLoadPostsListener {
    private ArticleView mArticleView;
    private ArticleListModel mArticleListModel;
    private Context mContext;
    public ArticlePresenterImpl(ArticleView mArticleView, Context context) {
        this.mArticleView = mArticleView;
        this.mContext = context;
        this.mArticleListModel = new ArticleListModelImpl();
    }
    @Override
    public void onLoadPostsList(int pageIndex) {
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (pageIndex == 0) {
            mArticleView.showLoading();
        }
        mArticleListModel.onLoadColumnList(mContext, Urls.PAZE_SIZE, pageIndex, 11, this);
    }

    @Override
    public void onSuccess(List<RecommendPostsBean> recommendPostsBeen) {
        mArticleView.hideLoading();
        mArticleView.onRefreshData(recommendPostsBeen);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mArticleView.hideLoading();
        mArticleView.showMsg(msg);
    }
}
