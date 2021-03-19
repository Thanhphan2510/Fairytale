package com.thanhpt.fairytale.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thanhpt.fairytale.Adapter.FavoriteListAdapter;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;

public class FragmentFavoriteMain extends Fragment {
    ListView listView;
    FavoriteListAdapter favoriteListAdapter;
    public static FragmentFavoriteMain newInstance() {
        FragmentFavoriteMain fragment = new FragmentFavoriteMain();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_main,container,false);
        listView = (ListView) view.findViewById(R.id.favorite_listview);
        ArrayList<PicFavo> imageList = new ArrayList<>();
        imageList.add(new PicFavo((R.drawable.pic1)));
        imageList.add(new PicFavo((R.drawable.pic2)));
        imageList.add(new PicFavo((R.drawable.pic3)));
        imageList.add(new PicFavo((R.drawable.pic4)));
        imageList.add(new PicFavo((R.drawable.pic5)));
        imageList.add(new PicFavo((R.drawable.pic6)));

        favoriteListAdapter = new FavoriteListAdapter(view.getContext(),imageList);
        listView.setAdapter(favoriteListAdapter);
        return view;

    }
}
