package com.example.gq.ma.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {

    private boolean enabled;

    public CustomViewPager(@NonNull Context context) {
        super(context);
        enabled = false;
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        enabled = false;
    }

    //设置是否滑动
    public void setPagingEnabled(boolean enabled){
        this.enabled = enabled;
    }

    //enabled 为 false 不触发触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled)
            return super.onTouchEvent(ev);
        return false;
    }

    //enabled 为 false 不处理拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled)
            return super.onInterceptTouchEvent(ev);
        return false;
    }
}
