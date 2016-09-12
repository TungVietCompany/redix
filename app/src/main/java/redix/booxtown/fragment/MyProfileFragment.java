package redix.booxtown.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.controller.UserController;
import redix.booxtown.R;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.model.Explore;
import redix.booxtown.model.User;

public class MyProfileFragment extends Fragment {
    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;
    ArrayList<Explore> listEx= new ArrayList<>();
    GridView grid;
    ImageView img_component;
    TextView txt_profile_email;
    TextView txt_profile_phone;
    TextView txt_profile_birthday;
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

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        Glide.with(getActivity()).load(R.drawable.btn_menu_locate).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView_back);

        ImageView imv_close_dialog_dashboard_status = (ImageView)view.findViewById(R.id.imv_close_dialog_dashboard_status);
        Picasso.with(getContext()).load(R.drawable.btn_rank_one).into(imv_close_dialog_dashboard_status);

        ImageView imageView26 = (ImageView)view.findViewById(R.id.imageView26);
        Picasso.with(getContext()).load(R.drawable.btn_rank_two).into(imageView26);

        ImageView imageView27 = (ImageView)view.findViewById(R.id.imageView27);
        Picasso.with(getContext()).load(R.drawable.btn_rank_three).into(imageView27);

        Profile profile = new Profile(getContext());
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String session_id =  pref.getString("session_id", null);
        profile.execute(session_id);

        //profile
        txt_profile_email = (TextView)view.findViewById(R.id.txt_profile_email);
        txt_profile_phone = (TextView)view.findViewById(R.id.txt_profile_phone);
        txt_profile_birthday = (TextView)view.findViewById(R.id.txt_profile_birthday);
        //end
       // imageView_back.setImageResource(R.drawable.btn_menu_locate);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
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

    class Profile extends AsyncTask<String,Void,List<User>>{
        Context context;
        public Profile(Context context){
            this.context=context;
        }
        ProgressDialog dialog;
        @Override
        protected List<User> doInBackground(String... strings) {
            UserController userController  = new UserController();
            List<User> profile = userController.getprofile(strings[0]);
            return profile;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.show();
        }

        @Override
        protected void onPostExecute(List<User> bookResult) {
            try {
                if(bookResult.size() == 0){
                    Toast.makeText(context,"No data",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }else {
                    txt_profile_email.setText(bookResult.get(0).getEmail());
                    txt_profile_phone.setText(bookResult.get(0).getPhone());
                    txt_profile_birthday.setText(bookResult.get(0).getBirthday());
                    dialog.dismiss();
                }
                super.onPostExecute(bookResult);
            }catch (Exception e){
                Toast.makeText(context,"no data",Toast.LENGTH_LONG).show();
            }

        }
    }


}
