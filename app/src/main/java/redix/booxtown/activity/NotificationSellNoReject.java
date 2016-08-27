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
 * Created by thuyetpham94 on 28/08/2016.
 */
public class NotificationSellNoReject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sell_accept2);
        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_nitification_infor3_phone);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(NotificationSellNoReject.this,mResources,mBitmap,mImageView);

        TextView txt_menu_notification_title2 = (TextView)findViewById(R.id.txt_menu_notification_title2);
        txt_menu_notification_title2.setText("Sorry!");

        TextView txt_notification_infor3_phone = (TextView)findViewById(R.id.txt_notification_infor3_phone);
        txt_notification_infor3_phone.setVisibility(View.GONE);

        TextView txt_menu_notification_infor3_title = (TextView)findViewById(R.id.txt_menu_notification_infor3_title);
        txt_menu_notification_infor3_title.setText("rejected your request for buying");

        TextView txt_notification_dominic_besttime = (TextView)findViewById(R.id.txt_notification_dominic_besttime);
        txt_notification_dominic_besttime.setVisibility(View.GONE);

        TextView txt_notification_dominic_time = (TextView)findViewById(R.id.txt_notification_dominic_time);
        txt_notification_dominic_time.setVisibility(View.GONE);

    }
}
