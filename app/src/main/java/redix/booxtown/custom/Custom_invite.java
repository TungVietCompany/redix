package redix.booxtown.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import redix.booxtown.R;

/**
 * Created by thuyetpham94 on 25/08/2016.
 */
public class Custom_invite extends BaseAdapter {
    String [] result;
    Context context;
    private static LayoutInflater inflater=null;
    public Custom_invite(Context context, String[] prgmNameList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        this.context=context;
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
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_listview_content_invite, null);
        holder.tv=(TextView) rowView.findViewById(R.id.txt_content_listview_invite);
        holder.tv.setText(result[position]);
        return rowView;
    }

}