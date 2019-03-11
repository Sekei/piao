package com.zd.piao;

import android.view.View;
import android.widget.TextView;

import com.zd.piao.base.BaseActivity;
import com.zd.piao.emptly.LoadingAndRetryManager;
import com.zd.piao.emptly.OnLoadingAndRetryListener;

import me.leefeng.promptlibrary.PromptDialog;

public class TestActivity extends BaseActivity {
    private PromptDialog promptDialog;
    private LoadingAndRetryManager mLoadingAndRetryManager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        promptDialog = new PromptDialog(this);
        TextView refreshLayout = findViewById(R.id.text);
        //SmartRefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        mLoadingAndRetryManager = LoadingAndRetryManager.generate(refreshLayout, new OnLoadingAndRetryListener() {
            @Override
            public void setRetryEvent(View retryView) {
                //promptDialog.showLoading("正在登录");
            }
        });
        mLoadingAndRetryManager.showLoading();
        //mLoadingAndRetryManager.showEmpty();
        //mLoadingAndRetryManager.showRetry();
        //mLoadingAndRetryManager.showContent();
    }

}
