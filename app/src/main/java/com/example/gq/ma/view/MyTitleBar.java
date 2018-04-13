package com.example.gq.ma.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.config.Const;
import com.example.gq.ma.utils.TimeThread;

public class MyTitleBar extends LinearLayout {

    TextView mIdTV;
    TextView mWeatherTV;
    TextView mTemperatureTV;
    TextView mHumidityTV;
    TextView mDateTV;

    public MyTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);

        init();

        //update time
        new Thread(new TimeThread(new MyHandler())).start();

    }

    private void init() {
        mIdTV = findViewById(R.id.bar_id_tv);
        mWeatherTV =findViewById(R.id.bar_weather_tv);
        mTemperatureTV = findViewById(R.id.bar_temperature_tv);
        mHumidityTV = findViewById(R.id.bar_humidity_tv);
        mDateTV = findViewById(R.id.bar_date_tv);
    }

    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Const.Thread.TIME_CHANGE:
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);
                    mDateTV.setText(sysTimeStr);
                    break;
                    default:
                        break;
            }
        }
    }
}
