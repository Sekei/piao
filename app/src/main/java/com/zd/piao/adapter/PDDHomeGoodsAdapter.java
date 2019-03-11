package com.zd.piao.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.piao.baselibrary.roundimageview.CircleImageView;
import com.zd.piao.R;
import com.zd.piao.utils.PileLayout;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2019/3/5.
 */

public class PDDHomeGoodsAdapter extends HelperRecyclerViewAdapter<String> {

    String[] urls = {"http://t20img.yangkeduo.com/a/8b11512796b3e408c4b52694c64d01bc33a9a913-1539704518?imageMogr2/sharpen/1%7CimageView2/2/w/50/q/70/format/",
            "http://t20img.yangkeduo.com/a/cbef5b0e342569bea404df9c2db676f9043196a7-1548198765?imageMogr2/sharpen/1%7CimageView2/2/w/50/q/70/format"
    };
    private LayoutInflater inflater = LayoutInflater.from(mContext);

    public PDDHomeGoodsAdapter(Context context, int... layoutIds) {
        super(Arrays.asList("限时秒杀", "断货清仓", "品牌馆", "多多果园", "9块9特卖", "助力享免单", "天天领现金", "1分抽大奖", "充值中心", "爱逛街", "现金签到", "金猪赚大钱", "电器城", "每日好店", "砍价免费拿", "帮帮免费团"), context, layoutIds);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        //viewHolder.setText(R.id.name, item);
        Glide.with(mContext).load("http://t00img.yangkeduo.com/goods/images/2019-02-13/b46c1ca2-6b1a-4780-bc82-0d5c4ab62382.jpg?").into((ImageView) viewHolder.getView(R.id.iamges));
        TextView content = viewHolder.getView(R.id.name);
        SpannableString spanText = new SpannableString("  " + "【春节也发货】指甲刀套装修脚刀指甲钳套装剪指甲套装修甲套装");
        Drawable d = mContext.getResources().getDrawable(R.drawable.icon_nsj);
        // 左上右下 控制图片大小
        d.setBounds(0, 0, UIUtil.dip2px(mContext, 35), UIUtil.dip2px(mContext, 16));
        // 替换0,1的字符
        spanText.setSpan(new ImageSpan(d), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        content.setText(spanText);
        //堆叠头像显示（2个）
        PileLayout mPileLayout = viewHolder.getView(R.id.pile_layout);
        for (int i = 0; i < urls.length; i++) {
            CircleImageView imageView = (CircleImageView) inflater.inflate(R.layout.item_praise, mPileLayout, false);
            Glide.with(mContext).load(urls[i]).into(imageView);
            mPileLayout.addView(imageView);
        }
    }
}
