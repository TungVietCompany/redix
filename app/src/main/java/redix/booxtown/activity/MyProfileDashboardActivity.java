package redix.booxtown.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterProfileDashboard;
import redix.booxtown.custom.NotificationAccept;

public class MyProfileDashboardActivity extends AppCompatActivity {

    public static int [] imgoffer={R.drawable.icon_sell_blue,R.drawable.icon_free_blue,R.drawable.icon_swap_blue,R.drawable.icon_swap_blue};
    public static int [] imgstatus={R.drawable.icon_status_profile,R.drawable.icon_stop_profile,R.drawable.icon_delete_profile,R.drawable.icon_delete_profile};
    public static String [] txtbook={"Nearest distance","Price low to high","Price high to low","Price high to low"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_dashboard);

        ListView lv_myprofile_dashboard = (ListView)findViewById(R.id.lv_myprofile_dashboard);
        lv_myprofile_dashboard.setAdapter(new AdapterProfileDashboard(MyProfileDashboardActivity.this,txtbook,imgoffer,imgstatus));

        lv_myprofile_dashboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(MyProfileDashboardActivity.this,DasgboardActivity.class);
                    startActivity(intent);
                }else if(i==1) {
                    Intent intent = new Intent(MyProfileDashboardActivity.this,DashboardStopActivity.class);
                    startActivity(intent);
                }else if(i==2){
                    Intent intent = new Intent(MyProfileDashboardActivity.this,DashboardDeleteActivity.class);
                    startActivity(intent);
                }
            }
        });

        //menu

        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("My Profile");

        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setImageResource(R.drawable.back_interact);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        //end
    }
}
