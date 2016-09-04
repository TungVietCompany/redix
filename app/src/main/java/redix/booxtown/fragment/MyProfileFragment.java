package redix.booxtown.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.model.Explore;

public class MyProfileFragment extends Fragment {
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    ImageView img_component;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.my_profile_fragment, container, false);

        ImageView img_menu_personal_dashboard = (ImageView)view.findViewById(R.id.img_menu_personal_dashboard);
        img_menu_personal_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callFragment(new MyProfileDashboardFragment());
            }
        });

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

        final AdapterListings adapter = new AdapterListings(getActivity(),listEx);
        grid=(GridView)view.findViewById(R.id.grid_myprofile);
        grid.setAdapter(adapter);

        View view_tab=(View)view.findViewById(R.id.tab_myprofile);
        final CustomTabbarExplore tab_custom=new CustomTabbarExplore(view_tab,getActivity());
        linear_all=(LinearLayout) view_tab.findViewById(R.id.linear_all);
        linear_swap=(LinearLayout) view_tab.findViewById(R.id.linear_swap);
        linear_free=(LinearLayout) view_tab.findViewById(R.id.linear_free);
        linear_cart=(LinearLayout) view_tab.findViewById(R.id.linear_cart);

        linear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(getActivity(),filterExplore(1),1);
                grid=(GridView)view.findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                tab_custom.setDefault(1);
            }
        });

        linear_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(getActivity(),filterExplore(2),1);
                grid=(GridView)view.findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);

                tab_custom.setDefault(2);
            }
        });

        linear_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(getActivity(),filterExplore(3),1);
                grid=(GridView)view.findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tab_custom.setDefault(3);
            }
        });

        linear_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AdapterExplore adapter = new AdapterExplore(getActivity(),filterExplore(4),1);
                grid=(GridView)view.findViewById(R.id.grid_myprofile);
                grid.setAdapter(adapter);
                tab_custom.setDefault(4);
            }
        });

        return view;
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
    public void callFragment(Fragment fragment ){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }
}
