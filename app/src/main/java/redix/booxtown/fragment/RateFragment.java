package redix.booxtown.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import redix.booxtown.R;
import redix.booxtown.custom.MenuBottomCustom;

public class RateFragment extends Fragment {
    private MenuBottomCustom bottomListings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rate_fragment, container, false);
        return view;
    }
}
