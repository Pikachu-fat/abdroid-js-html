package com.example.weijianqiang.testschemetwo.main;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.example.weijianqiang.testschemetwo.XMContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by weijianqiang
 * On 2019/12/6
 * Description:
 */
public class MyCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "MyCrashHandler";

    private String logFilePath = Environment.getExternalStorageDirectory() + File.separator + "Android" +
            File.separator + "data" + File.separator + XMContext.getContext().getPackageName() + File.separator + "crashLogwjq";


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e(TAG, "Thread = " + t.getName() + "\nThrowable = " + e.getMessage());
        String stackTraceInfo = getStackTraceInfo(e);
        Log.e(TAG, stackTraceInfo);
        saveThrowableMessage(stackTraceInfo);
    }

    /**
     * 获取错误的信息
     *
     * @param throwable
     * @return
     */
    private String getStackTraceInfo(final Throwable throwable) {
        PrintWriter pw = null;
        Writer writer = new StringWriter();
        try {
            pw = new PrintWriter(writer);
            throwable.printStackTrace(pw);
        } catch (Exception e) {
            return "";
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return writer.toString();
    }

    private void saveThrowableMessage(String errorMessage) {
        if (TextUtils.isEmpty(errorMessage)) {
            return;
        }
        File file = new File(logFilePath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (mkdirs) {
                writeStringToFile(errorMessage, file);
            }
        } else {
            writeStringToFile(errorMessage, file);
        }
    }

    private void writeStringToFile(final String errorMessage, final File file) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileOutputStream outputStream = null;
                try {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(errorMessage.getBytes());
                    outputStream = new FileOutputStream(new File(file, System.currentTimeMillis() + ".txt"));
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    outputStream.flush();
                    Log.e(TAG, "写入本地文件成功：" + file.getAbsolutePath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

}
