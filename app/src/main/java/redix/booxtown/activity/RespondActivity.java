package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterInteract;
import redix.booxtown.adapter.AdapterInteractThreadDetails;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Interact;
import redix.booxtown.model.InteractComment;

/**
 * Created by Administrator on 30/08/2016.
 */
public class RespondActivity extends AppCompatActivity
{

    ArrayList<Interact> listInteract= new ArrayList<>();
    ListView listView;
    private MenuBottomCustom menu_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respond);

        //--------------------------------------------------
        View view=(View) findViewById(R.id.menu_top_respond);
        TextView txtTitle=(TextView) view.findViewById(R.id.txt_title);
        txtTitle.setText("Respond");
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
        //--------------------------------------------------
        View view_bottom = (View)findViewById(R.id.menu_bottom_respond);
        menu_bottom=new MenuBottomCustom(view_bottom,this,4);
        menu_bottom.setDefaut(4);
        //---------------------------------------------------------------
        TextView btn_add_book=(TextView) findViewById(R.id.txt_add_book_respond);
        btn_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RespondActivity.this,AddbookActivity.class);
                startActivity(intent);
            }
        });

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
        View view_comment= (View) findViewById(R.id.gridview_comments_respond);
        ListView listView= (ListView) view_comment.findViewById(R.id.listview_comments);
        final AdapterInteractThreadDetails adapter = new AdapterInteractThreadDetails(RespondActivity.this,list);

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

    @Override
    protected void onRestart() {
        super.onRestart();
        menu_bottom.setDefaut(4);
    }
}
