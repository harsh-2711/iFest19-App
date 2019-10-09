package com.ieee.daiict.ifest19;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jay on 13-09-2017.
 */

public class EventAdapter extends BaseAdapter {

    Context context;
    List<Event> eventList;

    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    private class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_time;
        TextView tv_location;
        TextView tv_date;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return eventList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) {
            convertView = mInflater.inflate(R.layout.list_event, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.eventName);
            holder.tv_time = (TextView) convertView.findViewById(R.id.eventTime);
            holder.tv_location = (TextView) convertView.findViewById(R.id.eventLocation);
            holder.iv_icon = (ImageView) convertView.findViewById(R.id.eventIcon);
            holder.tv_date = (TextView) convertView.findViewById(R.id.eventDate);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Event event = eventList.get(position);

        holder.tv_name.setText(event.getName());
        holder.tv_time.setText(event.getTime());
        holder.tv_location.setText(event.getLocation());
        String date = event.getDate();
        if(date.equals("18-09-18") || date.equals("03-10-18")) {
            holder.tv_date.setVisibility(View.VISIBLE);
            holder.tv_date.setText(date);
        }
        else  {
            holder.tv_date.setVisibility(View.GONE);
        }
        if(event.getName().split(" ").length==2)
            Glide.with(convertView.getContext()).load(convertView.getResources().getIdentifier(event.getName().replace(" ","").toLowerCase()+"_b", "drawable",convertView.getContext().getPackageName())).into(holder.iv_icon);
        else
            Glide.with(convertView.getContext()).load(convertView.getResources().getIdentifier(event.getName().split(" ")[0].replace(".","").toLowerCase()+"_b", "drawable",convertView.getContext().getPackageName())).into(holder.iv_icon);

        return convertView;
    }
}
