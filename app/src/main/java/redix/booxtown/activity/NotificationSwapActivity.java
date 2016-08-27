package redix.booxtown.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomListviewNotificationSwap;

public class NotificationSwapActivity extends AppCompatActivity {

    public static String [] prgmNameList={"Home","Notifications","FAQ"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_swap);

        ListView listView = (ListView)findViewById(R.id.lv_notification_swap);
        listView.setAdapter(new CustomListviewNotificationSwap(NotificationSwapActivity.this, prgmNameList));

        Button btn_notification_not_like= (Button)findViewById(R.id.btn_notification_not_like);
        btn_notification_not_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(NotificationSwapActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_notification_swap_button);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ImageView imageView =(ImageView)dialog.findViewById(R.id.imv_clode_dialog_not_like);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}
