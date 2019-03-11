package com.zd.piao.service;

import com.zd.piao.utils.ReboundHScrollView;

/**
 * Created by admin on 2019/3/6.
 */

public interface ScrollViewListener {
    void onScrollChanged(ReboundHScrollView scrollView, int x, int y, int oldx, int oldy);
}
