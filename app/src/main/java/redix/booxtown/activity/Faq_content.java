package redix.booxtown.activity;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.custom.NewAdapter;

public class Faq_content extends ExpandableListActivity {
    private CoordinatorLayout coordinatorLayout;
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
