package com.liuchuanzheng.skillcollection.ui.activitys.BaseRecyclerViewAdapterHelper_10;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuchuanzheng.skillcollection.R;

import java.util.List;

/**
 * Created by 刘传政 on 2018/5/30 0030.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class MyAdapter extends BaseItemDraggableAdapter<String,BaseViewHolder> {

    public MyAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv,item);
    }
}
