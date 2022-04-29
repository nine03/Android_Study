package com.example.exam10_11;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;

        // 9개의 이미지 버튼 객체배열
        ImageView image[] = new ImageView[9];
        // 9개의 이미지버튼 ID 배열
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨",
                "피아노 앞의 소녀들", "해변에서" };
    }
}
