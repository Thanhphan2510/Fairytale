package com.thanhpt.fairytale.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.thanhpt.fairytale.Adapter.PictureAdapter;
import com.thanhpt.fairytale.Item.Picture;
import com.thanhpt.fairytale.R;
import com.thanhpt.fairytale.Utils.SpaceItemRecyclerView;
import com.thanhpt.fairytale.Utils.UIUtils;

import java.util.ArrayList;

public class FragmentHomeMain extends Fragment {
    ArrayList<Picture> pictureArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    PictureAdapter pictureAdapter;
    ImageView imageView;


    public static FragmentHomeMain newInstance() {
        FragmentHomeMain fragment = new FragmentHomeMain();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pictureArrayList.add(new Picture(R.drawable.pic1,"VENUES"));
        pictureArrayList.add(new Picture(R.drawable.pic2,"PHOTOGRAPHERS"));
        pictureArrayList.add(new Picture(R.drawable.pic3,"WEDDING DRESSES"));
        pictureArrayList.add(new Picture(R.drawable.pic4,"ENTERTAIMENT"));
        pictureArrayList.add(new Picture(R.drawable.pic5,"KOSHA DESIGN"));
        pictureArrayList.add(new Picture(R.drawable.pic6,"FLOWER SHOPS"));
        pictureArrayList.add(new Picture(R.drawable.pic1,"VENUES"));
        pictureArrayList.add(new Picture(R.drawable.pic2,"PHOTOGRAPHERS"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);


        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        pictureAdapter = new PictureAdapter(pictureArrayList);
        recyclerView.setAdapter(pictureAdapter);
        recyclerView.addItemDecoration(new SpaceItemRecyclerView(20));
        return view;

    }


}
