package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import redix.booxtown.R;
import redix.booxtown.custom.Custom_invite;

public class InviteFriendActivity extends AppCompatActivity {
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);


        ListView listView = (ListView)findViewById(R.id.lv_content_invite);
        listView.setAdapter(new Custom_invite(InviteFriendActivity.this, prgmNameList));

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
    }
}
