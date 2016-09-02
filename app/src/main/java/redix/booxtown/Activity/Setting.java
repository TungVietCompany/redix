package redix.booxtown.activity;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.Calendar;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;

public class Setting extends Fragment implements OnMapReadyCallback{

    TextView besttime1, besttime2;
    private SupportMapFragment mMapFragment;
    TextView txt_setting_besttime;
    SupportMapFragment mapFragment;
    MapView mMapView;
    private GoogleMap googleMap;
    Location location;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private MenuBottomCustom bottomListings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_setting, container, false);
        txt_setting_besttime= (TextView)view.findViewById(R.id.txt_setting_besttime);
        ImageView imv_setting_pass = (ImageView)view.findViewById(R.id.imv_setting_editpass);
        imv_setting_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_custom_editpass);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ImageView imageView = (ImageView) dialog.findViewById(R.id.imv_close_dialog_changepass);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        Switch switch_setting_editpass = (Switch) view.findViewById(R.id.switch_setting_besttime);
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom_seting_besttime);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        switch_setting_editpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b == false) {
                    dialog.dismiss();
                } else {

                    dialog.show();

                    //chinh thơi gian

                    besttime1 = (TextView) dialog.findViewById(R.id.txt_seting_besttime1);
                    besttime2 = (TextView) dialog.findViewById(R.id.txt_seting_besttime2);

                    besttime1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Calendar mcurrentTime = Calendar.getInstance();
                            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                            int minute = mcurrentTime.get(Calendar.MINUTE);
                            TimePickerDialog mTimePicker;
                            mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                    besttime1.setText(convertTime(i) + ":" + convertTime(i1) + " " + showTime(i, i1));
                                }
                            }, hour, minute, true);
                            mTimePicker.setTitle("");
                            mTimePicker.show();
                        }
                    });

                    besttime2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Calendar mcurrentTime = Calendar.getInstance();
                            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                            int minute = mcurrentTime.get(Calendar.MINUTE);
                            TimePickerDialog mTimePicker;
                            mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                    besttime2.setText(convertTime(i) + ":" + convertTime(i1) + " " + showTime(i, i1));
                                }
                            }, hour, minute, true);
                            mTimePicker.setTitle("");
                            mTimePicker.show();
                        }
                    });

                    ImageView imageView = (ImageView) dialog.findViewById(R.id.imv_close_dialog_submit);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    Button btn_setingdialog_time =(Button)dialog.findViewById(R.id.btn_setingdialog_time);
                    btn_setingdialog_time.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txt_setting_besttime.setText(besttime1.getText() +"  -  "+ besttime2.getText());
                            dialog.dismiss();
                        }
                    });
                }
            }
        });
        //map view
        mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);
        //end
        Switch switch_location = (Switch)view. findViewById(R.id.switch_seting_location);
        switch_location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == false) {
                    getActivity().getSupportFragmentManager().beginTransaction().hide(mapFragment).commit();
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction().show(mapFragment).commit();
                }
            }
        });


        return view;
    }

    public String showTime(int hour, int min) {
        String format;
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        return format;
    }

    public String convertTime(int hour) {
        if (hour < 10) {
            return "0" + hour;
        } else {
            return hour + "";
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
