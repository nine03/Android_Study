package com.example.exercise12_06;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;
    File myDir;
    String strSDpath;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 12-6");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        int cYear = Calendar.getInstance().get(Calendar.YEAR);
        int cMonth = Calendar.getInstance().get(Calendar.MONTH);
        int cDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // 데이터베이스 초기화
        myHelper = new myDBHelper(this);
        sqlDB = myHelper.getWritableDatabase();
        myHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();

        // 처음의 실행한 날짜(오늘)를 체크하기
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth + 1)
                + "_" + Integer.toString(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);
        btnWrite.setEnabled(true);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth);

                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (btnWrite.getText().toString() == "새로저장") {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO myDiary VALUES ( '" + fileName
                            + "' ,'" + edtDiary.getText().toString() + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨",
                            Toast.LENGTH_SHORT).show();
                } else {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE  myDiary SET content = '" + edtDiary.getText().toString()
                            + "' WHERE diaryDate = '" + fileName + "' ;");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;

        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate ='"
                + fName + "';", null);

        if (cursor == null) {
            edtDiary.setHint("일기없음");
            btnWrite.setText("새로저장");
        } else {
            if (cursor.moveToFirst() == true) {
                diaryStr = cursor.getString(1);
                btnWrite.setText("수정하기");
            } else {
                edtDiary.setHint("일기없음");
                btnWrite.setText("새로저장");
            }
        }

        cursor.close();
        sqlDB.close();

        return diaryStr;
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE if not exists  myDiary ( diaryDate CHAR(10) PRIMARY KEY, content VARCHAR(500));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
        }
    }
}
