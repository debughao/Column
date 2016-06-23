package com.debughao.column.ui.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.debughao.column.Adapter.ColumnAdapter;
import com.debughao.column.R;
import com.debughao.column.base.BaseFragment;
import com.debughao.column.commons.Urls;
import com.debughao.column.data.bean.Column;
import com.debughao.column.eventbus.EventCenter;
import com.debughao.column.presenter.ColumnPresenter;
import com.debughao.column.presenter.impl.ColumnPresenterImpl;
import com.debughao.column.ui.Activity.ColumnDetailActivity;
import com.debughao.column.utils.MyToast;
import com.debughao.column.view.ColumnsListView;
import com.debughao.column.widget.view.DividerItemDecoration;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 *
 */
public class ColoumnFragment extends BaseFragment implements ColumnsListView, SwipeRefreshLayout.OnRefreshListener {
    private int pageIndex = 0;
    @Bind(R.id.swipeRefresh_Column)
    SwipeRefreshLayout mSwipeRefreshWidget;
    @Bind(R.id.recycle_viewColumn)
    RecyclerView mRecyclerView;
    private ColumnPresenter mColumnPresenter;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;
    private ColumnAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Column> mData;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_column;
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
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mColumnPresenter = new ColumnPresenterImpl(this, getActivity());
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new ColumnAdapter(getActivity().getApplicationContext(),mData);
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mAdapter.isShowFooter(false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        if (!mHasLoadedOnce){
            mColumnPresenter.onLoadColumnList(pageIndex);
        }
        //onRefresh();
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
        mColumnPresenter.onLoadColumnList(pageIndex);
    }

    @Override
    public void onRefreshData(List<Column> columns) {
        mAdapter.isShowFooter(true);
        if (mData == null) {
            mData = new ArrayList<Column>();
        }
        mData.addAll(columns);
        if (pageIndex == 0) {
            mAdapter.setmDate(mData);
        } else {
            //如果没有更多数据了,则隐藏footer布局
            if (columns == null || columns.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
        pageIndex += Urls.PAZE_SIZE;
    }


    private ColumnAdapter.OnItemClickListener mOnItemClickListener = new ColumnAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int onItemClick) {
            Bundle bundle=new Bundle();
            bundle.putString("columnName",mData.get(onItemClick).getName());
            bundle.putString("columnUrl",mData.get(onItemClick).getUrl());
            readyGo(ColumnDetailActivity.class,bundle);
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
                mColumnPresenter.onLoadColumnList(pageIndex + Urls.PAZE_SIZE);

            }
        }
    };
}
