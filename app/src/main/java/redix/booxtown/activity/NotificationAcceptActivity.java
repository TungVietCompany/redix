package redix.booxtown.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

/**
 * Created by thuyetpham94 on 27/08/2016.
 */
public class NotificationAcceptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request for window feature action bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_confirm_accept);

        //infor
        ImageView imv_nitification_infor3_phone = (ImageView)findViewById(R.id.imv_menu_notification_infor2);
        imv_nitification_infor3_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationAcceptActivity.this,UserProfileActivity.class);
                startActivity(intent);
            }
        });
        //end
    }
}
