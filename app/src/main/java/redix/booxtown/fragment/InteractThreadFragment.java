package redix.booxtown.fragment;

import android.app.Dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterInteractThread;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Interact;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractThreadFragment extends Fragment
{

    ArrayList<InteractThread> listInteractThreads= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;
    Interact interact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.interact_thread_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        Picasso.with(getContext()).load(R.drawable.btn_sign_in_back).into(imageView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new InteractFragment());
            }
        });

        //-----------------------------------------------
        interact = (Interact) getArguments().getSerializable("thread");
        //--------------------------------------------------
        TextView txt_title_thread=(TextView) view.findViewById(R.id.txt_title_thread);
        TextView txt_count_thread=(TextView) view.findViewById(R.id.txt_count_thread);
        txt_title_thread.setText(interact.getInteractTitle());
        txt_count_thread.setText("("+interact.getInteractCount()+")");
        //------------------------------------------------------------------------------
        TextView btn_add_thread = (TextView) view.findViewById(R.id.btn_add_thread);
        btn_add_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_interact_addthread);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                ImageView imv_dialog_interacr_close = (ImageView)dialog.findViewById(R.id.imv_dialog_interacr_close);
                Picasso.with(getContext()).load(R.drawable.btn_close_filter).into(imv_dialog_interacr_close);
                imv_dialog_interacr_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btn_dialog_interact_submit = (Button)dialog.findViewById(R.id.btn_dialog_interact_submit);
                btn_dialog_interact_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //submit dialog add thread
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        //end

        InteractThread interact1= new InteractThread();
        interact1.setInteractThreadTitle("Thread one text");
        interact1.setInteractThreadCount("20");
        interact1.setStatus(true);
        interact1.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        interact1.setInteractThreadAddBy("Derek Jarma");


        InteractThread interact2= new InteractThread();
        interact2.setInteractThreadTitle("Evil Queen: The Last Paintings");
        interact2.setInteractThreadCount("15");
        interact2.setStatus(true);
        interact2.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        interact2.setInteractThreadAddBy("Richard D.Marshall");



        InteractThread interact3= new InteractThread();
        interact3.setInteractThreadTitle("Joan Mitchell, The Last Paintings");
        interact3.setInteractThreadCount("35");
        interact3.setStatus(false);
        interact3.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        interact3.setInteractThreadAddBy("Derek Jarma");


        InteractThread interact4= new InteractThread();
        interact4.setInteractThreadTitle("Ad Reinhardt: Last Paintings");
        interact4.setInteractThreadCount("23");
        interact4.setStatus(false);
        interact4.setInteractThreadContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        interact4.setInteractThreadAddBy("heinz Liesbrock");


        listInteractThreads.add(interact1);
        listInteractThreads.add(interact2);
        listInteractThreads.add(interact3);
        listInteractThreads.add(interact4);

        //-----------------------------------------------------------
        final AdapterInteractThread adapter = new AdapterInteractThread(getActivity(),listInteractThreads);
        listView=(ListView) view.findViewById(R.id.list_interact_thread);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InteractThread item = (InteractThread) listInteractThreads.get(position);

                Bundle bundle = new Bundle();
                bundle.putSerializable("thread", item);
                bundle.putSerializable("interact", interact);
                InteractThreadDetailsFragment fragment= new InteractThreadDetailsFragment();
                fragment.setArguments(bundle);
                callFragment(fragment);
            }
        });

        //------------------------------------------------------------------------------

        return view;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.commit();
    }
}

