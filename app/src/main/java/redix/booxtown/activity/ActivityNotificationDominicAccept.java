package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

public class ActivityNotificationDominicAccept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dominic_accept);

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_menu_notification_infor1);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        //RelativeLayout view = (RelativeLayout)findViewById(R.id.rl_notification_infor1);
        notificationAccept.accept(ActivityNotificationDominicAccept.this,mResources,mBitmap,mImageView);
    }
}
