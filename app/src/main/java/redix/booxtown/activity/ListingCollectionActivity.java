package redix.booxtown.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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

import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import redix.booxtown.controller.GPSTracker;
import redix.booxtown.controller.UploadFileController;
import redix.booxtown.controller.UserController;
import redix.booxtown.R;
import redix.booxtown.custom.CustomListviewGenre;
import redix.booxtown.fragment.ListingsFragment;
import redix.booxtown.model.Book;
import redix.booxtown.model.Explore;
import redix.booxtown.model.Genre;

public class ListingCollectionActivity extends Fragment implements LocationListener,OnMapReadyCallback,GoogleMap.OnMapLongClickListener, GoogleMap.OnInfoWindowClickListener ,View.OnClickListener {
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    ImageView btn_sellectimage,imagebook1,imagebook2,imagebook3,addtag;
    UploadFileController uploadFileController;
    Button btn_menu_editlist_delete,btn_menu_editlisting_update,btn_menu_listing_addbook;
    String username;
    ArrayList<Genre> genre;
    double latitude,longitude;
    EditText edt_tilte,edt_author,edt_tag,edt_editlisting_sell;
    TableRow row;
    CheckBox swap,free,sell;
    String session_id;
    float price;
    String condition;
    CrystalSeekbar seekbar;
    UserController userController;
    boolean success;
    Book book;
    String titl;
    String[] genravalue = {"Architecture","Business and Economics","Boy,Mid and Spirit","Children","Computers and Technology",
    "Crafts and Hobbies","Education","Family,Parenting and Relationships","Fiction and Literature","Food and Drink"
    };



    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List<String> imagesEncodedList;
    ArrayList<String> listTag;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_listing_collection,container,false);

        edt_editlisting_sell = (EditText) v.findViewById(R.id.edt_editlisting_sell);
        swap = (CheckBox) v.findViewById(R.id.checkBox);
        sell = (CheckBox) v.findViewById(R.id.ck_sell_editlisting);
        free = (CheckBox) v.findViewById(R.id.checkBox3) ;
        edt_author = (EditText) v.findViewById(R.id.editText9) ;
        edt_tilte = (EditText) v.findViewById(R.id.editText8) ;
        edt_tag = (EditText) v.findViewById(R.id.editText10) ;
        addtag = (ImageView) v.findViewById(R.id.imageView33);
        addtag.setOnClickListener(this);
        btn_menu_listing_addbook = (Button)v.findViewById(R.id.btn_menu_listing_addbook);
        btn_menu_editlist_delete = (Button)v.findViewById(R.id.btn_menu_editlist_delete);
        btn_menu_editlisting_update = (Button)v.findViewById(R.id.btn_menu_editlisting_update);
        btn_menu_editlist_delete.setOnClickListener(this);
        btn_menu_editlisting_update.setOnClickListener(this);
        row= (TableRow) v.findViewById(R.id.row_edit_book) ;
        String s = getArguments().getString("activity");
        listTag = new ArrayList<>();
            if (s.equals("edit")){
                btn_menu_listing_addbook.setVisibility(View.GONE);
                row.setVisibility(View.VISIBLE);
                Explore explore = (Explore) getArguments().getSerializable("book");
                Log.d("boooook",String.valueOf(explore.getPrice_book()));


            }else {
                btn_menu_listing_addbook.setVisibility(View.VISIBLE);
                row.setVisibility(View.GONE);
            }
        genre = new ArrayList<>();
        for (int i = 0;i<genravalue.length;i++){
            Genre genrel = new Genre();
            genrel.setValue(genravalue[i]);
            genre.add(genrel);
        }
        btn_sellectimage = (ImageView) v.findViewById(R.id.imageView32) ;
        //picaso
        Picasso.with(getContext()).load(R.drawable.btn_add).into(btn_sellectimage);
        //end
        btn_sellectimage.setOnClickListener(this);
        uploadFileController = new UploadFileController();
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        username = pref.getString("username",null);
        session_id = pref.getString("session_id",null);

        //end
        //spinner
        ImageView imageView=(ImageView) v.findViewById(R.id.img_menu_genre);
        Picasso.with(getContext()).load(R.drawable.btn_down).into(imageView);
        imagebook1 = (ImageView) v.findViewById(R.id.imageView29);
        imagebook2 = (ImageView) v.findViewById(R.id.imageView30);
        imagebook3 = (ImageView) v.findViewById(R.id.imageView31);
        seekbar = (CrystalSeekbar) v.findViewById(R.id.seekBar2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_genre);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                final ListView listView_genre=(ListView)dialog.findViewById(R.id.listView_genre);
                final CustomListviewGenre adapter = new CustomListviewGenre(getActivity(),genre);
                listView_genre.setAdapter(adapter);
                dialog.show();

                Button button_spiner_genre = (Button)dialog.findViewById(R.id.button_spiner_genre);
                button_spiner_genre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                ImageView img_close_dialoggenre = (ImageView)dialog.findViewById(R.id.img_close_dialoggenre);
                Picasso.with(getContext()).load(R.drawable.btn_close_filter).into(img_close_dialoggenre);
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
                Picasso.with(getContext()).load(R.drawable.btn_close_filter).into(img_close_dialoggenre);
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

        btn_menu_listing_addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),ListingsFragment.class);
