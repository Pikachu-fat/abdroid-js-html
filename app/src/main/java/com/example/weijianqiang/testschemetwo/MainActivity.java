package com.example.weijianqiang.testschemetwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_bb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test_aa:",this.toString());
//        final TextView tv1 = (TextView) findViewById(R.id.tv1);
//        if (getIntent() != null){
//            tv1.setText(getIntent().getType());
//            Bundle bundle = getIntent().getExtras();
//            if (bundle != null){
//                String content = bundle.getString("params");
//                tv1.setText(content);
//
//                if (TextUtils.isEmpty(content)){
//                    Log.d(TAG, "no data");
//                    return;
//                }
//
//                try {
//                    JSONObject jsonObject = new JSONObject(content);
//                    Log.d(TAG,"service"+jsonObject.optString("service"));
//
//                    String slots = jsonObject.getString("slots");
//                    Log.d(TAG, "slots: "+slots);
//
//                    JSONArray jsonObject1 = new JSONArray(slots);
//                    JSONObject jsonObject2 = jsonObject1.getJSONObject(0);;
//                    String inte = jsonObject2.optString("intent");
//                    Log.d(TAG, "intent: "+inte);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        findViewById(R.id.first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
//                SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日EEEE");
//                tv1.setText(sdf.format(new Date()));
//                Intent intent = new Intent("com.iflytek.install_app");
//                intent.putExtra("appPath","/sdcard/app_tvRelease_4.2.0_20191012.apk");
//                startService(intent);
                Intent intent = new Intent();
                intent.setAction("com.iflytek.huawei");
                sendBroadcast(intent);
            }
        });



    }
}
