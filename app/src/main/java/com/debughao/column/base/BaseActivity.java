package com.debughao.column.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.debughao.column.R;
import com.debughao.column.utils.UiUtis;
import com.debughao.column.widget.layout.SwipeBackLayout;

import butterknife.ButterKnife;

/**
 * Created by debguhao on 2016/6/17.
 */
public abstract class BaseActivity extends AppCompatActivity  {
    public Context mContext;
    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        this.setContentView(this.getLayoutId());
        ButterKnife.bind(this);
        this.initView();
        this.initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    public void reload() {
//        Intent intent = getIntent();
//        overridePendingTransition(0, 0);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        finish();
//        overridePendingTransition(0, 0);
//        startActivity(intent);
//    }

    @Override
    public void setContentView(int layoutResID) {
        if (layoutResID == R.layout.activity_login){
            UiUtis.setImmersionStatus(this);
            super.setContentView(layoutResID);
        }else if (layoutResID == R.layout.activity_main || layoutResID == R.layout.activity_flash) {
            setTheme(R.style.AppThemeDay);
            super.setContentView(layoutResID);
        } else {
            setTheme(R.style.AppThemeDay);
            super.setContentView(getContainer());
            View view = LayoutInflater.from(this).inflate(layoutResID, null);
            view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.window_background));
            swipeBackLayout.addView(view);
        }
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new SwipeBackLayout(this);
        swipeBackLayout.setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_black_7f));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        swipeBackLayout.setOnSwipeBackListener(new SwipeBackLayout.SwipeBackListener() {
            @Override
            public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
                ivShadow.setAlpha(1 - fractionScreen);
            }
        });
        return container;
    }

    public abstract int getLayoutId();

    public abstract void initView();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public abstract void initPresenter();
    interface  BaseActivityDao<T extends BasePresenter, E extends BaseModel>{

    };
}
