package com.example.exam13_14_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button btn;
    ProgressBar pb1, pb2;
    TextView tv1, tv2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        btn = (Button) findViewById(R.id.button1);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        tv1.setText("1번 진행률 : " + pb1.getProgress() + "%");
        tv2.setText("2번 진행률 : " + pb2.getProgress() + "%");

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        for (int i = pb1.getProgress(); i < 100; i = i + 2) {
                            pb1.post(new Runnable() {
                                public void run() {
                                    pb1.setProgress(pb1.getProgress() + 2);
                                    tv1.setText("1번 진행률 : " + pb1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    public void run() {
                        for (int i = pb2.getProgress(); i < 100; i++) {
                            pb2.post(new Runnable() {
                                public void run() {
                                    pb2.setProgress(pb2.getProgress() + 1);
                                    tv2.setText("2번 진행률 : " + pb2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}
