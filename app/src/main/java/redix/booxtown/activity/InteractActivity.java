package redix.booxtown.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.RecyclerClick.RecyclerItemClickListener;
import redix.booxtown.adapter.AdapterExplore;
import redix.booxtown.adapter.AdapterInteract;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.CustomSearch;
import redix.booxtown.custom.CustomTabbarExplore;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Explore;
import redix.booxtown.model.Interact;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractActivity extends Fragment
{

    ArrayList<Interact> listInteract= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_interact, container, false);

        Interact interact1= new Interact();
        interact1.setInteractTitle("Topic Name goes here");
        interact1.setInteractCount("20");
        interact1.setStatus(true);
        interact1.setInteractUpdatetime("27-08-2016");

        Interact interact2= new Interact();
        interact2.setInteractTitle("The Last Painting");
        interact2.setInteractCount("22");
        interact2.setStatus(true);
        interact2.setInteractUpdatetime("27-08-2016");

        Interact interact3= new Interact();
        interact3.setInteractTitle("A Nation on the Brink");
        interact3.setInteractCount("33");
        interact3.setStatus(false);
        interact3.setInteractUpdatetime("29-08-2016");

        Interact interact4= new Interact();
        interact4.setInteractTitle("The Last Painting");
        interact4.setInteractCount("69");
        interact4.setStatus(false);
        interact4.setInteractUpdatetime("30-08-2016");

        listInteract.add(interact1);
        listInteract.add(interact2);
        listInteract.add(interact3);
        listInteract.add(interact4);

        //-----------------------------------------------------------
        RecyclerView lv_recycler=(RecyclerView) view.findViewById(R.id.list_view_interact);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        lv_recycler.setLayoutManager(layoutManager);

        //set adapter
        AdapterInteract interact = new AdapterInteract(getActivity(),listInteract);
        lv_recycler.setAdapter(interact);
        //end

        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_interact);
//
//        //--------------------------------------------------
//        View view=(View) findViewById(R.id.menu_interact_top);
//        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
//        txtTitle.setText("Interact");
//        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
//        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
//        img_component.setVisibility(View.INVISIBLE);
//        ImageView img_menu = (ImageView)findViewById(R.id.img_menu);
//        img_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(InteractActivity.this,MenuActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //--------------------------------------------------
//        View view_bottom = (View)findViewById(R.id.menu_interact_bottom);
//        menu_bottom=new MenuBottomCustom(view_bottom,this,2);
//        menu_bottom.setDefaut(2);
//        //---------------------------------------------------------------
//
//
//        Interact interact1= new Interact();
//        interact1.setInteractTitle("Topic Name goes here");
//        interact1.setInteractCount("20");
//        interact1.setStatus(true);
//        interact1.setInteractUpdatetime("27-08-2016");
//
//        Interact interact2= new Interact();
//        interact2.setInteractTitle("The Last Painting");
//        interact2.setInteractCount("22");
//        interact2.setStatus(true);
//        interact2.setInteractUpdatetime("27-08-2016");
//
//        Interact interact3= new Interact();
//        interact3.setInteractTitle("A Nation on the Brink");
//        interact3.setInteractCount("33");
//        interact3.setStatus(false);
//        interact3.setInteractUpdatetime("29-08-2016");
//
//        Interact interact4= new Interact();
//        interact4.setInteractTitle("The Last Painting");
//        interact4.setInteractCount("69");
//        interact4.setStatus(false);
//        interact4.setInteractUpdatetime("30-08-2016");
//
//        listInteract.add(interact1);
//        listInteract.add(interact2);
//        listInteract.add(interact3);
//        listInteract.add(interact4);
//
//        //-----------------------------------------------------------
//        RecyclerView lv_recycler=(RecyclerView) findViewById(R.id.list_view_interact);
//        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
//        lv_recycler.setLayoutManager(layoutManager);
//
//        //set adapter
//        AdapterInteract interact = new AdapterInteract(InteractActivity.this,listInteract);
//        lv_recycler.setAdapter(interact);
//        //end
//
//        lv_recycler.addOnItemTouchListener(
//                new RecyclerItemClickListener(InteractActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        Interact item = (Interact) listInteract.get(position);
//                        Intent intent = new Intent(InteractActivity.this,InteractThreadActivity.class);
//                        intent.putExtra("thread",item);
//                        //based on item add info to intent
//                        startActivity(intent);
//                    }
//                })
//        );
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//       // menu_bottom.setDefaut(1);
//       finish();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        menu_bottom.setDefaut(2);
//    }
}
