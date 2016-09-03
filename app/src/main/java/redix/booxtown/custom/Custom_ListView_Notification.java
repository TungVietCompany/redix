package redix.booxtown.custom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import redix.booxtown.R;

/**
 * Created by thuyetpham94 on 25/08/2016.
 */
public class Custom_ListView_Notification extends RecyclerView.Adapter<Custom_ListView_Notification.RecyclerViewHolder> {
    String [] tv;
    String [] tv_content;
    public Custom_ListView_Notification(String[] tv, String[] tv_content) {
        // TODO Auto-generated constructor stub
        this.tv = tv;
        this.tv_content=tv_content;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.custom_listview_notification, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv.setText(tv[position]);
        holder.tv_content.setText(tv_content[position]);
    }

    @Override
    public int getItemCount() {
        return tv.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        TextView tv_content;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.txt_title_notification);
            tv_content = (TextView)itemView.findViewById(R.id.txt_content_notification);
        }
    }

}
