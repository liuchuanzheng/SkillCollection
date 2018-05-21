package com.liuchuanzheng.skillcollection.ui.activitys.animation_2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘传政 on 2017/7/7 0007.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */

public class AnimationTestActivity extends LCZBaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_right)
    ImageButton ibRight;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    private MyAdapter mAdapter;//recyclerview的适配器
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initView();
        setActivityAnimation();

    }
    private void setActivityAnimation() {
        // 侧滑动画
        Slide transition = new Slide();
        transition.setSlideEdge(Gravity.LEFT);
        transition.setDuration(500);
        //此activity进入
        getWindow().setEnterTransition(transition);
        //此activity退出
        getWindow().setExitTransition(transition);

        //再次进入时使用(如果当前Activity已经打开过，并且再次打开该Activity时的动画 )
        //getWindow().setReenterTransition(new Explode().setDuration(2000));
        //决定在两个Activity之间切换时，指定两个Activity中对应的View的过渡效果
        // getWindow().setSharedElementEnterTransition(new Explode().setDuration(2000));
    }

    private void initView() {
        tvTitle.setText("动画");
        tvMessage.setText("对原生的Android动画进行测试");
        rcv.setLayoutManager(new GridLayoutManager(this, 1));
        mAdapter = new MyAdapter();
        rcv.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int position) {
                switch (position){
                    case 0:
                        RealTestAnimation0Activity.startAction((Activity) baseContext);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onLongClick(int position) {

            }
        });
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, AnimationTestActivity.class);
        //5.0之后的写法
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        Toast.makeText(baseContext, "请对下方具体条目点击", Toast.LENGTH_SHORT).show();
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
                    baseContext).inflate(R.layout.item_animation, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            if(0 == position){
                holder.tv.setText("View Animation tween 补间动画");
            }else if (1 == position){

            }else if (2 == position){

            }else if (3 == position){

            }
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
            return 4;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item);
            }
        }
    }
}
