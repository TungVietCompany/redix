package redix.booxtown.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.activity.UserProfileActivity;
import redix.booxtown.model.InteractComment;

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

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Hoder hoder = new Hoder();

            InteractComment interactComments= listInteractComments.get(position);
        convertView = inflater.inflate(R.layout.custom_commnents_interact, null);

        hoder.img_icon=(ImageView) convertView.findViewById(R.id.icon_user_listing_detail);
        hoder.img_rank_one=(ImageView) convertView.findViewById(R.id.img_comment_rank1);
        hoder.img_rank_two=(ImageView) convertView.findViewById(R.id.img_comment_rank2);
        hoder.img_rank_three=(ImageView) convertView.findViewById(R.id.img_comment_rank3);
        hoder.txt_userName=(TextView) convertView.findViewById(R.id.txt_user_comment);
        hoder.txt_contents=(TextView) convertView.findViewById(R.id.txt_content_thread_comments);
        hoder.txt_datetime=(TextView) convertView.findViewById(R.id.txt_date_thread_comment);


        hoder.img_icon.setImageResource(R.drawable.icon_test);
        hoder.img_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,UserProfileActivity.class);
                    mContext.startActivity(intent);
                }
            });

//            Resources mResources = mContext.getResources();
//            Bitmap mBitmap = BitmapFactory.decodeResource(mResources, R.drawable.icon_test);
//            NotificationAccept notificationAccept = new NotificationAccept();
//            notificationAccept.accept(mContext, mResources, mBitmap, img_icon);

            if(interactComments.isRank_one()){
                hoder.img_rank_one.setVisibility(View.VISIBLE);
            }
            else{
                hoder.img_rank_one.setVisibility(View.INVISIBLE);
            }

            if(interactComments.isRank_two()){
                hoder.img_rank_two.setVisibility(View.VISIBLE);
            }
            else{
                hoder.img_rank_two.setVisibility(View.INVISIBLE);
            }

            if(interactComments.isRank_three()){
                hoder.img_rank_three.setVisibility(View.VISIBLE);
            }
            else{
                hoder.img_rank_three.setVisibility(View.INVISIBLE);
            }

        hoder.txt_userName.setText(interactComments.getUser_name());
        hoder.txt_contents.setText(interactComments.getContent());
        hoder.txt_datetime.setText(interactComments.getDate_time());


        return convertView;
    }

    public class Hoder{
        ImageView img_icon;
        ImageView img_rank_one;
        ImageView img_rank_two;
        ImageView img_rank_three;
        TextView txt_userName;
        TextView txt_contents;
        TextView txt_datetime;

    }
}
