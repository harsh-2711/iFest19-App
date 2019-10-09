package com.ieee.daiict.ifest19;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class SingleEventFragment extends Fragment {

    String eventName;

    public SingleEventFragment(String eventName){
        this.eventName = eventName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_single_event, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Event Info").setIcon(R.drawable.info_w));
        tabLayout.addTab(tabLayout.newTab().setText("Coordinators").setIcon(R.drawable.coordinators));
        tabLayout.addTab(tabLayout.newTab().setText("Schedule").setIcon(R.drawable.schedule_w));

        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.viewpager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
        }
        else {
            viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        }
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                Fragment f = new SingleEventInfoFragment(eventName);
                return f;
            }
            if(position==1){
                Fragment f = new SingleEventCoordinatorsFragment(eventName);
                return f;
            }
            if(position==2){
                Fragment f = new SingleEventScheduleFragment(eventName);
                return f;
            }
            Fragment f = new SingleEventInfoFragment(eventName);
            return f;

        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
