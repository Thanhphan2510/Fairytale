package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thanhpt.fairytale.Adapter.HomeRecyclerViewAdapter;
import com.thanhpt.fairytale.Adapter.PictureAdapter;
import com.thanhpt.fairytale.Adapter.SelecPictureListAdapter;
import com.thanhpt.fairytale.Item.ItemSelectPicure;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.Item.Picture;
import com.thanhpt.fairytale.R;
import com.thanhpt.fairytale.Utils.SpaceItemRecyclerView;
import com.thanhpt.fairytale.Utils.UIUtils;

import java.util.ArrayList;

public class SelectPictureActivity extends AppCompatActivity {
    ListView listView;
    ImageView back;
    TextView rate_tv;
    Button bookbtn;
    ArrayList<ItemSelectPicure> itemSelectPicuresList ;
    SelecPictureListAdapter selectPictureListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_select_picture);

        rate_tv = (TextView) findViewById(R.id.rate_tv);
        rate_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RateActivity.class);
                startActivityForResult(intent,1);


            }
        });


        listView = (ListView) findViewById(R.id.comment_listview_selectpic);

        itemSelectPicuresList = new ArrayList<>();
        itemSelectPicuresList.add(new ItemSelectPicure("LOREM IPSUM IS SIMPLY DUMMY TEXT OF THE " +
                "PRINTING AND TYPESETTING INDUSTRY. ", "PETER GEORGE", 4));
        itemSelectPicuresList.add(new ItemSelectPicure("LOREM IPSUM IS SIMPLY DUMMY TEXT OF THE " +
                "PRINTING AND TYPESETTING INDUSTRY. ", "WILLIAM JACOB", 2));
        itemSelectPicuresList.add(new ItemSelectPicure("LOREM IPSUM IS SIMPLY DUMMY TEXT OF THE " +
                "PRINTING AND TYPESETTING INDUSTRY. ", "RONALD MILHAN", 5));

        selectPictureListAdapter = new SelecPictureListAdapter(this, itemSelectPicuresList);
        listView.setAdapter(selectPictureListAdapter);

        //display full item of listview inside scrollview
        UIUtils.setListViewHeightBasedOnItems(listView);

        back = (ImageView) findViewById(R.id.back_selectpic);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });






        RecyclerView recyclerView;
        HomeRecyclerViewAdapter pictureAdapter;
        ArrayList<PicFavo> pictureArrayList = new ArrayList<>();
        pictureArrayList.add(new PicFavo(R.drawable.pic1));
        pictureArrayList.add(new PicFavo(R.drawable.pic2));
        pictureArrayList.add(new PicFavo(R.drawable.pic3));
        pictureArrayList.add(new PicFavo(R.drawable.pic4));
        pictureArrayList.add(new PicFavo(R.drawable.pic5));
        pictureArrayList.add(new PicFavo(R.drawable.pic6));



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_home);
        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        pictureAdapter = new HomeRecyclerViewAdapter(pictureArrayList);
        recyclerView.setAdapter(pictureAdapter);
        recyclerView.addItemDecoration(new SpaceItemRecyclerView(9));

        bookbtn = findViewById(R.id.booknow_button);
        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BookNowActivity.class);
                startActivity(intent);

            }
        });

         final ImageView favoIcon = (ImageView) findViewById(R.id.favorite_icon);
         favoIcon.setImageResource(R.drawable.favorite_icon2x);
        favoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                favoIcon.setImageResource(R.drawable.favorite_checked2x);
                if(favoIcon.getDrawable().getConstantState() ==  v.getResources().getDrawable(R.drawable.favorite_icon2x).getConstantState()){
                    favoIcon.setImageResource(R.drawable.favorite_checked2x);

                }else

                if(favoIcon.getDrawable().getConstantState() ==  v.getResources().getDrawable(R.drawable.favorite_checked2x).getConstantState())
                    favoIcon.setImageResource(R.drawable.favorite_icon2x);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
            String cmtReturn = data.getStringExtra("cmt");
            String rateReturn = data.getStringExtra("rate");
             itemSelectPicuresList.add(new ItemSelectPicure(cmtReturn,"Thanh Phan" , Float.parseFloat(rateReturn)));
                selectPictureListAdapter.notifyDataSetChanged();
                UIUtils.setListViewHeightBasedOnItems(listView);

            }
        }
    }
}
