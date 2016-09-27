package redix.booxtown.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import redix.booxtown.R;
import redix.booxtown.controller.ThreadController;
import redix.booxtown.controller.TopicController;
import redix.booxtown.model.Thread;
import redix.booxtown.model.Topic;

/**
 * Created by thuyetpham94 on 16/09/2016.
 */
public class AdapterThread extends RecyclerView.Adapter<AdapterThread.RecyclerViewHolder> {
    Context context;
    private List<Thread> listThread;
    public AdapterThread(Context context, List<Thread> listThread) {
        this.listThread = listThread;
        this.context = context;

    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.custom_interact, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final Thread thread= listThread.get(position);
        holder.txt_title_interact.setText(listThread.get(position).getTitle());
        holder.txt_dateUpdate_interact.setText("Added by "+ listThread.get(position).getUsername());
        holder.txt_count_interact.setText("("+listThread.get(position).getNum_comment()+")");
        if(listThread.get(position).getIs_read()==0){
            holder.txt_count_interact.setTextColor(context.getResources().getColor(R.color.color_text));
        }

//        holder.txt_title_interact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//                String session_id = pref.getString("session_id", null);
//                ThreadSync changeStatus = new ThreadSync(context, session_id, Integer.parseInt(thread.getId()));
//                changeStatus.execute();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listThread.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView txt_title_interact;
        public TextView txt_count_interact;
        public TextView txt_dateUpdate_interact;
        ImageView imageView;
        RelativeLayout topic_interact;
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


}
