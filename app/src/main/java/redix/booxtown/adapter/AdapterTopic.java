package redix.booxtown.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.model.Interact;
import redix.booxtown.model.Topic;

/**
 * Created by Administrator on 27/08/2016.
 */
public class AdapterTopic extends RecyclerView.Adapter<AdapterTopic.RecyclerViewHolder> {
    Context context;
    private List<Topic> listTopic;
    public AdapterTopic(Context context, ArrayList<Topic> listTopic) {
        this.listTopic = listTopic;
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
        Topic interact= listTopic.get(position);
        holder.txt_title_interact.setText(interact.getTitle());
//        holder.txt_count_interact.setText("("+interact.getInteractCount()+")");
//        if(interact.isStatus()) {
//            holder.txt_count_interact.setTextColor(context.getResources().getColor(R.color.color_text));
//        }
        holder.txt_dateUpdate_interact.setText("Last Updated on "+ interact.getCreate_date());
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

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txt_title_interact = (TextView) itemView.findViewById(R.id.txt_title_interact);
            txt_count_interact = (TextView) itemView.findViewById(R.id.txt_count_interact);
            txt_dateUpdate_interact = (TextView) itemView.findViewById(R.id.txt_time_update_interact);
            imageView = (ImageView)itemView.findViewById(R.id.imageView_next_interac);
            Picasso.with(context).load(R.drawable.btn_interact_next).into(imageView);
        }
    }
}
