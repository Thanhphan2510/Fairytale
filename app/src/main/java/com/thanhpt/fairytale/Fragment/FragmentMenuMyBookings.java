package com.thanhpt.fairytale.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thanhpt.fairytale.Adapter.MenuMyBookingsListAdapter;
import com.thanhpt.fairytale.Item.ItemMenuMyBookings;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;

public class FragmentMenuMyBookings extends Fragment {
    ListView listView;
    public static FragmentMenuMyBookings newInstance() {
        FragmentMenuMyBookings fragment = new FragmentMenuMyBookings();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_my_bookings,container,false);

        listView = (ListView) view.findViewById(R.id.list_mybookings_menu);
        ArrayList<ItemMenuMyBookings> arrayList = new ArrayList<>();
        arrayList.add(new ItemMenuMyBookings("PHOTOGRAPHY","PENDING"));
        arrayList.add(new ItemMenuMyBookings("PHOTOGRAPHY","CONFIRMED"));
        arrayList.add(new ItemMenuMyBookings("MODELING","PENDING"));
        MenuMyBookingsListAdapter menuMyBookingsListAdapter = new MenuMyBookingsListAdapter(view.getContext(),arrayList);
        listView.setAdapter(menuMyBookingsListAdapter);
        return view;

    }
}
