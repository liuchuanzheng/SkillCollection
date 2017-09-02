package com.liuchuanzheng.skillcollection.ui.activitys.notifycation_7;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.Button;
import android.widget.TextView;

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

public class Notifycation_real1_Activity extends LCZBaseActivity {


    @BindView(R.id.go)
    Button go;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_notifycation);
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
        Intent intent = new Intent(activity, Notifycation_real1_Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @OnClick(R.id.go)
    public void onClick() {
        pushNotifycation();
    }

    private void pushNotifycation() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        /*
         * 取得PendingIntent， 并设置跳转到的Activity，
         */
        Intent intent = new Intent(this, Notifycation_real1_Activity.class);
        PendingIntent mResultIntent = PendingIntent.getActivity(this,1,intent, PendingIntent.FLAG_ONE_SHOT);
        Bitmap largeIcon = BitmapFactory.decodeResource(
                this.getResources(), R.drawable.logo);
        Notification mNotification = new NotificationCompat.Builder(getBaseContext())

                // 设置大图标
                .setLargeIcon(largeIcon)

                // 设置小图标
                .setSmallIcon(R.drawable.ic_launcher_round)

                // 设置小图标旁的文本信息
                .setContentInfo("1")

                // 设置状态栏文本标题
                .setTicker("你的系统有更新")

                // 设置标题
                .setContentTitle("系统更新")

                // 设置内容
                .setContentText("发现系统更新，点击查看详情")

                // 设置ContentIntent
                .setContentIntent(mResultIntent)

                // 设置Notification提示铃声为系统默认铃声
                .setSound(
                        RingtoneManager.getActualDefaultRingtoneUri(
                                getBaseContext(),
                                RingtoneManager.TYPE_NOTIFICATION))

                // 点击Notification的时候使它自动消失
                .setAutoCancel(true).build();

        mNotificationManager.notify(0, mNotification);
    }
}
