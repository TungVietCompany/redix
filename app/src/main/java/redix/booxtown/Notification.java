package redix.booxtown;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout;
    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

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

        ImageView menubar = (ImageView)findViewById(R.id.imageView6);
        context=this;
        //show list menu
        relativeLayout = (RelativeLayout)findViewById(R.id.rl_menu_notifi);
        final BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        lv1=(ListView) findViewById(R.id.lv_menu_notifi);
        //final ImageView cross = (ImageView)findViewById(R.id.cross2);
        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
//                animation.setDuration(200);
//                relativeLayout.setAnimation(animation);
//                relativeLayout.animate();
//                animation.start();
                relativeLayout.setVisibility(View.VISIBLE);

                getSupportActionBar().hide();
                bottomBar.hide();
                //cross.setVisibility(View.GONE);
                lv1.setAdapter(new CustomAdapter(Notification.this, prgmNameList,prgmImages));
            }
        });

        //hide menu
//        ImageView close_menu = (ImageView)findViewById(R.id.imgv_close_notifi);
//        close_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportActionBar().show();
//                bottomBar.show();
//                //cross.setVisibility(View.VISIBLE);
//                relativeLayout.setVisibility(View.GONE);
//
//            }
//        });
    }
}
