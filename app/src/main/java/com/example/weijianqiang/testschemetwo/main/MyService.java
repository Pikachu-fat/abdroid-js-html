package com.example.weijianqiang.testschemetwo.main;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by weijianqiang
 * On 2019/12/6
 * Description:
 */
public class MyService extends Service {

    private static final String TAG = "MyService";
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }
}
