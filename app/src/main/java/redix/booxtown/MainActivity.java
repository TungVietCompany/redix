package redix.booxtown;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import redix.booxtown.custom.CustomAdapter;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener, GoogleMap.OnInfoWindowClickListener {
    private CoordinatorLayout coordinatorLayout;
    private GoogleMap mMap;
    final int RQS_GooglePlayServices = 1;

    ListView lv;
    Context context;
    ImageView close_menu;
    BottomBar bottomBar;
    public static int [] prgmImages={R.drawable.home,R.drawable.notification,R.drawable.faq,R.drawable.invited,R.drawable.rate,R.drawable.about,R.drawable.contact1,R.drawable.setting,R.drawable.logout,R.drawable.unsub};
    public static String [] prgmNameList={"Home","Notifications","FAQ","Invite friends","Rate Booxtown","About Booxtown","Contact Booxtown","Settings","Logout","Unsubscribe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MainActivity.this);

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
            Toast.makeText(getApplicationContext(),
                    "isGooglePlayServicesAvailable SUCCESS",
                    Toast.LENGTH_LONG).show();
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
}
