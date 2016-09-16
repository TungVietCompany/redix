package redix.booxtown.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.controller.TopicController;
import redix.booxtown.model.Topic;
import redix.booxtown.recyclerClick.RecyclerItemClickListener;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterTopic;
import redix.booxtown.model.Interact;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractFragment extends Fragment
{

    List<Topic> listtopic= new ArrayList<>();
    RecyclerView lv_recycler;
    AdapterTopic interact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.interact_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        Picasso.with(getContext()).load(R.drawable.btn_menu_locate).into(imageView_back);
//        imageView_back.setImageResource(R.drawable.btn_menu_locate);
        topicSync getalltopic = new topicSync(getContext());
        getalltopic.execute();
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        //-----------------------------------------------------------
        lv_recycler=(RecyclerView) view.findViewById(R.id.list_view_interact);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        lv_recycler.setLayoutManager(layoutManager);

        return view;
    }
    public void callFragment(Fragment fragment ){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_main_all, fragment);
        transaction.commit();
    }

    public class topicSync extends AsyncTask<Void,Void,List<Topic>>{
        ProgressDialog dialog;
        Context context;
        public topicSync(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected List<Topic> doInBackground(Void... params) {
            TopicController topicController = new TopicController();
            return topicController.getalltopic();
        }

        @Override
        protected void onPostExecute(final List<Topic> topics) {
            try{
                if(topics.size() >0){
                    //set adapter
                    interact = new AdapterTopic(context,topics);
                    lv_recycler.setAdapter(interact);

                    lv_recycler.addOnItemTouchListener(
                            new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Topic item = (Topic) topics.get(position);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("thread", item);
                                    InteractThreadFragment fragment= new InteractThreadFragment();
                                    fragment.setArguments(bundle);
                                    callFragment(fragment);
                                }
                            })
                    );

                    //end
                }else {
                    Toast.makeText(context,"No data",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){

            }
            dialog.dismiss();
            super.onPostExecute(topics);
        }
    }




}
