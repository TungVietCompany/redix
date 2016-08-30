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
 * Created by thuyetpham94 on 30/08/2016.
 */
public class CustomListviewGenre extends BaseAdapter {
    String [] result;
    Context context;
    private static LayoutInflater inflater=null;
    public CustomListviewGenre(Context context, String[] prgmNameList) {
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
        rowView = inflater.inflate(R.layout.custom_dialog_genre, null);
        holder.tv=(TextView) rowView.findViewById(R.id.txt_custom_listview_genre);
        holder.tv.setText(result[position]);
        return rowView;
    }
}
