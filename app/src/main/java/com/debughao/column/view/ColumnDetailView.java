package com.debughao.column.view;

import com.debughao.column.base.BaseView;
import com.debughao.column.data.bean.ColumnDetail;
import com.debughao.column.data.bean.PostsBean;

import java.util.List;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 10:45
 * description : 专栏详情view操作
 */
public interface ColumnDetailView extends BaseView {
    void onRefreshColumnDetailData(ColumnDetail columnDetail);
    void onRefreshColumnPostsData(List<PostsBean> postsBeanList);
}
