package com.example.weijianqiang.testschemetwo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by weijianqiang
 * On 2019/10/14
 * Description:
 */
public class TestReceiver extends BroadcastReceiver {

    private static final String TAG = "TestReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
    }
}
