package redix.booxtown.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.controller.TopicController;
import redix.booxtown.fragment.ThreadFragment;
import redix.booxtown.fragment.TopicFragment;
import redix.booxtown.model.Interact;
import redix.booxtown.model.Topic;
import redix.booxtown.recyclerClick.RecyclerItemClickListener;

/**
 * Created by Administrator on 27/08/2016.
 */
public class AdapterTopic extends RecyclerView.Adapter<AdapterTopic.RecyclerViewHolder> {
    Context context;
    private List<Topic> listTopic;
    View itemView;
    public AdapterTopic(Context context, List<Topic> listTopic) {
        this.listTopic = listTopic;
        this.context = context;

    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        itemView = inflater.inflate(R.layout.custom_interact, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final Topic interact = listTopic.get(position);
        holder.txt_title_interact.setText(interact.getTitle());
        holder.txt_count_interact.setText("(" + interact.getNum_thread() + ")");
        if (interact.getIs_read() == 0) {
            holder.txt_count_interact.setTextColor(context.getResources().getColor(R.color.color_text));
            holder.topic_interact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    String session_id = pref.getString("session_id", null);
                    topicSync changeStatus = new topicSync(context, session_id, Integer.parseInt(interact.getId()));
                    changeStatus.execute();
                }
            });
        } else {
            holder.txt_count_interact.setTextColor(context.getResources().getColor(R.color.color_topic_interact));
        }
        holder.txt_dateUpdate_interact.setText("Last Updated on " + interact.getCreate_date());

    }

    @Override
    public int getItemCount() {
        return listTopic.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView txt_title_interact;
        public TextView txt_count_interact;
        public TextView txt_dateUpdate_interact;
        ImageView imageView;
        public RelativeLayout topic_interact;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            topic_interact=(RelativeLayout) itemView.findViewById(R.id.topic_interact);
            txt_title_interact = (TextView) itemView.findViewById(R.id.txt_title_interact);
            txt_count_interact = (TextView) itemView.findViewById(R.id.txt_count_interact);
            txt_dateUpdate_interact = (TextView) itemView.findViewById(R.id.txt_time_update_interact);
            imageView = (ImageView)itemView.findViewById(R.id.imageView_next_interac);
            Picasso.with(context).load(R.drawable.btn_interact_next).into(imageView);
        }
    }

    public class topicSync extends AsyncTask<Void,Void,Boolean> {
        ProgressDialog dialog;
        Context context;
        String session_id;
        int thread_id;
        public topicSync(Context context,String session_id,int thread_id){
            this.context = context;
            this.session_id=session_id;
            this.thread_id=thread_id;

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
        protected Boolean doInBackground(Void... params) {
            TopicController topicController = new TopicController();
            return topicController.changeStatusTopic(session_id,thread_id);
        }

        @Override
        protected void onPostExecute(final Boolean topics) {
            try{
                if(topics){
                    //RecyclerViewHolder holder=  new RecyclerViewHolder(itemView);
                   // holder.txt_count_interact.setTextColor(context.getResources().getColor(R.color.color_topic_interact));
                }

            }catch (Exception e){

            }
            dialog.dismiss();

        }
    }
}
