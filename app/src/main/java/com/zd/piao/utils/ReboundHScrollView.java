package com.zd.piao.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import com.zd.piao.service.ScrollViewListener;

/**
 * Created by admin on 2019/3/5.
 */

public class ReboundHScrollView extends HorizontalScrollView {
    private static final int MAX_SCROLL = 150;
    private static final float SCROLL_RATIO = 0.5f;// 阻尼系数

    private ScrollViewListener scrollViewListener = null;

    public ReboundHScrollView(Context context) {
        super(context);
    }

    public ReboundHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReboundHScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int newDeltaX = deltaX;
        int delta = (int) (deltaX * SCROLL_RATIO);
        if ((scrollX + deltaX) == 0 || (scrollX - scrollRangeX + deltaX) == 0) {
            newDeltaX = deltaX;     //回弹最后一次滚动，复位
        } else {
            newDeltaX = delta;      //增加阻尼效果
        }
        return super.overScrollBy(newDeltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, MAX_SCROLL, maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public void setOnScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

}
