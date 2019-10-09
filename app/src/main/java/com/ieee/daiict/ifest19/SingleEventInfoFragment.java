package com.ieee.daiict.ifest19;



import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleEventInfoFragment extends Fragment {
    TextView infoTitle, infoDescription, infoQuote, infoRules;
    ImageView thumbnail;
    String eventName;

    public SingleEventInfoFragment(){

    }

    public SingleEventInfoFragment(String eventName) {
        // Required empty public constructor
        this.eventName = eventName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_single_event_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        infoDescription = (TextView)getView().findViewById(R.id.tv_infoDescription);
        infoRules = (TextView)getView().findViewById(R.id.tv_infoRules);
        infoTitle = (TextView)getView().findViewById(R.id.tv_infoTitle);
        infoQuote = (TextView)getView().findViewById(R.id.tv_infoQuote);
        thumbnail = (ImageView) getView().findViewById(R.id.thumbnail);

        Glide.with(this).load(getResources().getIdentifier(eventName.replace(".","").toLowerCase(), "drawable",getActivity().getPackageName())).into(thumbnail);
        infoTitle.setText(getString(getResources().getIdentifier(eventName+"Title","string", getActivity().getPackageName())));
        String quote = getString(getResources().getIdentifier(eventName+"Quote","string", getActivity().getPackageName()));
        if(!quote.equals("")) {
            infoQuote.setVisibility(View.VISIBLE);
            infoQuote.setText(quote);
        }
        String description = getString(getResources().getIdentifier(eventName+"Description","string", getActivity().getPackageName()));
        if(!description.equals("")) {
            getView().findViewById(R.id.card_view_info2).setVisibility(View.VISIBLE);
            if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
                infoDescription.setText(Html.fromHtml(description,Html.FROM_HTML_MODE_LEGACY));
            } else {
                infoDescription.setText(Html.fromHtml(description));
            }
            infoDescription.setMovementMethod(LinkMovementMethod.getInstance());
        }
        String rules = getString(getResources().getIdentifier(eventName+"Rules","string", getActivity().getPackageName()));
        if(!rules.equals("")) {
            getView().findViewById(R.id.card_view_info3).setVisibility(View.VISIBLE);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
                infoRules.setText(Html.fromHtml(rules,Html.FROM_HTML_MODE_LEGACY));
            } else {
                infoRules.setText(Html.fromHtml(rules));
            }
            infoRules.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
}
