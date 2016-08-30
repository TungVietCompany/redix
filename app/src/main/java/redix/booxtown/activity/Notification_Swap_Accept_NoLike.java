package redix.booxtown.activity;

import android.content.Intent;
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

public class Notification_Swap_Accept_NoLike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_swap_accept_no_like);

        TextView txt_menu_notification_infor2_phone = (TextView)findViewById(R.id.txt_menu_notification_infor2_phone);
        txt_menu_notification_infor2_phone.setVisibility(View.GONE);

        //infor
        ImageView imv_nitification_infor3_phone = (ImageView)findViewById(R.id.imv_menu_notification_infor2);
        imv_nitification_infor3_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notification_Swap_Accept_NoLike.this,UserProfileActivity.class);
                startActivity(intent);
            }
        });
        //end

    }
}
