package redix.booxtown.activity;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.custom.NewAdapter;

public class Faq_content extends ExpandableListActivity {
    private CoordinatorLayout coordinatorLayout;
    private MenuBottomCustom bottomListings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_content);

        //expland content
        ExpandableListView expandableListView = getExpandableListView();

        setGroupData();
        setChildGroupData();

        NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
        mNewAdapter
                .setInflater(
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                        this);
        expandableListView.setAdapter(mNewAdapter);
        //end
        //image menu
        //icon back
        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("FAQ");

        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setImageResource(R.drawable.back);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //bottom
        //--------------------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_faq_content);
        bottomListings=new MenuBottomCustom(view_bottom,this,0);
        bottomListings.setDefaut(0);
        //---------------------------------------------------------------
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bottomListings.setDefaut(0);
    }

    public void setGroupData() {
        groupItem.add("TechNology");
        groupItem.add("Mobile");
        groupItem.add("Manufacturer");
        groupItem.add("Extras");
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public void setChildGroupData() {
        /**
         * Add Data For TecthNology
         */
        ArrayList<String> child = new ArrayList<String>();
        child.add("Thanks for the code. Please from now on share code in your question by editing it, " +
                "since it is not readable in comment. Also, please share your main layout");
        childItem.add(child);

        /**
         * Add Data For Mobile
         */
        child = new ArrayList<String>();
        child.add("Thanks for the code. Please from now on share code in your question by editing it," +
                " since it is not readable in comment. Also, please share your main layout");
        childItem.add(child);
        /**
         * Add Data For Manufacture
         */
        child = new ArrayList<String>();
        child.add("Thanks for the code. Please from now on share code in your question by editing it," +
                " since it is not readable in comment. Also, please share your main layout");
        childItem.add(child);
        /**
         * Add Data For Extras
         */
        child = new ArrayList<String>();
        child.add("Thanks for the code. Please from now on share code in your question by editing it," +
                " since it is not readable in comment. Also, please share your main layout");
        childItem.add(child);
    }
}
