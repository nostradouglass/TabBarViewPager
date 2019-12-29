package com.kellydouglass.tabbarviewpager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.kellydouglass.tabbarviewpager.TabFragments.BlankFragment;
import com.kellydouglass.tabbarviewpager.TabFragments.BlankFragment2;
import com.kellydouglass.tabbarviewpager.TabFragments.BlankFragment3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;

    BlankFragment mBlankFragment1;
    BlankFragment2 mBlankFragment2;
    BlankFragment3 mBlankFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        mBlankFragment1 = new BlankFragment();
        mBlankFragment2 = new BlankFragment2();
        mBlankFragment3 = new BlankFragment3();

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);

    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] fragmentNames = {"first", "second", "third"};


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return mBlankFragment1;
                case 1:
                    return mBlankFragment2;
                case 2:
                    return mBlankFragment3;
            }

            return null;
        }

        @Override
        public int getCount() {
            return fragmentNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentNames[position];
        }
    }


}
