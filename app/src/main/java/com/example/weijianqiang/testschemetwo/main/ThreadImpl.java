package com.example.weijianqiang.testschemetwo.main;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/**
 * Created by weijianqiang
 * On 2019/12/16
 * Description:
 */
public class ThreadImpl extends HandlerThread {

    private static final String TAG = "ThreadImpl";
//    Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            return false;
//        }
//    });
    public ThreadImpl(String name) {
        super(name);

        this.start();
        Log.d(TAG, "ThreadImpl: this.getLooper()："+this.getLooper());
        Handler handler = new Handler(this.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    public ThreadImpl(String name, int priority) {
        super(name, priority);
    }

    public void init(){

        Log.d(TAG, "init: ");

    }
}
