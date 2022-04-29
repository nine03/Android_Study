package com.example.exercise11_06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MyGraphicView graphicView;
    static Integer selectedPoster;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float skewX = 0, skewY = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 11-6");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        registerForContextMenu(graphicView);

        final String[] movie = {"쿵푸팬더", "짱구는 못말려", "아저씨", "아바타", "대부",
                "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기"};

        final Integer[] posterID = {R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                R.drawable.mov24, R.drawable.mov25, R.drawable.mov26, R.drawable.mov27,
                R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};

        selectedPoster = posterID[0];

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selectedPoster = posterID[arg2];
                scaleX = 1;
                scaleY = 1;
                angle = 0;
                skewX = 0;
                skewY = 0;

                graphicView.invalidate();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                angle = angle + 20;
                graphicView.invalidate();
                return true;
            case 2:
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
                return true;
            case 3:
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
                return true;
            case 4:
                skewX = skewX + 0.1f;
                skewY = skewY + 0.1f;
                graphicView.invalidate();
                return true;
            case 5:
                skewX = skewX - 0.1f;
                skewY = skewY - 0.1f;
                graphicView.invalidate();
                return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v == graphicView) {
            menu.add(0, 1, 0, "회전");
            menu.add(0, 2, 0, "확대");
            menu.add(0, 3, 0, "축소");
            menu.add(0, 4, 0, "기울기 증가");
            menu.add(0, 5, 0, "기울기 감소");
        }
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            canvas.skew(skewX, skewY);
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), selectedPoster);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, null);

            picture.recycle();
        }
    }
}