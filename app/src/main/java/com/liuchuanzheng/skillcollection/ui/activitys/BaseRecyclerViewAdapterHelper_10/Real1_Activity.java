package com.liuchuanzheng.skillcollection.ui.activitys.BaseRecyclerViewAdapterHelper_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 刘传政 on 2017/7/4 0004.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */

public class Real1_Activity extends LCZBaseActivity {
    @BindView(R.id.rcv)
    RecyclerView rcv;
    ArrayList<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_baserecyclerviewadapterhelper);
        ButterKnife.bind(this);
        realTest();
    }


    private void realTest() {
        for (int i = 0; i < 40; i++) {
            mList.add(i, "我是第" + i + "条数据" );
        }
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        MyAdapter myAdapter = new MyAdapter(R.layout.item_live_list_layout,mList);
        myAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        myAdapter.isFirstOnly(false);
        //默认第一次加载会进入回调，如果不需要可以配置：
       // myAdapter.disableLoadMoreIfNotFullPage();
        // 开启滑动删除
        myAdapter.enableSwipeItem();
        // 开启拖拽
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(myAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rcv);

        myAdapter.enableDragItem(itemTouchHelper);
        rcv.setAdapter(myAdapter);
        //限制了RecyclerView自身的滑动，整个页面滑动仅依靠ScrollView实现，即可解决滑动卡顿的问题
        //这样recycleview的性能会降低。 尽量避免scrollview嵌套recyclerview
        rcv.setHasFixedSize(true);
        rcv.setNestedScrollingEnabled(false);
        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(Real1_Activity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
        myAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                return false;
            }
        });
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, Real1_Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
}
