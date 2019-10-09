package com.ieee.daiict.ifest19;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperFragment extends Fragment {
    TextView github1,github2,github3,github4,github5,github6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_developer, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        github1 = (TextView) getView().findViewById(R.id.tv6);
        github2 = (TextView) getView().findViewById(R.id.tv7);

        github3 = (TextView) getView().findViewById(R.id.tv8);
        github4 = (TextView) getView().findViewById(R.id.tv9);
        github5 = (TextView) getView().findViewById(R.id.tv10);

        github6 = (TextView) getView().findViewById(R.id.tv21);

        github1.setClickable(true);
        github1.setMovementMethod(LinkMovementMethod.getInstance());

        github2.setClickable(true);
        github2.setMovementMethod(LinkMovementMethod.getInstance());

        github3.setClickable(true);
        github3.setMovementMethod(LinkMovementMethod.getInstance());

        github4.setClickable(true);
        github4.setMovementMethod(LinkMovementMethod.getInstance());

        github5.setClickable(true);
        github5.setMovementMethod(LinkMovementMethod.getInstance());

        github6.setClickable(true);
        github6.setMovementMethod(LinkMovementMethod.getInstance());

    }



}
