package redix.booxtown.activity;

import android.content.Intent;
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
public class NotificationDominicAccept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sell_accept2);

        TextView txt_menu_notification_title2 = (TextView) findViewById(R.id.txt_menu_notification_title2);
        txt_menu_notification_title2.setText("you accepted a request form");

        TextView txt_menu_notification_infor3_title = (TextView) findViewById(R.id.txt_menu_notification_infor3_title);
        txt_menu_notification_infor3_title.setText("to buy your book");
        txt_menu_notification_infor3_title.setTextColor(getResources().getColor(R.color.color_txt_menu_notification_title2));

        TextView txt_notification_sell_accept_money = (TextView)findViewById(R.id.txt_notification_sell_accept_money);
        txt_notification_sell_accept_money.setVisibility(View.GONE);

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

        //infor
        ImageView imv_nitification_infor3_phone = (ImageView)findViewById(R.id.imv_nitification_infor3_phone);
        imv_nitification_infor3_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationDominicAccept.this,UserProfileActivity.class);
                startActivity(intent);
            }
        });
        //end

    }
}