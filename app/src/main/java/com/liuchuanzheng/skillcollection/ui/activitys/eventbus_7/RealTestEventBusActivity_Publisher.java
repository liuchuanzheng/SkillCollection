package com.liuchuanzheng.skillcollection.ui.activitys.eventbus_7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘传政 on 2017/7/4 0004.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:eventbus的事件订阅者
 * 注意事项:
 */

public class RealTestEventBusActivity_Publisher extends LCZBaseActivity {


    @BindView(R.id.publisher)
    Button publisher;
    @BindView(R.id.publisher_sticky)
    Button publisherSticky;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_eventbus_publisher);
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
        Intent intent = new Intent(activity, RealTestEventBusActivity_Publisher.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick({R.id.publisher, R.id.publisher_sticky})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.publisher:
                EventBus.getDefault().post(new MessageEvent("我是eventbus普通消息"));
                break;
            case R.id.publisher_sticky:
                EventBus.getDefault().postSticky(new MessageEvent("我是eventbus的粘性消息"));
                break;
        }
        finish();
    }
}
