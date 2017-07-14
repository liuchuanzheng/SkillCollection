package com.liuchuanzheng.skillcollection.ui.activitys;

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

public class SwipeRefreshLayoutTestActivity extends LCZBaseActivity {
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
        tvTitle.setText("SwipeRefreshLayout");
        tvMessage.setText("配合recyclerView使用");
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, SwipeRefreshLayoutTestActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
        RealTestSwipeRefreshLayoutActivity.startAction((Activity) baseContext);
    }
}
