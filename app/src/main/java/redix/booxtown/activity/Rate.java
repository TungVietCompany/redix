package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.MenuBottomCustom;

public class Rate extends Fragment {
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};
    private MenuBottomCustom bottomListings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_rate, container, false);
        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rate);
//
//        ImageView menu =
//                (ImageView)findViewById(R.id.img_menu);
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Intent intent = new Intent(Rate.this,MenuActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //icon back
//        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
//        img_menu_component.setVisibility(View.GONE);
//
//        TextView title_menu = (TextView)findViewById(R.id.txt_title);
//        title_menu.setText("Rate Booxtown");
//
//        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
//        img_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Rate.this,MenuActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //bottom
//        //--------------------------------------------------------------
//        View view_bottom = (View)findViewById(R.id.menu_bottom_rate);
//        bottomListings=new MenuBottomCustom(view_bottom,this,0);
//        bottomListings.setDefaut(0);
//        //---------------------------------------------------------------
 //   }

//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        bottomListings.setDefaut(0);
//    }
}
