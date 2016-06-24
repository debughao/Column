package com.debughao.column.widget.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/24 09:34
 * description :Y方向可以滑动
 */
public class YCanScrollview extends NestedScrollView {


    GestureDetector gestureDetector;
    public YCanScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(context,new YScroll());
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) && gestureDetector.onTouchEvent(ev);
    }

    class YScroll extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            //控制手指滑动的距离
            return Math.abs(distanceY) >= Math.abs(distanceX);
        }
    }
}
