package com.ieee.daiict.ifest19;



import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleEventCoordinatorsFragment extends Fragment {

    TextView contactName1,contactPhone1,contactName2,contactPhone2;
    Button btn1,btn2;
    String eventName;

    public SingleEventCoordinatorsFragment(String eventName){
        this.eventName = eventName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_event_coordinators, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            Glide.with(this).load(R.drawable.iganith).into((ImageView) getView().findViewById(R.id.thumbnail));
        } catch (Exception e) {
            e.printStackTrace();
        }
        contactName1 = (TextView)getView().findViewById(R.id.tv_contactName1);
        contactPhone1 = (TextView)getView().findViewById(R.id.tv_contactPhone1);
        contactName2 = (TextView)getView().findViewById(R.id.tv_contactName2);
        contactPhone2 = (TextView)getView().findViewById(R.id.tv_contactPhone2);
        btn1 = (Button) getView().findViewById(R.id.btn1);
        btn2 = (Button) getView().findViewById(R.id.btn2);

        contactName1.setText(getString(getResources().getIdentifier(eventName+"ContactName1","string", getActivity().getPackageName())));
        contactPhone1.setText(getString(getResources().getIdentifier(eventName+"ContactPhone1","string", getActivity().getPackageName())));
        String name2 = getString(getResources().getIdentifier(eventName+"ContactName2","string", getActivity().getPackageName()));
        if(!name2.equals("")) {
            contactName2.setVisibility(View.VISIBLE);
            contactPhone2.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);

            contactName2.setText(name2);
            contactPhone2.setText(getString(getResources().getIdentifier(eventName + "ContactPhone2", "string", getActivity().getPackageName())));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+contactPhone2.getText()));
                    startActivity(i);
                }
            });
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+contactPhone1.getText()));
                startActivity(i);
            }
        });
    }

}
