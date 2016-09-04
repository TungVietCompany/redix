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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import redix.booxtown.R;
import redix.booxtown.fragment.AboutFragment;
import redix.booxtown.fragment.ExploreFragment;
import redix.booxtown.fragment.InteractFragment;
import redix.booxtown.fragment.ListingsFragment;
import redix.booxtown.fragment.MainFragment;
import redix.booxtown.fragment.MyProfileFragment;
import redix.booxtown.fragment.RateFragment;
import redix.booxtown.fragment.WishboardFragment;

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
        Glide.with(MainAllActivity.this).load(R.drawable.btn_explore).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    callFragment(new ExploreFragment());
                    txtTitle.setText("Explore");
                    Glide.with(MainAllActivity.this).load(R.drawable.btn_location).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
                    flag=false;
                }
                else {
                    callFragment(new MainFragment());
                    txtTitle.setText("Locate");
                    Glide.with(MainAllActivity.this).load(R.drawable.btn_explore).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
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
                //btn_location.setImageResource(R.drawable.icon_menu_bottom_location);
                Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
                initLayout();
                callFragment(new MainFragment());
                img_component = (ImageView) view_top.findViewById(R.id.img_menu_component);
                img_component.setVisibility(View.VISIBLE);
                img_component.setImageResource(R.drawable.btn_explore);
                //Glide.with(MainAllActivity.this).load(R.drawable.btn_explore).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);

                txtTitle.setText("Locate");
                setDefaut(1);
            }
        });

        btn_commnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new InteractFragment());
                img_component.setVisibility(View.GONE);
                txtTitle.setText("Interact");
                setDefaut(2);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new ListingsFragment());
                img_component.setVisibility(View.GONE);
                txtTitle.setText("Listings");

                setDefaut(3);
            }
        });
        btn_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new WishboardFragment());
                img_component.setVisibility(View.VISIBLE);
                img_component.setImageResource(R.drawable.icon_menu_wishboard);
                txtTitle.setText("Wishboard");
                setDefaut(4);

            }
        });
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new MyProfileFragment());
                img_component.setVisibility(View.GONE);
                txtTitle.setText("My Profile");
                setDefaut(5);
            }
        });
        //-------------------------------------------------------

        callFragment(new MainFragment());

    }
    public void initLayout(){
        view_top = (View) findViewById(R.id.menu_top_all);
        txtTitle = (TextView) view_top.findViewById(R.id.txt_title);
        txtTitle.setText("Locate");
        flag=true;
        img_component = (ImageView) view_top.findViewById(R.id.img_menu_component);
        Glide.with(MainAllActivity.this).load(R.drawable.btn_explore).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    callFragment(new ExploreFragment());
                    txtTitle.setText("Explore");
                    Glide.with(MainAllActivity.this).load(R.drawable.btn_location).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
                    flag=false;
                }
                else {
                    callFragment(new MainFragment());
                    txtTitle.setText("Locate");
                    Glide.with(MainAllActivity.this).load(R.drawable.btn_explore).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_component);
                    flag=true;
                }
            }
        });
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
                callFragment(new RateFragment());
                break;
            case R.id.img_menu_bottom_comment:
                callFragment(new AboutFragment());
                break;
        }
    }

    public void setDefaut(int i){
        //set icon tab
        if(i==0) {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_not_active);
            btn_location.setImageResource(R.drawable.btn_locate_not_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_not_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_not_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_not_active);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_user);
        }
        else if(i==1) {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_not_active);
            btn_location.setImageResource(R.drawable.btn_locate_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_not_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_not_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_not_active);

//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_profile_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
        }
        else if(i==2) {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_active);
            btn_location.setImageResource(R.drawable.btn_locate_not_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_not_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_not_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_not_active);


//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_profile_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_user);
        }
        else if(i==3) {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_not_active);
            btn_location.setImageResource(R.drawable.btn_locate_not_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_not_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_not_active);

//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_profile_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_user);
        }
        else if(i==4) {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_not_active);
            btn_location.setImageResource(R.drawable.btn_locate_not_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_not_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_not_active);

//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_profile_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_user);
        }
        else {
            btn_commnet.setImageResource(R.drawable.btn_locate_interact_not_active);
            btn_location.setImageResource(R.drawable.btn_locate_not_active);
            btn_camera.setImageResource(R.drawable.btn_locate_listing_not_active);
            btn_bag.setImageResource(R.drawable.btn_locate_wishbroad_not_active);
            btn_user.setImageResource(R.drawable.btn_locate_profile_active);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_interact_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_commnet);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_location);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_listing_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_camera);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_wishbroad_not_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_bag);
//            Glide.with(MainAllActivity.this).load(R.drawable.btn_locate_profile_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(btn_user);

        }

    }
}
