package com.debughao.column.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.debughao.column.R;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/1 09:55
 * description :
 */
public class LikeButton extends TextView {
    private Drawable unDrawableLeft;
    private int unLikeDrawable, likeDrawable;
    private boolean isLike=false;
    private int unLikeTextColor, likeTextColor;
    private int unLikeBackground, likeBackground;

    public LikeButton(Context context) {
        super(context);
        init(context, null, 0);
    }


    public LikeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public LikeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LikeButton, defStyleAttr, 0);
        int n = array.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.LikeButton_IsLike:
                    isLike = array.getBoolean(attr, false);
                    break;
                case R.styleable.LikeButton_LikeBackground:
                    likeBackground = array.getResourceId(attr, 0);
                    break;
                case R.styleable.LikeButton_UnLikeBackground:
                    unLikeBackground = array.getResourceId(attr, 0);
                    break;
                case R.styleable.LikeButton_LikeImage:
                    likeDrawable = array.getResourceId(attr, 0);
                    break;
                case R.styleable.LikeButton_UnLikeImage:
                    unLikeDrawable = array.getResourceId(attr, 0);
                    break;
                case R.styleable.LikeButton_LikeTextColor:
                    likeTextColor = array.getColor(attr, 0);
                    break;
                case R.styleable.LikeButton_UnLikeTextColor:
                    unLikeTextColor = array.getColor(attr, 0);
                    break;

            }
        }
        array.recycle();//recycle TypedArray
        setTextStyle(isLike);
    }

    public void setTextStyle(boolean isLike) {
        setPadding(30, 15, 30, 15);
        if (isLike) {
            unDrawableLeft = ContextCompat.getDrawable(getContext(), likeDrawable);
            setTextColor(likeTextColor);
            setCompoundDrawablesWithIntrinsicBounds(unDrawableLeft, null, null, null);
            setBackgroundResource(likeBackground);
        } else {
            unDrawableLeft = ContextCompat.getDrawable(getContext(), unLikeDrawable);
            setTextColor(unLikeTextColor);
            setCompoundDrawablesWithIntrinsicBounds(unDrawableLeft, null, null, null);
            setBackgroundResource(unLikeBackground);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
