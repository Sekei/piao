package com.zd.piao.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by admin on 2018/2/26.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
  //间距
  private int mSpace;
  //每行显示的个数，用于计算间距
  private int mItem = 2;


  public SpaceItemDecoration(int space, int mItem) {
    this.mSpace = space;
    this.mItem = mItem;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
      RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);
    //不是第一个的格子都设一个左边和底部的间距
    outRect.left = mSpace;
    outRect.bottom = mSpace;
    //由于每行都只有3个，所以第一个都是2的倍数，把左边距设为0
    if (parent.getChildLayoutPosition(view) % mItem == 0) {
      outRect.left = 0;
    }
  }
}
