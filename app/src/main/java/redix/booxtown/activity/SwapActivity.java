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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.adapter.AdapterSwap;
import redix.booxtown.adapter.CustomPagerAdapter;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;
import redix.booxtown.model.InteractComment;

/**
 * Created by Administrator on 30/08/2016.
 */
public class SwapActivity extends AppCompatActivity {

    ArrayList<String> listSwap= new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_book);
        //------------------------------------------------------------
        View view_menu_top = (View) findViewById(R.id.menu_top_swap);
        TextView txtTitle = (TextView) view_menu_top.findViewById(R.id.txt_title);
        txtTitle.setText("Swap");
        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
        ImageView img_component = (ImageView) findViewById(R.id.img_menu_component);
        img_component.setVisibility(View.INVISIBLE);
        ImageView imageView_back=(ImageView) findViewById(R.id.img_menu);
        imageView_back.setImageResource(R.drawable.back_interact);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //------------------------------------------------------------
        listSwap.add("Any");
        listSwap.add("The Last Painting of Sara de Vos");
        listSwap.add("The Last Painting");
        listSwap.add("Never a Dull Moment");
        listSwap.add("A Nation on the Brink");
        listSwap.add("1634 the Baltic War");
        listSwap.add("Any");
        listSwap.add("The Last Painting of Sara de Vos");
        listSwap.add("The Last Painting");
        listSwap.add("Never a Dull Moment");
        listSwap.add("A Nation on the Brink");
        listSwap.add("1634 the Baltic War");
        AdapterSwap adapter = new AdapterSwap(SwapActivity.this,listSwap);
        listView=(ListView) findViewById(R.id.listView_swap);
        listView.setAdapter(adapter);


        TextView btn_Swap=(TextView) findViewById(R.id.btn_swap);
        TextView btn_add_book=(TextView) findViewById(R.id.btn_add_book);

        btn_Swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SwapActivity.this, ListingsDetailActivity.class);
                intent.putExtra("type",4);
                startActivity(intent);
            }
        });
        btn_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SwapActivity.this, AddbookActivity.class);
                startActivity(intent);
            }
        });
    }

}