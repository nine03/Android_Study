package com.example.exercise06_07;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{
    // 프로그먼트 (각 화면) 4개
    MyTabFragment myFrags[] = new MyTabFragment[4];
    ActionBar.Tab myTabs[] = new ActionBar.Tab[4]; // 4개 탭
    Integer iconIDs[] = { R.drawable.icon_dog, R.drawable.icon_cat,
            R.drawable.icon_rabbit, R.drawable.icon_horse };
    Integer imageIDs[] = { R.drawable.dog, R.drawable.cat, R.drawable.rabbit,
            R.drawable.horse };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("연습문제 6-7");

        ActionBar bar = getSupportActionBar();// 상단에 표시할 액션 바 준비
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // 4개 탭을 액션바에 추가함.
        for (int i = 0; i < 4; i++) {
            myTabs[i] = bar.newTab();
            myTabs[i].setIcon(iconIDs[i]);
            myTabs[i].setTabListener(this);
            bar.addTab(myTabs[i]);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null; // 현재 프래그면터(화면)

        int index = tab.getPosition();

        if (myFrags[index] == null) { // 이 탭이 처음으로 선택되면
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle(); // 프래그먼트에 값을 지정하기 위해서 준비
            data.putInt("iconID", iconIDs[index]); // 프래그먼트 마다 탭의 이름을 지정함
            myTabFrag.setArguments(data);
            myFrags[index] = myTabFrag; // 생성한 프래그먼트를 배열의 해당 위치에 지정
        } else {
            // 이미 해당 탭의 위치에 프래그먼트가 있으면(=전에 탭을 선택한 적이 있다면
            // 기존의 프래그먼트를 사용
            myTabFrag = myFrags[tab.getPosition()];
        }

        ft.replace(android.R.id.content, myTabFrag); // 화면을 변경함.
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // 프래그먼트를 정의함 --> 프래그먼트는 작은 액티비티라고 생각하면 됨.
    public static class MyTabFragment extends Fragment {
        int iconID;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            iconID = data.getInt("iconID");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // 프래그먼트 별로 다른 색을 지정함.
            View myView = inflater.inflate(R.layout.activity_main, null);
            ImageView petIV = (ImageView) myView.findViewById(R.id.petIV);

            if (iconID == R.drawable.icon_dog)
                petIV.setImageResource(R.drawable.dog);
            if (iconID == R.drawable.icon_cat)
                petIV.setImageResource(R.drawable.cat);
            if (iconID == R.drawable.icon_rabbit)
                petIV.setImageResource(R.drawable.rabbit);
            if (iconID == R.drawable.icon_horse)
                petIV.setImageResource(R.drawable.horse);

            return myView;
        }
    }
}