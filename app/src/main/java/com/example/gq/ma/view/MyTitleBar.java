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
import com.example.gq.ma.bean.Environment;
import com.example.gq.ma.config.Const;
import com.example.gq.ma.utils.HttpHelper;
import com.example.gq.ma.utils.TimeThread;
import com.example.gq.ma.view.inter.MyTitleBarInter;

public class MyTitleBar extends LinearLayout implements MyTitleBarInter {


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

        //天气
        //重庆 CHCQ000000 成都 CHSC000000
        HttpHelper helper = new HttpHelper(context, this);
        helper.getWeatherJson("CHSC000000");
    }

    private void init(){

        mIdTV = findViewById(R.id.bar_id_tv);
        mWeatherTV =findViewById(R.id.bar_weather_tv);
        mTemperatureTV = findViewById(R.id.bar_temperature_tv);
        mHumidityTV = findViewById(R.id.bar_humidity_tv);
        mDateTV = findViewById(R.id.bar_date_tv);
    }

    @Override
    public void onShowWeather(Environment environment) {
        String temperature = environment.getTemperature() + "℃";
        String humidity = environment.getTemperature() + "%RH";
        mWeatherTV.setText(environment.getWeather());
        mTemperatureTV.setText(temperature);
        mHumidityTV.setText(humidity);
    }

    @Override
    public void onShowUserEmail(String email) {
        mIdTV.setText(email);
    }

    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Const.Thread.TIME_CHANGE:
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);
                    mDateTV.setText(sysTimeStr.toString());
                    break;
                default:
                    break;
            }
        }
    }
}
