package com.debughao.column.model;

import android.content.Context;

import com.debughao.column.model.impl.ColumnListModelImpl;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/2213:40
 * description :
 */
public interface ColumnListModel {
    void onLoadColumnList(Context context ,int limit, int offset, int seed, ColumnListModelImpl.OnLoadColumnListListener mOnLoadColumnListListener);
}
