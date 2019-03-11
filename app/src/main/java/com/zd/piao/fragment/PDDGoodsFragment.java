package com.zd.piao.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zd.piao.R;
import com.zd.piao.adapter.PDDGoodsAdapter;
import com.zd.piao.adapter.PDDHomeGoodsClassAdapter;
import com.zd.piao.base.BaseFragment;
import com.zd.piao.utils.SpaceItemDecoration;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import butterknife.BindView;

/**
 * Created by admin on 2019/3/5.
 */

public class PDDGoodsFragment extends BaseFragment {

    @BindView(R.id.image_huodong)
    ImageView imageHuoDong;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    //商品列表
    @BindView(R.id.recycler_goods)
    RecyclerView recyclerGoods;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pdd_goods;
    }


    @Override
    protected void initView() {
        //分类适配器
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new PDDHomeGoodsClassAdapter(getActivity(), R.layout.item_pdd_goods_class));
        Glide.with(this).load("http://t00img.yangkeduo.com/goods/images/2019-02-27/8f039366b9ea6eb2d051a85c2192884b.jpeg?").into(imageHuoDong);
        //商品列表
        recyclerGoods.setNestedScrollingEnabled(false);
        recyclerGoods.addItemDecoration(new SpaceItemDecoration(UIUtil.dip2px(getActivity(), 5), 2));
        recyclerGoods.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerGoods.setAdapter(new PDDGoodsAdapter(getActivity(), R.layout.item_pdd_goods));
    }
}
