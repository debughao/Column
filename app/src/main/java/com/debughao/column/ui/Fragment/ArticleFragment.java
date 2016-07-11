package com.debughao.column.ui.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.debughao.column.R;
import com.debughao.column.adapter.RecommendPostsAdapter;
import com.debughao.column.base.BaseFragment;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.RecommendPostsBean;
import com.debughao.column.eventbus.EventCenter;
import com.debughao.column.presenter.ArticlePresenter;
import com.debughao.column.presenter.impl.ArticlePresenterImpl;
import com.debughao.column.ui.Activity.PostsDetailActivity;
import com.debughao.column.utils.MyToast;
import com.debughao.column.view.ArticleView;
import com.debughao.column.widget.view.DividerItemDecoration;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class ArticleFragment extends BaseFragment implements ArticleView, SwipeRefreshLayout.OnRefreshListener {
    private int pageIndex = 0;
    @Bind(R.id.swipeRefresh_Article)
    SwipeRefreshLayout mSwipeRefreshWidget;
    @Bind(R.id.recycle_viewArticle)
    RecyclerView mRecyclerView;
    private ArticlePresenter mArticlePresenter;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;
    private RecommendPostsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<RecommendPostsBean> mData;
    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void initViewsAndEvents() {
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mArticlePresenter = new ArticlePresenterImpl(this, getActivity());
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new RecommendPostsAdapter(getActivity().getApplicationContext(),mData);
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mAdapter.isShowFooter(false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        if (!mHasLoadedOnce){
            mArticlePresenter.onLoadPostsList(pageIndex);
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_article;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }


    @Override
    public void showMsg(String msg) {
        if (pageIndex == 0) {
            mAdapter.isShowFooter(false);
            mAdapter.notifyDataSetChanged();
            mSwipeRefreshWidget.setRefreshing(false);
        }
        if (!TextUtils.isEmpty(msg)) {
            MyToast.showShort(msg);
        }
    }

    @Override
    public void showLoading() {
        if (mSwipeRefreshWidget!=null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshWidget.setRefreshing(true);
                }
            });
        }
    }



    @Override
    public void hideLoading() {
        mHasLoadedOnce = true;
        if (mSwipeRefreshWidget!=null) {
            mSwipeRefreshWidget.setRefreshing(false);
        }
    }


    @Override
    public void onRefreshData(List<RecommendPostsBean> columnBeen) {
        mAdapter.isShowFooter(true);
        if (mData == null) {
            mData = new ArrayList<RecommendPostsBean>();
        }
        mData.addAll(columnBeen);
        if (pageIndex == 0) {
            mAdapter.setmDate(mData);
        } else {
            //如果没有更多数据了,则隐藏footer布局
            if (columnBeen == null || columnBeen.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
        pageIndex += Urls.PAZE_SIZE;
    }

    @Override
    public void onRefresh() {
        pageIndex = 0;
        if (mData != null) {
            mData.clear();
        }
        mArticlePresenter.onLoadPostsList(pageIndex);
    }
    private RecommendPostsAdapter.OnItemClickListener mOnItemClickListener = new RecommendPostsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int onItemClick) {

            RecommendPostsBean.ColumnBean columnBean = mData.get(onItemClick).getColumn();

            Bundle bundle=new Bundle();
            if (columnBean!=null){
                bundle.putString("refer","/"+columnBean.getSlug());
            }
            bundle.putString("columnName",mData.get(onItemClick).getTitle());
            bundle.putString("titleImage",mData.get(onItemClick).getImage_url());
            bundle.putInt("slug",mData.get(onItemClick).getSlug());
            readyGo(PostsDetailActivity.class,bundle);

        }
    };

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount()) {
                //加载更多
                Logger.d("is loading more data");
                mArticlePresenter.onLoadPostsList(pageIndex + Urls.PAZE_SIZE);

            }
        }
    };
}
