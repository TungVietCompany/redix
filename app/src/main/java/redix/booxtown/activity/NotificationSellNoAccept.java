package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

/**
 * Created by thuyetpham94 on 27/08/2016.
 */
public class NotificationSellNoAccept extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sell_accept2);
        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_nitification_infor3_phone);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(NotificationSellNoAccept.this,mResources,mBitmap,mImageView);

        TextView txt_menu_notification_title2 = (TextView)findViewById(R.id.txt_menu_notification_title2);
        txt_menu_notification_title2.setVisibility(View.GONE);

        TextView txt_menu_notification_infor3_title = (TextView)findViewById(R.id.txt_menu_notification_infor3_title);
        txt_menu_notification_infor3_title.setText("accepted your request for buying");

    }
}
