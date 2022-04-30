package com.example.exam13_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMP3;
    Button btnPlay, btnStop;
    TextView tvMP3;
    ProgressBar pbMP3;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/" ;
    MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);
    }
}
