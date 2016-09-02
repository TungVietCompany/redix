package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import redix.booxtown.R;
import redix.booxtown.custom.Custom_Listview_faq;
import redix.booxtown.custom.Custom_invite;
import redix.booxtown.custom.MenuBottomCustom;

public class InviteFriendActivity extends Fragment {
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    private MenuBottomCustom bottomListings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_invite_friend, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.lv_content_invite);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //set adapter
        Custom_invite custom_invite = new Custom_invite(prgmNameList);
        recyclerView.setAdapter(custom_invite);
        return view;
    }
}
