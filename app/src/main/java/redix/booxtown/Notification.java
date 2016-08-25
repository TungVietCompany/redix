package redix.booxtown;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout1;
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

    public boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();

        TextView title_menu = (TextView)findViewById(R.id.txt_title_menu);
        title_menu.setText("Notifications");

        ImageView icon_menu_right = (ImageView)findViewById(R.id.imv_menu_right);
        icon_menu_right.setVisibility(View.GONE);

        //bottom menu
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);

        final BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.three_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.recent_item:
                        //Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.favorite_item:
                        //Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.location_item:
                        //Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;

                }
            }
        });
        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.
        bottomBar.setActiveTabColor("#C2185B");
        //end

        ImageView menubar = (ImageView)findViewById(R.id.imageView6);
        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.menu);
                ListView lv=(ListView) findViewById(R.id.listViewa);
                getSupportActionBar().hide();
                bottomBar.hide();
                // cross.setVisibility(View.GONE);
                lv.setAdapter(new CustomAdapter(Notification.this, prgmNameList,prgmImages));

                ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
                //hide menu
                close_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSupportActionBar().show();
                        bottomBar.show();
                        setContentView(R.layout.activity_notification);
                    }
                });



                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i){
                            case 0:
                                getSupportActionBar().show();
                                bottomBar.show();
                                break;
                            case 1:
                                Intent itent = new Intent(Notification.this,Notification.class);
                                startActivity(itent);
                                break;
                        }
                    }
                });
            }
        });

    }
}
