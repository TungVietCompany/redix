package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.adapter.CustomPagerAdapter;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;
import redix.booxtown.model.InteractComment;

/**
 * Created by Administrator on 29/08/2016.
 */
public class ListingsDetailActivity extends AppCompatActivity
{
    private  ListView listView;
    private TextView txt_add_book;
    private TextView txt_my_book;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    private MenuBottomCustom bottomListings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_detail);

        final int type = (int) getIntent().getSerializableExtra("type");

        ProgressBar progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(40);

        //------------------------------------------------------------
        View view_menu_top=(View) findViewById(R.id.menu_top_detail_listings);
        TextView txtTitle=(TextView) view_menu_top.findViewById(R.id.txt_title);
        txtTitle.setText("Listings");
        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setVisibility(View.INVISIBLE);
        //------------------------------------------------------------
        View view_bottom=(View) findViewById(R.id.menu_bottom_listing_detail);
        bottomListings=new MenuBottomCustom(view_bottom,this,3);
        //------------------------------------------------------------
        View view=(View) findViewById(R.id.layout_details);
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        CirclePageIndicator indicator = (CirclePageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(mViewPager);

        ArrayList<InteractComment> list= new ArrayList<>();
        InteractComment interactComment1= new InteractComment(2.5f,true,false,true,"Gandalf","If you want to buy best books order us1","June 12 at 5:14 pm");
        InteractComment interactComment2= new InteractComment(3.0f,true,true,true,"Gandalf2","If you want to buy best books order us2","June 12 at 5:14 pm");
        InteractComment interactComment3= new InteractComment(4.0f,false,false,true,"Gandalf3","If you want to buy best books order us3","June 12 at 5:14 pm");
        InteractComment interactComment4= new InteractComment(3.5f,true,false,false,"Gandalf4","If you want to buy best books order us4","June 12 at 5:14 pm");
        InteractComment interactComment5= new InteractComment(5.0f,true,false,false,"Gandalf5","If you want to buy best books order us5","June 12 at 5:14 pm");

        list.add(interactComment1);
        list.add(interactComment2);
        list.add(interactComment3);
        list.add(interactComment4);
        list.add(interactComment5);


        //-----------------------------------------------------------
        final AdapterInteractThreadDetails adapter = new AdapterInteractThreadDetails(ListingsDetailActivity.this,list);
        listView=(ListView) view.findViewById(R.id.listview_comments);
        listView.setDivider(null);
        listView.setAdapter(adapter);
        //---------------------------------------------------------------
        EditText edit=(EditText) view.findViewById(R.id.edit_message);
        ImageView img_send=(ImageView) view.findViewById(R.id.btn_send_comment_interact);
        ImageView imgFree=(ImageView) view.findViewById(R.id.img_free_listings);
        ImageView imgSwap=(ImageView) view.findViewById(R.id.img_swap_listing);
        ImageView imgBuy=(ImageView) view.findViewById(R.id.img_buy_listing);
        if(type!=1){
            edit.setVisibility(View.GONE);
            img_send.setVisibility(View.GONE);
            imgFree.setVisibility(View.INVISIBLE);
        }

        if (type==3){
            final Dialog dialog = new Dialog(ListingsDetailActivity.this);
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
                    final Dialog dialog1 = new Dialog(ListingsDetailActivity.this);
                    dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog1.setContentView(R.layout.dialog_request_sent_listing);
                    dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog1.show();

                    ImageView btn_close = (ImageView) dialog1.findViewById(R.id.close_sent_request_lising);
                    btn_close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();
                            finish();
                        }
                    });
                    TextView btn_back=(TextView) dialog1.findViewById(R.id.btn_back_home);
                    btn_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent inten= new Intent(ListingsDetailActivity.this, MainActivity.class);
                            startActivity(inten);
                            finish();
                        }
                    });
                }
            });

        }
        if(type==4){

            final Dialog dialog1 = new Dialog(ListingsDetailActivity.this);
            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog1.setContentView(R.layout.dialog_request_sent_listing);
            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog1.show();

            ImageView btn_close = (ImageView) dialog1.findViewById(R.id.close_sent_request_lising);
            btn_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog1.dismiss();
                    finish();
                }
            });
            TextView btn_back=(TextView) dialog1.findViewById(R.id.btn_back_home);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inten= new Intent(ListingsDetailActivity.this, MainActivity.class);
                    startActivity(inten);
                    finish();
                }
            });

        }

        imgBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type==2){
                    final Dialog dialog = new Dialog(ListingsDetailActivity.this);
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
                            final Dialog dialog1 = new Dialog(ListingsDetailActivity.this);
                            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog1.setContentView(R.layout.dialog_request_sent_listing);
                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog1.show();

                            ImageView btn_close = (ImageView) dialog1.findViewById(R.id.close_sent_request_lising);
                            btn_close.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    finish();
                                }
                            });
                            TextView btn_back=(TextView) dialog1.findViewById(R.id.btn_back_home);
                            btn_back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent inten= new Intent(ListingsDetailActivity.this, MainActivity.class);
                                    startActivity(inten);
                                    finish();
                                }
                            });
                        }
                    });

                }
            }
        });

        imgSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type==2){
                    Intent intent= new Intent(ListingsDetailActivity.this, SwapActivity.class);
                    startActivity(intent);
                }
            }
        });

//        //------------------------------------------------------------
//        View view=(View) findViewById(R.id.menu_top_listings);
//        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
//        txtTitle.setText("Listings");
//        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
//        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
//        img_component.setVisibility(View.INVISIBLE);
//
//        //--------------------------------------------------------------
//        View view_bottom = (View)findViewById(R.id.menu_bottom_listings);
//        bottomListings=new MenuBottomCustom(view_bottom,this,3);
//        bottomListings.setDefaut(3);
//        //---------------------------------------------------------------
//
//        txt_my_book=(TextView) findViewById(R.id.txt_my_listings);
//        txt_add_book=(TextView) findViewById(R.id.txt_add_book);
//
//        txt_my_book.setBackgroundColor(getResources().getColor(R.color.dot_light_screen2));
//
//        txt_add_book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bottomListings.setDefaut(3);
    }

}

