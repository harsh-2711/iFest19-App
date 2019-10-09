package com.ieee.daiict.ifest19;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    List<String[]> names;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        names = new ArrayList<String[]>();
        names.add(new String[]{"Rahil Patel","PR & Marketing","+91 9375962477"});
        names.add(new String[]{"Parth Katrodiya","PR & Marketing","+91 9429432142"});
        names.add(new String[]{"Vishwa Shah","PR & Marketing","+91 9408780818"});
        names.add(new String[]{"Khyati Bhuva","Sponsorship","+91 7016332328"});
        names.add(new String[]{"Devanshu Vithlani","Designing","+91 9714533000"});
        names.add(new String[]{"Devyani Panchal","Designing","+91 9824413747"});
        names.add(new String[]{"Yashvi Shah","Designing","+91 9725035934"});
        names.add(new String[]{"Nikunj Shah","Sponsorship","+91 9924230332"});
        names.add(new String[]{"Vedant Thakkar","Sponsorship","+91 9825551070"});
        names.add(new String[]{"Madhavendra Choksi","Sponsorship","+91 9427772012"});
        names.add(new String[]{"Kartavi Shah","Sponsorship","+234 8121451665"});
        names.add(new String[]{"Meet Raval","Production","+91 886724439"});
        names.add(new String[]{"Harsh Patel","Production","+91 7990252119"});

        ContactAdapter adapter = new ContactAdapter(this.getActivity(), names);

        ListView listView = (ListView) getView().findViewById(R.id.contactList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+names.get(position)[2]));
                startActivity(i);
            }
        });
    }
}
