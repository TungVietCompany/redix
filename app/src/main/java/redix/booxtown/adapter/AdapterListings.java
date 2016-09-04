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

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.EditListingActivity;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.UserProfileActivity;
import redix.booxtown.fragment.ListingsFragment;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 29/08/2016.
 */
public class AdapterListings extends BaseAdapter {
    private Context mContext;
    private ArrayList<Explore> listExplore;


    public AdapterListings(Context c, ArrayList<Explore> list_explores) {
        mContext = c;
        this.listExplore = list_explores;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listExplore.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return listExplore.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Explore ex= listExplore.get(position);
        convertView = inflater.inflate(R.layout.custom_gridview_listings, null);
        TextView txt_title_book = (TextView) convertView.findViewById(R.id.txt_title_book_listings);
        TextView txt_author_book = (TextView) convertView.findViewById(R.id.txt_author_book_listings);
        TextView txt_price_book=(TextView) convertView.findViewById(R.id.txt_price_listings);

        ImageView img_book = (ImageView)convertView.findViewById(R.id.img_book);
        ImageView img_swap = (ImageView)convertView.findViewById(R.id.img_explore_swap_listings);
        ImageView img_free = (ImageView)convertView.findViewById(R.id.img_explore_free_listings);
        ImageView img_buy = (ImageView)convertView.findViewById(R.id.img_explore_buy_listing);
        ImageView img_edit = (ImageView)convertView.findViewById(R.id.img_listings_edit);
        if(position%2==0){
            img_book.setImageResource((R.drawable.img_temp1));
            txt_title_book.setText("The Las Painting of Sara de Vos");
            txt_author_book.setText("buy Gandalf");
        }
        else
        {
            img_book.setImageResource((R.drawable.img_temp2));
            txt_title_book.setText("Gandalf the first");
            txt_author_book.setText("buy Ptit");
        }
        if(!ex.isBuy()) {
            txt_price_book.setVisibility(View.INVISIBLE);
        }
        if(ex.isSwap()){
            //img_swap.setImageResource((R.drawable.explore_btn_swap_active));
            Glide.with(mContext).load(R.drawable.explore_btn_swap_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
        }
        else {
            Glide.with(mContext).load(R.drawable.explore_btn_swap_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
            //img_swap.setImageResource((R.drawable.explore_btn_swap_dis_active));
        }
        if(ex.isFree()){
            Glide.with(mContext).load(R.drawable.explore_btn_free_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
            //img_free.setImageResource((R.drawable.explore_btn_free_active));
        }
        else {
            Glide.with(mContext).load(R.drawable.explore_btn_free_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
            //img_free.setImageResource((R.drawable.explore_btn_free_dis_active));
        }
        if(ex.isBuy()){
            Glide.with(mContext).load(R.drawable.listing_btn_buy).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
            //img_buy.setImageResource((R.drawable.listing_btn_buy));
        }
        else {
            Glide.with(mContext).load(R.drawable.explore_btn_buy_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
            //img_buy.setImageResource((R.drawable.explore_btn_buy_dis_active));
        }
        Glide.with(mContext).load(R.drawable.listing_btn_edit).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_edit);
        //img_edit.setImageResource((R.drawable.listing_btn_edit));

        img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, ListingsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type","1");
            }
        });
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, EditListingActivity.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }
}
