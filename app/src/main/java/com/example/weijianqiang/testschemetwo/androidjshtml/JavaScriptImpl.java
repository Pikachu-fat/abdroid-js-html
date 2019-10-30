package com.example.weijianqiang.testschemetwo.androidjshtml;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import java.lang.annotation.Annotation;

/**
 * Created by weijianqiang
 * On 2019/10/29
 * Description:
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
public class JavaScriptImpl implements JavascriptInterface {

    private WebView webView;
    private Handler handler = new Handler(Looper.getMainLooper());

    public JavaScriptImpl(WebView webView) {
        this.webView = webView;
    }

    private static final String TAG = "JavaScriptImpl";

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @JavascriptInterface
    public void showToast(String text) {
        Log.d(TAG, "showToast: " + text);
    }

    @JavascriptInterface
    public String syncExec() {
        return "syncExec interface is call";
    }

    @JavascriptInterface
    public void asyncExec(final String msg, final String functionId) {
        Log.d(TAG, "asyncExec: start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5*1000);
                final String url = "javascript:"+functionId+"(\""+msg+" from android "+"\")";
                Log.d(TAG, "run: url:"+url);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl(url);
                    }
                });
            }
        }).start();
    }

    @JavascriptInterface
    public void callBack(String msg){
        Log.d(TAG, "callBack: msg:"+msg);
    }

}
