package redix.booxtown.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_Listview_faq;
import redix.booxtown.custom.MenuBottomCustom;

public class FaqActivity extends AppCompatActivity {
    public static String [] prgmNameList={"General","Sell","Swap","Buy","Donate"};
    private MenuBottomCustom bottomListings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        RecyclerView listView_faq = (RecyclerView)findViewById(R.id.lv_content_faq);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
        listView_faq.setLayoutManager(layoutManager);
        //set adapter
        Custom_Listview_faq custom_faq = new Custom_Listview_faq(FaqActivity.this,prgmNameList);
        listView_faq.setAdapter(custom_faq);
        //end
        ImageView menu =
                (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaqActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //icon back
        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("FAQ");
        //bottom
        //--------------------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_faq);
        bottomListings=new MenuBottomCustom(view_bottom,this,0);
        bottomListings.setDefaut(0);
        //---------------------------------------------------------------
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bottomListings.setDefaut(0);
    }
}
