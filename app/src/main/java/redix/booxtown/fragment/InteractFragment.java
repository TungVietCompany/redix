package redix.booxtown.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.recyclerClick.RecyclerItemClickListener;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterInteract;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Interact;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractFragment extends Fragment
{

    ArrayList<Interact> listInteract= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.interact_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        Picasso.with(getContext()).load(R.drawable.btn_menu_locate).into(imageView_back);
//        imageView_back.setImageResource(R.drawable.btn_menu_locate);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });
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
        lv_recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Interact item = (Interact) listInteract.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("thread", item);
                        InteractThreadFragment fragment= new InteractThreadFragment();
                        fragment.setArguments(bundle);
                        callFragment(fragment);
                    }
                })
        );

        return view;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_main_all, fragment);
        transaction.commit();
    }


}
