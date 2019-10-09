package com.ieee.daiict.ifest19;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import br.liveo.interfaces.OnItemClickListener;
import br.liveo.model.HelpLiveo;
import br.liveo.navigationliveo.NavigationLiveo;


public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;
    private NavigationLiveo navigationLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {

        //this.userName.setText("i.Fest 2017");
        //this.userEmail.setText("INTELLI ODYSSEY");
        //this.userPhoto.setImageResource(R.drawable.daiictlogo);
        /*this.userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.daiict.ac.in"));
                startActivity(i);
            }
        });*/
        this.userBackground.setImageResource(R.drawable.nav_drawer);
        /*this.userBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://ieee.daiict.ac.in"));
                startActivity(i);
            }
        });*/

        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add("Online Registration", R.drawable.registration);
        mHelpLiveo.addSubHeader("Get all Details here"); //Item subHeader
        mHelpLiveo.add("Events", R.drawable.events);
        mHelpLiveo.add("About", R.drawable.info);
        mHelpLiveo.add("Schedule", R.drawable.schedule);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add("Sponsors", R.drawable.sponsors);
        mHelpLiveo.add("Contact Us", R.drawable.contact);


        //with(this, Navigation.THEME_DARK);
        //with(this, Navigation.THEME_LIGHT);

        navigationLiveo = with(this);
        Data.setNavigationLiveo(navigationLiveo);

        with(this)
                .startingPosition(2)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem("Developed By",R.drawable.developer)
                .setOnClickFooter(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navigationLiveo.setCheckedItemNavigation(navigationLiveo.getCurrentCheckPosition(), false);
                        Fragment fragment = new DeveloperFragment();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                        transaction.addToBackStack(null);  // this will manage backstack
                        transaction.commit();
                        closeDrawer();
                    }
                })
                .removeColorFilter()
                .build();

    }
    @Override
    public void onItemClick(int position) {
        Fragment fragment=new EventFragment();
        if(position==0){
            String url = "http://ifest.daiict.ac.in/register.html";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            return;
        }
        if(position==2){
            fragment= new EventFragment();
        }
        if(position==3){
            fragment= new AboutUsFragment();
        }
        if(position==4){
            fragment= new ScheduleFragment();
        }
        if(position==6){
            fragment= new SponsorFragment();
        }
        if(position==7){
            fragment= new ContactUsFragment();
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
        transaction.addToBackStack(null);  // this will manage backstack
        transaction.commit();
    }
}

