package redix.booxtown.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

public class NotificationDominicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dominic);

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_nitification_infor3_phone);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(NotificationDominicActivity.this,mResources,mBitmap,mImageView);

        TextView txt_notification_infor3_phone = (TextView)findViewById(R.id.txt_notification_infor3_phone);
        txt_notification_infor3_phone.setVisibility(View.GONE);

        Button btn_menu_notification_dominic_accept = (Button)findViewById(R.id.btn_menu_notification_dominic_accept);
        btn_menu_notification_dominic_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationDominicActivity.this,NotificationDominicAccept.class);
                startActivity(intent);
            }
        });

        Button btn_menu_notification_dominic_reject = (Button)findViewById(R.id.btn_menu_notification_dominic_reject);
        btn_menu_notification_dominic_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationDominicActivity.this,NotificationDominicNoReject.class);
                startActivity(intent);
            }
        });

    }
}
