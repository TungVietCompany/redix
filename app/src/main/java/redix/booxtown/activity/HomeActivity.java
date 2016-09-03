package redix.booxtown.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_menu_bottom_location;
    ImageView img_menu_bottom_comment;
    private MenuBottomCustom menu_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        img_menu_bottom_location = (ImageView)findViewById(R.id.img_menu_bottom_location);
        img_menu_bottom_comment = (ImageView)findViewById(R.id.img_menu_bottom_comment);

        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setVisibility(View.GONE);

        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //--------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom);
        menu_bottom=new MenuBottomCustom(view_bottom,HomeActivity.this,0);
        menu_bottom.setDefaut(0);
        //---------------------------------------------------------------

        String i = intent.getStringExtra("position");
        int position = Integer.parseInt(i);
        if(position==1){
            callFragment(new redix.booxtown.activity.NotificationActivity());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("Notifications");
        } else if(position == 2){
            callFragment(new redix.booxtown.activity.FaqActivity());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("FAQ");
        }else if(position == 3){
            callFragment(new redix.booxtown.activity.InviteFriendActivity());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("Invite Friends");
        }else if(position == 4){
            callFragment(new Rate());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("Rate Booxtown");
        }else if(position == 5){
            callFragment(new About());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("About Boxtown");
        }else if(position == 6){
            callFragment(new Contact());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("Contact Booxtown");
        }else if(position == 7){
            callFragment(new Setting());
            TextView txtTitle=(TextView)findViewById(R.id.txt_title);
            txtTitle.setText("Settings");
        }else if(position == 8){

        }

        img_menu_bottom_location.setOnClickListener(this);
        img_menu_bottom_comment.setOnClickListener(this);
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.framlayout_home, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_menu_bottom_location:
                callFragment(new Rate());
                break;
            case R.id.img_menu_bottom_comment:
                callFragment(new About());
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        menu_bottom.setDefaut(0);
    }
}
