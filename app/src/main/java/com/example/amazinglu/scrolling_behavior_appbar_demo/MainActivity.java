package com.example.amazinglu.scrolling_behavior_appbar_demo;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.main_tab_layout) TabLayout tabLayout;
    @BindView(R.id.main_view_pager) ViewPager viewPager;

    private MyAdapter adapter;

    /**
     * implement scrolling behavior using CoordinatorLayout and AppBarLayout
     *
     * Standard App bar scrolling with only Toolbar and the tab bar remain there
     * details in activity_main.xml
     * https://android.jlelse.eu/scrolling-behavior-for-appbars-in-android-41aff9c5c468
     *
     * 注意：
     * when <item name="android:windowTranslucentStatus">true</item>
     * 向上滑之后tablayout 会和status bar重叠，加上fitSystemWindow也是没有用的
     *
     * 唯一能实现这个功能的办法就是不能把status bar 设置成透明
     * */

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        initViewPagerAndTab();
    }

    private void initViewPagerAndTab() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText(R.string.tab0);
        tabLayout.getTabAt(1).setText(R.string.tab1);
        tabLayout.getTabAt(2).setText(R.string.tab2);
    }
}
