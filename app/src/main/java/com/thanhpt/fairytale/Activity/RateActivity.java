package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.thanhpt.fairytale.R;

public class RateActivity extends AppCompatActivity {
    Button submitbtn;
    TextView skipview;
    RatingBar ratingBar;
    EditText commentRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_rate);
        submitbtn = (Button) findViewById(R.id.submit_btn);
        skipview = (TextView) findViewById(R.id.skipview_submit);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar_rate);
        commentRate = (EditText) findViewById(R.id.comment_rate);



        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringToPassBack =String.valueOf(commentRate.getText());
                String rateToBack = String.valueOf(ratingBar.getRating()) ;
                Intent intent = new Intent();
                intent.putExtra("cmt", stringToPassBack);
                intent.putExtra("rate",rateToBack);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        skipview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //ratingBar.setRating(rating);
                Toast.makeText(RateActivity.this, ""+rating, Toast.LENGTH_SHORT).show();

            }
        });



    }
}
