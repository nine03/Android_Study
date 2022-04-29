package com.example.exercise04_08;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 4-8");

        editText1 = (EditText) findViewById(R.id.editText1);

        editText1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                if (arg2.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), editText1.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
