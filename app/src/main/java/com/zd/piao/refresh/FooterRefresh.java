package com.zd.piao.refresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * Created by admin on 2019/3/4.
 */

public class FooterRefresh extends LinearLayout implements RefreshFooter {

    public static String REFRESH_FOOTER_PULLUP = "上拉加载";
    public static String REFRESH_FOOTER_RELEASE = "释放加载";
    public static String REFRESH_FOOTER_LOADING = "正在加载";
    public static String REFRESH_FOOTER_REFRESHING = "正在刷新";
    public static String REFRESH_FOOTER_FINISH = "加载完成";
    public static String REFRESH_FOOTER_FAILED = "加载失败";
    public static String REFRESH_FOOTER_ALLLOADED = "没有更多数据了";

    private TextView mHeaderText;//标题文本
    protected boolean mNoMoreData = false;

    public FooterRefresh(Context context) {
        super(context);
        this.initView(context, null, 0);
    }

    public FooterRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context, attrs, 0);
    }

    public FooterRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        setGravity(Gravity.CENTER);
        mHeaderText = new TextView(context);
        mHeaderText.setTextSize(10);
        mHeaderText.setText(REFRESH_FOOTER_PULLUP);
        addView(mHeaderText, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setMinimumHeight(DensityUtil.dp2px(40));
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (!mNoMoreData) {
            if (success) {
                mHeaderText.setText(REFRESH_FOOTER_FINISH);
            } else {
                mHeaderText.setText(REFRESH_FOOTER_FAILED);
            }
            return 200;
        }
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        if (!mNoMoreData) {
            switch (newState) {
                case PullUpToLoad:
                    mHeaderText.setText(REFRESH_FOOTER_PULLUP);
                    break;
                case Loading:
                case LoadReleased:
                    mHeaderText.setText(REFRESH_FOOTER_LOADING);
                    break;
                case ReleaseToLoad:
                    mHeaderText.setText(REFRESH_FOOTER_RELEASE);
                    break;
                case Refreshing:
                    mHeaderText.setText(REFRESH_FOOTER_REFRESHING);
                    break;
            }
        }
    }

    @Override
    public boolean setNoMoreData(boolean noMoreData) {
        if (mNoMoreData != noMoreData) {
            mNoMoreData = noMoreData;
            if (noMoreData) {
                mHeaderText.setText(REFRESH_FOOTER_ALLLOADED);
            } else {
                mHeaderText.setText(REFRESH_FOOTER_PULLUP);
            }
        }
        return true;
    }
}
