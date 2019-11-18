package com.example.weijianqiang.testschemetwo.media;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by weijianqiang
 * On 2019/11/12
 * Description:
 */
public class MediaPlayUtil implements MediaPlayer.OnPreparedListener {

    private static final String TAG = "MediaPlayUtil";
    private static MediaPlayUtil mediaPlayUtil;
    private MediaPlayer mediaPlayer;
    private AudioTrack audioTrack;
    private String path;
    private boolean isPlaying = false;
    private boolean isStop = true;
    private Handler handler;



    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "onPrepared: ");
        mediaPlayer.start();
    }

    private MediaPlayUtil(){
        mediaPlayer = new MediaPlayer();
        HandlerThread handlerThread = new HandlerThread("playRecord");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    public static MediaPlayUtil getInstance(){
        if (mediaPlayUtil == null){
            mediaPlayUtil = new MediaPlayUtil();
        }
        return mediaPlayUtil;
    }

    public void startPlay(String path){
        Log.d(TAG, "startPlay: ");
        this.path = path;
        handler.postDelayed(playPCMRecord,0);


//        Log.d(TAG, "startPlay: "+path);
//        mediaPlayer.reset();
//        Log.d(TAG, "startPlay: start");
//        try {
//            mediaPlayer.setDataSource(path);
//            mediaPlayer.prepare();
//            mediaPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void setPath(String path){
        this.path = path;
    }

    private Runnable playPCMRecord = new Runnable() {
        @Override
        public void run() {
            int bufferSize = AudioTrack.getMinBufferSize(16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 16000, AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM);
            FileInputStream fis = null;
            try {
                audioTrack.play();
                fis = new FileInputStream(path);
                byte[] buffer = new byte[bufferSize];
                int len = 0;
                isPlaying = true;
                while ((len = fis.read(buffer)) != -1 && !isStop) {
//                    Log.d(TAG, "playPCMRecord: len " + len);
                    Log.d(TAG, "run: len:"+len);
                    audioTrack.write(buffer, 0, len);
                }

            } catch (Exception e) {
                Log.e(TAG, "playPCMRecord: e : " + e);
            } finally {
                isPlaying = false;
                isStop = false;
                if (audioTrack != null) {
                    audioTrack.stop();
                    audioTrack.release();
                    audioTrack = null;
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
}
