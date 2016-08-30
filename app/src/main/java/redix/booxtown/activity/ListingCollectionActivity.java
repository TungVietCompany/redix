package redix.booxtown.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import redix.booxtown.R;
import redix.booxtown.custom.CustomListviewGenre;
import redix.booxtown.custom.MenuBottomCustom;

public class ListingCollectionActivity extends AppCompatActivity implements LocationListener,OnMapReadyCallback,GoogleMap.OnMapLongClickListener, GoogleMap.OnInfoWindowClickListener  {
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    String[] genre= {"Architecture","Business and Economics","Boy,Mid and Spirit","Children","Computers and Technology",
    "Crafts and Hobbies","Education","Family,Parenting and Relationships","Fiction and Literature","Food and Drink"
    };
    private MenuBottomCustom menu_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_collection);
//menu
        mMapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map_editlisting));
        mMapFragment.getMapAsync(ListingCollectionActivity.this);
        TextView title_menu = (TextView)findViewById(R.id.txt_title);
        title_menu.setText("Listings");

        ImageView img_menu_component = (ImageView)findViewById(R.id.img_menu_component);
        img_menu_component.setVisibility(View.GONE);
        ImageView menu =
                (ImageView)findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListingCollectionActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //end


        //---------------------------------------------------------------
        //spinner
        ImageView imageView=(ImageView) findViewById(R.id.img_menu_genre);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ListingCollectionActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_genre);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ListView listView_genre=(ListView)dialog.findViewById(R.id.listView_genre);
                listView_genre.setAdapter(new CustomListviewGenre(ListingCollectionActivity.this,genre));
                dialog.show();

                Button button_spiner_genre = (Button)dialog.findViewById(R.id.button_spiner_genre);
                button_spiner_genre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                ImageView img_close_dialoggenre = (ImageView)dialog.findViewById(R.id.img_close_dialoggenre);
                img_close_dialoggenre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        TextView txt_view = (TextView) findViewById(R.id.txt_menu_genre1);
        txt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ListingCollectionActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_genre);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ListView listView_genre=(ListView)dialog.findViewById(R.id.listView_genre);
                listView_genre.setAdapter(new CustomListviewGenre(ListingCollectionActivity.this,genre));
                dialog.show();

                Button button_spiner_genre = (Button)dialog.findViewById(R.id.button_spiner_genre);
                button_spiner_genre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                ImageView img_close_dialoggenre = (ImageView)dialog.findViewById(R.id.img_close_dialoggenre);
                img_close_dialoggenre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        });

        //show edittext when check to sell
        final CheckBox checkBox = (CheckBox)findViewById(R.id.ck_sell_editlisting);
        final EditText edt_editlisting_sell = (EditText)findViewById(R.id.edt_editlisting_sell);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    edt_editlisting_sell.setVisibility(View.VISIBLE);

                }else {
                    edt_editlisting_sell.setVisibility(View.GONE);
                }
            }
        });
        //end
        Button btn_menu_listing_addbook = (Button)findViewById(R.id.btn_menu_listing_addbook);
        btn_menu_listing_addbook.setVisibility(View.VISIBLE);

        btn_menu_listing_addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingCollectionActivity.this,ListingsActivity.class);
                startActivity(intent);
            }
        });

        //change color tab
        TextView txt_add_book = (TextView)findViewById(R.id.txt_add_book1);
        txt_add_book.setTextColor(getResources().getColor(R.color.color_text));
        txt_add_book.setBackgroundColor(getResources().getColor(R.color.dot_light_screen1));

        TextView txt_my_listings = (TextView)findViewById(R.id.txt_my_listings1);
        txt_my_listings.setTextColor(getResources().getColor(R.color.dot_light_screen1));
        txt_my_listings.setBackgroundColor(getResources().getColor(R.color.color_text));

        txt_my_listings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingCollectionActivity.this,ListingsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //--------------------------------------------------
        View view_bottom = (View) findViewById(R.id.menu_bottom_listing_collec);
        menu_bottom=new MenuBottomCustom(view_bottom,this,3);
        menu_bottom.setDefaut(3);
        //---------------------------------------------------------------


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        menu_bottom.setDefaut(3);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Location location;
        Boolean isGPSEnabled=false;
        Boolean isNetworkEnabled = false;
        mMap = googleMap;
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(ListingCollectionActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(ListingCollectionActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        // getting GPS status
        isGPSEnabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        isNetworkEnabled = service
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        System.out.print("GPS:"+isGPSEnabled);
        System.out.print("net:"+isNetworkEnabled);
        if(isGPSEnabled){
            location = service
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                addMaker(location);
            }

        }
        if(isNetworkEnabled){
            location = service
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                addMaker(location);
            }
        }
    }

    public void addMaker(Location location){
        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Hello Maps");
        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_sell));
        // adding marker
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 8));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setTrafficEnabled(true);
    }
}
