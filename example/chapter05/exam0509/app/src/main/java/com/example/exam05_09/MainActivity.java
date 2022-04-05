package com.example.exam05_09;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        // 버튼 생성
        Button btn = new Button(this);
        // 버튼 텍스트 설정, android:text = "버튼입니다"
        btn.setText("버튼입니다");
        // 버튼 바탕색 설정, android:background = "#FF00FF"
        btn.setBackgroundColor(Color.MAGENTA);
        // 리니어레이아웃에 버튼 추가
        baseLayout.addView(btn);

        // 버튼을 클릭했을때 실행
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "코드로 생성한 버튼입니다",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
