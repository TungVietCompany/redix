package redix.booxtown.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    }
}
