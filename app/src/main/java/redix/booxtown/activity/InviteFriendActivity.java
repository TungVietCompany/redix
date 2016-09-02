package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import redix.booxtown.R;
import redix.booxtown.custom.Custom_Listview_faq;
import redix.booxtown.custom.Custom_invite;
import redix.booxtown.custom.MenuBottomCustom;

public class InviteFriendActivity extends AppCompatActivity {
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    private MenuBottomCustom bottomListings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lv_content_invite);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //set adapter
        Custom_invite custom_invite = new Custom_invite(prgmNameList);
        recyclerView.setAdapter(custom_invite);

        //icon back
        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("Invite Friends");

        ImageView menu = (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InviteFriendActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //bottom
        //--------------------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_invitefriend);
        bottomListings=new MenuBottomCustom(view_bottom,this,0);
        bottomListings.setDefaut(0);
        //---------------------------------------------------------------
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bottomListings.setDefaut(0);
    }
}
