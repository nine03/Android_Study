package com.example.exam05_08;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // android:layout_width = "match_parent"
        // android:layout_height = "match_parent"
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        // 〈LinearLayout〉 </LinearLayout>
        LinearLayout baseLayout = new LinearLayout(this);

        // android:orientation = "vertical"
        baseLayout.setOrientation(LinearLayout.VERTICAL);

        // android:background = "#00FF00"
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));

        // 리니어레이아웃을 화면에 출력한다.
        setContentView(baseLayout, params);
    }
}
