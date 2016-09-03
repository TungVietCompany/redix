package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListviewWishboard;
import redix.booxtown.custom.CustomSearch;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

public class WishboardActivity extends Fragment {

    public static String [] title={"The last painting of Sara","Never of Dull moment","The nation of Brink"};
    public static String [] name={"Sara","Thuye","The nation"};
    public static String [] date={"22-08-1994","11-08-1994","10-08-1994"};
    private MenuBottomCustom menu_bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_wishboard , container, false);

        ImageView img_menu = (ImageView)getActivity().findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        ListView lv_wishboard = (ListView) view.findViewById(R.id.lv_wishboard);
        lv_wishboard.setAdapter(new AdapterListviewWishboard(getActivity(),title,name,date));

        ImageView img_component=(ImageView) getActivity().findViewById(R.id.img_menu_component);

        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_post_book_wishbroad);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ImageView img_close_dialog_post_book_wishbroad = (ImageView)dialog.findViewById(R.id.img_close_dialog_post_book_wishbroad);
                img_close_dialog_post_book_wishbroad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                TextView btn_submit_dialog_post_book_wishbroad = (TextView)dialog.findViewById(R.id.btn_submit_dialog_post_book_wishbroad);
                btn_submit_dialog_post_book_wishbroad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        return view;
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_wishboard);
//
//        ListView lv_wishboard = (ListView)findViewById(R.id.lv_wishboard);
//        lv_wishboard.setAdapter(new AdapterListviewWishboard(WishboardActivity.this,title,name,date));
//
//        //menu
//
//        TextView title_menu = (TextView)findViewById(R.id.txt_title);
//        title_menu.setText("Wishboard");
//
//        ImageView menu = (ImageView)findViewById(R.id.img_menu);
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(WishboardActivity.this,MenuActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
//        img_component.setImageResource(R.drawable.icon_menu_wishboard);
//        img_component.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog = new Dialog(WishboardActivity.this);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(R.layout.dialog_post_book_wishbroad);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//                ImageView img_close_dialog_post_book_wishbroad = (ImageView)dialog.findViewById(R.id.img_close_dialog_post_book_wishbroad);
//                img_close_dialog_post_book_wishbroad.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//
//                TextView btn_submit_dialog_post_book_wishbroad = (TextView)dialog.findViewById(R.id.btn_submit_dialog_post_book_wishbroad);
//                btn_submit_dialog_post_book_wishbroad.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//            }
//        });
//        //end
//
//        //--------------------------------------------------
//        View view_bottom = (View) findViewById(R.id.menu_bottom_wishboard);
//        menu_bottom=new MenuBottomCustom(view_bottom,this,4);
//        menu_bottom.setDefaut(4);
//        //---------------------------------------------------------------
//
//
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        menu_bottom.setDefaut(4);
//    }
}
