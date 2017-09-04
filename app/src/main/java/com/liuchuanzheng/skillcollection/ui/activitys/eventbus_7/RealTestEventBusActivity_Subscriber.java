package com.liuchuanzheng.skillcollection.ui.activitys.eventbus_7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.liuchuanzheng.skillcollection.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

public class RealTestEventBusActivity_Subscriber extends LCZBaseActivity {


    @BindView(R.id.go)
    Button go;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.unregister)
    Button unregister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_eventbus_subscriber);
        ButterKnife.bind(this);
        realTest();
    }

    @OnClick({R.id.go, R.id.register, R.id.unregister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go:
                RealTestEventBusActivity_Publisher.startAction((Activity) baseContext);
                break;
            case R.id.register:
                EventBus.getDefault().register(this);
                break;
            case R.id.unregister:
                EventBus.getDefault().unregister(this);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBusReceiveMessageEvent(MessageEvent messageEvent){
        Toast.makeText(this,"收到了消息:" + messageEvent.getMessage(),Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMoonStickyEvent(MessageEvent messageEvent){
        Toast.makeText(this,"收到了消息:" + messageEvent.getMessage(),Toast.LENGTH_SHORT).show();
    }

    private void realTest() {
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, RealTestEventBusActivity_Subscriber.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
}
