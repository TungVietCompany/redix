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

public class NotificationRejectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_notification_reject);

        TextView txt_menu_notification_title2 = (TextView)findViewById(R.id.txt_menu_notification_title2);
        txt_menu_notification_title2.setText("with your book");
        txt_menu_notification_title2.setTextColor(getResources().getColor(R.color.color_txt_menu_notification_title2));

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
