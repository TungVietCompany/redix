package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterFilter;
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
    public static String [] prgmNameList1={"Nearest distance","Price low to high","Price high to low","Recently added"};
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
        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExploreActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------------------------------
        final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,listEx);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        //---------------------------------------------------------------

        //filter/sort--------------------------------
        filterSort();
        //end-------------------------------------

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
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(1));
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                tab_custom.setDefault(1);
            }
        });

        linear_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(2));
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);

                tab_custom.setDefault(2);
            }
        });

        linear_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(3));
                grid=(GridView)findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tab_custom.setDefault(3);
            }
        });

        linear_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,filterExplore(4));
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

    public void filterSort(){
        ImageView btn_filter_explore = (ImageView)findViewById(R.id.btn_filter_explore);
        btn_filter_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(ExploreActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_filter_sort);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ListView lv_dialog_filter = (ListView)dialog.findViewById(R.id.lv_dialog_filter);
                lv_dialog_filter.setAdapter(new AdapterFilter(ExploreActivity.this,prgmNameList1));

                final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) dialog.findViewById(R.id.rangeSeekbar3);
                final TextView tvMin = (TextView) dialog.findViewById(R.id.txt_filter_rangemin);
                final TextView tvMax = (TextView) dialog.findViewById(R.id.txt_filter_rangemax);

                rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue, Number maxValue) {
                        tvMin.setText(String.valueOf(minValue));
                        tvMax.setText(String.valueOf(maxValue));
                    }
                });

                final TextView txt_filter_proximity = (TextView)dialog.findViewById(R.id.txt_filter_proximity);
                final CrystalSeekbar seekbar = (CrystalSeekbar) dialog.findViewById(R.id.rangeSeekbar8);
                seekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue) {
                        txt_filter_proximity.setText(String.valueOf(minValue)+" KM");
                    }
                });

                ImageView imv_dialog_filter_close = (ImageView)dialog.findViewById(R.id.imv_dialog_filter_close);
                imv_dialog_filter_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btn_dialog_filter_submit = (Button)dialog.findViewById(R.id.btn_dialog_filter_submit);
                btn_dialog_filter_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner_dialog_filter);
                List<String> list = new ArrayList<String>();
                list.add("Nearest distance");
                list.add("list 2");
                list.add("list 3");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ExploreActivity.this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(dataAdapter);
            }
        });
    }
}
