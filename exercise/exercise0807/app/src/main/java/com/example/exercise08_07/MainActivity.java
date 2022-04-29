package com.example.exercise08_07;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    TextView tvNumber;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 8-7");

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.READ_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;
        tvNumber.setText("1" + "/" + imageFiles.length);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum <= 0) {
                    curNum = imageFiles.length - 1;
                } else {
                    curNum--;
                }

                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum >= imageFiles.length - 1) {
                    curNum = 0;
                } else {
                    curNum++;
                }

                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });
    }
}
