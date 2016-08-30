package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 26/08/2016.
 */
public class ExploreActivity extends AppCompatActivity
{
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    private MenuBottomCustom bottomExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        //------------------------------------------------------------
        TextView txtTitle=(TextView) findViewById(R.id.txt_title);
        txtTitle.setText("Explore");
        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setImageResource(R.drawable.icon_comeback_location);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //-----------------------------------------------------------
        final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,listEx,1);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        //---------------------------------------------------------------

        Explore e1= new Explore();
        e1.setSwap(true);
        e1.setFree(true);
        e1.setBuy(false);

        Explore e2= new Explore();
        e2.setSwap(true);
        e2.setFree(false);
        e2.setBuy(true);

        Explore e3= new Explore();
        e3.setSwap(false);
        e3.setFree(true);
        e3.setBuy(false);


        Explore e4= new Explore();
        e4.setSwap(false);
        e4.setFree(false);
        e4.setBuy(true);


        listEx.add(e1);
        listEx.add(e2);
        listEx.add(e3);
        listEx.add(e4);
        //--------------------------------------------------------------
        View view = (View)findViewById(R.id.menu_bottom_explore);
        bottomExplore=new MenuBottomCustom(view,this,1);
        bottomExplore.setDefaut(1);
        //---------------------------------------------------------------
        View view_tab=(View) findViewById(R.id.tab_explore);
        final CustomTabbarExplore tab_custom=new CustomTabbarExplore(view_tab,this);

        linear_all=(LinearLayout) view_tab.findViewById(R.id.linear_all);
        linear_swap=(LinearLayout) view_tab.findViewById(R.id.linear_swap);
        linear_free=(LinearLayout) view_tab.findViewById(R.id.linear_free);
        linear_cart=(LinearLayout) view_tab.findViewById(R.id.linear_cart);

        linear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(1),1);
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                tab_custom.setDefault(1);
            }
        });

        linear_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(2),1);
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);

                tab_custom.setDefault(2);
            }
        });

        linear_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(3),1);
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tab_custom.setDefault(3);
            }
        });

        linear_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(4),1);
                grid=(GridView)findViewById(R.id.gridView);
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

        bottomExplore.setDefaut(1);
    }
}
