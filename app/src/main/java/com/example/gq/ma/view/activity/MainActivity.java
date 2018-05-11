package com.example.gq.ma.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.gq.ma.DbSave;
import com.example.gq.ma.R;
import com.example.gq.ma.adapter.MyFragmentAdapter;
import com.example.gq.ma.base.BaseActivity;
import com.example.gq.ma.utils.GLog;
import com.example.gq.ma.utils.HttpHelper;
import com.example.gq.ma.view.CustomViewPager;
import com.example.gq.ma.view.MyTitleBar;
import com.example.gq.ma.view.fragment.DetectFragment;
import com.example.gq.ma.view.fragment.TargetFragment;
import com.example.gq.ma.view.fragment.TaskFragment;
import com.example.gq.ma.view.fragment.TerrainFragment;
import com.example.gq.ma.view.fragment.TransportFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.json.JSONObject;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements OnTabSelectListener{


    BottomBar mBottomBar;
    CustomViewPager mViewPager;
    MyFragmentAdapter mFragmentAdapter;
    MyTitleBar titleBar;

    public static void actionStart(Context context, String email){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("email", email);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        //Connector.getDatabase();
        //DbSave.save();
        Intent intent = getIntent();
        titleBar.onShowUserEmail(intent.getStringExtra("email"));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TaskFragment());
        fragments.add(new DetectFragment());
        fragments.add(new TransportFragment());
        fragments.add(new TerrainFragment());
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
        titleBar = findViewById(R.id.title_bar);
    }




}
