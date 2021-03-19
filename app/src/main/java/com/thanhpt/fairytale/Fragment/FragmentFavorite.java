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
import android.widget.ListView;

import com.thanhpt.fairytale.Adapter.FavoriteListAdapter;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;

public class FragmentFavorite extends Fragment {
    ListView listView;
    FavoriteListAdapter favoriteListAdapter;
    public static FragmentFavorite newInstance() {
        FragmentFavorite fragment = new FragmentFavorite();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_favorite,container,false);
        AppCompatActivity activity =(AppCompatActivity)view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_favorite, FragmentFavoriteMain.newInstance()).addToBackStack(null).commit();
       return view;

    }
}
