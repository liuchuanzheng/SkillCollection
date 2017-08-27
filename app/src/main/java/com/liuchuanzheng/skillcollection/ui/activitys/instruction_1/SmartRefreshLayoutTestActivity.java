package com.liuchuanzheng.skillcollection.ui.activitys.instruction_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.real_2.RealTestSmartRefreshLayoutActivity;

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

public class SmartRefreshLayoutTestActivity extends LCZBaseActivity {
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
        tvTitle.setText("SmartRefreshLayout");
        tvMessage.setText("一个各种头布局脚布局刷新库");
        textView.setText("gitHub地址: https://github.com/scwang90/SmartRefreshLayout \n" +
                "下拉刷新、上拉加载、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, SmartRefreshLayoutTestActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        RealTestSmartRefreshLayoutActivity.startAction((Activity) baseContext);
    }
}
