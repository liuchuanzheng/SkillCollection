package com.liuchuanzheng.skillcollection.ui.activitys.notifycation_7;

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

public class Notifycation_Instruction_Activity extends LCZBaseActivity {
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
        tvTitle.setText("NotifyCation");
        tvMessage.setText("通知栏");
        textView.setText("学习地址: http://blog.csdn.net/qq_22078107/article/details/53448535 \n" +
                "系统原生的通知栏，点击跳转到相应界面");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, Notifycation_Instruction_Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        Notifycation_real1_Activity.startAction((Activity) baseContext);
    }
}
