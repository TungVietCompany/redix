package redix.booxtown.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;

public class MenuActivity extends AppCompatActivity {
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ListView lv=(ListView) findViewById(R.id.listViewa);
        lv.setAdapter(new CustomAdapter(MenuActivity.this, prgmNameList,prgmImages));
        ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
        close_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent= new Intent(MenuActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if(i==1){
                    Intent intent= new Intent(MenuActivity.this,NotificationActivity.class);
                    startActivity(intent);
                    finish();
                }else if(i==2){
                    Intent intent= new Intent(MenuActivity.this,FaqActivity.class);
                    startActivity(intent);
                    finish();
                }else if(i==3){
                    Intent intent= new Intent(MenuActivity.this,InviteFriendActivity.class);
                    startActivity(intent);
                    finish();
                }else if(i==4){
                    Intent intent= new Intent(MenuActivity.this,Rate.class);
                    startActivity(intent);
                    finish();
                }else if(i==5){
                    Intent intent= new Intent(MenuActivity.this,About.class);
                    startActivity(intent);
                    finish();
                }else if(i==6){
                    Intent intent= new Intent(MenuActivity.this,Contact.class);
                    startActivity(intent);
                    finish();
                }else if(i==7){
                    Intent intent= new Intent(MenuActivity.this,Setting.class);
                    startActivity(intent);
                    finish();
                }else if(i==8){
                    //log out
                    Intent intent= new Intent(MenuActivity.this,SignIn_Activity.class);
                    startActivity(intent);
                    finish();
                }else if(i==9){
                    //Intent intent= new Intent(MenuActivity.this,.class);
                    //startActivity(intent);
                }
            }
        });
    }
}
