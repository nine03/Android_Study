package com.example.exercise02_07;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    Button btnToast, btnHomepage;
    RadioButton rdoOreo, rdoPie;
    ImageView ivAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 앱");

        edit1 = (EditText) findViewById(R.id.edit1);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnHomepage = (Button) findViewById(R.id.btnHomepage);
        rdoOreo = (RadioButton) findViewById(R.id.rdoOreo);
        rdoPie = (RadioButton) findViewById(R.id.rdoPie);
        ivAndroid = (ImageView) findViewById(R.id.ivAndroid);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edit1.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(edit1.getText().toString()));
                startActivity(mIntent);
            }
        });

        rdoOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivAndroid.setImageResource(R.drawable.oreo);
            }
        });

        rdoPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivAndroid.setImageResource(R.drawable.pie);
            }
        });
    }
}
