package com.zd.piao.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.githang.statusbar.StatusBarCompat;
import com.zd.piao.R;

import butterknife.ButterKnife;

/**
 * Created by admin on 2019/3/1.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        initView();
    }

    private void initActionBar() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(getLayoutId());
        //初始化BUtterKnife框架，可写在项目基类里面。
        ButterKnife.bind(this);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.color_ef4136));
    }
}
