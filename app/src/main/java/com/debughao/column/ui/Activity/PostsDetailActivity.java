package com.debughao.column.ui.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.debughao.column.R;
import com.debughao.column.adapter.CommentAdapter;
import com.debughao.column.base.BaseActivity;
import com.debughao.column.data.bean.CommentBean;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.data.bean.SubColumn;
import com.debughao.column.presenter.PostsDetailPresenter;
import com.debughao.column.presenter.impl.PostsDetailPresenterImpl;
import com.debughao.column.utils.DateHelper;
import com.debughao.column.utils.MyToast;
import com.debughao.column.utils.NetUtils;
import com.debughao.column.utils.StringUtils;
import com.debughao.column.view.PostsDetailView;
import com.debughao.column.widget.view.CircleImageView;
import com.debughao.column.widget.view.LikeButton;
import com.debughao.column.widget.view.ZhFullyListView;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class PostsDetailActivity extends BaseActivity implements PostsDetailView {
    private PostsDetailPresenter mPostsDetailPresenter;

    @Bind(R.id.tv_postsTitle)
    TextView mPostsTitle;
    @Bind(R.id.tv_postsAutor)
    TextView mPostsAutor;
    @Bind(R.id.iv_PostsAvatar)
    CircleImageView mPostsAutorAvatar;
//    @Bind(R.id.iv_PostsAvatars)
    CircleImageView mPostsAutorAvatars;
    @Bind(R.id.wb_postsDetail)
    WebView mWebView;
    @Bind(R.id.toolbar_PostDetail)
    Toolbar mToolbar;
//    @Bind(R.id.tv_postsLike)
    LikeButton mPostsLike;
    @Bind(R.id.tv_postsTip)
    TextView mPostsTip;
//    @Bind(R.id.tv_postsTitles)
    TextView mPostsTitles;
//    @Bind(R.id.tv_postsDescriptions)
    TextView mPostsDescription;
    @Bind(R.id.tv_enterColumn)
    TextView mEnterColumn;
//    @Bind(R.id.tv_commentNum)
    TextView mCommentNum;
//    @Bind(R.id.ll_postsFooter)
    LinearLayout mPostsFooter;
//    @Bind(R.id.ll_postsComment)
    LinearLayout mPostsComment;
//    @Bind(R.id.lv_postsComment)
    ZhFullyListView mListCommentView;
    private ImageView mImageView;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView mTitleTextView;
    private String mBaseHtml, columnName, mTitle, mTitleImage;
    private PostsBean mPostsBean;
    private String refer;
    private int slug;
    private CommentAdapter mCommentAdapter;
    private List<CommentBean> mCommentList = new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public int getLayoutId() {
        if (TextUtils.isEmpty(mTitleImage)) {
            return R.layout.activity_posts_detail_untitleimage;
        } else {
            return R.layout.activity_posts_detail;
        }
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mPostsTitle.setText(columnName);
        mCommentNum= (TextView) findViewById(R.id.tv_commentNum);
        mPostsFooter= (LinearLayout) findViewById(R.id.ll_postsFooter);
        mListCommentView= (ZhFullyListView) findViewById(R.id.lv_postsComment);
        mPostsComment= (LinearLayout) findViewById(R.id.ll_postsComment);
        if (TextUtils.isEmpty(mTitleImage)) {
            mTitleTextView = (TextView) findViewById(R.id.tv_tb_postsTitle);
            mTitleTextView.setText(columnName);
        } else {
            mImageView = (ImageView) findViewById(R.id.iv_postsDetailImage);
            collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_PostsDetail);
            collapsingToolbar.setTitle(columnName);
        }
        initWebView();
        mPostsDetailPresenter = new PostsDetailPresenterImpl(mContext, this);
        mPostsDetailPresenter.getPostsDetail(refer, slug);

    }

    @Override
    protected void getBundleExtras(Bundle extras) {
        mTitleImage = extras.getString("titleImage", "");
        columnName = extras.getString("columnName", "");
        refer = extras.getString("refer", "");
        slug = extras.getInt("slug", 0);
    }


    public void loadUrl(final String url) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (StringUtils.isInternetURL(url)) {
                    mWebView.loadUrl(url);// 载入网页
                } else {
                    mWebView.loadDataWithBaseURL("", mBaseHtml, "text/html", "UTF-8", "");//载入网页片段
                }
            }
        });
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

    public String getHtml(PostsBean postsBean) {
        mTitle = postsBean.getTitle();
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html lang=\"zh-CN>\n  head>\n" +
                "<meta charset=\"utf-8\" />\n" +
                "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\">\n" +
                "<meta name=\"format-detection\" content=\"telephone=no,email=no\">");
        sb.append("<title>" + mTitle + "</title>");
        sb.append("<link rel=\"stylesheet\" href=\"file:///android_asset/style.css\">");
        sb.append("</head><body>");
        sb.append("<section class=\"entry-content\">");
        sb.append(postsBean.getContent());
        sb.append("</section>");
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public void loadWebView(PostsBean postsBean) {
        this.mPostsBean = postsBean;
        String publishedTime = postsBean.getPublishedTime();
        mPostsAutor.setText(postsBean.getAuthor().getName() + " · " + DateHelper.getInstance().getTimeStateString(publishedTime));
        Glide.with(mContext).load(postsBean.getAuthor().getAvatar().getTemplate("b")).diskCacheStrategy(DiskCacheStrategy.ALL).into(mPostsAutorAvatar);
        if (!TextUtils.isEmpty(mTitleImage)) {
            Glide.with(getApplicationContext()).load(mTitleImage).diskCacheStrategy(DiskCacheStrategy.ALL).into(mImageView);
        }
        mBaseHtml = getHtml(postsBean);
        loadUrl(mBaseHtml);
    }

    @Override
    public void loadCommentView(List<CommentBean> commentBean) {
        if (mPostsBean.isCanComment()) {//允许评论

        }else {//不允许许评论

        }
        int commentNum = mPostsBean.getCommentsCount();

        if (commentNum != 0) {
            mCommentNum.setText(commentNum + "条评论");
        }else {
            mCommentNum.setText( "还没有评论");
        }
        mCommentAdapter = new CommentAdapter(commentBean, mContext);
        mListCommentView.setAdapter(mCommentAdapter);
        mCommentAdapter.notifyDataSetChanged();
        mPostsComment.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadSubColumnView(final List<SubColumn> subColumn) {
        mPostsAutorAvatars= (CircleImageView) findViewById(R.id.iv_PostsAvatars);
        mPostsLike= (LikeButton) findViewById(R.id.tv_postsLike);
        mPostsTitles= (TextView) findViewById(R.id.tv_postsTitles);
        mPostsDescription= (TextView) findViewById(R.id.tv_postsDescriptions);
        Glide.with(getApplicationContext()).load(subColumn.get(0).getSourceColumn().getImage_url()).diskCacheStrategy(DiskCacheStrategy.ALL).into(mPostsAutorAvatars);
        mPostsLike.setTextStyle(false);
        mPostsTitles.setText(subColumn.get(0).getSourceColumn().getName());
        mPostsDescription.setText(subColumn.get(0).getSourceColumn().getIntro());
        mPostsFooter.setVisibility(View.VISIBLE);
    }

    private void initWebView() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.getSettings().setAppCacheEnabled(true);
        // 启用数据库
        mWebView.getSettings().setDatabaseEnabled(true);
        String dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        mWebView.getSettings().setGeolocationDatabasePath(dir);
        mWebView.getSettings().setGeolocationEnabled(true);
        // LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
        // LOAD_DEFAULT: 根据cache-control决定是否从网络上取数据。
        // 总结：根据以上两种模式，建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT，无网络时，使用LOAD_CACHE_ELSE_NETWORK。
        if (NetUtils.isNetAvailable(mContext)) {
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                loadUrl(url);// 载入网页
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                // mProgressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
                mPostsDetailPresenter.getSubColumn(slug);
                mPostsDetailPresenter.getSubComment(slug, 0);
            }

            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                // TODO Auto-generated method stub

                super.onReceivedError(view, errorCode, description, failingUrl);
            }

        });


    }


}
