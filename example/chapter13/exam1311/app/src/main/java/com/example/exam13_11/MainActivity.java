package com.example.exam13_11;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        for (int i = pb1.getProgress(); i < 100; i = i + 2) {
                            pb1.setProgress(pb1.getProgress() + 2);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    public void run() {
                        for (int i = pb2.getProgress(); i < 100; i++) {
                            pb2.setProgress(pb2.getProgress() + 1);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}






















