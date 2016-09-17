package redix.booxtown.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterFilter;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.adapter.ListBookAdapter;
import redix.booxtown.controller.BookController;
import redix.booxtown.custom.CustomSearch;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Book;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 26/08/2016.
 */
public class ExploreFragment extends Fragment
{
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    EditText editSearch;
    ListBookAdapter adapter;
    public TextView tab_all_count,tab_swap_count,tab_free_count,tab_cart_count;
    List<Book> listbook= new ArrayList<>();
    GridView grid;
    ImageView img_component;
    private MenuBottomCustom bottomExplore;
    public static String [] prgmNameList1={"Nearest distance","Price low to high","Price high to low","Recently added"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.explore_fragment, container, false);

        ImageView img_menu = (ImageView)getActivity().findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });
        grid=(GridView)view.findViewById(R.id.gridView);
        View view_search= (View)view.findViewById(R.id.explore_search);
        new CustomSearch(view_search,getActivity());

        //-----------------------------------------------------------
        Getallbook getallbook = new Getallbook();
        getallbook.execute();
        filterSort(view);
        //end-------------------------------------

        //---------------------------------------------------------------
        View view_tab=(View) view.findViewById(R.id.tab_explore);
        final CustomTabbarExplore tab_custom=new CustomTabbarExplore(view_tab,getActivity());

        linear_all=(LinearLayout) view_tab.findViewById(R.id.linear_all);
        linear_swap=(LinearLayout) view_tab.findViewById(R.id.linear_swap);
        linear_free=(LinearLayout) view_tab.findViewById(R.id.linear_free);
        linear_cart=(LinearLayout) view_tab.findViewById(R.id.linear_cart);
        tab_all_count = (TextView) view_tab.findViewById(R.id.tab_all_count) ;
        tab_cart_count = (TextView) view_tab.findViewById(R.id.tab_cart_count) ;
        tab_free_count = (TextView) view_tab.findViewById(R.id.tab_free_count) ;
        tab_swap_count = (TextView) view_tab.findViewById(R.id.tab_swap_count) ;
        editSearch = (EditText) view.findViewById(R.id.editSearch);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        linear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListBookAdapter adapter = new ListBookAdapter(getActivity(),filterExplore(1),2);
                grid=(GridView) view.findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                tab_custom.setDefault(1);
            }
        });

        linear_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListBookAdapter adapter = new ListBookAdapter(getActivity(),filterExplore(2),2);
                grid=(GridView)view.findViewById(R.id.gridView);
                grid.setAdapter(adapter);

                tab_custom.setDefault(2);
            }
        });

        linear_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListBookAdapter adapter = new ListBookAdapter(getActivity(),filterExplore(3),2);
                grid=(GridView)view.findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tab_custom.setDefault(3);
            }
        });

        linear_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListBookAdapter adapter = new ListBookAdapter(getActivity(),filterExplore(4),2);
                grid=(GridView)view.findViewById(R.id.gridView);
                grid.setAdapter(adapter);
                tab_custom.setDefault(4);
            }
        });


        return view;
    }


    public List<Book> filterExplore(int type){
        List<Book> list= new ArrayList<>();
        if(type==1){
            list = listbook;
        }
        else if(type==2){
            for (int i=0; i<listbook.size(); i++){
                if(listbook.get(i).getAction().equals("100")){
                    list.add(listbook.get(i));
                }
            }
        }
        else if(type==3){
            for (int i=0; i<listbook.size(); i++){
                if(listbook.get(i).getAction().equals("010")){
                    list.add(listbook.get(i));
                }
            }
        }
        else{
            for (int i=0; i<listbook.size(); i++){
                if(listbook.get(i).getAction().equals("001")){
                    list.add(listbook.get(i));
                }
            }
        }

        return list;
    }
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }
    public void filterSort(View view){
        ImageView btn_filter_explore = (ImageView)view.findViewById(R.id.btn_filter_explore);
        Picasso.with(getContext()).load(R.drawable.btn_locate_filter).into(btn_filter_explore);

        ImageView btn_search = (ImageView)view.findViewById(R.id.btn_search);
        Picasso.with(getContext()).load(R.drawable.btn_locate_search).into(btn_search);

        btn_filter_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_filter_sort);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ListView lv_dialog_filter = (ListView)dialog.findViewById(R.id.lv_dialog_filter);
                lv_dialog_filter.setAdapter(new AdapterFilter(getActivity(),prgmNameList1));

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
                Picasso.with(getContext()).load(R.drawable.btn_close_filter).into(imv_dialog_filter_close);
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
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(dataAdapter);
            }
        });
    }

    public class Getallbook extends AsyncTask<Void,Void,List<Book>>{
        @Override
        protected List<Book> doInBackground(Void... params) {
            BookController bookController = new BookController();
            listbook  =  bookController.getallbook();
            return listbook;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Book> list) {
            super.onPostExecute(list);
            adapter = new ListBookAdapter(getActivity(),list,2);
            grid.setAdapter(adapter);
            tab_all_count.setText("("+String.valueOf(filterExplore(1).size()+")"));
            tab_swap_count.setText("("+String.valueOf(filterExplore(2).size()+")"));
            tab_free_count.setText("("+String.valueOf(filterExplore(3).size()+")"));
            tab_cart_count.setText("("+String.valueOf(filterExplore(4).size()+")"));
        }
    }
}
