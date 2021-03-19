package com.thanhpt.fairytale.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanhpt.fairytale.R;

public class FragmentMenuMain extends Fragment {
    TextView aboutusView,contactusView,mybookingsView;
    public static FragmentMenuMain newInstance() {
        FragmentMenuMain fragment = new FragmentMenuMain();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        pictureArrayList.add(new Picture(R.drawable.pic1,"VENUES"));
//        pictureArrayList.add(new Picture(R.drawable.pic2,"PHOTOGRAPHERS"));
//        pictureArrayList.add(new Picture(R.drawable.pic3,"WEDDING DRESSES"));
//        pictureArrayList.add(new Picture(R.drawable.pic4,"ENTERTAIMENT"));
//        pictureArrayList.add(new Picture(R.drawable.pic5,"KOSHA DESIGN"));
//        pictureArrayList.add(new Picture(R.drawable.pic6,"FLOWER SHOPS"));
//        pictureArrayList.add(new Picture(R.drawable.pic1,"VENUES"));
//        pictureArrayList.add(new Picture(R.drawable.pic2,"PHOTOGRAPHERS"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_menu_main,container,false);
        aboutusView = (TextView) view.findViewById(R.id.about_us_tv);
        aboutusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMenuAboutUs fragmentMenuAboutUs = new FragmentMenuAboutUs();
                AppCompatActivity activity =(AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu,fragmentMenuAboutUs)
                        .addToBackStack(null).commit();
            }
        });
        contactusView = (TextView) view.findViewById(R.id.contact_us_tv);
        contactusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMenuContactUs fragmentMenuContactUs = new FragmentMenuContactUs();
                AppCompatActivity activity =(AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu,fragmentMenuContactUs)
                        .addToBackStack(null).commit();

            }
        });

        mybookingsView = (TextView) view.findViewById(R.id.mybooking_tv);
        mybookingsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMenuMyBookings fragmentMenuMyBookings = new FragmentMenuMyBookings();
                AppCompatActivity activity =(AppCompatActivity) view.getContext();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu,fragmentMenuMyBookings)
                        .addToBackStack(null).commit();

            }
        });

        return view;

    }


}
