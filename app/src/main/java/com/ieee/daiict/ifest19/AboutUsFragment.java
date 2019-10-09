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
public class AboutUsFragment extends Fragment {
    TextView despDA,despIFEST,despIEEE,despDi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Data.getNavigationLiveo().setCheckedItemNavigation(Data.getNavigationLiveo().getCurrentCheckPosition(), false);
        Data.getNavigationLiveo().setCheckedItemNavigation(3, true);
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        despDA = (TextView) getView().findViewById(R.id.despDA);
        despIEEE = (TextView) getView().findViewById(R.id.despIEEE);
        despIFEST = (TextView) getView().findViewById(R.id.despIFEST);
        despDi = (TextView) getView().findViewById(R.id.despDIS);

    }
}
