package com.ieee.daiict.ifest19;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jay on 09-09-2017.
 */

public class EventFragmentAdapter extends RecyclerView.Adapter<EventFragmentAdapter.MyViewHolder> {

    private Context mContext;
    private List<Event> eventList;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, time, location;
        public ImageView thumbnail, overflow;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            time = (TextView) view.findViewById(R.id.time);
            location = (TextView) view.findViewById(R.id.location);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }

    }


    public EventFragmentAdapter(Context mContext, List<Event> albumList) {
        this.mContext = mContext;
        this.eventList = albumList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Event event = eventList.get(position);
        holder.title.setText(event.getName());
        holder.date.setText(event.getDate());
        holder.location.setText(event.getLocation());
        holder.time.setText(event.getTime());
        // loading album cover using Glide library
        Glide.with(mContext).load(event.getThumbnail()).into(holder.thumbnail);
        //holder.thumbnail.setImageResource(event.getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = event.getName();
                if(name.contains("."))
                    name = name.split(" ")[0];
                else
                    name = name.replace(" ","");
                Fragment fragment=new SingleEventFragment(name);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                transaction.addToBackStack(null);  // this will manage backstack
                transaction.commit();
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = event.getName();
                if (name.contains("."))
                    name = name.split(" ")[0];
                else
                    name = name.replace(" ", "");
                Fragment fragment = new SingleEventFragment(name);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                transaction.addToBackStack(null);  // this will manage backstack
                transaction.commit();
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    private void showPopupMenu(View view, String time, String location) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_event, popup.getMenu());
        Menu menu = popup.getMenu();
        MenuItem item1 = menu.findItem(R.id.location);
        item1.setTitle("Venue: " + location);
        MenuItem item2 = menu.findItem(R.id.time);
        item2.setTitle("Time: " + time);
        popup.show();
    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
