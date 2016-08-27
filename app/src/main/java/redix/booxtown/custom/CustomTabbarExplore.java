package redix.booxtown.custom;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import redix.booxtown.R;

/**
 * Created by Administrator on 27/08/2016.
 */
public class CustomTabbarExplore {

    private LinearLayout linear_all;
    private LinearLayout linear_swap;
    private LinearLayout linear_free;
    private LinearLayout linear_cart;

    private TextView txt_all;
    private TextView txt_all_count;
    private ImageView img_swap;
    private TextView  txt_swap_count;
    private ImageView img_free;
    private TextView txt_free_count;
    private ImageView imge_cart;
    private TextView txt_cart_count;

    View view;

    public CustomTabbarExplore(View view, Context ct){

        this.view= view;

        linear_all=(LinearLayout) view.findViewById(R.id.linear_all);
        linear_swap=(LinearLayout) view.findViewById(R.id.linear_swap);
        linear_free=(LinearLayout) view.findViewById(R.id.linear_free);
        linear_cart=(LinearLayout) view.findViewById(R.id.linear_cart);

        txt_all=(TextView) view.findViewById(R.id.tab_all);
        txt_all_count=(TextView) view.findViewById(R.id.tab_all_count);

        img_swap=(ImageView) view.findViewById(R.id.tab_swap);
        txt_swap_count=(TextView) view.findViewById(R.id.tab_swap_count);

        img_free=(ImageView) view.findViewById(R.id.tab_free);
        txt_free_count=(TextView) view.findViewById(R.id.tab_free_count);

        imge_cart=(ImageView) view.findViewById(R.id.tab_cart);
        txt_cart_count=(TextView) view.findViewById(R.id.tab_cart_count);
        setDefault(1);
    }


    public void setDefault(int type){
        if(type==1){
            linear_all.setBackgroundColor(view.getResources().getColor(R.color.dot_light_screen1));
            txt_all.setTextColor(view.getResources().getColor(R.color.color_text));
            txt_all_count.setTextColor(view.getResources().getColor(R.color.color_text));

            linear_swap.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_swap.setImageResource(R.drawable.tab_swap_not);
            txt_swap_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_free.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_free.setImageResource(R.drawable.tab_free_not);
            txt_free_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_cart.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            imge_cart.setImageResource(R.drawable.tab_cart_not);
            txt_cart_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

        }
        else if(type==2){
            linear_all.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            txt_all.setTextColor(view.getResources().getColor(R.color.dot_light_screen1));
            txt_all_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_swap.setBackgroundColor(view.getResources().getColor(R.color.dot_light_screen1));
            img_swap.setImageResource(R.drawable.tab_swap);
            txt_swap_count.setTextColor(view.getResources().getColor(R.color.color_text));

            linear_free.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_free.setImageResource(R.drawable.tab_free_not);
            txt_free_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_cart.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            imge_cart.setImageResource(R.drawable.tab_cart_not);
            txt_cart_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));
        }
        else if(type==3){
            linear_all.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            txt_all.setTextColor(view.getResources().getColor(R.color.dot_light_screen1));
            txt_all_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_swap.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_swap.setImageResource(R.drawable.tab_swap_not);
            txt_swap_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_free.setBackgroundColor(view.getResources().getColor(R.color.dot_light_screen1));
            img_free.setImageResource(R.drawable.tab_free);
            txt_free_count.setTextColor(view.getResources().getColor(R.color.color_text));

            linear_cart.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            imge_cart.setImageResource(R.drawable.tab_cart_not);
            txt_cart_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));
        }
        else {
            linear_all.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            txt_all.setTextColor(view.getResources().getColor(R.color.dot_light_screen1));
            txt_all_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_swap.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_swap.setImageResource(R.drawable.tab_swap_not);
            txt_swap_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_free.setBackgroundColor(view.getResources().getColor(R.color.color_text));
            img_free.setImageResource(R.drawable.tab_free_not);
            txt_free_count.setTextColor(view.getResources().getColor(R.color.color_text_hint));

            linear_cart.setBackgroundColor(view.getResources().getColor(R.color.dot_light_screen1));
            imge_cart.setImageResource(R.drawable.tab_cart);
            txt_cart_count.setTextColor(view.getResources().getColor(R.color.color_text));
        }
    }

}
