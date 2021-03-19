package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.thanhpt.fairytale.R;

public class BookNowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_book_now);
        final ImageView imageView_photo, imageView_video, back;
        Button bookNow;
        imageView_photo = (ImageView) findViewById(R.id.checkbox_photo_imageview);
        imageView_video = (ImageView) findViewById(R.id.checkbox_video_imageview);
        bookNow = (Button) findViewById(R.id.booknow_button);
        imageView_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_photo.setImageResource(R.drawable.checked_icon2x);
                imageView_video.setImageResource(R.drawable.checkbox2x);
            }
        });
        imageView_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_photo.setImageResource(R.drawable.checkbox2x);
                imageView_video.setImageResource(R.drawable.checked_icon2x);
            }
        });
        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MakeBookingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        back = (ImageView)   findViewById(R.id.back_imageview);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
