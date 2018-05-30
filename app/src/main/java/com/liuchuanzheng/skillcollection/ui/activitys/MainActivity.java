package com.liuchuanzheng.skillcollection.ui.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.ui.DividerItemDecoration;
import com.liuchuanzheng.skillcollection.ui.activitys.animation_2.AnimationTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.coordinatorlayout_6.CoordinatorLayoutTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.eventbus_7.EventBusTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.logger_1.LoggerTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.notifycation_8.Notifycation_Instruction_Activity;
import com.liuchuanzheng.skillcollection.ui.activitys.shareelement_9.Instruction_Activity;
import com.liuchuanzheng.skillcollection.ui.activitys.slidelayout_4.SlideLayoutTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.smartrefreshlayout_5.SmartRefreshLayoutTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.swiperefreshlayout_3.SwipeRefreshLayoutTestActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.textInputlayout.TextinputLayoutTestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends LCZBaseActivity {
    @BindView(R.id.rcv)
    RecyclerView recyclerView;
    private MyAdapter mAdapter;//recyclerview的适配器
    private String[] strings = {"logger","基本动画","SwipeRefreshLayout","SlideLayout",
            "SmartRefreshLayout","CoordinatorLayout","EventBus","notifycation","TextInputLayout"
            ,"共享元素","BaseRecyclerViewAdapterHelper"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));//两列
        recyclerView.setAdapter(mAdapter = new MyAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int position) {
                switchAndStartActivity(position);
            }

            @Override
            public void onLongClick(int position) {

            }
        });

    }

    /**
     * 打开每个知识点对应的activity
     * @param position
     */
    private void switchAndStartActivity(int position) {
        switch (position){
            case 0:
                //logger库测试
                LoggerTestActivity.startAction(((Activity) baseContext));
                break;
            case 1:
                //测试官方的基本动画
                AnimationTestActivity.startAction(((Activity) baseContext));
                break;
            case 2:
                //测试SwipeRefreshLayout
                SwipeRefreshLayoutTestActivity.startAction((Activity) baseContext);
                break;
            case 3:
                //测试SlideLayout
                SlideLayoutTestActivity.startAction((Activity) baseContext);
                break;
            case 4:
                //测试SmartRefreshLayout
                SmartRefreshLayoutTestActivity.startAction((Activity) baseContext);
                break;
            case 5:
                //测试CoordinatorLayout
                CoordinatorLayoutTestActivity.startAction((Activity) baseContext);
                break;
            case 6:
                //测试eventbus
                EventBusTestActivity.startAction((Activity) baseContext);
                break;
            case 7:
                Notifycation_Instruction_Activity.startAction((Activity) baseContext);
                break;
            case 8:
                TextinputLayoutTestActivity.startAction((Activity) baseContext);
                break;
            case 9:
                Instruction_Activity.startAction((Activity) baseContext);
                break;
            case 10:
                com.liuchuanzheng.skillcollection.ui.activitys.BaseRecyclerViewAdapterHelper_10.Instruction_Activity.startAction((Activity) baseContext);
                break;

        }
    }


    public interface OnClickListener{
        void onClick(int position);
        void onLongClick(int position);
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private OnClickListener onClickListener = null;
        public void setOnClickListener(OnClickListener onClickListener){
            this.onClickListener = onClickListener;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    baseContext).inflate(R.layout.item_recyclerview, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.tv.setText(strings[position]);
            if (onClickListener != null) {
                holder.tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(holder.getAdapterPosition());
                    }
                });
                holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onClickListener.onLongClick(holder.getAdapterPosition());
                        return false;
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return strings.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item);
            }
        }
    }


    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        //fade_in是第二个界面的进入动画，fade_out是第一个界面退出动画
        //5.0之前的overridePendingTransition
        activity.overridePendingTransition(R.anim.act_fade_in_1, R.anim.act_fade_out_1);
    }
}
