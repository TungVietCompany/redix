package redix.booxtown.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    }
}
