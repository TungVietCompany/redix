package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;

/**
 * Created by thuyetpham94 on 29/08/2016.
 */
public class DashboardStopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasgboard);

        TextView txt_menu_dashboard_cancel = (TextView)findViewById(R.id.txt_menu_dashboard_cancel);
        txt_menu_dashboard_cancel.setVisibility(View.GONE);

        Button btn_menu_dashboard_bottom_rate = (Button) findViewById(R.id.btn_menu_dashboard_bottom_rate);
        btn_menu_dashboard_bottom_rate.setBackgroundResource(R.drawable.icon_dashboard_stop);

        ImageView img_menu_dashboard_bottom_status = (ImageView)findViewById(R.id.img_menu_dashboard_bottom_status);
        img_menu_dashboard_bottom_status.setImageResource(R.drawable.icon_stop_profile);

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.img_menu_dashboard_middle);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(DashboardStopActivity.this,mResources,mBitmap,mImageView);
    }
}
