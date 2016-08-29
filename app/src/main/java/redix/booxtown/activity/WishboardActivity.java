package redix.booxtown.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterListviewWishboard;

public class WishboardActivity extends AppCompatActivity {

    public static String [] title={"The last painting of Sara","Never of Dull moment","The nation of Brink"};
    public static String [] name={"Sara","Thuye","The nation"};
    public static String [] date={"22-08-1994","11-08-1994","10-08-1994"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishboard);

        ListView lv_wishboard = (ListView)findViewById(R.id.lv_wishboard);
        lv_wishboard.setAdapter(new AdapterListviewWishboard(WishboardActivity.this,title,name,date));

        //menu

        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("Wishboard");

        ImageView menu = (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WishboardActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        ImageView img_component=(ImageView) findViewById(R.id.img_menu_component);
        img_component.setImageResource(R.drawable.icon_menu_wishboard);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //end
    }
}
