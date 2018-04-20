package com.example.gq.ma.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gq.ma.R;
import com.example.gq.ma.adapter.MyFragmentAdapter;
import com.example.gq.ma.base.BaseActivity;
import com.example.gq.ma.config.Const;
import com.example.gq.ma.utils.TimeThread;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements OnTabSelectListener{


    BottomBar mBottomBar;
    CustomViewPager mViewPager;
    MyFragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TaskFragment());
        fragments.add(new DetectFragment());
        fragments.add(new TransportFragment());
        fragments.add(new EnvironmentFragment());
        fragments.add(new TargetFragment());
        mFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, null);
        mViewPager.setPagingEnabled(false);
        mBottomBar.setOnTabSelectListener(this);
        mViewPager.setAdapter(mFragmentAdapter);

    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId){
            case R.id.tab_tasks:
                Toast.makeText(this,"tab_tasks", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tab_detect:
                Toast.makeText(this,"tab_detect", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tab_transport:
                Toast.makeText(this,"tab_transport", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tab_environment:
                Toast.makeText(this,"tab_environment", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(3);
                break;
            case R.id.tab_target:
                Toast.makeText(this,"tab_target", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }

    private void init() {
        mBottomBar = findViewById(R.id.bottomBar);
        mViewPager = findViewById(R.id.view_pager);
    }




}
