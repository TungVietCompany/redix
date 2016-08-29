package redix.booxtown.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
