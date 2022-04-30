package com.example.exam11_13;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;

        Integer[] posterID = { R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
                R.drawable.mov14, R.drawable.mov15, R.drawable.mov16, R.drawable.mov17,
                R.drawable.mov18, R.drawable.mov19, R.drawable.mov20 };

        public MyGalleryAdapter(Context c) { context = c; }

        public int getCount() { return 0; }

        public Object getItem(int arg0) { return null; }

        public long getItemId(int position) { return 0; }

        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
