package com.debughao.column.view;

import com.debughao.column.base.BaseView;
import com.debughao.column.data.bean.CommentBean;
import com.debughao.column.data.bean.PostsBean;
import com.debughao.column.data.bean.SubColumn;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/28 18:11
 * description :
 */
public interface PostsDetailView extends BaseView {
    void  loadWebView(PostsBean postsBean);
    void  loadCommentView(List<CommentBean> commentBean);
    void  loadSubColumnView(List<SubColumn> subColumn);
}
