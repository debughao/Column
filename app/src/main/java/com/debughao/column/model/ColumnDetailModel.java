package com.debughao.column.model;

import com.debughao.column.model.impl.ColumnDetailModelImpl;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 10:49
 * description :
 */
public interface ColumnDetailModel {
    void onLoadColumnDetail( String Url , ColumnDetailModelImpl.OnLoadColumnDetailListener onLoadColumnDetailListener);
    void onLoadColumnPostsList(int limit, int offset, String Url, ColumnDetailModelImpl.OnLoadColumnPostsListListener onLoadColumnPostsListListener);
}
