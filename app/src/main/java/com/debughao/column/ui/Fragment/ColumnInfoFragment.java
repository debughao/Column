package com.debughao.column.ui.Fragment;


import android.os.Bundle;
import android.widget.TextView;

import com.debughao.column.R;
import com.debughao.column.base.BaseFragment;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.eventbus.EventCenter;
import com.debughao.column.widget.view.CircleImageView;
import com.debughao.column.widget.view.ZHTopicView;
import com.orhanobut.logger.Logger;

import butterknife.Bind;


public class ColumnInfoFragment extends BaseFragment {
    @Bind(R.id.tv_columnDetailtitle)
   TextView mTitle;
    @Bind(R.id.tv_fragment_columnDscription)
    TextView mDscription;
    @Bind(R.id.tv_fragment_columnIntroduce)
    TextView mIntroduce;
    @Bind(R.id.tv_columnEditorsInfo)
    TextView mEditorsInfo;
    @Bind(R.id.tv_fragment_columnEditorsPostsNum)
    TextView mEditorsPostsNum;
    @Bind(R.id.iv_columnEditorsAvatar)
    CircleImageView mEditorsAvatar;
    @Bind(R.id.iv_columnDetailAvatar)
    CircleImageView mColumnAvatar;
    @Bind(R.id.zhv_columnDetailTopic)
    ZHTopicView mZHTopicView;
    private ColumnDetail columnDetail;

    private static String ARG_PARAM1 = "columnDetail";


    public static ColumnInfoFragment newInstance(ColumnDetail columnDetail) {
        ColumnInfoFragment fragment = new ColumnInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, columnDetail);
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
            columnDetail = (ColumnDetail) getArguments().getSerializable(ARG_PARAM1);
            Logger.d(columnDetail.toString());
           // mZHTopicView.setPostTopicsBean(columnDetail.getPostTopics());
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_column_info;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
