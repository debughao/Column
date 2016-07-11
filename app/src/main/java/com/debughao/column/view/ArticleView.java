package com.debughao.column.view;

import com.debughao.column.base.BaseView;
import com.debughao.column.data.bean.RecommendPostsBean;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/11 21:59
 * description :
 */
public interface ArticleView  extends BaseView {
    void onRefreshData(List<RecommendPostsBean> columnBeen);
}
