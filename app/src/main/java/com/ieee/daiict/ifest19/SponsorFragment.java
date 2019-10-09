package com.ieee.daiict.ifest19;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SponsorFragment extends Fragment {

    List<Integer> sponsorLogos;
    //List<String> sponsorUrls;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Data.getNavigationLiveo().setCheckedItemNavigation(Data.getNavigationLiveo().getCurrentCheckPosition(), false);
        Data.getNavigationLiveo().setCheckedItemNavigation(6, true);
        return inflater.inflate(R.layout.fragment_sponsor, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sponsorLogos = new ArrayList<Integer>();
        //sponsorUrls = new ArrayList<String>();
        sponsorLogos.add(R.drawable.sponsor1);
        //sponsorUrls.add("http://ieee.daiict.ac.in");
        sponsorLogos.add(R.drawable.sponsor2);
        //sponsorUrls.add("https://www.endeavorcareers.com/centers/ahmedabad");
        sponsorLogos.add(R.drawable.sponsor6);
        //sponsorUrls.add("https://www.endeavorcareers.com/centers/ahmedabad");
        sponsorLogos.add(R.drawable.sponsor7);
        //sponsorUrls.add("https://www.thecollegefever.com/");
        sponsorLogos.add(R.drawable.sponsor4);
        //sponsorUrls.add("https://www.sharkid.in");
        sponsorLogos.add(R.drawable.sponsor5);
        //sponsorUrls.add("http://www.infizeal.com");
        sponsorLogos.add(R.drawable.sbi);
        //sponsorUrls.add("http://www.infizeal.com");
        sponsorLogos.add(R.drawable.delhivery);
        sponsorLogos.add(R.drawable.careerlauncher);
        sponsorLogos.add(R.drawable.gymlounge);
        sponsorLogos.add(R.drawable.beansco);
        sponsorLogos.add(R.drawable.krishna);

        SponsorAdapter adapter = new SponsorAdapter(this.getActivity(), sponsorLogos);

        ListView listView = (ListView) getView().findViewById(R.id.sponsorList);
        listView.setAdapter(adapter);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(sponsorUrls.get(position)));
                startActivity(i);
            }
        });*/
    }
}
