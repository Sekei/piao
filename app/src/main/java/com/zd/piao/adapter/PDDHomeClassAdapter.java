package com.zd.piao.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zd.piao.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2019/3/5.
 */

public class PDDHomeClassAdapter extends HelperRecyclerViewAdapter<String> {

    List<String> arrImages = Arrays.asList(
            "http://t07img.yangkeduo.com/images/2018-05-16/26c916947489c6b2ddd188ecdb54fd8d.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2018-12-22/b9851773573d1d682aa46d896de7f4fa.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-03-05/bd29631f13f5d4dc4d154a6170274194.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-01-30/5667b3f1eaa8bb379303afb3934d1bc8.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2018-10-07/c671f2c49805658697cc0f72fff87eb3.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-02-15/b329c4673337e18030f1211df38a543b.png?imageMogr2/format/webp/quality/50",
            "http://t10img.yangkeduo.com/images/2018-05-16/712fc1e7f4f7b0572257ef162b5185a9.png?imageMogr2/format/webp/quality/50",
            "http://t05img.yangkeduo.com/images/2018-05-04/c71c9acd8b48203a704f6c0951caddc0.png?imageMogr2/format/webp/quality/50",
            "http://t05img.yangkeduo.com/images/2018-05-16/801ae189938526cdaf40935d07034c5e.png?imageMogr2/format/webp/quality/50",
            "http://t03img.yangkeduo.com/images/2018-05-16/a666ac01e718dd06231a722baa6fa935.png?imageMogr2/format/webp/quality/50",
            "http://t01img.yangkeduo.com/images/2018-05-16/c2ba677bcd16ecad6c335e5e04a1cf1e.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-02-05/1351e256a0319a6885761b937d06d581.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2018-08-31/2068a85245f512000d78325876d23ae3.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-01-20/d36b7af30da354cb2c8ad4ea7bd819cd.png?imageMogr2/format/webp/quality/50",
            "http://t00img.yangkeduo.com/goods/images/2019-02-15/1ddd6e21a8281e794dec6ef736867290.png?imageMogr2/format/webp/quality/50",
            "http://t11img.yangkeduo.com/images/2018-04-28/5cfc9925dac860135143921e0f687a7d.png?imageMogr2/format/webp/quality/50"
    );

    public PDDHomeClassAdapter(Context context, int... layoutIds) {
        super(Arrays.asList("限时秒杀", "断货清仓", "品牌馆", "多多果园", "9块9特卖", "助力享免单", "天天领现金", "1分抽大奖", "充值中心", "爱逛街", "现金签到", "金猪赚大钱", "电器城", "每日好店", "砍价免费拿", "帮帮免费团"), context, layoutIds);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        viewHolder.setText(R.id.name, item);
        Glide.with(mContext).load(arrImages.get(position)).into((ImageView) viewHolder.getView(R.id.iamges));
        //签动画
        if (position == 10) {
            Glide.with(mContext).load("http://t00img.yangkeduo.com/goods/images/2018-12-03/6fffdaa9bdef16e5140d46357293e1fa.gif?imageMogr2/sharpen/1%7CimageView2/2/w/1300/").into((ImageView) viewHolder.getView(R.id.iamges_gif));
        }
        //新动画
        if (position == 0 || position == 3) {
            Glide.with(mContext).load("http://t00img.yangkeduo.com/goods/images/2018-11-27/b029799e2af2466305285a445feb13a7.gif?imageMogr2/strip%7CimageView2/2/w/1300/q/80").into((ImageView) viewHolder.getView(R.id.iamges_gif));
        }
    }
}
