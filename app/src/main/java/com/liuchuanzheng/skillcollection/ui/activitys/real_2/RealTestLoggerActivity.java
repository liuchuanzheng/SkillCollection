package com.liuchuanzheng.skillcollection.ui.activitys.real_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by 刘传政 on 2017/7/4 0004.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */

public class RealTestLoggerActivity extends LCZBaseActivity {
    private String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
            "\"temp\":\"18\",\"WD\":\"东南风\",\"WS\":\"1级\",\"SD\":\"17%\",\"WSE\":\"1\"," +
            "\"time\":\"17:05\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"," +
            "\"njd\":\"暂无实况\",\"qy\":\"1011\",\"rain\":\"0\"}}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_logger);
        realTest();
    }

    /**
     * 真正的logger库测试代码
     */
    private void realTest() {
        //官网地址https://github.com/orhanobut/logger
        //Logger 是有它自己默认的 TAG 的，默认的 TAG 是 PRETTYLOGGER
        //1. 初始化
       /* FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("刘传政")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();*/
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("刘传政")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        Logger.t("123");//只生效一次,且设置后的tag类似PRETTYLOGGER_123  是拼接基本tag
        Logger.v("verbose");
        Logger.d("debug");
        Logger.i("information");
        Logger.w("warning");
        Logger.e("error");
        Logger.wtf("wtf!!!!");
        Logger.json(JSON_CONTENT);
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, RealTestLoggerActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
}
