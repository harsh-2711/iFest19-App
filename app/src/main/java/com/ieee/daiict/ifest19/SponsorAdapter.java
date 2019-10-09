package com.ieee.daiict.ifest19;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jay on 15-09-2017.
 */

public class SponsorAdapter extends BaseAdapter {

    Context context;
    List<Integer> sponsorLogos;
    //List<String> sponsorUrls;

    public SponsorAdapter(Context context, List<Integer> sponsorLogos) {
        this.context = context;
        this.sponsorLogos = sponsorLogos;
        //this.sponsorUrls = sponsorUrls;
    }

    private class ViewHolder {
        ImageView logo_sponsor;
    }

    @Override
    public int getCount() {
        return sponsorLogos.size();
    }

    @Override
    public Object getItem(int position) {
        return sponsorLogos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sponsorLogos.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) {
            convertView = mInflater.inflate(R.layout.list_sponsor, null);
            holder = new ViewHolder();
            holder.logo_sponsor = (ImageView) convertView.findViewById(R.id.logo_sponsor);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Integer sponsor = sponsorLogos.get(position);
        Glide.with(convertView.getContext()).load(sponsor).into(holder.logo_sponsor);
        //holder.logo_sponsor.setImageResource(sponsor);
        return convertView;
    }
}
