package redix.booxtown.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import redix.booxtown.R;

/**
 * Created by thuyetpham94 on 28/08/2016.
 */
public class AdapterFilter  extends BaseAdapter {

    String [] result;
    Context context;
    private static LayoutInflater inflater=null;
    public AdapterFilter(Context context, String[] prgmNameList) {
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
        CheckBox ck;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_listview_fitersort, null);
        holder.tv=(TextView) rowView.findViewById(R.id.txt_listview_filter);
        holder.tv.setText(result[position]);
        return rowView;
    }
}