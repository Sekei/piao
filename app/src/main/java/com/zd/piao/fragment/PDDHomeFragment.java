package com.zd.piao.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.zd.piao.R;
import com.zd.piao.adapter.PDDHomeClassAdapter;
import com.zd.piao.adapter.PDDHomeGoodsAdapter;
import com.zd.piao.base.BaseFragment;
import com.zd.piao.service.ScrollViewListener;
import com.zd.piao.utils.GlideImageLoader;
import com.zd.piao.utils.ReboundHScrollView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/3/5.
 */

public class PDDHomeFragment extends BaseFragment implements OnBannerListener, ScrollViewListener {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.image_huodong)
    ImageView imageHuoDong;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    //商品列表
    @BindView(R.id.recycler_goods)
    RecyclerView recyclerGoods;
    //scrollview
    @BindView(R.id.scroll_one)
    ReboundHScrollView scrollViewOne;
    @BindView(R.id.scroll_two)
    ReboundHScrollView scrollViewTwo;


    private ArrayList<String> list_path = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pdd_home;
    }


    @Override
    protected void initView() {
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/ac8f3881678dfe27cf0fe6fe8491573a.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/71fb84893ddc1c52d4cd98e6cc0e9a74.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/9ab7eddcb754d3eb771d656172a68b57.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/85360680c0612849266abd846c814ed4.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/71808355518e9284bb875d314de2d453.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t16img.yangkeduo.com/pdd_oms/2018-12-05/491104b3e5122ced16387ed699fff134.jpg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t16img.yangkeduo.com/pdd_oms/2018-12-19/2085d13d679874b0aa4f5f1e0ba979cf.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/21a739cb3c5665e6a29b59a489d98cc4.jpeg?imageMogr2/format/webp/quality/50");
        list_path.add("http://t00img.yangkeduo.com/goods/images/2019-03-04/7821e3e46c9f5cc578b48f91022bcb11.jpeg?imageMogr2/format/webp/quality/50");
        //设置样式，里面有很多种样式可以自己都看看效果
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//指示器模式
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置指示器的位置，小点点，居中显示
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mBanner.setOnBannerListener(this);//轮播图的监听
        //设置图片加载地址
        mBanner.setImages(list_path);
        //开始调用的方法，启动轮播图。
        mBanner.start();
        //分类适配器
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(8, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new PDDHomeClassAdapter(getActivity(), R.layout.item_pdd_home));
        //最惠时尚
        Glide.with(this).load("http://t00img.yangkeduo.com/goods/images/2019-03-05/764677c368f2e37d77b0b41c3da78aed.gif?imageMogr2/sharpen/1%7CimageView2/2/w/1300/").into(imageHuoDong);
        //商品列表适配器
        recyclerGoods.setNestedScrollingEnabled(false);
        recyclerGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerGoods.setAdapter(new PDDHomeGoodsAdapter(getActivity(), R.layout.item_pdd_home_goods));

        scrollViewOne.setOnScrollViewListener(this);
        scrollViewTwo.setOnScrollViewListener(this);
    }


    @Override
    public void OnBannerClick(int position) {

    }

    @Override
    public void onScrollChanged(ReboundHScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == scrollViewOne) {
            scrollViewTwo.scrollTo(x, y);
        } else if (scrollView == scrollViewTwo) {
            scrollViewOne.scrollTo(x, y);
        }
    }
}

