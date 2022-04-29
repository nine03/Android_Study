package com.example.exercise07_04;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-4");

        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "강아지");
        menu.add(0, 2, 0, "고양이");
        menu.add(0, 3, 0, "토끼");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                imageView1.setImageResource(R.drawable.dog);
                return true;
            case 2:
                imageView1.setImageResource(R.drawable.cat);
                return true;
            case 3:
                imageView1.setImageResource(R.drawable.rabbit);
                return true;
        }
        return false;
    }
}