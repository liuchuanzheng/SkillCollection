package com.liuchuanzheng.skillcollection.ui.activitys.instruction_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.ui.activitys.real_2.RealTestLoggerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘传政 on 2017/6/30 0030.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:测试著名的logger库
 * 注意事项:
 */

public class LoggerTestActivity extends LCZBaseActivity {


    @BindView(R.id.ib_right)
    ImageButton ibRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        ButterKnife.bind(this);
    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, LoggerTestActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
       RealTestLoggerActivity.startAction(((Activity) baseContext));
    }
}
