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

        //menu

        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setImageResource(R.drawable.back_interact);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //end
    }
}
