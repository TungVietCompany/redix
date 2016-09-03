package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.adapter.AdapterListviewWishboard;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 29/08/2016.
 */
public class ListingsActivity extends Fragment
{
    private TextView txt_add_book;
    private TextView txt_my_book;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    private MenuBottomCustom bottomListings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_listings , container, false);

        ImageView img_menu = (ImageView)getActivity().findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        //------------------------------------------------------------
        //add book
        TextView txt_add_book = (TextView)view.findViewById(R.id.txt_add_book);
        txt_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //-------------------------------------------------------------
        Explore e1= new Explore();
        e1.setPrice_book(152.0f);
        e1.setBuy(true);

        Explore e2= new Explore();
        e2.setPrice_book(153.0f);
        e2.setBuy(true);

        Explore e3= new Explore();
        e3.setPrice_book(154.0f);
        e3.setBuy(true);

        Explore e4= new Explore();
        e4.setPrice_book(155.0f);
        e4.setBuy(true);

        listEx.add(e1);
        listEx.add(e2);
        listEx.add(e3);
        listEx.add(e4);
        //-----------------------------------------------------------
        final AdapterListings adapter = new AdapterListings(getActivity(),listEx);
        grid=(GridView)view.findViewById(R.id.grid_view_listings);
        grid.setAdapter(adapter);

        //--------------------------------------------------------------
        //change color tab

        TextView txt_my_listings = (TextView)view.findViewById(R.id.txt_my_listings);
        txt_my_listings.setTextColor(getResources().getColor(R.color.color_text));
        txt_my_listings.setBackgroundColor(getResources().getColor(R.color.dot_light_screen1));

        txt_add_book.setTextColor(getResources().getColor(R.color.dot_light_screen1));
        txt_add_book.setBackgroundColor(getResources().getColor(R.color.color_text));
        //end
        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_listings);
//
//        //------------------------------------------------------------
//        View view=(View) findViewById(R.id.menu_top_listings);
//        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
//        txtTitle.setText("Listings");
//        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
//        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
//        img_component.setVisibility(View.INVISIBLE);
//
//        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
//        img_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ListingsActivity.this,MenuActivity.class);
//                startActivity(intent);
//            }
//        });
//        //------------------------------------------------------------
//        //add book
//        TextView txt_add_book = (TextView)findViewById(R.id.txt_add_book);
//        txt_add_book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ListingsActivity.this,ListingCollectionActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        //
//        Explore e1= new Explore();
//        e1.setPrice_book(152.0f);
//        e1.setBuy(true);
//
//        Explore e2= new Explore();
//        e2.setPrice_book(153.0f);
//        e2.setBuy(true);
//
//        Explore e3= new Explore();
//        e3.setPrice_book(154.0f);
//        e3.setBuy(true);
//
//        Explore e4= new Explore();
//        e4.setPrice_book(155.0f);
//        e4.setBuy(true);
//
//        listEx.add(e1);
//        listEx.add(e2);
//        listEx.add(e3);
//        listEx.add(e4);
//        //-----------------------------------------------------------
//        final AdapterListings adapter = new AdapterListings(ListingsActivity.this,listEx);
//        grid=(GridView)findViewById(R.id.grid_view_listings);
//        grid.setAdapter(adapter);
//
//        //--------------------------------------------------------------
//        View view_bottom = (View)findViewById(R.id.menu_bottom_listings);
//        bottomListings=new MenuBottomCustom(view_bottom,this,3);
//        bottomListings.setDefaut(3);
//        //---------------------------------------------------------------
//
//        //change color tab
//
//        TextView txt_my_listings = (TextView)findViewById(R.id.txt_my_listings);
//        txt_my_listings.setTextColor(getResources().getColor(R.color.color_text));
//        txt_my_listings.setBackgroundColor(getResources().getColor(R.color.dot_light_screen1));
//
//        txt_add_book.setTextColor(getResources().getColor(R.color.dot_light_screen1));
//        txt_add_book.setBackgroundColor(getResources().getColor(R.color.color_text));
//        //end
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        bottomListings.setDefaut(3);
//    }

}

