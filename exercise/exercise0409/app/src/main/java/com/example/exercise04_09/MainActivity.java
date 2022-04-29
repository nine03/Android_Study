package com.example.exercise04_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnRotate;
    ImageView imgDog;
    float angle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 4-9");

        btnRotate = (Button) findViewById(R.id.BtnRotate);
        imgDog = (ImageView) findViewById(R.id.ImgDog);

        btnRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle += 10;
                imgDog.setRotation(angle);
            }
        });
    }
}