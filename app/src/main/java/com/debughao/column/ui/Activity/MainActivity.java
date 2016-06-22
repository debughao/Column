package com.debughao.column.ui.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.debughao.column.R;
import com.debughao.column.ui.Fragment.ArticleFragment;
import com.debughao.column.ui.Fragment.ColoumnFragment;
import com.debughao.column.ui.Fragment.MyFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private static final String TAG = "MainActivity";
    private int lastSelectedPosition = 0;
    private ArticleFragment articleFragment;
    private ColoumnFragment coloumnFragment;
    private MyFragment myFragment;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @Bind(R.id.tv_mainTitle)
    TextView mMainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeDay);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.tab_data_normal, "专栏").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.tab_info_normal, "文章").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.tab_my_normal, "我的").setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(lastSelectedPosition)//设置默认选中
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        coloumnFragment = new ColoumnFragment();
        transaction.replace(R.id.id_content, coloumnFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                mMainTitle.setText(R.string.recommendColumn);
                if (coloumnFragment == null) {
                    coloumnFragment = new ColoumnFragment();
                }
                transaction.replace(R.id.id_content, coloumnFragment);

                break;
            case 1:
                mMainTitle.setText(R.string.recommendArticle);
                if (articleFragment == null) {
                    articleFragment = new ArticleFragment();
                }
                transaction.replace(R.id.id_content, articleFragment);

                break;
            case 2:
                mMainTitle.setText(R.string.my);
                if (myFragment == null) {
                    myFragment = MyFragment.newInstance("我的", "");
                }
                transaction.replace(R.id.id_content, myFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
