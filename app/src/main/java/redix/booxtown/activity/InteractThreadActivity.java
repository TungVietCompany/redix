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
import redix.booxtown.adapter.AdapterInteract;
import redix.booxtown.adapter.AdapterInteractThread;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Interact;
import redix.booxtown.model.InteractThread;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractThreadActivity extends AppCompatActivity
{

    ArrayList<InteractThread> listInteractThreads= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact_thread);

        //----------------------------------------------
        Interact interact = (Interact) getIntent().getSerializableExtra("thread");
        //--------------------------------------------------
        View view=(View) findViewById(R.id.menu_interact_thread);

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

        TextView txt_title_thread=(TextView) findViewById(R.id.txt_title_thread);
        TextView txt_count_thread=(TextView) findViewById(R.id.txt_count_thread);
        txt_title_thread.setText(interact.getInteractTitle());
        txt_count_thread.setText("("+interact.getInteractCount()+")");

        //--------------------------------------------------
        View view_bottom = (View)findViewById(R.id.bottom_interact_thread);
        menu_bottom=new MenuBottomCustom(view_bottom,this,2);
        menu_bottom.setDefaut(2);
        //---------------------------------------------------------------


        InteractThread interact1= new InteractThread();
        interact1.setInteractThreadTitle("Thread one text");
        interact1.setInteractThreadCount("20");
        interact1.setStatus(true);
        interact1.setInteractThreadAddBy("Derek Jarma");

        InteractThread interact2= new InteractThread();
        interact2.setInteractThreadTitle("Evil Queen: The Last Paintings");
        interact2.setInteractThreadCount("15");
        interact2.setStatus(true);
        interact2.setInteractThreadAddBy("Richard D.Marshall");

        InteractThread interact3= new InteractThread();
        interact3.setInteractThreadTitle("Joan Mitchell, The Last Paintings");
        interact3.setInteractThreadCount("35");
        interact3.setStatus(false);
        interact3.setInteractThreadAddBy("Derek Jarma");

        InteractThread interact4= new InteractThread();
        interact4.setInteractThreadTitle("Ad Reinhardt: Last Paintings");
        interact4.setInteractThreadCount("23");
        interact4.setStatus(false);
        interact4.setInteractThreadAddBy("heinz Liesbrock");


        listInteractThreads.add(interact1);
        listInteractThreads.add(interact2);
        listInteractThreads.add(interact3);
        listInteractThreads.add(interact4);

        //-----------------------------------------------------------
        final AdapterInteractThread adapter = new AdapterInteractThread(InteractThreadActivity.this,listInteractThreads);
        listView=(ListView) findViewById(R.id.list_interact_thread);
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

