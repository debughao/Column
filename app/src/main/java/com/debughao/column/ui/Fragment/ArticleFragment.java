package com.debughao.column.ui.Fragment;

import com.debughao.column.R;
import com.debughao.column.base.BaseFragment;
import com.debughao.column.data.bean.Column;
import com.debughao.column.eventbus.EventCenter;
import com.debughao.column.view.ColumnsListView;

import java.util.List;


public class ArticleFragment extends BaseFragment implements ColumnsListView {

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

    }

    @Override
    public void showLoading() {

    }



    @Override
    public void hideLoading() {

    }



    @Override
    public void onRefreshData(List<Column> columnBeen) {

    }


}
