package com.zd.piao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.piao.baselibrary.roundimageview.CircleImageView;
import com.zd.piao.R;
import com.zd.piao.utils.PileLayout;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.Arrays;

/**
 * Created by admin on 2019/3/5.
 */

public class PDDGoodsAdapter extends HelperRecyclerViewAdapter<String> {

    String[] urls = {"http://t20img.yangkeduo.com/a/8b11512796b3e408c4b52694c64d01bc33a9a913-1539704518?imageMogr2/sharpen/1%7CimageView2/2/w/50/q/70/format/",
            "http://t20img.yangkeduo.com/a/cbef5b0e342569bea404df9c2db676f9043196a7-1548198765?imageMogr2/sharpen/1%7CimageView2/2/w/50/q/70/format"
    };
    private LayoutInflater inflater = LayoutInflater.from(mContext);

    public PDDGoodsAdapter(Context context, int... layoutIds) {
        super(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""), context, layoutIds);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        //viewHolder.setText(R.id.name, item);
        Glide.with(mContext).load("http://t00img.yangkeduo.com/goods/images/2019-02-13/b46c1ca2-6b1a-4780-bc82-0d5c4ab62382.jpg?").into((ImageView) viewHolder.getView(R.id.iamges));
        //堆叠头像显示（2个）
        PileLayout mPileLayout = viewHolder.getView(R.id.pile_layout);
        for (int i = 0; i < urls.length; i++) {
            CircleImageView imageView = (CircleImageView) inflater.inflate(R.layout.item_praise, mPileLayout, false);
            Glide.with(mContext).load(urls[i]).into(imageView);
            mPileLayout.addView(imageView);
        }
    }
}
