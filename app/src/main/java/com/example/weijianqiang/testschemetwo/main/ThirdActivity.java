package com.example.weijianqiang.testschemetwo.main;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.weijianqiang.testschemetwo.R;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity_aa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findViewById(R.id.third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
//                startActivity(intent);
                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> runningTaskInfos = am.getRunningTasks(3);
                for (ActivityManager.RunningTaskInfo runningTaskInfo:runningTaskInfos){
                    Log.d(TAG, "onClick: id=="+runningTaskInfo.id);
                    Log.d(TAG, "onClick: numActivities=="+runningTaskInfo.numActivities);
                    Log.d(TAG, "onClick: description=="+runningTaskInfo.description);
                    Log.d(TAG, "onClick: numRunning=="+runningTaskInfo.numRunning);
                    Log.d(TAG, "onClick: topActivity=="+runningTaskInfo.topActivity);
                    Log.d(TAG, "onClick: baseActivity=="+runningTaskInfo.baseActivity);

                }
            }
        });
    }
}
