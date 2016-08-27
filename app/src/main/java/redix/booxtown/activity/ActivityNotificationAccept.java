package redix.booxtown.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import redix.booxtown.R;
import redix.booxtown.custom.BorderImage;
import redix.booxtown.custom.NotificationAccept;

/**
 * Created by thuyetpham94 on 27/08/2016.
 */
public class ActivityNotificationAccept extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request for window feature action bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_confirm_accept);
        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_menu_notification_infor2);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        //RelativeLayout view = (RelativeLayout)findViewById(R.id.rl_notification_infor1);
        notificationAccept.accept(ActivityNotificationAccept.this,mResources,mBitmap,mImageView);
    }
}
