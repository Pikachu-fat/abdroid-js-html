package com.example.weijianqiang.testschemetwo;

import android.app.Application;

import com.example.weijianqiang.testschemetwo.main.MyCrashHandler;

/**
 * Created by weijianqiang
 * On 2019/12/6
 * Description:
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XMContext.setContext(this);
        Thread.setDefaultUncaughtExceptionHandler(new MyCrashHandler());
    }
}
