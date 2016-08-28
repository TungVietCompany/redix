package redix.booxtown.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.model.Interact;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 27/08/2016.
 */
public class AdapterInteractThread extends BaseAdapter {
    private Context mContext;
    private ArrayList<InteractThread> listInteract;


    public AdapterInteractThread(Context c, ArrayList<InteractThread> list_interact) {
        mContext = c;
        this.listInteract = list_interact;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listInteract.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View listView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        InteractThread interact= listInteract.get(position);

        if (convertView == null) {

            listView = new View(mContext);
            listView = inflater.inflate(R.layout.custom_interact, null);

            TextView txt_title_interact=(TextView) listView.findViewById(R.id.txt_title_interact);
            TextView txt_count_interact=(TextView) listView.findViewById(R.id.txt_count_interact);
            TextView txt_dateUpdate_interact=(TextView) listView.findViewById(R.id.txt_time_update_interact);

            txt_title_interact.setText(interact.getInteractThreadTitle());

            txt_count_interact.setText(" ("+interact.getInteractThreadCount()+")");
            if(interact.isStatus()) {
                txt_count_interact.setTextColor(listView.getResources().getColor(R.color.color_text));
            }

            txt_dateUpdate_interact.setText("Added by "+ interact.getInteractThreadAddBy());

        } else {
            listView = (View) convertView;
        }

        return listView;
    }
}
