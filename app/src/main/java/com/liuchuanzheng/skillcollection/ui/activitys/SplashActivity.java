package com.liuchuanzheng.skillcollection.ui.activitys;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 刘传政 on 2017/6/29 0029.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:闪屏Activity
 * 注意事项:
 */

public class SplashActivity extends LCZBaseActivity{
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置沉浸状态栏
        SetTranslanteBar();
        initAnimations();
    }

    /**
     * 设置闪屏动画
     */
    private void initAnimations() {
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.3f, 1f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1f);
        PropertyValuesHolder rotationX = PropertyValuesHolder.ofFloat("rotation", 0.0f, 90.0f,180f,270f,360f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(tvName, alpha, scaleX, scaleY,rotationX);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(ivLogo, alpha, scaleX, scaleY,rotationX);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(3000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //开启主界面
                MainActivity.startAction(SplashActivity.this);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }

}
