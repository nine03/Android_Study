package com.example.exercise14_04;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicService extends Service {
    MediaPlayer mp;
    String mp3Path = "/sdcard/";
    ArrayList<String> mp3List;
    int index = 0; // 현재 MP3 번호

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        android.util.Log.i("서비스 테스트", "onCreate()");
        super.onCreate();

        mp3List = new ArrayList<String>();

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equals((String) "mp3")) {
                mp3List.add(fileName);
                Toast.makeText(getApplicationContext(), fileName, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()");
        mp.stop();
        mp.reset();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("서비스 테스트", "onStartCommand()");

        try {
            mp = new MediaPlayer();
            mp.setDataSource(mp3Path + mp3List.get(index));
            mp.prepare();
            mp.start();
        } catch (IOException e) {
        }

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                try {
                    mp.stop();
                    mp.reset();

                    if (index < mp3List.size() - 1)
                        index++;
                    else
                        index = 0;

                    mp.setDataSource(mp3Path + mp3List.get(index));
                    mp.prepare();
                    mp.start();

                } catch (IOException e) {
                }

            }
        });

        return super.onStartCommand(intent, flags, startId);
    }
}
