package com.thanhpt.fairytale.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.thanhpt.fairytale.Activity.SelectPictureActivity;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.List;



public class FavoriteListAdapter extends ArrayAdapter<PicFavo> {
    private Context context;
    private List<PicFavo> picFavoArrayList = new ArrayList<>();

    public FavoriteListAdapter(Context context, List<PicFavo> picFavoArrayList) {
        super(context, 0,picFavoArrayList);
        this.context = context;
        this.picFavoArrayList = picFavoArrayList;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View listView = convertView;
        listView = LayoutInflater.from(context).inflate(R.layout.item_listview_favorite,parent,false);

        PicFavo picFavo = picFavoArrayList.get(position);
        ImageView imageView = (ImageView)  listView.findViewById(R.id.pic_imageview);
        imageView.setImageResource(picFavo.getPic());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity =(AppCompatActivity) v.getContext();
                Intent intent = new Intent(activity.getApplicationContext(),SelectPictureActivity.class);
                activity.startActivity(intent);
            }
        });

        return listView;
    }
}
