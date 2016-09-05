package redix.booxtown.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.SwapActivity;
import redix.booxtown.fragment.MainFragment;
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
                    final Dialog dialog = new Dialog(mContext);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_buy_listing);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    ImageView btn_dialog_notification_swap = (ImageView) dialog.findViewById(R.id.close_buy_listings);
                    btn_dialog_notification_swap.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();
                        }
                    });


                    TextView btn_confirm=(TextView) dialog.findViewById(R.id.btn_confirm_buy_listing);
                    btn_confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            final Dialog dialog1 = new Dialog(mContext);
                            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog1.setContentView(R.layout.dialog_request_sent_listing);
                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog1.show();

                            ImageView btn_close = (ImageView) dialog1.findViewById(R.id.close_sent_request_lising);
                            btn_close.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
//                                    getActivity().finish();
                                }
                            });
                            TextView btn_back=(TextView) dialog1.findViewById(R.id.btn_back_home);
                            btn_back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog1.dismiss();
                                    callFragment(new MainFragment());
                                }
                            });
                        }
                    });
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

    public void callFragment(Fragment fragment ){
        android.support.v4.app.FragmentManager manager = ((FragmentActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }
}