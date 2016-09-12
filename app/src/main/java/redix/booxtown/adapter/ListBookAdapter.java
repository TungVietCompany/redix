package redix.booxtown.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.activity.EditListingActivity;
import redix.booxtown.activity.ListingCollectionActivity;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.UserProfileActivity;
import redix.booxtown.fragment.ListingsFragment;
import redix.booxtown.model.Book;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 29/08/2016.
 */
public class ListBookAdapter extends BaseAdapter {
    private Context mContext;
    private List<Book> listBook;


    public ListBookAdapter(Context c, List<Book> list_book) {
        mContext = c;
        this.listBook = list_book;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return listBook.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final Book ex= listBook.get(position);
        Hoder hoder = new Hoder();
        convertView = inflater.inflate(R.layout.custom_gridview_listings, null);
        hoder.txt_title_book = (TextView) convertView.findViewById(R.id.txt_title_book_listings);
        hoder.txt_author_book = (TextView) convertView.findViewById(R.id.txt_author_book_listings);
        hoder.txt_price_book=(TextView) convertView.findViewById(R.id.txt_price_listings);

        hoder.img_book = (ImageView)convertView.findViewById(R.id.img_book);
        hoder.img_swap = (ImageView)convertView.findViewById(R.id.img_explore_swap_listings);
        hoder.img_free = (ImageView)convertView.findViewById(R.id.img_explore_free_listings);
        hoder.img_buy = (ImageView)convertView.findViewById(R.id.img_explore_buy_listing);
        hoder.img_edit = (ImageView)convertView.findViewById(R.id.img_listings_edit);
        if(position%2==0){
            Picasso.with(mContext).load(R.drawable.img_temp1).resize(200,250).into(hoder.img_book);
        }
        else
        {
            Picasso.with(mContext).load(R.drawable.img_temp2).resize(200,250).into(hoder.img_book);
        }
        //String action[] = ex.getAction().split("");
        char array[]=ex.getAction().toCharArray();
        if(ex.getPrice() == null) {
            hoder.txt_price_book.setVisibility(View.INVISIBLE);
        }else {
            hoder.txt_price_book.setText(ex.getPrice());
        }
        if(String.valueOf(array[0]).contains("1")){
            Picasso.with(mContext).load(R.drawable.explore_btn_swap_active).into(hoder.img_swap);
            //img_swap.setImageResource((R.drawable.explore_btn_swap_active));
            //Glide.with(mContext).load(R.drawable.explore_btn_swap_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
        }
        else {
            Picasso.with(mContext).load(R.drawable.explore_btn_swap_dis_active).into(hoder.img_swap);

//            Glide.with(mContext).load(R.drawable.explore_btn_swap_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
            //img_swap.setImageResource((R.drawable.explore_btn_swap_dis_active));
        }
        if(String.valueOf(array[1]).contains("1")){
            Picasso.with(mContext).load(R.drawable.explore_btn_free_active).into(hoder.img_free);
//            Glide.with(mContext).load(R.drawable.explore_btn_free_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
            //img_free.setImageResource((R.drawable.explore_btn_free_active));
        }
        else {
            Picasso.with(mContext).load(R.drawable.explore_btn_free_dis_active).into(hoder.img_free);
//            Glide.with(mContext).load(R.drawable.explore_btn_free_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
            //img_free.setImageResource((R.drawable.explore_btn_free_dis_active));
        }
        if(String.valueOf(array[2]).contains("1")){
            Picasso.with(mContext).load(R.drawable.listing_btn_buy).into(hoder.img_buy);
//            Glide.with(mContext).load(R.drawable.listing_btn_buy).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
            //img_buy.setImageResource((R.drawable.listing_btn_buy));
        }
        else {
            Picasso.with(mContext).load(R.drawable.explore_btn_buy_dis_active).into(hoder.img_buy);
//            Glide.with(mContext).load(R.drawable.explore_btn_buy_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
            //img_buy.setImageResource((R.drawable.explore_btn_buy_dis_active));
        }

        Picasso.with(mContext).load(R.drawable.listing_btn_edit).into(hoder.img_edit);
//        Glide.with(mContext).load(R.drawable.listing_btn_edit).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_edit);
        //img_edit.setImageResource((R.drawable.listing_btn_edit));

        hoder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, ListingsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type","1");
            }
        });
        hoder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListingCollectionActivity fragment = new ListingCollectionActivity();
                Bundle bundle = new Bundle();
                bundle.putString("activity","edit");
                bundle.putSerializable("bookedit",ex);
                fragment.setArguments(bundle);
                callFragment(fragment);
            }
        });


        hoder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListingsDetailActivity fragment = new ListingsDetailActivity();
                Bundle bundle = new Bundle();
                bundle.putString(String.valueOf(R.string.valueListings),"2");
                bundle.putSerializable("bookedit",ex);
                fragment.setArguments(bundle);
                callFragment(fragment);
            }
        });

        hoder.txt_title_book.setText(ex.getTitle().toString());
        hoder.txt_author_book.setText(ex.getAuthor().toString());


        return convertView;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }

    public class Hoder{

        TextView txt_title_book ;
        TextView txt_author_book ;
        TextView txt_price_book;

        ImageView img_book ;
        ImageView img_swap;
        ImageView img_free;
        ImageView img_buy ;
        ImageView img_edit ;

    }
}
