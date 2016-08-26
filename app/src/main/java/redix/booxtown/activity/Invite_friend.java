package redix.booxtown.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import redix.booxtown.R;
import redix.booxtown.custom.Custom_invite;

public class Invite_friend extends AppCompatActivity {
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);


        ListView listView = (ListView)findViewById(R.id.lv_content_invite);
        listView.setAdapter(new Custom_invite(Invite_friend.this, prgmNameList));

    }
}
