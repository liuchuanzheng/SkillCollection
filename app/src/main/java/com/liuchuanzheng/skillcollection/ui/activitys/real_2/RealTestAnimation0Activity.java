package com.liuchuanzheng.skillcollection.ui.activitys.real_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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

public class RealTestAnimation0Activity extends LCZBaseActivity {
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.set)
    Button set;
    @BindView(R.id.alpha)
    Button alpha;
    @BindView(R.id.scale)
    Button scale;
    @BindView(R.id.translate)
    Button translate;
    @BindView(R.id.rotate)
    Button rotate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_animation_0);
        ButterKnife.bind(this);
        realTest();
    }

    /**
     *
     */
    private void realTest() {
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, RealTestAnimation0Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick({R.id.set, R.id.alpha, R.id.scale, R.id.translate, R.id.rotate})
    public void onViewClicked(View view) {
        Animation animation = null;
        switch (view.getId()) {
            case R.id.set:
                animation = AnimationUtils.loadAnimation(baseContext,R.anim.set);
                break;
            case R.id.alpha:
                animation = AnimationUtils.loadAnimation(baseContext,R.anim.alpha);
                break;
            case R.id.scale:
                animation = AnimationUtils.loadAnimation(baseContext,R.anim.scale);
                break;
            case R.id.translate:
                animation = AnimationUtils.loadAnimation(baseContext,R.anim.translate);
                break;
            case R.id.rotate:
                animation = AnimationUtils.loadAnimation(baseContext,R.anim.rotate);
                break;

        }
        iv.startAnimation(animation);
    }
}
