package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import redix.booxtown.R;
import redix.booxtown.RecyclerClick.RecyclerItemClickListener;
import redix.booxtown.custom.CustomAdapter;

public class MenuActivity extends AppCompatActivity {
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        RecyclerView lv=(RecyclerView) findViewById(R.id.listViewa);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
        lv.setLayoutManager(layoutManager);

        //set adapter
        CustomAdapter menu = new CustomAdapter(prgmNameList,prgmImages);
        lv.setAdapter(menu);
        //end
        ImageView close_menu = (ImageView)findViewById(R.id.imgv_close);
        close_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lv.addOnItemTouchListener(
                new RecyclerItemClickListener(MenuActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
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
                            final Dialog dialog = new Dialog(MenuActivity.this);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.dialog_unsubcribe);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.show();

                            ImageView img_close_dialog_unsubcribe = (ImageView)dialog.findViewById(R.id.img_close_dialog_unsubcribe);
                            img_close_dialog_unsubcribe.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });

                            Button btn_unsubcribe = (Button)dialog.findViewById(R.id.btn_unsubcribe);
                            btn_unsubcribe.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    }
                })
        );
    }
}
