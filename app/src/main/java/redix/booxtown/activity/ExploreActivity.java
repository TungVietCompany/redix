package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 26/08/2016.
 */
public class ExploreActivity extends AppCompatActivity
{
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        RelativeLayout view = (RelativeLayout)findViewById(R.id.menu_bottom_explore);
        new MenuBottomCustom(view,this);
        ArrayList<Explore> list= new ArrayList<>();
        Explore e1= new Explore();
        e1.setUrl_img_book("dsds");
        e1.setTitle_book("t");

        Explore e2= new Explore();
        e2.setUrl_img_book("dsds");
        e2.setTitle_book("t");

        Explore e3= new Explore();
        e3.setUrl_img_book("dsds");
        e3.setTitle_book("t");

        Explore e4= new Explore();
        e4.setUrl_img_book("dsds");
        e4.setTitle_book("t");

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        AdapterExplore adapter = new AdapterExplore(ExploreActivity.this,list);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
    }
}
