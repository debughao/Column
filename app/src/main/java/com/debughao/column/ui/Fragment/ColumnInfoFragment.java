package com.debughao.column.ui.Fragment;


import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
    @Bind(R.id.tv_columnEditorsName)
    TextView mEditorsName;
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
            setViewContent(columnDetail);
        }
    }

    private void setViewContent(ColumnDetail columnDetail) {
        mTitle.setText(columnDetail.getName());
        mDscription.setText(columnDetail.getIntro());
        mIntroduce.setText(columnDetail.getDescription());
        mEditorsPostsNum.setText(columnDetail.getPostsCount()+" 篇文章");
        mEditorsInfo.setText(""+columnDetail.getCreator().getBio());
        mEditorsName.setText(columnDetail.getCreator().getName());
        Glide.with(mContext).load(columnDetail.getAvatar().getTemplate()).diskCacheStrategy(DiskCacheStrategy.ALL).into(mColumnAvatar);
        Glide.with(mContext).load(columnDetail.getCreator().getAvatar().getTemplate()).diskCacheStrategy(DiskCacheStrategy.ALL).into(mEditorsAvatar);
        mZHTopicView.setPostTopicsBean(columnDetail.getPostTopics());
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
