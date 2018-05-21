package com.liuchuanzheng.skillcollection.ui.activitys.shareelement_9;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘传政 on 2017/7/4 0004.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */

public class real1_Activity extends LCZBaseActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_share);
        ButterKnife.bind(this);
        realTest();
    }


    private void realTest() {

    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, real1_Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
    @OnClick(R.id.imageView)
    public void onViewClicked() {
        Intent intent = new Intent(this, real2_Activity.class);
        imageView.setTransitionName("share");
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,imageView,"share").toBundle());

    }

}
