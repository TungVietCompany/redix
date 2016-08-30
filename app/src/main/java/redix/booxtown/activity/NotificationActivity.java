package redix.booxtown.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_ListView_Notification;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.InteractThread;

public class NotificationActivity extends AppCompatActivity {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout1;
    public static String [] prgmNameList={"Unread","Dominic send a swap request","Dominic want to your book","Dominic reject your swap request"};
    private MenuBottomCustom bottomListings;
    public boolean flag=true;
    ArrayList<InteractThread> listInteractThreads= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //listview content notification
        final ListView list_notification = (ListView)findViewById(R.id.lv_content_notification) ;
        list_notification.setAdapter(new Custom_ListView_Notification(NotificationActivity.this, prgmNameList,prgmNameList));

        list_notification.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    InteractThread interact1= new InteractThread();
                    interact1.setInteractThreadTitle("Thread one text");
                    interact1.setInteractThreadCount("20");
                    interact1.setStatus(true);
                    interact1.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
                    interact1.setInteractThreadAddBy("Derek Jarma");

                    listInteractThreads.add(interact1);
                    InteractThread item = (InteractThread) listInteractThreads.get(0);
                    Intent intent = new Intent(NotificationActivity.this,InteractThreadDetailsActivity.class);
                    intent.putExtra("threadDetail",item);
                    startActivity(intent);
                }else if(i==1){
                    Intent intent = new Intent(NotificationActivity.this,NotificationSwapActivity.class);
                    startActivity(intent);
                }else if(i==2){
                    Intent intent1 = new Intent(NotificationActivity.this,NotificationSellActivity.class);
                    startActivity(intent1);
                }else if(i==3){
                    Intent intent2 = new Intent(NotificationActivity.this,NotificationDominicActivity.class);
                    startActivity(intent2);
                }
            }
        });
        //end
        //menu
        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("Notifications");

        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //end

        //bottom
        //--------------------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_notification);
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
