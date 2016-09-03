package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;

/**
 * Created by Administrator on 03/09/2016.
 */
public class MainAllActivity extends AppCompatActivity implements View.OnClickListener {

    View view_top;
    View view_bottom;
    TextView txtTitle;
    ImageView img_component;
    boolean flag;

    //-----------------------------
    private ImageView btn_location;
    private ImageView btn_commnet;
    private ImageView btn_camera;
    private ImageView btn_bag;
    private ImageView btn_user;
    //-----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_all);

        view_top = (View) findViewById(R.id.menu_top_all);
        txtTitle = (TextView) view_top.findViewById(R.id.txt_title);
        txtTitle.setText("Locate");
        flag=true;
        img_component = (ImageView) view_top.findViewById(R.id.img_menu_component);
        img_component.setImageResource(R.drawable.icon_explore);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    callFragment(new redix.booxtown.activity.ExploreActivity());
                    txtTitle.setText("Explore");
                    img_component.setImageResource(R.drawable.icon_comeback_location);
                    flag=false;
                }
                else {
                    callFragment(new redix.booxtown.activity.MainActivity());
                    txtTitle.setText("Locate");
                    img_component.setImageResource(R.drawable.icon_explore);
                    flag=true;
                }
            }
        });

        ImageView img_menu = (ImageView)view_top.findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainAllActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //-------------------------------------------------------
        btn_location = (ImageView) findViewById(R.id.img_menu_bottom_location);
        btn_commnet = (ImageView) findViewById(R.id.img_menu_bottom_comment);
        btn_camera = (ImageView) findViewById(R.id.img_menu_bottom_camera);
        btn_bag = (ImageView) findViewById(R.id.img_menu_bottom_bag);
        btn_user = (ImageView) findViewById(R.id.img_menu_bottom_user);

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_location.setImageResource(R.drawable.icon_menu_bottom_location);
                callFragment(new redix.booxtown.activity.MainActivity());
                img_component.setVisibility(View.VISIBLE);
                img_component.setImageResource(R.drawable.icon_explore);
                txtTitle.setText("Locate");
                setDefaut(1);
            }
        });

        btn_commnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new redix.booxtown.activity.InteractActivity());
                img_component.setVisibility(View.GONE);
                txtTitle.setText("Interact");
                setDefaut(2);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new redix.booxtown.activity.ListingsActivity());
                img_component.setVisibility(View.GONE);
                txtTitle.setText("Listings");

                setDefaut(3);
            }
        });
        btn_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new redix.booxtown.activity.WishboardActivity());
                img_component.setVisibility(View.VISIBLE);
                img_component.setImageResource(R.drawable.icon_menu_wishboard);
                txtTitle.setText("Wishboard");
                setDefaut(4);

            }
        });
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDefaut(5);
            }
        });
        //-------------------------------------------------------

        callFragment(new redix.booxtown.activity.MainActivity());

    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
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

    public void setDefaut(int i){
        //set icon tab
        if(i==0) {
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location_not);
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment_not);
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera_not);
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag_not);
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user_not);
        }
        else if(i==1) {
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location);
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment_not);
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera_not);
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag_not);
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user_not);
        }
        else if(i==2) {
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment);
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location_not);
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera_not);
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag_not);
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user_not);
        }
        else if(i==3) {
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera);
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location_not);
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment_not);
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag_not);
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user_not);
        }
        else if(i==4) {
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag);
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location_not);
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment_not);
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera_not);
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user_not);
        }
        else {
            btn_user.setImageResource(R.drawable.icon_menu_bottom_user);
            btn_location.setImageResource(R.drawable.icon_menu_bottom_location_not);
            btn_commnet.setImageResource(R.drawable.icon_menu_bottom_comment_not);
            btn_camera.setImageResource(R.drawable.icon_menu_bottom_camera_not);
            btn_bag.setImageResource(R.drawable.icon_menu_bottom_bag_not);
        }

    }
}
