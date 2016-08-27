package redix.booxtown.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import redix.booxtown.R;
import redix.booxtown.custom.BorderImage;

/**
 * Created by thuyetpham94 on 26/08/2016.
 */
public class TestActivity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Button mBTN;
    private ImageView mImageView;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request for window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_notification_infor2);
        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mImageView = (ImageView) findViewById(R.id.imv_menu_notification_infor2);

        // Get the bitmap from drawable resources
        mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.img_temp1);

        // Display the bitmap in ImageView
        mImageView.setImageBitmap(mBitmap);

        // Set an image for ImageView
        mImageView.setImageBitmap(mBitmap);
        BorderImage borderImage = new BorderImage();
        RoundedBitmapDrawable drawable = borderImage.createRoundedBitmapDrawableWithBorder(mResources,mBitmap);
        mImageView.setImageDrawable(drawable);
    }
}