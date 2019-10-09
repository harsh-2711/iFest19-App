package com.ieee.daiict.ifest19;



import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleEventScheduleFragment extends Fragment {

    String eventName;
    TextView tv_schedule1;

    public SingleEventScheduleFragment(String eventName){
        this.eventName = eventName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_event_schedule, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_schedule1 = (TextView)getView().findViewById(R.id.tv_schedule1);

        tv_schedule1.setText(getString(getResources().getIdentifier(eventName+"Schedule","string", getActivity().getPackageName())));
    }
}
