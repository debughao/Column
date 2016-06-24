package com.debughao.column.presenter;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 13:09
 * description :
 */
public interface ColumnDetailPresenter {
    void getColumnDetail(String columnName);
    void getColumnPostList(int pageIndex,String columnName);
}
