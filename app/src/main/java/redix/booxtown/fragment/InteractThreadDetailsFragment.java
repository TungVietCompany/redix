package redix.booxtown.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import redix.booxtown.R;
import redix.booxtown.activity.HomeActivity;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.controller.CommentController;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Comment;
import redix.booxtown.model.Thread;
import redix.booxtown.model.Topic;

/**
 * Created by Administrator on 28/08/2016.
 */
public class InteractThreadDetailsFragment extends Fragment
{

    ListView listView;
    private MenuBottomCustom menu_bottom;
    Thread threads;
    Topic topic;
    TextView txt_title;
    AdapterInteractThreadDetails adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.interact_thread_detail_fragment, container, false);

        txt_title=(TextView) getActivity().findViewById(R.id.txt_title);
        txt_title.setText("Interact");

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        imageView_back.setImageResource(R.drawable.btn_sign_in_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(topic !=null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("thread", topic);
                    ThreadFragment fragment = new ThreadFragment();
                    fragment.setArguments(bundle);
                    callFragment(fragment);
                }
                else {
                    HomeActivity home= (HomeActivity)getActivity();
                    home.callFragment(new NotificationFragment());
                    txt_title.setText("Notifications");
                }

            }
        });

        //----------------------------------------------
        threads = (Thread) getArguments().getSerializable("thread");
        topic = (Topic) getArguments().getSerializable("interact");
        //--------------------------------------------------
        TextView txt_title_thread=(TextView) view.findViewById(R.id.txt_title_thread_detail);
        TextView txt_count_thread=(TextView) view.findViewById(R.id.txt_count_thread_detail);
        TextView txt_content_thread=(TextView) view.findViewById(R.id.txt_contern_thread_details);
        TextView txt_author_thread=(TextView) view.findViewById(R.id.txt_author_interact_thread_detail);
        txt_title_thread.setText(threads.getTitle()+"");
//        txt_count_thread.setText("("+interactThreads.getInteractThreadCount()+")");
        txt_content_thread.setText(threads.getDescription());
        txt_author_thread.setText("Added by "+threads.getUsername());


//        ArrayList<InteractComment> list= new ArrayList<>();
//        InteractComment interactComment1= new InteractComment(2.5f,true,false,true,"Gandalf","If you want to buy best books order us1","June 12 at 5:14 pm");
//        InteractComment interactComment2= new InteractComment(3.0f,true,true,true,"Gandalf2","If you want to buy best books order us2","June 12 at 5:14 pm");
//        InteractComment interactComment3= new InteractComment(4.0f,false,false,true,"Gandalf3","If you want to buy best books order us3","June 12 at 5:14 pm");
//        InteractComment interactComment4= new InteractComment(3.5f,true,false,false,"Gandalf4","If you want to buy best books order us4","June 12 at 5:14 pm");
//        InteractComment interactComment5= new InteractComment(5.0f,true,false,false,"Gandalf5","If you want to buy best books order us5","June 12 at 5:14 pm");
//
//        list.add(interactComment1);
//        list.add(interactComment2);
//        list.add(interactComment3);
//        list.add(interactComment4);
//        list.add(interactComment5);


        //-----------------------------------------------------------

        listView=(ListView) view.findViewById(R.id.listview_comments);
        listView.setDivider(null);
        listView.setAdapter(adapter);

        commentAsync commentAsync1 = new commentAsync(getContext());
        commentAsync1.execute(threads.getId());

        SharedPreferences pref = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor  = pref.edit();
        final String session_id = pref.getString("session_id", null);


        final EditText edit_message = (EditText)view.findViewById(R.id.edit_message);

        final ImageView btn_send_comment_interact = (ImageView)view.findViewById(R.id.btn_send_comment_interact);
        btn_send_comment_interact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertComment insertComment1 = new insertComment(getContext());
                insertComment1.execute(session_id,edit_message.getText().toString(),threads.getId());
                edit_message.setText("");
            }
        });
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
    class commentAsync extends AsyncTask<String,Void,List<Comment>>{

        Context context;
        ProgressDialog dialog;
        public commentAsync(Context context){
            this.context = context;
        }
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            dialog.setMessage("please waiting...");
            dialog.show();
        }

        @Override
        protected List<Comment> doInBackground(String... strings) {
            CommentController commentController = new CommentController();
            return commentController.getallcomment(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Comment> comments) {
            try {
                if(comments.size() >0){
                    adapter = new AdapterInteractThreadDetails(context,comments);
                    listView.setAdapter(adapter);
                    dialog.dismiss();
                }
            }catch (Exception e){
                dialog.dismiss();
            }
        }
    }

    class insertComment extends AsyncTask<String,Void,Boolean>{

        Context context;
        ProgressDialog dialog;
        public insertComment(Context context){
            this.context = context;
        }
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            dialog.setMessage("please waiting...");
            dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            CommentController comment = new CommentController();
            return comment.insertComment(strings[0],strings[1],strings[2]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            try {
                if(aBoolean == true){
                    Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }else {
                    Toast.makeText(context,"no success",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }catch (Exception e){
                dialog.dismiss();
            }

        }
    }
}

