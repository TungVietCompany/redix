package redix.booxtown.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import redix.booxtown.R;
import redix.booxtown.custom.Custom_invite;

public class Invite_friend extends AppCompatActivity {
    BottomBar bottomBar;
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();

        TextView title_menu = (TextView)findViewById(R.id.txt_title_menu);
        title_menu.setText("Invite friend");

        ImageView icon_menu_right = (ImageView)findViewById(R.id.imv_menu_right);
        icon_menu_right.setVisibility(View.GONE);

        ListView listView = (ListView)findViewById(R.id.lv_content_invite);
        listView.setAdapter(new Custom_invite(Invite_friend.this, prgmNameList));

        bottomBar = BottomBar.attach(this, savedInstanceState);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);
        bottomBar.setItemsFromMenu(R.menu.three_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.location_item:

                        break;
                    case R.id.message_item:

                        break;
                    case R.id.camera_item:

                        break;

                }
            }
        });

        bottomBar.mapColorForTab(0,0xFF5D4037);
        bottomBar.mapColorForTab(1, 0xFF5D4037);
        bottomBar.mapColorForTab(2, "#7B1FA2");
        bottomBar.mapColorForTab(3, "#FF5252");
        bottomBar.mapColorForTab(4, "#FF9800");
    }
}
