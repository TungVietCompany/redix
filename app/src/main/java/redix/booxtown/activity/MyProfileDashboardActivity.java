package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

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

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_menu_profile);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(MyProfileDashboardActivity.this,mResources,mBitmap,mImageView);

        ListView lv_myprofile_dashboard = (ListView)findViewById(R.id.lv_myprofile_dashboard);
        lv_myprofile_dashboard.setAdapter(new AdapterProfileDashboard(MyProfileDashboardActivity.this,txtbook,imgoffer,imgstatus));

    }
}
