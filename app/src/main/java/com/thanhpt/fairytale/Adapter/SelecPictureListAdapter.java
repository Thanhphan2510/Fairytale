package com.thanhpt.fairytale.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.thanhpt.fairytale.Item.ItemSelectPicure;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.List;

public class SelecPictureListAdapter extends ArrayAdapter<ItemSelectPicure> {
    private Context context;
    private List<ItemSelectPicure> selectPicureList = new ArrayList<>();

    public SelecPictureListAdapter(Context context, List<ItemSelectPicure> selectPicureList) {
        super(context, 0,selectPicureList);
        this.context = context;
        this.selectPicureList = selectPicureList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listview_selectpicture,parent,false);

        ItemSelectPicure itemSelectPicure = selectPicureList.get(position);
        TextView title = (TextView) view.findViewById(R.id.title_tv);
        TextView comment = (TextView) view.findViewById(R.id.comment_tv);
        RatingBar rating = (RatingBar) view.findViewById(R.id.rating_bar1);

        title.setText(itemSelectPicure.getTitle());
        comment.setText(itemSelectPicure.getComment());
        rating.setRating(itemSelectPicure.getRate());
        return view;
    }
}
