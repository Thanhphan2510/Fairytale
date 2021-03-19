package com.thanhpt.fairytale.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thanhpt.fairytale.Item.ItemMenuMyBookings;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MenuMyBookingsListAdapter extends ArrayAdapter<ItemMenuMyBookings> {
    private Context context;
    private ArrayList<ItemMenuMyBookings> list;

    public MenuMyBookingsListAdapter(Context context, ArrayList<ItemMenuMyBookings> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }


    //    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu_my_bookings, parent, false);
        ItemMenuMyBookings myBookings = list.get(position);

        TextView title = (TextView) view.findViewById(R.id.title_mybookings_tv);
        TextView status = (TextView) view.findViewById(R.id.status_mybookings_tv);
        title.setText(myBookings.getTitle());
        String statusString = myBookings.getStatus();
        status.setText(statusString);
        if (statusString.equalsIgnoreCase("PENDING")) {
            status.setTextColor(Color.parseColor("#ffdfdfdf"));

        }
        if (statusString.equalsIgnoreCase("CONFIRMED")) {
            status.setTextColor(Color.parseColor("#ff444444"));        }


        return view;
    }
}
