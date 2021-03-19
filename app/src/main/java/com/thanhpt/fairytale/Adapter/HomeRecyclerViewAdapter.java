package com.thanhpt.fairytale.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanhpt.fairytale.Activity.SelectPictureGalleryActivity;
import com.thanhpt.fairytale.Fragment.FragmentHome;
import com.thanhpt.fairytale.Fragment.FragmentHomeClickPicture;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.Item.Picture;
import com.thanhpt.fairytale.R;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHoder> {
    private List<PicFavo> picFavoList;

    public HomeRecyclerViewAdapter(List<PicFavo> picFavoList) {
        this.picFavoList = picFavoList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recyclerview_home,viewGroup,false);
//        int height = viewGroup.getMeasuredHeight() / 4;
//        view.setMinimumHeight(height);
        return new ViewHoder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        PicFavo picture = picFavoList.get(i);
        viewHoder.imageView.setImageResource(picture.getPic());
    }

    @Override
    public int getItemCount() {
        return picFavoList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder  {
        public ImageView imageView;
        public ViewHoder(final View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_recyclerview_home);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),SelectPictureGalleryActivity.class);
                imageView.buildDrawingCache();
                Bitmap image= imageView.getDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable("KEY", image);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);

                }
            });
        }


    }
}
