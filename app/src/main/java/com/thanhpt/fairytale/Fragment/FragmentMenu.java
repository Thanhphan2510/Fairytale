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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.thanhpt.fairytale.R;

public class FragmentMenu extends Fragment {

    public static FragmentMenu newInstance() {
        FragmentMenu fragment = new FragmentMenu();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        AppCompatActivity activity =(AppCompatActivity)view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//        for (Fragment fragment:activity.getSupportFragmentManager().getFragments()) {
//            activity.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
//        }
        transaction.replace(R.id.frame_menu, FragmentMenuMain.newInstance()).addToBackStack(null).commit();
        return view;
    }
}
