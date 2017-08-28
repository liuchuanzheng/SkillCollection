package com.liuchuanzheng.skillcollection.ui.activitys.real_2.real_2_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

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
                break;
            case R.id.register:
                break;
            case R.id.unregister:
                break;
        }
    }


    /**
     * 为recyclerView定义的点击接口
     */
    public interface OnClickListener {
        void onClick(int position);

        void onLongClick(int position);
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
