package redix.booxtown.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import redix.booxtown.R;

public class DasgboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasgboard);

        Button btn_menu_dashboard_bottom_cancel = (Button)findViewById(R.id.btn_menu_dashboard_bottom_cancel);
        btn_menu_dashboard_bottom_cancel.setVisibility(View.GONE);

        TextView txt_menu_dashboard_cancel = (TextView)findViewById(R.id.txt_menu_dashboard_cancel);
        txt_menu_dashboard_cancel.setVisibility(View.GONE);
    }
}
