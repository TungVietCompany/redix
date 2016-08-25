package redix.booxtown.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import redix.booxtown.Notification;
import redix.booxtown.R;

/**
 * Created by thuyetpham94 on 25/08/2016.
 */
public class Custom_ListView_Notification extends BaseAdapter {
    String [] result;
    Context context;
    String [] imageId;
    private static LayoutInflater inflater=null;
    public Custom_ListView_Notification(Notification mainActivity, String[] prgmNameList, String[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv_content;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_listview_notification, null);
        holder.tv=(TextView) rowView.findViewById(R.id.txt_title_notification);
        holder.tv_content=(TextView) rowView.findViewById(R.id.txt_content_notification);
        holder.tv.setText(result[position]);
        holder.tv_content.setText(result[position]);
        return rowView;
    }
}
