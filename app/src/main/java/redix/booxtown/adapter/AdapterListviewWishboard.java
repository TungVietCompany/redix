package redix.booxtown.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import redix.booxtown.R;
import redix.booxtown.activity.RespondActivity;

/**
 * Created by thuyetpham94 on 30/08/2016.
 */
public class AdapterListviewWishboard  extends BaseAdapter {

    String [] title;
    String [] name;
    String [] date;
    Context context;
    private static LayoutInflater inflater=null;
    public AdapterListviewWishboard(Context context,String []title,String[]name,String[] date) {
        // TODO Auto-generated constructor stub
        this.title=title;
        this.context=context;
        this.name = name;
        this.date = date;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
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
        TextView title;
        TextView name;
        TextView date;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_listview_wishboard, null);
        holder.title=(TextView) rowView.findViewById(R.id.txt_title_lisview_wishboard);
        holder.name = (TextView)rowView.findViewById(R.id.txt_name_custom_listview_wishboard);
        holder.date = (TextView)rowView.findViewById(R.id.txt_date_customlistview_wishboard);
        holder.title.setText(title[position]);
        holder.name.setText(name[position]);
        holder.date.setText(date[position]);

        ImageView imgv_listview_respond = (ImageView)rowView.findViewById(R.id.imgv_listview_respond);
        Picasso.with(context).load(R.drawable.btn_wishbroad_message).into(imgv_listview_respond);
        imgv_listview_respond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RespondActivity.class);
                context.startActivity(intent);
            }
        });

        if(position %2==0){
            rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_hint_interact));
        }else{
            rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.dot_light_screen1));
        }
        return rowView;
    }
}