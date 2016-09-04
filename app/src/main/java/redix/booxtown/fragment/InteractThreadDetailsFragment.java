package redix.booxtown.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Interact;
import redix.booxtown.model.InteractComment;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 28/08/2016.
 */
public class InteractThreadDetailsFragment extends Fragment
{

    ArrayList<InteractComment> listInteractThreads= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;
    InteractThread interactThreads;
    Interact interact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.interact_thread_detail_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        imageView_back.setImageResource(R.drawable.btn_sign_in_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("thread", interact);
                InteractThreadFragment fragment= new InteractThreadFragment();
                fragment.setArguments(bundle);
                callFragment(fragment);

            }
        });

        //----------------------------------------------
        interactThreads = (InteractThread) getArguments().getSerializable("thread");
        interact = (Interact) getArguments().getSerializable("interact");
        //--------------------------------------------------
        TextView txt_title_thread=(TextView) view.findViewById(R.id.txt_title_thread_detail);
        TextView txt_count_thread=(TextView) view.findViewById(R.id.txt_count_thread_detail);
        TextView txt_content_thread=(TextView) view.findViewById(R.id.txt_contern_thread_details);
        TextView txt_author_thread=(TextView) view.findViewById(R.id.txt_author_interact_thread_detail);
        txt_title_thread.setText(interactThreads.getInteractThreadTitle()+"");
        txt_count_thread.setText("("+interactThreads.getInteractThreadCount()+")");
        txt_content_thread.setText(interactThreads.getInteractThreadContent());
        txt_author_thread.setText("Added by "+interactThreads.getInteractThreadAddBy());


        ArrayList<InteractComment> list= new ArrayList<>();
        InteractComment interactComment1= new InteractComment(2.5f,true,false,true,"Gandalf","If you want to buy best books order us1","June 12 at 5:14 pm");
        InteractComment interactComment2= new InteractComment(3.0f,true,true,true,"Gandalf2","If you want to buy best books order us2","June 12 at 5:14 pm");
        InteractComment interactComment3= new InteractComment(4.0f,false,false,true,"Gandalf3","If you want to buy best books order us3","June 12 at 5:14 pm");
        InteractComment interactComment4= new InteractComment(3.5f,true,false,false,"Gandalf4","If you want to buy best books order us4","June 12 at 5:14 pm");
        InteractComment interactComment5= new InteractComment(5.0f,true,false,false,"Gandalf5","If you want to buy best books order us5","June 12 at 5:14 pm");

        list.add(interactComment1);
        list.add(interactComment2);
        list.add(interactComment3);
        list.add(interactComment4);
        list.add(interactComment5);


        //-----------------------------------------------------------
        final AdapterInteractThreadDetails adapter = new AdapterInteractThreadDetails(getActivity(),list);
        listView=(ListView) view.findViewById(R.id.listview_comments);
        listView.setDivider(null);
        listView.setAdapter(adapter);
        //---------------------------------------------------------------

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

