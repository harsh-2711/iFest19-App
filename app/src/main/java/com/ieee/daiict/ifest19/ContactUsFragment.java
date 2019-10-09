package com.ieee.daiict.ifest19;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class ContactUsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Data.getNavigationLiveo().setCheckedItemNavigation(Data.getNavigationLiveo().getCurrentCheckPosition(), false);
        Data.getNavigationLiveo().setCheckedItemNavigation(7, true);
        Element mobileNo = new Element();
        mobileNo.setTitle("Speak with us");
        mobileNo.setIconDrawable(R.drawable.contact2);
        mobileNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ContactFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                transaction.addToBackStack(null);  // this will manage backstack
                transaction.commit();
                //Intent i = new Intent(Intent.ACTION_DIAL);
                //i.setData(Uri.parse("tel:+917202839225"));
                //startActivity(i);
            }
        });

        return new AboutPage(this.getActivity())
                .setDescription("How to Reach us...")
                .setImage(R.drawable.icon_final)
                .addItem(mobileNo)
                .addEmail("ifest2019.daiict@gmail.com","Write to Us")
                .addWebsite("http://ifest.daiict.ac.in")
                .addFacebook("ifestdaiict")
                .addInstagram("i.fest")
                .addPlayStore("com.ieee.daiict.ifest19")
                .create();

    }

}