package redix.booxtown.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.InteractComment;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 28/08/2016.
 */
public class InteractThreadDetailsActivity extends AppCompatActivity
{

    ArrayList<InteractComment> listInteractThreads= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;

    //----------------------------------------------

    //--------------------------------------------------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact_thread_detail);

        //----------------------------------------------
        InteractThread interact = (InteractThread) getIntent().getSerializableExtra("threadDetail");
        //--------------------------------------------------
        View view=(View) findViewById(R.id.menu_interact_thread_detail);

        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
        txtTitle.setText("Interact");
        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setVisibility(View.INVISIBLE);

        ImageView imageView_back=(ImageView) findViewById(R.id.img_menu);
        imageView_back.setImageResource(R.drawable.back_interact);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView txt_title_thread=(TextView) findViewById(R.id.txt_title_thread_detail);
        TextView txt_count_thread=(TextView) findViewById(R.id.txt_count_thread_detail);
        TextView txt_content_thread=(TextView) findViewById(R.id.txt_contern_thread_details);
        TextView txt_author_thread=(TextView) findViewById(R.id.txt_author_interact_thread_detail);
        txt_title_thread.setText(interact.getInteractThreadTitle());
        txt_count_thread.setText("("+interact.getInteractThreadCount()+")");
        txt_content_thread.setText(interact.getInteractThreadContent());
        txt_author_thread.setText("Added by "+interact.getInteractThreadAddBy());

        //--------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_threads);
        menu_bottom=new MenuBottomCustom(view_bottom,this,2);
        menu_bottom.setDefaut(2);
        //---------------------------------------------------------------

        ArrayList<InteractComment> list= new ArrayList<>();
        InteractComment interactComment1= new InteractComment(2.5f,true,false,true,"Gandalf","If you want to buy best books order us1","June 12 at 5:14 pm");
        InteractComment interactComment2= new InteractComment(3.0f,true,true,true,"Gandalf2","If you want to buy best books order us2","June 12 at 5:14 pm");
        InteractComment interactComment3= new InteractComment(4.0f,false,false,true,"Gandalf3","If you want to buy best books order us3","June 12 at 5:14 pm");
        InteractComment interactComment4= new InteractComment(3.5f,true,false,false,"Gandalf4","If you want to buy best books order us4","June 12 at 5:14 pm");
        InteractComment interactComment5= new InteractComment(5.0f,true,false,false,"Gandalf5","If you want to buy best books order us5","June 12 at 5:14 pm");

        list.add(interactComment1);
        list.add(interactComment2);
        list.add(interactComment3);
        list.add(interactComment4);
        list.add(interactComment5);


        //-----------------------------------------------------------
        final AdapterInteractThreadDetails adapter = new AdapterInteractThreadDetails(InteractThreadDetailsActivity.this,list);
        listView=(ListView) findViewById(R.id.listview_comments);
        listView.setDivider(null);
        listView.setAdapter(adapter);
        //---------------------------------------------------------------

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // menu_bottom.setDefaut(1);
        finish();
    }
}

