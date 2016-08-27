package redix.booxtown.custom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import redix.booxtown.R;
import redix.booxtown.activity.InteractActivity;

/**
 * Created by Administrator on 26/08/2016.
 */
public class MenuBottomCustom{
    private ImageView btn_location;
    private ImageView btn_commnet;
    private ImageView btn_camera;
    private ImageView btn_bag;
    private ImageView btn_user;
    Context context;
    private int type;

    public MenuBottomCustom(View view, Context ct, final int type) {
        this.context=ct;
        this.type=type;
        btn_location = (ImageView) view.findViewById(R.id.img_menu_bottom_location);
        btn_commnet = (ImageView) view.findViewById(R.id.img_menu_bottom_comment);
        btn_camera = (ImageView) view.findViewById(R.id.img_menu_bottom_camera);
        btn_bag = (ImageView) view.findViewById(R.id.img_menu_bottom_bag);
        btn_user = (ImageView) view.findViewById(R.id.img_menu_bottom_user);

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_location.setImageResource(R.drawable.icon_menu_bottom_location);
                setDefaut(1);
            }
        });

        btn_commnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type!=2){
                    Intent itent = new Intent(context, InteractActivity.class);
                    context.startActivity(itent);
                }
                setDefaut(2);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDefaut(3);
            }
        });
        btn_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDefaut(4);

            }
        });
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDefaut(5);
            }
        });


    }


    public void setDefaut(int i){
            //set icon tab
            if(i==1) {
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
