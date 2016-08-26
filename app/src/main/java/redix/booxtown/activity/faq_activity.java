package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.roughike.bottombar.BottomBar;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_Listview_faq;

public class faq_activity extends AppCompatActivity {

    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        ListView listView_faq = (ListView)findViewById(R.id.lv_content_faq);
        listView_faq.setAdapter(new Custom_Listview_faq(faq_activity.this, prgmNameList));

        listView_faq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent itent = new Intent(faq_activity.this,Faq_content.class);
                        startActivity(itent);
                        break;
                }
            }
        });

        ImageView menu =
                (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.menu);
                ListView lv=(ListView) findViewById(R.id.listViewa);
                lv.setAdapter(new CustomAdapter(faq_activity.this, prgmNameList,prgmImages));
                ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
                close_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent itent = new Intent(faq_activity.this,faq_activity.class);
                        startActivity(itent);
                    }
                });
            }
        });
    }
}
