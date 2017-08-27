package com.liuchuanzheng.skillcollection.ui.activitys.real_2.real_2_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

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

public class CoordinatorActivity_2_2 extends LCZBaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout_2_2);
        ButterKnife.bind(this);
    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, CoordinatorActivity_2_2.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
    @OnClick(R.id.fab)
    public void onViewClicked() {
        Snackbar.make(findViewById(R.id.contentView), "Snackbar", Snackbar.LENGTH_SHORT).show();
    }

}
