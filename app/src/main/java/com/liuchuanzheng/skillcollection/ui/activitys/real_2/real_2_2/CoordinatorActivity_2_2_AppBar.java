package com.liuchuanzheng.skillcollection.ui.activitys.real_2.real_2_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import butterknife.ButterKnife;

/**
 * Created by 刘传政 on 2017/6/30 0030.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:测试著名的logger库
 * 注意事项:
 */

public class CoordinatorActivity_2_2_AppBar extends LCZBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout_2_2_appbar);
        ButterKnife.bind(this);
    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, CoordinatorActivity_2_2_AppBar.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }


}
