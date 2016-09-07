package redix.booxtown.fragment;

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
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListviewWishboard;
import redix.booxtown.custom.CustomSearch;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

public class WishboardFragment extends Fragment {

    public static String [] title={"The last painting of Sara","Never of Dull moment","The nation of Brink"};
    public static String [] name={"Sara","Thuye","The nation"};
    public static String [] date={"22-08-1994","11-08-1994","10-08-1994"};
    private MenuBottomCustom menu_bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_wishboard , container, false);

        ImageView img_menu = (ImageView)getActivity().findViewById(R.id.img_menu);
        img_menu.setImageResource(R.drawable.btn_menu_locate);
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
}
