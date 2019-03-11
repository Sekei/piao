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

public class PDDHomeGoodsClassAdapter extends HelperRecyclerViewAdapter<String> {

    List<String> arrImages = Arrays.asList(
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/c8957ade9f897cd35ab1d2bcc700a87a.jpeg?i",
            "http://t00img.yangkeduo.com/goods/images/2019-02-21/9b6b27b2049c9d51d4c2db1cfbb4f87d.png?im",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/ab9e44c28a5ef37e5840c6a489e80740.jpeg?imageMogr2/sharpen/1%7CimageView2/2/w/108/q/70/format/webp\"\n",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/638f461a8a101b44d7837074a8534938.jpeg?ima",
            "http://t00img.yangkeduo.com/goods/images/2018-10-15/238509a95cfe8bbc15c03a5f5eaba5b0.jpeg?ima",
            "http://t00img.yangkeduo.com/goods/images/2019-02-21/04518348977988e9d6a3301a63a037db.png?imag",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/ed847319eaff1058f888785e9cd8639d.jpeg?i",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/d2ab428d91a45a93254c6c553c7eef7c.jpeg?ima",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/d8e636d80e5a50f9a632668261ac1068.jpeg?imageMogr2/sharpen/1%7CimageView2/2/w/108/q",
            "http://t00img.yangkeduo.com/goods/images/2018-09-07/d2ab428d91a45a93254c6c553c7eef7c.jpeg?ima"
    );

    public PDDHomeGoodsClassAdapter(Context context, int... layoutIds) {
        super(Arrays.asList("春上新", "T恤", "休闲裤", "牛仔裤", "套装", "夹克", "毛衣", "卫衣", "衬衫", "查看全部"), context, layoutIds);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        viewHolder.setText(R.id.name, item);
        viewHolder.setVisible(R.id.iamges_gengduo, false);
        viewHolder.setVisible(R.id.iamges, true);
        if (position == 9) {
            viewHolder.setVisible(R.id.iamges, false);
            viewHolder.setVisible(R.id.iamges_gengduo, true);
        } else {
            Glide.with(mContext).load(arrImages.get(position)).into((ImageView) viewHolder.getView(R.id.iamges));
        }
    }
}
