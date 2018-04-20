package com.example.gq.ma.utils;

import android.os.Handler;
import android.os.Message;

import com.example.gq.ma.config.Const;

public class TimeThread implements Runnable {

    private Handler handler;

    public TimeThread(Handler handler) {
        this.handler = handler;
    }

    //Change time per second. May consume memory all the time in while.
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Message msg = new Message();
                msg.what = Const.Thread.TIME_CHANGE;
                handler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
