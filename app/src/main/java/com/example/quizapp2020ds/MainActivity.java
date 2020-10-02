package com.example.quizapp2020ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quizapp2020ds.adapter.MainPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.viewPager.NonScrollBarViewPager;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;


    TextView quiz;


    private NonScrollBarViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz=findViewById(R.id.Quiz1);
        viewPager = findViewById(R.id.main_pager);

        navigationView=findViewById(R.id.navigView);

        NavigationViewPager();

    }






    private void NavigationViewPager() {




        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));


        viewPager.setOffscreenPageLimit(2);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_main:
                        viewPager.setCurrentItem(0,false);

                        quiz.setText("Quiz");

                        break;
                    case R.id.nav_history:
                        viewPager.setCurrentItem(1,false);
                        quiz.setText("History");

                        break;
                    case R.id.nav_settings:
                        viewPager.setCurrentItem(2,false);
                        quiz.setText("Settings");

                        break;



                }
                return true;
            }





        });
    }

}