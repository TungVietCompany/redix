package redix.booxtown.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.adapter.AdapterFilter;
import redix.booxtown.custom.CustomAdapter;
import redix.booxtown.custom.CustomSearch;
import redix.booxtown.custom.MenuBottomCustom;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener, GoogleMap.OnInfoWindowClickListener {
    private CoordinatorLayout coordinatorLayout;
    private GoogleMap mMap;
    final int RQS_GooglePlayServices = 1;

    ListView lv;
    Context context;
    ImageView close_menu;
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Nearest distance","Price low to high","Price high to low","Recently added","Nearest distance","Price low to high","Price high to low","Recently added","Nearest distance","Price low to high"};
    public static String [] prgmNameList1={"Nearest distance","Price low to high","Price high to low","Recently added"};
    private MenuBottomCustom bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view_top= (View) findViewById(R.id.explore_menu_top);
        TextView txtTitle=(TextView) view_top.findViewById(R.id.txt_title);
        txtTitle.setText("Locate");

        ImageView img_component=(ImageView) view_top.findViewById(R.id.img_menu_component);
        img_component.setImageResource(R.drawable.icon_explore);
        img_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itentsign = new Intent(MainActivity.this,ExploreActivity.class);
                startActivity(itentsign);
            }
        });
        // set onclick for menu bottom
        RelativeLayout menu_bottom=(RelativeLayout) findViewById(R.id.explore_menu_bottom);
        bottom=new MenuBottomCustom(menu_bottom,this,1);
        bottom.setDefaut(1);
        // set for layout_search
        View view= (View) findViewById(R.id.custom_search);
        new CustomSearch(view,this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MainActivity.this);

        ImageView menu = (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        filterSort();
    }

    public void filterSort(){
        ImageView btn_filter_explore = (ImageView)findViewById(R.id.btn_filter_explore);
        btn_filter_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_filter_sort);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ListView lv_dialog_filter = (ListView)dialog.findViewById(R.id.lv_dialog_filter);
                lv_dialog_filter.setAdapter(new AdapterFilter(MainActivity.this,prgmNameList1));

                final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) dialog.findViewById(R.id.rangeSeekbar3);
                final TextView tvMin = (TextView) dialog.findViewById(R.id.txt_filter_rangemin);
                final TextView tvMax = (TextView) dialog.findViewById(R.id.txt_filter_rangemax);

                rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue, Number maxValue) {
                        tvMin.setText(String.valueOf(minValue));
                        tvMax.setText(String.valueOf(maxValue));
                    }
                });

                final TextView txt_filter_proximity = (TextView)dialog.findViewById(R.id.txt_filter_proximity);
                final CrystalSeekbar seekbar = (CrystalSeekbar) dialog.findViewById(R.id.rangeSeekbar8);
                seekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue) {
                        txt_filter_proximity.setText(String.valueOf(minValue)+" KM");
                    }
                });

                ImageView imv_dialog_filter_close = (ImageView)dialog.findViewById(R.id.imv_dialog_filter_close);
                imv_dialog_filter_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btn_dialog_filter_submit = (Button)dialog.findViewById(R.id.btn_dialog_filter_submit);
                btn_dialog_filter_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner_dialog_filter);
                List<String> list = new ArrayList<String>();
                list.add("Nearest distance");
                list.add("list 2");
                list.add("list 3");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(dataAdapter);
            }
        });
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(getBaseContext(),
                "Info Window clicked@" + marker.getId(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (resultCode == ConnectionResult.SUCCESS){
        }else{
            GooglePlayServicesUtil.getErrorDialog(resultCode, this, RQS_GooglePlayServices);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        // latitude and longitude
        double latitude = 17.385044;
        double longitude = 78.486671;
        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_sell));

        // adding marker
        mMap.addMarker(marker);


        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        mMap.getUiSettings().setAllGesturesEnabled(true);

        mMap.setTrafficEnabled(true);

        mMap.setOnMapLongClickListener(this);
        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter());
        mMap.setOnInfoWindowClickListener(this);
    }

    class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        MyInfoWindowAdapter(){
            myContentsView = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        }

        @Override
        public View getInfoContents(Marker marker) {
            TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title_locate));
            tvTitle.setText(marker.getTitle());
            TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet_locate));
            tvSnippet.setText(marker.getSnippet());

            return myContentsView;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bottom.setDefaut(1);
    }
}
