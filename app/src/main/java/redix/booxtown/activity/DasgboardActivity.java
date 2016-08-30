package redix.booxtown.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;

public class DasgboardActivity extends AppCompatActivity {
    private MenuBottomCustom menu_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasgboard);

        Button btn_menu_dashboard_bottom_cancel = (Button)findViewById(R.id.btn_menu_dashboard_bottom_cancel);
        btn_menu_dashboard_bottom_cancel.setVisibility(View.GONE);

        TextView txt_menu_dashboard_cancel = (TextView)findViewById(R.id.txt_menu_dashboard_cancel);
        txt_menu_dashboard_cancel.setVisibility(View.GONE);

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

        Button btn_menu_dashboard_bottom_rate = (Button)findViewById(R.id.btn_menu_dashboard_bottom_rate);
        btn_menu_dashboard_bottom_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(DasgboardActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_dashboard_status);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                Button btn_rate_dashboard_status = (Button)dialog.findViewById(R.id.btn_rate_dashboard_status);
                btn_rate_dashboard_status.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                ImageView imv_close_dialog_dashboard_status = (ImageView)dialog.findViewById(R.id.imv_close_dialog_dashboard_status);
                imv_close_dialog_dashboard_status.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        });

        //end
        //--------------------------------------------------
        View view_bottom = (View) findViewById(R.id.menu_bottom_myprofile);
        menu_bottom=new MenuBottomCustom(view_bottom,this,0);
        menu_bottom.setDefaut(0);
        //---------------------------------------------------------------
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        menu_bottom.setDefaut(0);
    }
}
