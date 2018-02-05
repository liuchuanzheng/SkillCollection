package com.liuchuanzheng.skillcollection.ui.activitys.coordinatorlayout_6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuchuanzheng.skillcollection.R;
import com.liuchuanzheng.skillcollection.base.LCZBaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 刘传政 on 2017/6/30 0030.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:测试著名的logger库
 * 注意事项:
 */

public class CoordinatorActivity_2_2_ViewPager extends LCZBaseActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    List<Fragment> mFragments;

    String[] mTitles = new String[]{"主页", "微博", "相册"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout_2_2_viewpager);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 第二步：为ViewPager设置适配器

        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //初始化显示条目
                // 准备显示的数据，一个简单的TextView
                TextView tv = new TextView(CoordinatorActivity_2_2_ViewPager.this);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(20);
                tv.setText(mTitles[position]);

                // 添加到ViewPager容器
                container.addView(tv);

                // 返回填充的View对象
                return tv;
            }
        });
        //  第三步：将ViewPager与TableLayout 绑定在一起
        tabs.setupWithViewPager(viewpager);

    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, CoordinatorActivity_2_2_ViewPager.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }


}
