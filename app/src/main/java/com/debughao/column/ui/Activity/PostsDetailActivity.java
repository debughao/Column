package com.debughao.column.ui.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.debughao.column.R;
import com.debughao.column.base.BaseActivity;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.utils.NetUtils;
import com.debughao.column.utils.StringUtils;
import com.debughao.column.view.PostsDetailView;

public class PostsDetailActivity extends BaseActivity implements PostsDetailView {
    public WebView mWebView;
    private String mBaseHtml;
    private String mTitle;
    private  PostsBean mPostsBean;
    @Override
    public int getLayoutId() {
       return R.layout.activity_posts_detail;
    }

    @Override
    public void initView() {
        initWebView();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

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

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public String getHtml(PostsBean postsBean ) {
        mTitle = postsBean.getTitle();
                StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html lang=\"zh-CN>\n  head>\n" +
                "<meta charset=\"utf-8\" />\n" +
                "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\">\n" +
                "<meta name=\"format-detection\" content=\"telephone=no,email=no\">");
        sb.append("<title>" + mTitle + "</title>");
        sb.append("<link rel=\"stylesheet\" href=\"file:///android_asset/style.css\">");
        sb.append("</head><body>");
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public void loadWebView(PostsBean postsBean) {
      mBaseHtml=  getHtml(postsBean);
      loadUrl(mBaseHtml);
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
                loadUrl( url);// 载入网页
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
