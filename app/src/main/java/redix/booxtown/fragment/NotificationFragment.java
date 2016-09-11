package redix.booxtown.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.recyclerClick.RecyclerItemClickListener;
import redix.booxtown.activity.HomeActivity;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.activity.NotificationDominicActivity;
import redix.booxtown.activity.NotificationSellActivity;
import redix.booxtown.activity.NotificationSwapActivity;
import redix.booxtown.custom.Custom_ListView_Notification;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.InteractThread;

public class NotificationFragment extends Fragment {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout1;
    public static String [] prgmNameList={"Unread","Dominic send a swap request","Dominic want to your book","Dominic reject your swap request"};
    private MenuBottomCustom bottomListings;
    public boolean flag=true;
    HomeActivity main;
    ArrayList<InteractThread> listInteractThreads= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        main = (HomeActivity) getActivity();
        View view = inflater.inflate(R.layout.notification_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        imageView_back.setImageResource(R.drawable.btn_menu_locate);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        //listview content notification
        RecyclerView lv_notification=(RecyclerView) view.findViewById(R.id.lv_content_notification);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        lv_notification.setLayoutManager(layoutManager);
        Custom_ListView_Notification menu = new Custom_ListView_Notification(getActivity(),prgmNameList,prgmNameList);
        lv_notification.setAdapter(menu);
        lv_notification.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        if(i==0){
                            InteractThread interact1= new InteractThread();
                            interact1.setInteractThreadTitle("Thread one text");
                            interact1.setInteractThreadCount("20");
                            interact1.setStatus(true);
                            interact1.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
                            interact1.setInteractThreadAddBy("Derek Jarma");
                            listInteractThreads.add(interact1);
                            InteractThread item = (InteractThread) listInteractThreads.get(0);
                            InteractThreadDetailsFragment fragment= new InteractThreadDetailsFragment();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("thread", item);
                            fragment.setArguments(bundle);
                            main.callFragment(fragment);

                        }else if(i==1){
                            Intent intent = new Intent(getActivity(),NotificationSwapActivity.class);
                            startActivity(intent);
                        }else if(i==2){
                            Intent intent1 = new Intent(getActivity(),NotificationSellActivity.class);
                            startActivity(intent1);
                        }else if(i==3){
                            Intent intent2 = new Intent(getActivity(),NotificationDominicActivity.class);
                            startActivity(intent2);
                        }
                    }
                })
        );
        return view;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.add(R.id.frame_main_all, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
