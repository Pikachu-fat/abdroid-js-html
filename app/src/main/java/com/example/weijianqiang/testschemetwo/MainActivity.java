package com.example.weijianqiang.testschemetwo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.weijianqiang.testschemetwo.nanohttpddemo.ClientServerHttpd;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_bb";
    private ArrayList<File> files = new ArrayList<>();
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: service:" + service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test_aa:", this.toString());
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
                Intent intent = new Intent("com.iflytek.xiri.remote.action.TELEPHONE");
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
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
//                Intent intent = new Intent("com.iflytek.xiri.remote.action.TELEPHONE");
                unbindService(serviceConnection);
//                bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for (int i = 0; i < 5; i++) {
//                    File file = new File("/sdcard/html5/" + i + ".txt");
//                    if (!file.exists()) {
//                        file.mkdirs();
//                    }
//                    files.add(file);
//                }
                files.add(new File("sdcard/33870569245018351.jpg"));
                files.add(new File("sdcard/_0ServerSendToService.txt"));
                files.add(new File("sdcard/deviceId.txt"));

                ClientServerHttpd clientServerHttpd = new ClientServerHttpd(files);
                try {
                    clientServerHttpd.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ((TextView) findViewById(R.id.ip)).setText(getLocalIpStr(this));

    }

    //获取IP地址
    public static String getLocalIpStr(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return intToIpAddr(wifiInfo.getIpAddress());
    }

    private static String intToIpAddr(int ip) {
        return (ip & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 24) & 0xFF);

    }
}
