package com.example.zhuxiaodong.iss_tracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.zhuxiaodong.iss_tracker.fragment.InfoFragment;
import com.example.zhuxiaodong.iss_tracker.fragment.MapFragment;
import com.example.zhuxiaodong.iss_tracker.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private final Fragment m_MapFragment = new MapFragment();
    private final Fragment m_NotificationFragment = new NotificationFragment();
    private final Fragment m_InfoFragment = new InfoFragment();
    private Fragment activeFragment = m_MapFragment;
    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction().hide(activeFragment).show(m_MapFragment).commit();
                    activeFragment = m_MapFragment;
                    return true;
                case R.id.info_dashboard:
                    fragmentManager.beginTransaction().hide(activeFragment).show(m_InfoFragment).commit();
                    activeFragment = m_InfoFragment;
                    return true;
                case R.id.navigation_notifications:
                    fragmentManager.beginTransaction().hide(activeFragment).show(m_NotificationFragment).commit();
                    activeFragment = m_NotificationFragment;
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager.beginTransaction().add(R.id.main_container, m_NotificationFragment, "Notification").hide(m_NotificationFragment).commit();
        fragmentManager.beginTransaction().add(R.id.main_container, m_InfoFragment, "Info").hide(m_InfoFragment).commit();
        fragmentManager.beginTransaction().add(R.id.main_container, m_MapFragment, "Map").commit();

    }

}
