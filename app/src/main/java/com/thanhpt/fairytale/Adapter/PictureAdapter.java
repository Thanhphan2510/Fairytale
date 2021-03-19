package com.thanhpt.fairytale.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thanhpt.fairytale.Fragment.FragmentHome;
import com.thanhpt.fairytale.Fragment.FragmentHomeClickPicture;
import com.thanhpt.fairytale.Fragment.FragmentHomeMain;
import com.thanhpt.fairytale.Item.Picture;
import com.thanhpt.fairytale.R;

import java.util.List;


public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHoder> {

    private List<Picture> pictureList;

    public PictureAdapter(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }


    public class ViewHoder extends RecyclerView.ViewHolder  {
        public ImageView imageView;
        public TextView textView;

        public ViewHoder(final View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pic_imageview_recycler);
            textView = (TextView) itemView.findViewById(R.id.pic_textview);
            final FragmentHome fragmentHome = new FragmentHome();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity =(AppCompatActivity) itemView.getContext();
                    FragmentHomeClickPicture fragment = new FragmentHomeClickPicture();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_home,fragment)
                            .addToBackStack(null).commit();

                }
            });
        }


    }


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recyclerview_custom_layout,viewGroup,false);
        return new ViewHoder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        Picture picture = pictureList.get(i);
        viewHoder.imageView.setImageResource(picture.getImageView());
        viewHoder.textView.setText(picture.getTextView());
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

}
