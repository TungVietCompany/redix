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

public class Notification_Swap_Accept_Like extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification__swap__accept__like);

        TextView txt_notification_infor3_phone = (TextView)findViewById(R.id.txt_notification_infor3_phone);
        txt_notification_infor3_phone.setVisibility(View.GONE);
        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_nitification_infor3_phone);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(Notification_Swap_Accept_Like.this,mResources,mBitmap,mImageView);
    }
}
