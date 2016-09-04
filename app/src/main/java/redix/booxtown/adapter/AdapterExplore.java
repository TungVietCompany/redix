package redix.booxtown.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.SwapActivity;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 26/08/2016.
 */
public class AdapterExplore extends BaseAdapter {
    private Context mContext;
    private ArrayList<Explore> listExplore;
    private int type;

    public AdapterExplore(Context c, ArrayList<Explore> list_explores,int type) {
        mContext = c;
        this.listExplore = list_explores;
        this.type=type;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final Explore ex= listExplore.get(position);

            convertView = inflater.inflate(R.layout.custom_gridview_explore, null);
            TextView txt_title_book = (TextView) convertView.findViewById(R.id.txt_title_book_listings);
            TextView txt_author_book = (TextView) convertView.findViewById(R.id.txt_author_book_listings);
            TextView txt_price_book=(TextView) convertView.findViewById(R.id.txt_pricebook);

            ImageView img_book = (ImageView)convertView.findViewById(R.id.img_book);
            ImageView img_swap = (ImageView)convertView.findViewById(R.id.img_explore_swap);
            ImageView img_free = (ImageView)convertView.findViewById(R.id.img_explore_free);
            ImageView img_buy = (ImageView)convertView.findViewById(R.id.img_explore_buy);


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

            if(ex.isSwap()){
                //img_swap.setImageResource((R.drawable.explore_btn_swap_active));
                Glide.with(mContext).load(R.drawable.explore_btn_swap_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
            }
            else{
                Glide.with(mContext).load(R.drawable.explore_btn_swap_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_swap);
                //img_swap.setImageResource((R.drawable.explore_btn_swap_dis_active));
            }

            if(ex.isFree()){
                Glide.with(mContext).load(R.drawable.explore_btn_free_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
                //img_free.setImageResource((R.drawable.explore_btn_free_active));
            }
            else{
                Glide.with(mContext).load(R.drawable.explore_btn_free_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_free);
                //img_free.setImageResource((R.drawable.explore_btn_free_dis_active));
            }

            if(ex.isBuy()){
                Glide.with(mContext).load(R.drawable.explore_btn_buy_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
                //img_buy.setImageResource((R.drawable.explore_btn_buy_active));
                txt_price_book.setVisibility(View.VISIBLE);
                
            }
            else{
                Glide.with(mContext).load(R.drawable.explore_btn_buy_dis_active).diskCacheStrategy(DiskCacheStrategy.ALL).into(img_buy);
                //img_buy.setImageResource((R.drawable.explore_btn_buy_dis_active));
            }

            img_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ex.isBuy()&& type!=0) {
                        Intent intent = new Intent(mContext, ListingsDetailActivity.class);
                        intent.putExtra("type", 3);
                        mContext.startActivity(intent);
                    }
                }
            });

            img_swap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ex.isSwap()&& type!=0) {
                        Intent intent = new Intent(mContext, SwapActivity.class);
                        mContext.startActivity(intent);
                    }
                }
            });

        return convertView;
    }
}