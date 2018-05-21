package com.liuchuanzheng.skillcollection.ui.activitys.logger_1;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.ImageButton;

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

public class LoggerTestActivity extends LCZBaseActivity {


    @BindView(R.id.ib_right)
    ImageButton ibRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        ButterKnife.bind(this);
        setActivityAnimation();
    }

    private void setActivityAnimation() {
        // 侧滑动画
        //从xml读取的方式
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_lsft);
        //此activity进入
        getWindow().setEnterTransition(transition);
        //此activity退出
        getWindow().setExitTransition(transition);

        //再次进入时使用(如果当前Activity已经打开过，并且再次打开该Activity时的动画 )
        //getWindow().setReenterTransition(new Explode().setDuration(2000));
        //决定在两个Activity之间切换时，指定两个Activity中对应的View的过渡效果
        // getWindow().setSharedElementEnterTransition(new Explode().setDuration(2000));
    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, LoggerTestActivity.class);
        //5.0之后的写法
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
    }

    @OnClick(R.id.ib_right)
    public void onViewClicked() {
       RealTestLoggerActivity.startAction(((Activity) baseContext));
    }
}
