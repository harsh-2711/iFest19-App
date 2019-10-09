package com.ieee.daiict.ifest19;

import java.util.ArrayList;

import br.liveo.navigationliveo.NavigationLiveo;

/**
 * Created by Jay on 09-09-2017.
 */

public class Data {

    private static ArrayList<Event> eventList;
    private static ArrayList<Event> eventListPhaseless;
    private static String username;
    private static boolean b[];
    private static ArrayList<String> RegisterEventList;
    private static NavigationLiveo navigationLiveo;

    public static boolean[] getB() {
        return b;
    }

    public static void setB(boolean[] b) {
        Data.b = b;
    }

    public static ArrayList<String> getRegisterEventList() {
        return RegisterEventList;
    }

    public static void setRegisterEventList(ArrayList<String> registerEventList) {
        RegisterEventList = registerEventList;
    }

    public static NavigationLiveo getNavigationLiveo() {
        return navigationLiveo;
    }

    public static void setNavigationLiveo(NavigationLiveo nl) {
        navigationLiveo = nl;
    }

    public static void setEventList(ArrayList<Event> list) {
        eventList = list;
    }

    public static void setusername(String id) {
        username = id;
    }

    public static void setEventListPhaseless(ArrayList<Event> list) {
        eventListPhaseless = list;
    }

    public static ArrayList<Event> getEventList() {
        return eventList;
    }

    public static String getusername() {
        return username;
    }

    public static ArrayList<Event> getEventListPhaseless() {
        return eventListPhaseless;
    }

    public static int getIndexOfEvent(String k){
        if (k.equals("i.Biz")){
            return 0;
        }
        else if (k.equals("i.Relay")){
            return 1;
        }
        else if (k.equals("Blind-C")){
            return 2;
        }
        else if (k.equals("i.App")){
            return 3;
        }
        else if (k.equals("i.Clash")){
            return 4;
        }
        else if (k.equals("i.Database")){
            return 5;
        }
        else if (k.equals("i.Maze")){
            return 6;
        }
        else if (k.equals("i.Cube")){
            return 7;
        }
        else if (k.equals("i.Decipher")){
            return 8;
        }
        else if (k.equals("i.Ganith")){
            return 9;
        }
        else if (k.equals("Treasure Hunt")){
            return 10;
        }
        else if (k.equals("i.Rubble")){
            return 11;
        }
        /*else if (k.equals("i.Electro")){
            return 12;
        }*/
        else if (k.equals("i.Quiz")){
            return 12;
        }
        else if (k.equals("i.Capture")){
            return 13;
        }
        else if (k.equals("i.Bot")){
            return 14;
        }
        else if (k.equals("i.Intelligence")){
            return 15;
        }
        else if (k.equals("i.Web")){
            return 16;
        }
        else if (k.equals("i.Crypt")){
            return 17;
        }
        else if (k.equals("i.Ride")){
            return 18;
        }
        else if (k.equals("i.OHunt")){
            return 19;
        }
        else if (k.equals("i.Papyrus")){
            return 20;
        }
        else if (k.equals("RoboClash")){
            return 21;
        }
        else if (k.equals("IoT Auction")){
            return 22;
        }
        else if (k.equals("TicTechToe")){
            return 23;
        }
        else{
            return -1;
        }
    }

}
