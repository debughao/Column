package com.debughao.column.view;

import com.debughao.column.base.BaseView;
import com.debughao.column.data.bean.Column;

import java.util.List;

/**
 * Created by admin on 2016/6/22.
 */
public interface ColumnsListView extends BaseView {
    void onRefreshData(List<Column> columns);
}
