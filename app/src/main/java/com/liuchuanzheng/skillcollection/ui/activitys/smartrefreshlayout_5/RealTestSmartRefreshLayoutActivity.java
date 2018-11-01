package com.liuchuanzheng.skillcollection.ui.activitys.smartrefreshlayout_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.DropBoxHeader;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.FunGameBattleCityHeader;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.header.StoreHouseHeader;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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

public class RealTestSmartRefreshLayoutActivity extends LCZBaseActivity {
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private MyAdapter mAdapter;//recyclerview的适配器
    ArrayList<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_smartrefrush);
        ButterKnife.bind(this);
        realTest();
    }


    /**
     * 为recyclerView定义的点击接口
     */
    public interface OnClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    /**
     * recyclerView的adapter
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private OnClickListener onClickListener = null;

        public void setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    baseContext).inflate(R.layout.item_smart, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.tv.setText(mList.get(position));

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
            return mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item);
            }
        }
    }

    private void realTest() {
        for (int i = 0; i < 20; i++) {
            String message = "";
            if(i == 0){
                //Material风格头
                message = "MaterialHeader";
            }else if (i == 1){
                //古典风格头
                message = "ClassicsHeader";
            }else if (i == 2){
                //盒子风格头
                message = "DropboxHeader";
            }else if (i == 3){
                //纸飞机头
                message = "FlyRefreshHeader";
            }else if (i == 4){
                //贝塞尔雷达头
                message = "BezierRadarHeader";
            }else if (i == 5){
                message = "DeliveryHeader";
            }else if (i == 6){
                message = "CircleHeader";
            }else if (i == 7){
                message = "FunGameBattleCityHeader";
            }else if (i == 8){
                message = "StoreHouseHeader";
            }else if (i == 9){
                message = "PhoenixHeader";
            }else if (i == 10){
                message = "WaterDropHeader";
            }else if (i == 11){
                message = "WaveSwipeHeader";
            }
            mList.add(i, "我是第" + (i + 1) + "条数据" + message);
        }
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MyAdapter();
        rcv.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(baseContext, position + "", Toast.LENGTH_SHORT).show();
                if(position == 0){
                    //Material风格头
                    refreshLayout.setRefreshHeader(new MaterialHeader(baseContext).setShowBezierWave(false));
                    refreshLayout.setEnableHeaderTranslationContent(false);
                }else if (position == 1){
                    //古典风格头
                    refreshLayout.setRefreshHeader(new ClassicsHeader(baseContext));
                }else if (position == 2){
                    //盒子风格头
                    refreshLayout.setRefreshHeader(new DropBoxHeader(baseContext));
                }else if (position == 3){
                    //纸飞机头
                    refreshLayout.setRefreshHeader(new FlyRefreshHeader(baseContext));
                }else if (position == 4){
                    //贝塞尔雷达头
                    refreshLayout.setRefreshHeader(new BezierRadarHeader(baseContext));
                }else if (position == 5){
                    refreshLayout.setRefreshHeader(new DeliveryHeader(baseContext));
                }else if (position == 6){
                    //refreshLayout.setRefreshHeader(new CircleHeader(baseContext));
                }else if (position == 7){
                    refreshLayout.setRefreshHeader(new FunGameBattleCityHeader(baseContext));
                }else if (position == 8){
                    refreshLayout.setRefreshHeader(new StoreHouseHeader(baseContext));
                }else if (position == 9){
                    refreshLayout.setRefreshHeader(new PhoenixHeader(baseContext));
                }else if (position == 10){
                    refreshLayout.setRefreshHeader(new WaterDropHeader(baseContext));
                }else if (position == 11){
                    refreshLayout.setRefreshHeader(new WaveSwipeHeader(baseContext));
                }else if (position == 12){
                }
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        //设置 Header
        //为 Material风格
        //refreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //古典风格
        //refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        //盒子风格
        //refreshLayout.setRefreshHeader(new DropboxHeader(this));
        //设置 Footer
        // 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        //设置监听器
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, RealTestSmartRefreshLayoutActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
}
