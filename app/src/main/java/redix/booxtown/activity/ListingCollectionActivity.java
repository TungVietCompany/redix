package redix.booxtown.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
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

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.custom.CustomListviewGenre;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.fragment.ListingsFragment;

public class ListingCollectionActivity extends Fragment implements LocationListener,OnMapReadyCallback,GoogleMap.OnMapLongClickListener, GoogleMap.OnInfoWindowClickListener ,View.OnClickListener {
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    ImageView btn_sellectimage;
    String[] genre= {"Architecture","Business and Economics","Boy,Mid and Spirit","Children","Computers and Technology",
    "Crafts and Hobbies","Education","Family,Parenting and Relationships","Fiction and Literature","Food and Drink"
    };

    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List<String> imagesEncodedList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_listing_collection,container,false);


        btn_sellectimage = (ImageView) v.findViewById(R.id.imageView32) ;
        btn_sellectimage.setOnClickListener(this);

        //end
        //spinner
        ImageView imageView=(ImageView) v.findViewById(R.id.img_menu_genre);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_genre);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ListView listView_genre=(ListView)dialog.findViewById(R.id.listView_genre);
                listView_genre.setAdapter(new CustomListviewGenre(getActivity(),genre));
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
        TextView txt_view = (TextView) v.findViewById(R.id.txt_menu_genre1);
        txt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_genre);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ListView listView_genre=(ListView)dialog.findViewById(R.id.listView_genre);
                listView_genre.setAdapter(new CustomListviewGenre(getActivity(),genre));
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
        //end
        //show edittext when check to sell
        final CheckBox checkBox = (CheckBox)v.findViewById(R.id.ck_sell_editlisting);
        final EditText edt_editlisting_sell = (EditText)v.findViewById(R.id.edt_editlisting_sell);
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
        Button btn_menu_listing_addbook = (Button)v.findViewById(R.id.btn_menu_listing_addbook);
        btn_menu_listing_addbook.setVisibility(View.VISIBLE);
        TableRow row= (TableRow) v.findViewById(R.id.row_edit_book) ;
        row.setVisibility(View.GONE);

        btn_menu_listing_addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),ListingsFragment.class);
//                startActivity(intent);
                MainAllActivity mainAllActivity = (MainAllActivity)getActivity();
                mainAllActivity.callFragment(new ListingsFragment());
            }
        });

        //change color tab
        TextView txt_add_book = (TextView)v.findViewById(R.id.txt_add_book1);
        txt_add_book.setTextColor(getResources().getColor(R.color.color_text));
        txt_add_book.setBackgroundColor(getResources().getColor(R.color.dot_light_screen1));

        TextView txt_my_listings = (TextView)v.findViewById(R.id.txt_my_listings1);
        txt_my_listings.setTextColor(getResources().getColor(R.color.dot_light_screen1));
        txt_my_listings.setBackgroundColor(getResources().getColor(R.color.color_text));

        txt_my_listings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainAllActivity main = (MainAllActivity)getActivity();
                main.callFragment(new ListingsFragment());
            }
        });

        //--------------------------------------------------
//        View view_bottom = (View) v.findViewById(R.id.menu_bottom_listing_collec);
//        menu_bottom=new MenuBottomCustom(view_bottom,this,3);
//        menu_bottom.setDefaut(3);
        //---------------------------------------------------------------

        return v;
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
                ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager service = (LocationManager) getActivity().getSystemService(getActivity().LOCATION_SERVICE);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView32:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == getActivity().RESULT_OK
                    && null != data) {
                // Get the Image from data

                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                imagesEncodedList = new ArrayList<String>();
                if(data.getData()!=null){

                    Uri mImageUri=data.getData();

                    // Get the cursor
                    Cursor cursor = getActivity().getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageEncoded  = cursor.getString(columnIndex);
                    cursor.close();

                }else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getActivity().getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageEncoded  = cursor.getString(columnIndex);
                            imagesEncodedList.add(imageEncoded);
                            cursor.close();

                        }
                        Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
                    }
                }
            } else {
                Toast.makeText(getActivity(), "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
