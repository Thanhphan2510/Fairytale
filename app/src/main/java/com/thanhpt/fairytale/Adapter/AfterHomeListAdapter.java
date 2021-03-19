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
import com.thanhpt.fairytale.Item.PicFavo_Icon;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.List;

public class AfterHomeListAdapter extends ArrayAdapter<PicFavo_Icon> {
    private Context context;
    private List<PicFavo_Icon> picafterHomeArrayList = new ArrayList<>();

    public AfterHomeListAdapter(Context context, List<PicFavo_Icon> picafterHomeArrayList) {
        super(context, 0,picafterHomeArrayList);
        this.context = context;
        this.picafterHomeArrayList = picafterHomeArrayList;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View listView = convertView;
        listView = LayoutInflater.from(context).inflate(R.layout.item_listview_afterhome,parent,false);

        PicFavo_Icon picFavo = picafterHomeArrayList.get(position);
        final ImageView imageView = (ImageView)  listView.findViewById(R.id.pic_imageview_afterhome);
        imageView.setImageResource(picFavo.getImage());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity =(AppCompatActivity) v.getContext();
                Intent intent = new Intent(activity.getApplicationContext(),SelectPictureActivity.class);
                activity.startActivity(intent);
            }
        });
        final ImageView imageView1 = (ImageView)  listView.findViewById(R.id.icon_afterhome);
        imageView1.setImageResource(picFavo.getIcon());
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(imageView1.getDrawable().getConstantState() ==  v.getResources().getDrawable(R.drawable.uncheck2x).getConstantState()){
                   imageView1.setImageResource(R.drawable.check2x);

               }else

                if(imageView1.getDrawable().getConstantState() ==  v.getResources().getDrawable(R.drawable.check2x).getConstantState())
                    imageView1.setImageResource(R.drawable.uncheck2x);

            }
        });

        return listView;
    }


}
