package com.example.weijianqiang.testschemetwo.nanohttpddemo;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by weijianqiang
 * On 2019/11/6
 * Description:
 */
public class ClientServerHttpd extends NanoHTTPD {

    private static final String TAG = "ClientServerHttpd";
    private static final int PORT = 13245;
    private ArrayList<File> mFiles = new ArrayList<>();

    public ClientServerHttpd(ArrayList<File> files) {
        super(PORT);
        if (files != null && files.size() > 0) {
            this.mFiles = files;
        }
    }

    @Override
    public Response serve(IHTTPSession session) {

        String uri = session.getUri();
        Log.d(TAG, "serve: uri:" + uri);
        Response response ;

        if (TextUtils.isEmpty(uri) || uri.equals("/")) {
            response = operateRoot(session);
        } else {
            response = operateFile(session);
        }

        Log.d(TAG, "serve: response:" + response);
        return response;
    }


    private Response operateRoot(IHTTPSession session) {

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><body>");
        sb.append("<ol>");

        for (int i = 0; i < mFiles.size(); i++) {
            File file = mFiles.get(i);
            if (file != null && file.exists()) {
                sb.append("<li> <a href=\"" + file.getPath() + "\">" + file.getName() + "</a> </li>");
            }
        }

        sb.append("<li>" + "文件个数:" + mFiles.size() + "</li>");
        sb.append("</ol>");

        sb.append("</body></html>\n");
        Log.d(TAG, "operateRoot: "+sb.toString());
        return newFixedLengthResponse(sb.toString());
    }

    private Response operateFile(IHTTPSession session) {

        String uri = session.getUri();
        File file = new File(uri);
        if (!file.exists()){
            return null;
        }
        for (int i = 0; i < mFiles.size(); i++) {
            if (mFiles.get(i).getPath().equals(uri)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(uri);
                    return newFixedLengthResponse(Response.Status.OK, "application/octet-stream", fileInputStream, fileInputStream.available());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return error404(session);
    }

    private Response error404(IHTTPSession session){
        String uri = session.getUri();
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<body>")
                .append("没有找到文件"+uri)
                .append("</body>")
                .append("</html>");
        return newFixedLengthResponse(sb.toString());
    }
}
