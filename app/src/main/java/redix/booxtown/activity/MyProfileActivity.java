package redix.booxtown.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

public class MyProfileActivity extends AppCompatActivity {
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    ArrayList<Explore> listEx= new ArrayList<>();


    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        ImageView img_menu_personal_dashboard = (ImageView)findViewById(R.id.img_menu_personal_dashboard);
        img_menu_personal_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this,MyProfileDashboardActivity.class);
                startActivity(intent);
            }
        });

        //--------------------------------------------------
        View view=(View) findViewById(R.id.menu_top_myprofile);
        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
        txtTitle.setText("My Profile");
        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setVisibility(View.INVISIBLE);
        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //--------------------------------------------------
        View view_bottom = (View) findViewById(R.id.menu_bottom_myprofile);
        MenuBottomCustom menu_bottom=new MenuBottomCustom(view_bottom,this,5);
        menu_bottom.setDefaut(5);
        //---------------------------------------------------------------

        //------------------------------------------------------------
        Explore e1= new Explore();
        e1.setPrice_book(152.0f);
        e1.setBuy(true);
        e1.setSwap(true);

        Explore e2= new Explore();
        e2.setPrice_book(153.0f);
        e2.setBuy(true);
        e2.setFree(true);

        Explore e3= new Explore();
        e3.setPrice_book(154.0f);
        e3.setFree(true);

        Explore e4= new Explore();
        e4.setPrice_book(155.0f);
        e4.setSwap(true);

        listEx.add(e1);
        listEx.add(e2);
        listEx.add(e3);
        listEx.add(e4);
        //-----------------------------------------------------------
        final AdapterListings adapter = new AdapterListings(MyProfileActivity.this,listEx);
        grid=(GridView)findViewById(R.id.grid_myprofile);
        grid.setAdapter(adapter);


        //---------------------------------------------------------------
        View view_tab=(View) findViewById(R.id.tab_myprofile);
        final CustomTabbarExplore tab_custom=new CustomTabbarExplore(view_tab,this);

        linear_all=(LinearLayout) view_tab.findViewById(R.id.linear_all);
        linear_swap=(LinearLayout) view_tab.findViewById(R.id.linear_swap);
        linear_free=(LinearLayout) view_tab.findViewById(R.id.linear_free);
        linear_cart=(LinearLayout) view_tab.findViewById(R.id.linear_cart);

        linear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(MyProfileActivity.this,filterExplore(1));
                grid=(GridView)findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                tab_custom.setDefault(1);
            }
        });

        linear_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(MyProfileActivity.this,filterExplore(2));
                grid=(GridView)findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);

                tab_custom.setDefault(2);
            }
        });

        linear_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(MyProfileActivity.this,filterExplore(3));
                grid=(GridView)findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tab_custom.setDefault(3);
            }
        });

        linear_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(MyProfileActivity.this,filterExplore(4));
                grid=(GridView)findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                tab_custom.setDefault(4);
            }
        });
    }

    public ArrayList<Explore> filterExplore(int type){
        ArrayList<Explore> list= new ArrayList<>();
        if(type==1){
            list=listEx;
        }
        else if(type==2){
            for (int i=0; i<listEx.size(); i++){
                if(listEx.get(i).isSwap()){
                    list.add(listEx.get(i));
                }
            }
        }
        else if(type==3){
            for (int i=0; i<listEx.size(); i++){
                if(listEx.get(i).isFree()){
                    list.add(listEx.get(i));
                }
            }
        }
        else{
            for (int i=0; i<listEx.size(); i++){
                if(listEx.get(i).isBuy()){
                    list.add(listEx.get(i));
                }
            }
        }

        return list;
    }
    @Override
    protected void onRestart() {
        super.onRestart();
       // menu_bottom.setDefaut(5);
    }
}
