package com.thanhpt.fairytale.Fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.thanhpt.fairytale.Activity.SelectPictureActivity;
import com.thanhpt.fairytale.Adapter.AfterHomeListAdapter;
import com.thanhpt.fairytale.Adapter.FavoriteListAdapter;
import com.thanhpt.fairytale.Item.PicFavo;
import com.thanhpt.fairytale.Item.PicFavo_Icon;
import com.thanhpt.fairytale.R;

import java.util.ArrayList;

public class FragmentHomeClickPicture extends Fragment {
    ListView listView;
    ImageView backHome, camera;


    AfterHomeListAdapter afterHomeListAdapter;

    public static FragmentHomeClickPicture newInstance() {
        FragmentHomeClickPicture fragment = new FragmentHomeClickPicture();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_clickpicture, container, false);
        listView = (ListView) view.findViewById(R.id.afterhome_listview);
        ArrayList<PicFavo_Icon> imageList = new ArrayList<>();
        imageList.add(new PicFavo_Icon((R.drawable.pic1), R.drawable.uncheck2x));
        imageList.add(new PicFavo_Icon((R.drawable.pic2), R.drawable.uncheck2x));
        imageList.add(new PicFavo_Icon((R.drawable.pic3), R.drawable.uncheck2x));
        imageList.add(new PicFavo_Icon((R.drawable.pic4), R.drawable.uncheck2x));
        imageList.add(new PicFavo_Icon((R.drawable.pic5), R.drawable.uncheck2x));
        imageList.add(new PicFavo_Icon((R.drawable.pic6), R.drawable.uncheck2x));

        afterHomeListAdapter = new AfterHomeListAdapter(view.getContext(), imageList);
        listView.setAdapter(afterHomeListAdapter);

        backHome = (ImageView) view.findViewById(R.id.back_home);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHomeMain fragmentHomeMain = new FragmentHomeMain();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, fragmentHomeMain)
                        .addToBackStack(null).commit();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(view.getContext(),
                    android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                        5);


            }

        }
        camera = (ImageView) view.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent1);
            }
        });


        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera
            } else {
                // Your app will not have this permission. Turn off all functions
                // if permission not granted it will force close the app

            }
        }


    }
}
