package redix.booxtown.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.ListingCollectionActivity;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 29/08/2016.
 */
public class ListingsFragment extends Fragment
{
    private TextView txt_add_book;
    private TextView txt_my_book;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    private MenuBottomCustom bottomListings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.listings_fragment, container, false);

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
                callFragment(new ListingCollectionActivity());
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


    public void callFragment(Fragment fragment ){
        FragmentManager manager = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}

