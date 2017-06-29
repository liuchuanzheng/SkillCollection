package com.liuchuanzheng.skillcollection.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liuchuanzheng.skillcollection.utils.StatusBarCompat;

/**
 * Created by 刘传政 on 2017/6/29 0029.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:基类activity
 * 注意事项:
 */

public class LCZBaseActivity extends AppCompatActivity {
    public Context baseContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseContext = this;
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar(){
        StatusBarCompat.translucentStatusBar(this);
    }
}
