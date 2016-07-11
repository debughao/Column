package com.debughao.column.model;

import android.content.Context;

import com.debughao.column.model.impl.ArticleListModelImpl;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/11 22:22
 * description :
 */
public interface ArticleListModel {
    void onLoadColumnList(Context context , int limit, int offset, int seed, ArticleListModelImpl.OnLoadPostsListener mOnLoadColumnListListener);

}
