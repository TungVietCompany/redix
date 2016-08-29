package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
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

        Button btn_menu_dashboard_bottom_cancel = (Button)findViewById(R.id.btn_menu_dashboard_bottom_cancel);
        btn_menu_dashboard_bottom_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(DashboardStopActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_cancel_dashboard);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                Button btn_cancel_dialog_dashboard = (Button)dialog.findViewById(R.id.btn_cancel_dialog_dashboard);
                btn_cancel_dialog_dashboard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardStopActivity.this,DashboardDeleteActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        //menu
        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setImageResource(R.drawable.back_interact);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("Dashboard");

        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);
        //end
    }
}
