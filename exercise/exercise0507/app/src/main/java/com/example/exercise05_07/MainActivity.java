package com.example.exercise05_07;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("연습문제 5-7");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        LinearLayout upLayout = new LinearLayout(this);
        upLayout.setOrientation(LinearLayout.HORIZONTAL);
        upLayout.setLayoutParams(params);

        LinearLayout upLeft = new LinearLayout(this);
        upLeft.setLayoutParams(params);
        upLeft.setBackgroundColor(Color.RED);

        upLayout.addView(upLeft);

        LinearLayout upRight = new LinearLayout(this);
        upRight.setLayoutParams(params);
        upRight.setOrientation(LinearLayout.VERTICAL);

        upLayout.addView(upRight);

        LinearLayout upRight1 = new LinearLayout(this);
        upRight1.setLayoutParams(params);
        upRight1.setBackgroundColor(Color.YELLOW);

        LinearLayout upRight2 = new LinearLayout(this);
        upRight2.setLayoutParams(params);
        upRight2.setBackgroundColor(Color.BLACK);

        upRight.addView(upRight1);
        upRight.addView(upRight2);

        LinearLayout downLayout = new LinearLayout(this);
        downLayout.setLayoutParams(params);
        downLayout.setBackgroundColor(Color.BLUE);

        baseLayout.addView(upLayout);
        baseLayout.addView(downLayout);

        setContentView(baseLayout);
    }
}