//                startActivity(intent);

                addbook();
                Addbook addbook = new Addbook();
                addbook.execute();
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


    public void addbook(){

        GPSTracker gps = new GPSTracker(getActivity());
        for (int i = 0; i < lisImmage.size();i++){
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),lisImmage.get(i));
                bmap.add(bitmap);
                String fileName = getFileName(lisImmage.get(i));
                listFileName.add(fileName);
                Log.d("dsmdhkshkd",listFileName.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<String> listvalueGenre = new ArrayList<>();
        for (int i = 0;i<genre.size();i++){
            if (genre.get(i).ischeck() == true){
                listvalueGenre.add(genre.get(i).getValue());
            }
            Log.d("dsmnndshk",String.valueOf(listvalueGenre.size()));
        }

        String auth = edt_author.getText().toString();
        titl = edt_tilte.getText().toString();
        String tag = "";
        if (listTag.size()!=0){
            for(int i=0;i<listTag.size(); i++){
                if(i!=listTag.size()-1) {
                    tag = tag + listTag.get(i) + ";";
                }
                else{
                    tag = tag + listTag.get(i);
                }
            }
        }

        String genrel="";

        if (listvalueGenre.size()!=0){
            for(int i=0;i<listvalueGenre.size(); i++){
                if(i!=listvalueGenre.size()-1) {
                    genrel = genrel + listvalueGenre.get(i) + ";";
                }
                else{
                    genrel = genrel + listvalueGenre.get(i);
                }
            }
        }

        String action = getAction();

        seekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue) {
                condition = String.valueOf(minValue);
            }
        });

        String imagename = "";
        if (listFileName.size()!=0){
            for(int i=0;i<listFileName.size(); i++){
                if(i!=listFileName.size()-1) {
                    imagename = imagename + listFileName.get(i) + ";";
                }
                else{
                    imagename = imagename + listFileName.get(i);
                }
            }
        }

//        if(sell.isChecked()){
//            price = Float.valueOf(edt_editlisting_sell.getText().toString());
//        }



        book = new Book();
        book.setAction(action);
        book.setAuthor(auth);
        book.setTitle(titl);
        book.setCondition(condition);
        book.setGenre(genrel);
        book.setHash_tag(tag);
        book.setLocation_latitude(Float.valueOf(String.valueOf(gps.getLatitude())));
        book.setLocation_longitude(Float.valueOf(String.valueOf(gps.getLongitude())));
        book.setPhoto(imagename);
