package com.debughao.column.ui.Fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.debughao.column.R;
import com.debughao.column.adapter.PostsAdapter;
import com.debughao.column.base.BaseFragment;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.eventbus.EventCenter;
import com.debughao.column.presenter.ColumnDetailPresenter;
import com.debughao.column.presenter.impl.ColumnDetailPresenterImpl;
import com.debughao.column.utils.MyToast;
import com.debughao.column.view.ColumnDetailView;
import com.debughao.column.widget.view.DividerItemDecoration;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class PostsListFragment extends BaseFragment implements ColumnDetailView, SwipeRefreshLayout.OnRefreshListener {
    private int pageIndex = 0;
    private static final String ARG_PARAM1 = "param1";

    @Bind(R.id.swipeRefresh_postList)
    SwipeRefreshLayout mSwipeRefreshWidget;
    @Bind(R.id.recycle_viewpostList)
    RecyclerView mRecyclerView;

    private ColumnDetailPresenter mColumnDetailPresenter;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;
    private PostsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<PostsBean> mData;
    private String columnName;

    public static PostsListFragment newInstance(String param1) {
        PostsListFragment fragment = new PostsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


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
        if (getArguments() != null) {
            columnName = getArguments().getString(ARG_PARAM1);
        }
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mColumnDetailPresenter = new ColumnDetailPresenterImpl(this, getActivity());
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new PostsAdapter(getActivity().getApplicationContext(), mData);
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mAdapter.isShowFooter(false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        if (!mHasLoadedOnce) {
            mColumnDetailPresenter.getColumnPostList(pageIndex, columnName);
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_posts_list;
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
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mHasLoadedOnce = true;
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        pageIndex = 0;
        if (mData != null) {
            mData.clear();
        }
        mColumnDetailPresenter.getColumnPostList(pageIndex, columnName);
    }

    @Override
    public void onRefreshColumnDetailData(ColumnDetail columnDetail) {

    }

    @Override
    public void onRefreshColumnPostsData(List<PostsBean> postsBeanList) {
        mAdapter.isShowFooter(true);
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(postsBeanList);
        if (pageIndex == 0) {
            mAdapter.setmDate(mData);
        } else {
            //如果没有更多数据了,则隐藏footer布局
            if (postsBeanList == null || postsBeanList.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
        pageIndex += Urls.PAZE_SIZE;
    }

    private PostsAdapter.OnItemClickListener mOnItemClickListener = new PostsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int onItemClick) {

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
                mColumnDetailPresenter.getColumnPostList(pageIndex + Urls.PAZE_SIZE, columnName);

            }
        }
    };
}
