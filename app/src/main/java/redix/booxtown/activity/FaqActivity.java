package redix.booxtown.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_Listview_faq;
import redix.booxtown.custom.MenuBottomCustom;

public class FaqActivity extends Fragment {
    public static String [] prgmNameList={"General","Sell","Swap","Buy","Donate"};
    private MenuBottomCustom bottomListings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_faq, container, false);
        RecyclerView listView_faq = (RecyclerView)view.findViewById(R.id.lv_content_faq);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getContext());
        listView_faq.setLayoutManager(layoutManager);
        //set adapter
        Custom_Listview_faq custom_faq = new Custom_Listview_faq(getContext(),prgmNameList);
        listView_faq.setAdapter(custom_faq);
        return view;
    }
}
