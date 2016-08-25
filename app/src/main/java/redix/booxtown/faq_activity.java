package redix.booxtown;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_Listview_faq;

public class faq_activity extends AppCompatActivity {

    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();

        TextView title_menu = (TextView)findViewById(R.id.txt_title_menu);
        title_menu.setText("FAQ");

        ImageView icon_menu_right = (ImageView)findViewById(R.id.imv_menu_right);
        icon_menu_right.setVisibility(View.GONE);

        ListView listView_faq = (ListView)findViewById(R.id.lv_content_faq);
        listView_faq.setAdapter(new Custom_Listview_faq(faq_activity.this, prgmNameList));

        listView_faq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent itent = new Intent(faq_activity.this,Faq_content.class);
                        startActivity(itent);
                        break;
                }
            }
        });
        //bottom menu

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
        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.
        //bottomBar.setActiveTabColor("#C2185B");
        //end

        ImageView menubar = (ImageView)findViewById(R.id.imageView6);
        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.menu);
                ListView lv1=(ListView) findViewById(R.id.listViewa);
                getSupportActionBar().hide();
                bottomBar.hide();
                // cross.setVisibility(View.GONE);
                lv1.setAdapter(new CustomAdapter(faq_activity.this, prgmNameList,prgmImages));

                ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
                //hide menu
                close_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itent = new Intent(faq_activity.this,faq_activity.class);
                        startActivity(itent);
                    }
                });



                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i){
                            case 0:
                                Intent itent1 = new Intent(faq_activity.this,MainActivity.class);
                                startActivity(itent1);
                                break;
                            case 1:
                                Intent itent = new Intent(faq_activity.this,Notification.class);
                                startActivity(itent);
                                break;
                        }
                    }
                });
            }
        });
    }
}
