package com.example.exam05_16;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    // 10개 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    // 10개 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
            R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i; // 증가값 용도

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
    }
}
