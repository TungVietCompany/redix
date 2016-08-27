package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

public class ActivityNotificationDominic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dominic);

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_menu_notification_infor1);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(ActivityNotificationDominic.this,mResources,mBitmap,mImageView);

        TextView txt_cross = (TextView)findViewById(R.id.txt_notification_cross_infor1);
        txt_cross.setVisibility(View.VISIBLE);
    }
}
