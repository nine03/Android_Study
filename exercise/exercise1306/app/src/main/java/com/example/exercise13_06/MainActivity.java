package com.example.exercise13_06;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ListView listViewMP3;
    Button btnPlay, btnPause, btnStop;
    TextView tvMP3;
    TextView tvTime;
    ProgressBar pbMP3;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/" ;
    MediaPlayer mPlayer;

    boolean PAUSED = false; // 음악이 일시정지 중인지 체크.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 13-6");

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.READ_EXTERNAL_STORAGE},MODE_PRIVATE);

        // SDCard의 파일을 읽어서 리스트뷰에 출력
        mp3List = new ArrayList<String>(); // 가변적 문자열

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equals((String) "mp3")) // 확장명이 mp3일 때만 추가함.
                mp3List.add(fileName);
        }

        ListView listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selectedMP3 = mp3List.get(arg2);
            }
        });

        selectedMP3 = mp3List.get(0);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        tvMP3 = (TextView) findViewById(R.id.tvMP3);
        tvTime = (TextView) findViewById(R.id.tvTime);
        pbMP3 = (ProgressBar) findViewById(R.id.pbMP3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false);
                    btnPause.setClickable(true);
                    btnStop.setClickable(true);
                    tvMP3.setText("실행중인 음악 :  " + selectedMP3);

                    // 핸들러를 호출함. sendEmptyMessage()를 호출하면 자동으로 핸들러의
                    // handleMessage()가 실행됨. 파라미터 what는 정수형으로 구분하기 위해서
                    // 사용하는데, 이 예제는 사용하지 않으므로 아무 숫자나 입력해도 됨.
                    mp3Handler.sendEmptyMessage(0);
                } catch (IOException e) {
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (PAUSED == false) {
                    mPlayer.pause();
                    btnPause.setText("이어듣기");
                    PAUSED = true;

                } else {
                    mPlayer.start();
                    PAUSED = false;
                    btnPause.setText("일시정지");

                    // 일시정지 후, <이어 듣기>를 할 경우 핸들러를 계속 진행함.
                    mp3Handler.sendEmptyMessage(0);

                }
            }
        });
        btnPause.setClickable(false);

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnPause.setClickable(false);
                btnPause.setText("일시정지");
                btnStop.setClickable(false);
                tvMP3.setText("실행중인 음악 :  ");

                pbMP3.setProgress(0);
                tvTime.setText("진행 시간 : ");

            }
        });
        btnStop.setClickable(false);

    }

    // <일시정지> 버튼에서 핸들러를 멈추고 다시 시작해야 하므로 별도로 만들었음.
    Handler mp3Handler = new Handler() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");

        // sendEmptyMessage()메소드를 호출하면 아래 메소드가 자동 실행됨.
        // 파라미터는 msg는 이 예제는 사용하지 않음.
        public void handleMessage(Message msg) {
            if (mPlayer.isPlaying()) {
                pbMP3.setMax(mPlayer.getDuration());
                pbMP3.setProgress(mPlayer.getCurrentPosition());
                tvTime.setText("진행 시간 : " + timeFormat.format(mPlayer.getCurrentPosition()));
                // 핸들러를 0.2초마다 진행하도록 함.
                mp3Handler.sendEmptyMessageDelayed(0, 200);
            }
        }
    };
}
