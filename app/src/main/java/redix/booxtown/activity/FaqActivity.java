package redix.booxtown.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_Listview_faq;

public class FaqActivity extends AppCompatActivity {

    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        ListView listView_faq = (ListView)findViewById(R.id.lv_content_faq);
        listView_faq.setAdapter(new Custom_Listview_faq(FaqActivity.this, prgmNameList));

        listView_faq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent itent = new Intent(FaqActivity.this,Faq_content.class);
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
                Intent intent = new Intent(FaqActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //icon back
        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("FAQ");
    }
}
