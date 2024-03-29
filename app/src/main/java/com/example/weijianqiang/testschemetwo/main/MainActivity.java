package com.example.weijianqiang.testschemetwo.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.weijianqiang.testschemetwo.R;
import com.example.weijianqiang.testschemetwo.nanohttpddemo.ClientServerHttpd;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_bb";
    private ArrayList<File> files = new ArrayList<>();
    private Handler handler = null;
    private Handler mainHandler = null;
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
                String test = null;
                // 测试崩溃CrashHandler
                //test.equals("test");
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
//                SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日EEEE");
//                tv1.setText(sdf.format(new Date()));
//                Intent intent = new Intent("com.iflytek.install_app");
//                intent.putExtra("appPath","/sdcard/app_tvRelease_4.2.0_20191012.apk");
//                startService(intent);
//                Intent intent = new Intent("com.iflytek.xiri.openplatform");
//                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);


//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i =0 ;i<1000;i++){
//                            Log.d(TAG, "run: i+"+i);
//                            XMContext.getContext().startService(new Intent("iflytek.test"));
//                        }
//
//                    }
//                }).start();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(6);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        android.os.Process.killProcess(android.os.Process.myPid());
//                    }
//                }).start();

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }).start();
                init();

            }
        });

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // test

// second test
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
//                SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日EEEE");
//                tv1.setText(sdf.format(new Date()));
//                Intent intent = new Intent("com.iflytek.install_app");
//                intent.putExtra("appPath","/sdcard/app_tvRelease_4.2.0_20191012.apk");
//                startService(intent);
//                Intent intent = new Intent("com.iflytek.xiri.remote.action.TELEPHONE");
//                unbindService(serviceConnection);
                //MediaPlayUtil.getInstance().startPlay("/sdcard/xmbase/data/xiriAudioFiles/voice#264350515#20191113151611.pcm");
//                MediaPlayUtil.getInstance().startPlay("/sdcard/test/file_tenggeer_response_mg.pcm");
//                bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
//                Intent intent = new Intent("com.iflytek.testxiri59");
//                startService(intent);
                handler.sendMessage(Message.obtain());
                mainHandler.sendMessage(Message.obtain());
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

    @WorkerThread
    @NonNull
    private void init(){
//        Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//            }
//        };
        mainHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.d(TAG, "handleMessage: main");
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "init: Thread:"+Thread.currentThread().getName());
                Looper.prepare();
                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Log.d(TAG, "handleMessage: thread123");
                    }
                };
                Looper.loop();

                new ThreadImpl("thtest");

            }
        }).start();

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
