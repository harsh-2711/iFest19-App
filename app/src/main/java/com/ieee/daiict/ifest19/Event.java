package com.ieee.daiict.ifest19;

import android.support.annotation.NonNull;

/**
 * Created by Jay on 09-09-2017.
 */

public class Event implements Comparable<Event>{
    private String name;
    private String date ;
    private String time;
    private String location;
    private String prize;
    private String about;
    private boolean registered;
    private int thumbnail;
    
    public Event(String name, String date, int thumbnail, String location,String time) {
        this.name = name;
        this.date = date;
        this.thumbnail = thumbnail;
        this.time = time;
        this.location = location;
        this.registered = false;
    }
    public Event(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int[] getSETime() {
        String s[] = time.split("-")[0].split(":");
        int i[] = {Integer.parseInt(s[0]),Integer.parseInt(s[1])};
        return i;
    }

    @Override
    public int compareTo(@NonNull Event o) {
        int i1[] = this.getSETime();
        int i2[] = o.getSETime();
        if(((Integer)i1[0]).compareTo(i2[0])!=0)
            return ((Integer)i1[0]).compareTo(i2[0]);
        else
            return ((Integer)i1[1]).compareTo(i2[1]);
    }
}
