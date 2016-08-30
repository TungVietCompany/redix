package redix.booxtown.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;

/**
 * Created by thuyetpham94 on 29/08/2016.
 */
public class DashboardDeleteActivity extends AppCompatActivity {
    private MenuBottomCustom menu_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasgboard);

        ImageView img_menu_dashboard_bottom_status = (ImageView)findViewById(R.id.img_menu_dashboard_bottom_status);
        img_menu_dashboard_bottom_status.setImageResource(R.drawable.icon_delete_profile);

        Button btn_menu_dashboard_bottom_rate = (Button)findViewById(R.id.btn_menu_dashboard_bottom_rate);
        btn_menu_dashboard_bottom_rate.setVisibility(View.GONE);

        Button btn_menu_dashboard_bottom_cancel = (Button)findViewById(R.id.btn_menu_dashboard_bottom_cancel);
        btn_menu_dashboard_bottom_cancel.setVisibility(View.GONE);

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
