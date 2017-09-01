package com.liuchuanzheng.skillcollection.ui.activitys.instruction_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.real_2.real_2_2.RealTestEventBusActivity_Subscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘传政 on 2017/7/14 0014.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */

public class EventBusTestActivity extends LCZBaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_right)
    ImageButton ibRight;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);//复用此布局
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("EventBus");
        tvMessage.setText("Android事件总线");
        textView.setText("学习地址: http://m.blog.csdn.net/JiangWeiHu/article/details/77338159 \n" +
                "为了更简化并更高质量的在Activity，Fragment，Thread和Service等之间的通信，解决组件之间高耦合的同时仍能进行高效的通信。");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, EventBusTestActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        RealTestEventBusActivity_Subscriber.startAction((Activity) baseContext);
    }
}
