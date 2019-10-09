package com.ieee.daiict.ifest19;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jay on 13-09-2017.
 */

public class ContactAdapter extends BaseAdapter {

    Context context;
    List<String[]> contactList;

    public ContactAdapter(Context context, List<String[]> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    private class ViewHolder {
        TextView tv_name;
        TextView tv_phone;
        TextView tv_department;
        ImageView icon_phone;
        LinearLayout contact_layout;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) {
            convertView = mInflater.inflate(R.layout.list_contact, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
            holder.tv_department = (TextView) convertView.findViewById(R.id.tv_department);
            holder.icon_phone = (ImageView) convertView.findViewById(R.id.icon_phone);
            holder.contact_layout = (LinearLayout) convertView.findViewById(R.id.contactLayout);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        String[] contact = contactList.get(position);

        holder.tv_name.setText(contact[0]);
        //holder.tv_department.setText(contact[1]);
        holder.tv_phone.setText(contact[2]);
        holder.icon_phone.setImageResource(R.drawable.contact2);
        //holder.tv_name.setTypeface(typeface);
        //holder.tv_department.setTypeface(typeface);
        //holder.tv_phone.setTypeface(typeface);

        /*if(position%2==0) {
            holder.contact_layout.setBackgroundColor(convertView.getResources().getColor(R.color.lightblue));
        }
        else {
            holder.contact_layout.setBackgroundColor(convertView.getResources().getColor(R.color.white));
        }*/

        return convertView;
    }
}
