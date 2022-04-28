package com.example.exam05_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    Button button;
    RatingBar ratingbar;
    ImageView imageview;
    CheckBox checkbox;

    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        ratingbar = (RatingBar)findViewById(R.id.ratingBar1);
        imageview = (ImageView)findViewById(R.id.imageView1);
        checkbox = (CheckBox)findViewById(R.id.checkBox1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( check == 0 ){
                    check = 1;
                    button.setText("\"RatingBar\"만 보임");
                    ratingbar.setVisibility(View.VISIBLE);
                    imageview.setVisibility(View.INVISIBLE);
                    checkbox.setVisibility(View.INVISIBLE);
                } else if( check == 1 ){
                    check = 2;
                    button.setText("\"ImageView\"만 보임");
                    ratingbar.setVisibility(View.INVISIBLE);
                    imageview.setVisibility(View.VISIBLE);
                    checkbox.setVisibility(View.INVISIBLE);
                } else {
                    check = 0;
                    button.setText("\"CheckBox\"만 보임");
                    ratingbar.setVisibility(View.INVISIBLE);
                    imageview.setVisibility(View.INVISIBLE);
                    checkbox.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
