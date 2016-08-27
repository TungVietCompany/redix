package redix.booxtown.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 26/08/2016.
 */
public class AdapterExplore extends BaseAdapter {
    private Context mContext;
    private ArrayList<Explore> listExplore;


    public AdapterExplore(Context c, ArrayList<Explore> list_explores) {
        mContext = c;
        this.listExplore = list_explores;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listExplore.size();
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Explore ex= listExplore.get(position);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_gridview_explore, null);
            TextView txt_title_book = (TextView) grid.findViewById(R.id.txt_title_book);
            TextView txt_author_book = (TextView) grid.findViewById(R.id.txt_author_book);
            TextView txt_price_book=(TextView) grid.findViewById(R.id.txt_pricebook);

            ImageView img_book = (ImageView)grid.findViewById(R.id.img_book);
            ImageView img_swap = (ImageView)grid.findViewById(R.id.img_explore_swap);
            ImageView img_free = (ImageView)grid.findViewById(R.id.img_explore_free);
            ImageView img_buy = (ImageView)grid.findViewById(R.id.img_explore_buy);


            if(position%2==0){
                img_book.setImageResource((R.drawable.img_temp1));
                txt_title_book.setText("The Las Painting of Sara de Vos");
                txt_author_book.setText("buy Gandalf");
            }
            else
            {
                img_book.setImageResource((R.drawable.img_temp1));
                txt_title_book.setText("Gandalf the first");
                txt_author_book.setText("buy Ptit");
            }

            if(ex.isSwap()){
                img_swap.setImageResource((R.drawable.tab_book_explore_swap));
            }
            else{
                img_swap.setImageResource((R.drawable.tab_book_explore_swap_not));
            }

            if(ex.isFree()){
                img_free.setImageResource((R.drawable.tab_book_explore_free));
            }
            else{
                img_free.setImageResource((R.drawable.tab_book_explore_free_not));
            }

            if(ex.isBuy()){
                img_buy.setImageResource((R.drawable.tab_book_explore_cart));
                txt_price_book.setVisibility(View.VISIBLE);
                
            }
            else{
                img_buy.setImageResource((R.drawable.tab_book_explore_cart_not));
            }
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}