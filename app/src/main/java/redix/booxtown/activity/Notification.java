package redix.booxtown.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.roughike.bottombar.BottomBar;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_ListView_Notification;

public class Notification extends AppCompatActivity {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout1;
    BottomBar bottomBar;
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

    public boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //listview content notification
        final ListView list_notification = (ListView)findViewById(R.id.lv_content_notification) ;
        list_notification.setAdapter(new Custom_ListView_Notification(Notification.this, prgmNameList,prgmNameList));
        //end
        ImageView menu =
                (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.menu);
                ListView lv=(ListView) findViewById(R.id.listViewa);
                lv.setAdapter(new CustomAdapter(Notification.this, prgmNameList,prgmImages));
                ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
                close_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent itent = new Intent(Notification.this,Notification.class);
                        startActivity(itent);
                    }
                });
            }
        });
    }
}
