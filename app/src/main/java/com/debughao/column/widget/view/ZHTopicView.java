package com.debughao.column.widget.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.debughao.column.R;
import com.debughao.column.data.bean.PostTopicsBean;

import java.util.Iterator;
import java.util.List;


/**
 * Created by zhanghao on 2015/12/30.
 */
public class ZHTopicView extends HorizontalScrollView {
    private List<PostTopicsBean> PostTopicsBeans;
    private boolean b;

    public ZHTopicView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
    }

    public ZHTopicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHorizontalScrollBarEnabled(false);
    }

    public ZHTopicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHorizontalScrollBarEnabled(false);
    }
    @Override
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      //  Log.e(TAG, "onLayout------------------------------" + paramBoolean);
        if (b) {
            final LinearLayoutCompat localZHLinearLayout = (LinearLayoutCompat) getChildAt(0);
            if (localZHLinearLayout == null) {

            }else{
                int count = localZHLinearLayout.getChildCount();
                TextView localTextView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.text, localZHLinearLayout, false);
                localTextView.setText("...");
                int width = 0;
                for (int i = 0; i < count; i++) {
                    View child = localZHLinearLayout.getChildAt(i);
                    MarginLayoutParams lp = (MarginLayoutParams) child
                            .getLayoutParams();
                    width+=child.getWidth()+lp.leftMargin+lp.rightMargin;
                    //LogUtil.e("width + localTextView.getWidth()"+(width + localTextView.getWidth())+"getWidth()"+getWidth());
                    if (width + localTextView.getWidth() >= getWidth()) {
                        localZHLinearLayout.removeViews(i - 1, count - i + 1);
                        localZHLinearLayout.addView(localTextView);
                        b=false;
                        break;
                    }
                }
           }
       }

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    public void setPostTopicsBean(List<PostTopicsBean> list) {
        removeAllViews();
        this.b = true;
        this.PostTopicsBeans = list;
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext());
        linearLayoutCompat.setOrientation(LinearLayoutCompat.HORIZONTAL);
        Iterator iterator = PostTopicsBeans.iterator();
        while (iterator.hasNext()) {
            final PostTopicsBean localPostTopicsBean = (PostTopicsBean) iterator.next();
            TextView localTextView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.text, linearLayoutCompat, false);
            localTextView.setText(localPostTopicsBean.getName());
//            localTextView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getContext(), localPostTopicsBean.getName(), Toast.LENGTH_SHORT).show();
//                }
//            });
            linearLayoutCompat.addView(localTextView);
        }
        addView(linearLayoutCompat);
    }
}
