package redix.booxtown.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.NotificationDominicAccept;
import redix.booxtown.custom.NotificationAccept;
import redix.booxtown.model.InteractComment;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 28/08/2016.
 */
public class AdapterInteractThreadDetails extends BaseAdapter {
    private Context mContext;
    private ArrayList<InteractComment> listInteractComments;


    public AdapterInteractThreadDetails(Context c, ArrayList<InteractComment> list_interact) {
        mContext = c;
        this.listInteractComments = list_interact;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listInteractComments.size();
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

        InteractComment interactComments= listInteractComments.get(position);

        if (convertView == null) {

            listView = new View(mContext);
            listView = inflater.inflate(R.layout.custom_commnents_interact, null);

            ImageView img_icon=(ImageView) listView.findViewById(R.id.icon_user);
            ImageView img_rank_one=(ImageView) listView.findViewById(R.id.img_comment_rank1);
            ImageView img_rank_two=(ImageView) listView.findViewById(R.id.img_comment_rank2);
            ImageView img_rank_three=(ImageView) listView.findViewById(R.id.img_comment_rank3);
            TextView txt_userName=(TextView) listView.findViewById(R.id.txt_user_comment);
            TextView txt_contents=(TextView) listView.findViewById(R.id.txt_content_thread_comments);
            TextView txt_datetime=(TextView) listView.findViewById(R.id.txt_date_thread_comment);


            img_icon.setImageResource(R.drawable.icon_test);

//            Resources mResources = mContext.getResources();
//            Bitmap mBitmap = BitmapFactory.decodeResource(mResources, R.drawable.icon_test);
//            NotificationAccept notificationAccept = new NotificationAccept();
//            notificationAccept.accept(mContext, mResources, mBitmap, img_icon);

            if(interactComments.isRank_one()){
                img_rank_one.setVisibility(View.VISIBLE);
            }
            else{
                img_rank_one.setVisibility(View.INVISIBLE);
            }

            if(interactComments.isRank_two()){
                img_rank_two.setVisibility(View.VISIBLE);
            }
            else{
                img_rank_two.setVisibility(View.INVISIBLE);
            }

            if(interactComments.isRank_three()){
                img_rank_three.setVisibility(View.VISIBLE);
            }
            else{
                img_rank_three.setVisibility(View.INVISIBLE);
            }

            txt_userName.setText(interactComments.getUser_name());
            txt_contents.setText(interactComments.getContent());
            txt_datetime.setText(interactComments.getDate_time());
        } else {
            listView = (View) convertView;
        }

        return listView;
    }
}
