package com.ieee.daiict.ifest19;


import android.app.Fragment;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class EventFragment extends Fragment {
    private RecyclerView recyclerView;
    private EventFragmentAdapter adapter;
    private ArrayList<Event> eventList;
    private ArrayList<Event> eventListPhaseless;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        Data.getNavigationLiveo().setCheckedItemNavigation(Data.getNavigationLiveo().getCurrentCheckPosition(), false);
        Data.getNavigationLiveo().setCheckedItemNavigation(2, true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);

        eventList = new ArrayList<>();
        eventListPhaseless = new ArrayList<>();
        adapter = new EventFragmentAdapter(getActivity().getApplicationContext(), eventListPhaseless);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // prepareEvents();
        /*
        try {
            Glide.with(this).load(R.drawable.main).into((ImageView) getView().findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        new loadList().execute();

        return view;

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initCollapsingToolbar();
    }



    private void initCollapsingToolbar() {
        collapsingToolbar.setTitle("Events");
        collapsingToolbar.setCollapsedTitleTextColor(getActivity().getResources().getColor(R.color.white));
        collapsingToolbar.setContentScrim(getActivity().getResources().getDrawable(R.color.colorPrimaryDark));
        //collapsingToolbar.setContentScrim(getActivity().getResources().getDrawable(R.drawable.main));
        AppBarLayout appBarLayout = (AppBarLayout) getView().findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Events");
                    //collapsingToolbar.setContentScrim(getActivity().getResources().getDrawable(R.drawable.main));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("Events");
                    //collapsingToolbar.setContentScrim(getActivity().getResources().getDrawable(R.drawable.main));
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private class loadList extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            int[] covers = new int[]{
                    R.drawable.ibiz,
                    R.drawable.iapp,
                    R.drawable.ibot,
                    R.drawable.iclash,
                    R.drawable.icube,
                    R.drawable.idatabase,
                    R.drawable.idesign,
                    R.drawable.ielectro,
                    R.drawable.iganith,
                    R.drawable.imaze,
                    R.drawable.irelay,
                    R.drawable.iride,
                    R.drawable.irubble,
                    R.drawable.iweb,
                    R.drawable.treasurehunt,
                    R.drawable.blindc,
                    R.drawable.icrypt,
                    R.drawable.iohunt,
                    R.drawable.iquiz,
                    R.drawable.icapture,
                    R.drawable.idecipher,
                    R.drawable.closingceremony_b,
                    R.drawable.inauguralceremony_b,
                    R.drawable.ipapyrus,    //23
                    R.drawable.roboclash,   //24
                    R.drawable.iotauction,  //25
                    R.drawable.tictechtoe,  //26
            };

            Event a = new Event("i.App", "13-10-19", covers[1], "CEP Conference room", "10:00");
            eventList.add(a);

            a = new Event("i.Biz", "13-10-19", covers[0], "CEP Conference room", "13:00");
            eventList.add(a);

            a = new Event("Blind C", "13-10-19", covers[15], "Lab 004, 005 and 007", "14:30-17:00");
            eventList.add(a);

            a = new Event("i.Bot", "12-10-19", covers[2], "Outside Cafeteria", "21:00");
            eventList.add(a);

            a = new Event("i.Capture", "12-10-19", covers[19], "Cafeteria", "10:00-21:00");
            eventList.add(a);

            a = new Event("i.Capture", "13-10-19", covers[19], "Cafeteria", "10:00-18:00");
            eventList.add(a);

            a = new Event("i.Clash", "11-10-19", covers[3], "Lab 002 and 007", "21:00-00:00");
            eventList.add(a);

            a = new Event("i.Clash", "12-10-19", covers[3], "Lab 002 and 007", "09:00-12:00");
            eventList.add(a);

            a = new Event("i.Clash", "13-10-19", covers[3], "Lab 002 and 007", "09:00-18:00");
            eventList.add(a);

            a = new Event("i.Crypt", "13-10-19", covers[16], "CEP-110 and 108", "17:00-20:00");
            eventList.add(a);

            a = new Event("i.Cube", "12-10-19", covers[4], "LT-3", "10:00-16:30");
            eventList.add(a);

            a = new Event("i.Database", "12-10-19", covers[5], "CEP-106", "15:00-16:30");
            eventList.add(a);

            a = new Event("i.Decipher", "09-10-19", covers[20], "Lab Building", "20:00-21:00");
            eventList.add(a);

            a = new Event("Bug Bounty", "12-10-19", covers[26], "CEP-102", "13:00");
            eventList.add(a);

            a = new Event("i.Ganith (Phase 1)", "11-10-19", covers[8], "LT-2", "21:00-23:45");
            eventList.add(a);

            a = new Event("i.Ganith (Phase 2-3)", "12-10-19", covers[8], "CEP-108", "09:00-10:30");
            eventList.add(a);

            a = new Event("i.Maze (Phase 1)", "12-10-19", covers[9], "CEP-110", "12:00-15:30");
            eventList.add(a);

            a = new Event("i.Maze (Phase 2)", "13-10-19", covers[9], "CEP-110", "09:00-10:00");
            eventList.add(a);

            a = new Event("i.OHunt", "12-09-19", covers[17], "Lab Building", "19:00-Onwards");
            eventList.add(a);

            a = new Event("i.Papyrus", "12-10-19", covers[23], "CEP Corridor", "15:00-17:00");
            eventList.add(a);

            a = new Event("i.Quiz", "13-10-19", covers[18], "CEP-110", "11:30-14:00");
            eventList.add(a);

            a = new Event("i.Relay", "12-10-19", covers[10], "Lab 004 and 005", "13:30-16:30");
            eventList.add(a);

            a = new Event("i.Ride", "13-10-19", covers[11], "Near Cafeteria", "16:30-18:30");
            eventList.add(a);

            a = new Event("RoboClash", "12-10-19", covers[24], "Outside Cafeteria", "21:00-00:00");
            eventList.add(a);

            a = new Event("i.Rubble", "13-10-19", covers[12], "OAT", "16:00-18:00");
            eventList.add(a);

            //a = new Event("TicTechToe", "06-10-18", covers[26], "Cafeteria", "16:00-19:30");
            //eventList.add(a);

            a = new Event("Treasure Hunt", "12-10-19", covers[14], "OAT", "16:30-19:00");
            eventList.add(a);

            a = new Event("i.Web", "13-10-19", covers[13], "CEP Conference Room", "18:00-20:30");
            eventList.add(a);

            a = new Event("Inaugural Ceremony", "11-10-19", covers[22], "OAT", "18:00-19:00");
            eventList.add(a);

            a = new Event("Closing Ceremony", "13-10-19", covers[21], "LT-3", "21:00-22:00");
            eventList.add(a);

            //a = new Event("i.Web Theme Launch", "05-10-18", covers[13], "Online", "11:55");
            //eventList.add(a);

            //a = new Event("i.Design Theme Launch", "05-10-18", covers[6], "Online", "13:00");
            //eventList.add(a);

            a = new Event("IoT Auction", "13-10-19", covers[25], "CEP 106", "10:00-13:00");
            eventList.add(a);

            if (Data.getEventList() == null)
                Data.setEventList(eventList);

            a = new Event("i.App", covers[1]);
            eventListPhaseless.add(a);

            a = new Event("i.Biz", covers[0]);
            eventListPhaseless.add(a);

            a = new Event("Blind C", covers[15]);
            eventListPhaseless.add(a);

            a = new Event("i.Bot", covers[2]);
            eventListPhaseless.add(a);

            a = new Event("i.Capture", covers[19]);
            eventListPhaseless.add(a);

            a = new Event("i.Clash", covers[3]);
            eventListPhaseless.add(a);

            a = new Event("i.Crypt", covers[16]);
            eventListPhaseless.add(a);

            a = new Event("i.Cube", covers[4]);
            eventListPhaseless.add(a);

            a = new Event("i.Database", covers[5]);
            eventListPhaseless.add(a);

            a = new Event("i.Decipher", covers[20]);
            eventListPhaseless.add(a);

            a = new Event("Bug Bounty", covers[26]);
            eventListPhaseless.add(a);

            a = new Event("i.Ganith", covers[8]);
            eventListPhaseless.add(a);

            a = new Event("i.Maze", covers[9]);
            eventListPhaseless.add(a);

            a = new Event("i.OHunt", covers[17]);
            eventListPhaseless.add(a);

            a = new Event("i.Papyrus", covers[23]);
            eventListPhaseless.add(a);

            a = new Event("i.Quiz", covers[18]);
            eventListPhaseless.add(a);

            a = new Event("i.Relay", covers[10]);
            eventListPhaseless.add(a);

            a = new Event("i.Ride", covers[11]);
            eventListPhaseless.add(a);

            a = new Event("RoboClash", covers[24]);
            eventListPhaseless.add(a);

            a = new Event("i.Rubble", covers[12]);
            eventListPhaseless.add(a);

            //a = new Event("TicTechToe", covers[26]);
            //eventListPhaseless.add(a);

            a = new Event("TreasureHunt", covers[14]);
            eventListPhaseless.add(a);

            a = new Event("i.Web", covers[13]);
            eventListPhaseless.add(a);

            a = new Event("IoT Auction", covers[25]);
            eventListPhaseless.add(a);

            if (Data.getEventListPhaseless() == null) {
                Data.setEventListPhaseless(eventListPhaseless);
            }
            return null;
        }

        //    adapter.notifyDataSetChanged();
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        /*@Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }*/
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().finish();
    }

}
