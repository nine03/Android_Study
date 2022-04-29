package com.example.exercise05_06;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout1, layout2, layout3, layout4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 5-6");

        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        layout4 = (LinearLayout) findViewById(R.id.layout4);

        layout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = Integer.toString(layout1.getWidth()) + " x "
                        + Integer.toString(layout1.getHeight());
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = Integer.toString(layout2.getWidth()) + " x "
                        + Integer.toString(layout2.getHeight());
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = Integer.toString(layout3.getWidth()) + " x "
                        + Integer.toString(layout3.getHeight());
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = Integer.toString(layout4.getWidth()) + " x "
                        + Integer.toString(layout4.getHeight());
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
