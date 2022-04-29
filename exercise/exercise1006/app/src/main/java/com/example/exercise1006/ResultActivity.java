package com.example.exercise1006;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent(); // 앞 화면에서 보낸 투표 결과 값을 받는다.
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        Integer imageFileId[] = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
                R.drawable.pic8, R.drawable.pic9 };

        // voteResult[] 에 의해서 정렬 한다.
        int tmpResult;
        String tmpName;
        int tmpId;
        for (int i = 0; i < voteResult.length - 1; i++)
            for (int j = i; j < voteResult.length - 1; j++) {
                if (voteResult[j] > voteResult[j + 1]) {
                    tmpResult = voteResult[j];
                    tmpName = imageName[j];
                    tmpId = imageFileId[j];
                    voteResult[j] = voteResult[j + 1];
                    imageName[j] = imageName[j + 1];
                    imageFileId[j] = imageFileId[j + 1];
                    voteResult[j + 1] = tmpResult;
                    imageName[j + 1] = tmpName;
                    imageFileId[j + 1] = tmpId;
                }
            }

        // 이미지뷰 ID 배열
        Integer ivID[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7,
                R.id.iv8, R.id.iv9 };

        // 이미지뷰에 정렬된 아이디를 거꾸로 적용(내림차순)
        for (int i = 0; i < voteResult.length; i++) {
            ImageView iv = (ImageView) findViewById(ivID[voteResult.length - i - 1]);
            iv.setImageResource(imageFileId[i]);
        }

        // 뷰 플리퍼 작동
        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);

        final ViewFlipper vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