//        book.setPrice(price);


    }

    public String getAction(){
        String s = "";
        s += swap.isChecked() == true ? "1" : "0";
        s += sell.isChecked() == true ? "1" : "0";
        s += free.isChecked() == true ? "1" : "0";
        return s;
    }

    public String parseJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
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
            if (location == null) {
                {
                    location = service.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    latitude =  location.getLatitude();
                    longitude = location.getLongitude();
                }
                addMaker(location);
            }

        }
        if(isNetworkEnabled){
            location = service
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location == null) {
                location = service.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                {
                    latitude =  location.getLatitude();
                    longitude = location.getLongitude();
                }
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
                if (lisImmage.size()<3){
                    choseImage();
                break;
                }else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setTitle("you want to change other image");
                    alertDialogBuilder
                            .setMessage("Click yes to chose other image")
                            .setCancelable(false)
                            .setPositiveButton("Yes",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            lisImmage.remove(0);
                                            choseImage();
                                        }
                                    })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            case R.id.btn_menu_editlist_delete:
                break;
            case R.id.btn_menu_editlisting_update:
                break;
            case R.id.imageView33:
                if (listTag.size() < 3){
                    addTag();
                }else {
                    addtag.setEnabled(false);
                }

                break;

        }
    }


    public void addTag(){

        listTag.add(edt_tag.getText().toString());
        edt_tag.setText("");
    }

    public void choseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);

    }


    ArrayList<Uri> lisImmage = new ArrayList<>();

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
                    lisImmage.add(mImageUri);

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
                return;
            }
        } catch (Exception e) {
            return;
        }
        if (lisImmage.size() == 1){
            imagebook1.setImageURI(lisImmage.get(0));
        }else if (lisImmage.size() == 2){
            imagebook2.setImageURI(lisImmage.get(1));
        }else if (lisImmage.size()==3){
            imagebook3.setImageURI(lisImmage.get(2));
        }

//        Log.d("dsdsds",String.valueOf(lisImmage.size()));
//        Log.d("dsdsds",String.valueOf(imagebook1.getTag()));
//        Log.d("dsdsds",String.valueOf(imagebook2.getTag()));
//        Log.d("dsdsds",String.valueOf(imagebook3.getTag()));
//        Log.d("dsdsds",String.valueOf(imagesEncodedList.size()));
        super.onActivityResult(requestCode, resultCode, data);
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }


    ArrayList<String> listFileName = new ArrayList<>();
    ArrayList<Uri> listImageTemp = new ArrayList<>();
    ArrayList<Bitmap> bmap = new ArrayList<>();

    public class Addbook extends AsyncTask<Void,Void,Boolean>{

        public ProgressDialog dialog;



        @Override
        protected Boolean doInBackground(Void... params) {

//            for (int i = 0;i<listImageTemp.size();i++){


            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (uploadFileController.uploadFile(bmap.get(0),""+username+"::"+listFileName.get(0))){
                    }
                }
            });

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (uploadFileController.uploadFile(bmap.get(1),""+username+"::"+listFileName.get(1)));
                }
            });

            Thread thread2  =new Thread(new Runnable() {
                @Override
                public void run() {
                    uploadFileController.uploadFile(bmap.get(2),""+username+"::"+listFileName.get(2)+"");

                }
            });

            Thread content = new Thread(new Runnable() {
                @Override
                public void run() {
                    userController = new UserController();
                    success = userController.addbook(book,session_id);
                }
            });
            content.start();
            if (bmap.size() == 1){
                thread.start();
            }else if (bmap.size() == 2){
                thread.start();
                thread1.start();
            }else if (bmap.size() == 3){
                thread.start();
                thread1.start();
                thread2.start();
            }

//                new UploadFileController().uploadFile(bmap.get(0),"duong::book.jpg");
//            }

            return success;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean bolean) {
            if (bolean == true){
                dialog.dismiss();
                Toast.makeText(getActivity(),"Addbook Success",Toast.LENGTH_LONG).show();
            }else {
                dialog.dismiss();
                Toast.makeText(getActivity(),"Addbook Faile",Toast.LENGTH_LONG).show();
            }
            super.onPostExecute(bolean);
        }
    }
}
