
package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.thanhpt.fairytale.Adapter.ImageWelcomeAdaper;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class WelcomeActivity extends AppCompatActivity {
    private static final Integer[] imageWelcome = {R.drawable.image_welcome, R.drawable.pic1, R.drawable.pic2,};
    private ArrayList<Integer> imageWelcomeArray = new ArrayList<Integer>();
    private static int currentPage = 0;
    private static ViewPager mPager;

    TextView skipview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_welcome);
        init();
        skipview = (TextView) findViewById(R.id.skipview);
        skipview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        for (int i = 0; i < imageWelcome.length; i++)
            imageWelcomeArray.add(imageWelcome[i]);

        mPager = (ViewPager) findViewById(R.id.welcome_viewpager);
        mPager.setAdapter(new ImageWelcomeAdaper(WelcomeActivity.this, imageWelcomeArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imageWelcome.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}


