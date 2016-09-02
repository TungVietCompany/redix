package redix.booxtown.activity;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.RecyclerClick.RecyclerItemClickListener;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.Custom_ListView_Notification;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.InteractThread;

public class NotificationActivity extends Fragment {
    ListView lv1;
    Context context;
    RelativeLayout relativeLayout1;
    public static String [] prgmNameList={"Unread","Dominic send a swap request","Dominic want to your book","Dominic reject your swap request"};
    private MenuBottomCustom bottomListings;
    public boolean flag=true;
    ArrayList<InteractThread> listInteractThreads= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_notification, container, false);
        //listview content notification
        RecyclerView lv_notification=(RecyclerView) view.findViewById(R.id.lv_content_notification);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        lv_notification.setLayoutManager(layoutManager);
        Custom_ListView_Notification menu = new Custom_ListView_Notification(prgmNameList,prgmNameList);
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
                            Intent intent = new Intent(getActivity(),InteractThreadDetailsActivity.class);
                            intent.putExtra("threadDetail",item);
                            startActivity(intent);
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
}
