package com.liuchuanzheng.skillcollection.ui.activitys.BaseRecyclerViewAdapterHelper_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

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

public class Instruction_Activity extends LCZBaseActivity {
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
        setContentView(R.layout.activity_swipe);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("BaseRecyclerViewAdapterHelper");
        tvMessage.setText("一个RecyclerView扩展库");
        textView.setText("gitHub地址: https://github.com/CymChad/BaseRecyclerViewAdapterHelper \n" +
                "BRVAH是一个强大的RecyclerAdapter框架(什么是RecyclerView？)，它能节约开发者大量的开发时间，集成了大部分列表常用需求解决方案。为什么会有它？请查看「Android开源框架BRVAH由来篇」该框架于2016年4月10号发布的第1个版本到现在已经一年多了，经历了800多次代码提交，140多次版本打包，修复了1000多个问题，获得了9000多star，非常感谢大家的使用以及反馈。\n" +
                "本篇为BRVAH的使用指南以及包含常见问题会第一时间更新最新的使用方法。最新版本请查看releases,由于持续更新。");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, Instruction_Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        Real1_Activity.startAction((Activity) baseContext);
    }
}
