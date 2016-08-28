package redix.booxtown.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.custom.NotificationAccept;
import redix.booxtown.model.Explore;

public class MyProfileActivity extends AppCompatActivity {
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Resources mResources = getResources();
        ImageView mImageView = (ImageView) findViewById(R.id.imv_menu_profile);
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);
        NotificationAccept notificationAccept = new NotificationAccept();
        notificationAccept.accept(MyProfileActivity.this,mResources,mBitmap,mImageView);

        ImageView img_menu_personal_dashboard = (ImageView)findViewById(R.id.img_menu_personal_dashboard);
        img_menu_personal_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this,MyProfileDashboardActivity.class);
                startActivity(intent);
            }
        });






    }
}
