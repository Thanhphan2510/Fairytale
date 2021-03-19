package com.thanhpt.fairytale.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.thanhpt.fairytale.Fragment.FragmentFavorite;
import com.thanhpt.fairytale.Fragment.FragmentHome;
import com.thanhpt.fairytale.Fragment.FragmentHomeClickPicture;
import com.thanhpt.fairytale.Fragment.FragmentMenu;
import com.thanhpt.fairytale.Fragment.FragmentProfile;
import com.thanhpt.fairytale.R;
import com.thanhpt.fairytale.Adapter.ViewPagerAdapter;

public class MainAfterSignupActivity extends AppCompatActivity {
    ViewPager viewPager;
    FragmentHome fragmentHome;
    FragmentMenu fragmentMenu;
    FragmentFavorite fragmentFavorite;
    FragmentProfile fragmentProfile;
    MenuItem prevMenuItem;
    BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_menu:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_home:
                    viewPager.setCurrentItem(1);
                    return true;

                case R.id.navigation_favorite:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_profile:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main_aftersignup);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        navigation.setSelectedItemId(R.id.navigation_home);


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentMenu = new FragmentMenu();
        fragmentHome = new FragmentHome();
        fragmentFavorite = new FragmentFavorite();
        fragmentProfile = new FragmentProfile();

        viewPagerAdapter.addFragment(fragmentMenu);  //index 0
        viewPagerAdapter.addFragment(fragmentHome);
        viewPagerAdapter.addFragment(fragmentFavorite);
        viewPagerAdapter.addFragment(fragmentProfile);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
    }

}
