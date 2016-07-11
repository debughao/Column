package com.debughao.column.ui.Activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.debughao.column.R;
import com.debughao.column.base.BaseActivity;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.presenter.ColumnDetailPresenter;
import com.debughao.column.presenter.impl.ColumnDetailPresenterImpl;
import com.debughao.column.ui.Fragment.ColumnInfoFragment;
import com.debughao.column.ui.Fragment.PostsListFragment;
import com.debughao.column.utils.MyToast;
import com.debughao.column.view.ColumnDetailView;
import com.debughao.column.widget.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 13:05
 * description :专栏详情Activity
 */
public class ColumnDetailActivity extends BaseActivity implements ColumnDetailView,View.OnClickListener {
    private ColumnDetailPresenter mColumnDetailPresenter;
    private ColumnDetail mColumnDetail;
    private String columnName, columnUrl;
    @Bind(R.id.toolbar_columnDetal)
    Toolbar toolbar;
    @Bind(R.id.collapsing_ColumnDetail)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.tab_layoutColumnDetail)
    TabLayout mTablayout;
    @Bind(R.id.tv_followColumn)
    TextView mFllow;
    @Bind(R.id.iv_columnDetailAvatar)
    CircleImageView mCircleImageView;
    @Bind(R.id.vp_layoutColumnDetail)
    ViewPager mViewPager;
    private boolean isFollow;
    @Override
    protected void getBundleExtras(Bundle extras) {
        columnName = extras.getString("columnName", "");
        columnUrl = extras.getString("columnUrl", "");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_column_detail;
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFllow.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mTablayout.addTab(mTablayout.newTab().setText(R.string.columnInformation));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.columnArticle));
        collapsingToolbar.setTitle(columnName);
        mColumnDetailPresenter = new ColumnDetailPresenterImpl(this, mContext);
        mColumnDetailPresenter.getColumnDetail(columnUrl);

    }


    @Override
    public void showMsg(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            MyToast.showShort(msg);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onRefreshColumnDetailData(ColumnDetail columnDetail) {
        this.mColumnDetail = columnDetail;
        setupViewPager(mViewPager);
        mTablayout.setupWithViewPager(mViewPager);
        initColumnDetail(columnDetail);
    }

    private void initColumnDetail(ColumnDetail columnDetail) {
        Glide.with(mContext).load(columnDetail.getAvatar().getTemplate("b")).diskCacheStrategy(DiskCacheStrategy.ALL).into(mCircleImageView);
    }

    @Override
    public void onRefreshColumnPostsData(List<PostsBean> postsBeanList) {

    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ColumnInfoFragment.newInstance(mColumnDetail), getString(R.string.columnInformation));
        adapter.addFragment(PostsListFragment.newInstance(columnUrl), getString(R.string.columnArticle));
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_followColumn:
                if(isFollow){
                    //取消关注
                    mFllow.setBackgroundResource(R.drawable.shap_unfllow_text);
                    mFllow.setText(R.string.followColumn);
                    isFollow=false;
                }else {
                    mFllow.setBackgroundResource(R.drawable.shap_fllow_text);
                    //添加关注
                    isFollow=true;
                    mFllow.setText(R.string.unFollowColumn);
                }
                break;
        }
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitles.get(position);
        }
    }
}
