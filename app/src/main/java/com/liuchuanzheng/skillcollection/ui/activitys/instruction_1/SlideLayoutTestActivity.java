package com.liuchuanzheng.skillcollection.ui.activitys.instruction_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.real_2.RealTestSlideLayoutActivity;

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

public class SlideLayoutTestActivity extends LCZBaseActivity {
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
        tvTitle.setText("SlideLayout");
        tvMessage.setText("一个ViewGroup,可以提供任何方向的测拉");
        textView.setText("gitHub地址: https://github.com/yanbober/SlideLayout \n" +
                "纯手工超级迷你轻量级全方向完美滑动处理侧滑控件（比官方 support v4 包 SlidingPaneLayout 控件更加 Q 迷你，累计代码不足 300 行），支持上下左右有各种侧拉，可配置侧拉松手临界距离，支持单独使用、ListView、GridView、RecycleView、ScrollView、ViewPager 等各种嵌套（作为 item 使用或者作为以上所有控件的父容器使用）");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, SlideLayoutTestActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        RealTestSlideLayoutActivity.startAction((Activity) baseContext);
    }
}
